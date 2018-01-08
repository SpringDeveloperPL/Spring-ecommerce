package com.ecommerce.product.controller;

import com.ecommerce.auction.service.AuctionService;
import com.ecommerce.category.domain.Category;
import com.ecommerce.category.domain.ProductCategory;
import com.ecommerce.category.service.CategoryService;
import com.ecommerce.manufacturer.service.ManufacturerService;
import com.ecommerce.product.doimain.*;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.tax.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * @author Brove
 *
 */
@Controller
@RequestMapping("/dashboard")
public class ProductController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	TaxService taxService;

	@Autowired
	ManufacturerService manufacturerService;

	@Autowired
	AuctionService auctionService;

	LinkedList<FileMeta> requestImages = new LinkedList<FileMeta>();
	List<ProductImage> imageToSave = new ArrayList<>();
	FileMeta fileMeta = null;

	@RequestMapping("/manageproduct")
	public String manageProduct() {

		return "manageproduct";

	}

	@RequestMapping(value = "/manageproduct/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model, @ModelAttribute("productForm") ProductForm productForm) {
		requestImages.clear();
		List<String> chosedProductCategory = new ArrayList<>();
		Product product = new Product();
		Tax tax = new Tax();
		product.setTax(tax);

		model.addAttribute("taxList", taxService.fintAllTaxes());
		model.addAttribute("categoryList", categoryService.findAllCategory());
		model.addAttribute("manufacturerList", productService.findAllManufacturer());
		model.addAttribute("chosedProductCategory", chosedProductCategory);
		model.addAttribute("productForm", productForm);
		model.addAttribute("product", product);

		return "addProduct";
	}

	@RequestMapping(value = "/manageproduct/addProduct", method = RequestMethod.POST)
	public String processAddProduct(Model model, @ModelAttribute("productForm") ProductForm productForm) throws ParseException {

		List<Tax> taxlist = taxService.fintAllTaxes();
		Product product = productForm.getProduct();
		Tax tax = new Tax();
		Manufacturer manufacturer = new Manufacturer();
		product.setManufacturer(manufacturer);
		product.getManufacturer().setManufacturerIdFromForm(productForm.getManufacturerID());
		product.setTax(tax);
		product.getTax().setTaxIdFromForm(productForm.getTaxID());
		// set Main Image ,getting 0 index element from image list
		if(!requestImages.get(0).equals(null))
		product.setImageName(requestImages.get(0).getFileName());
		for (FileMeta requestImage : requestImages) {
			ProductImage productImage = new ProductImage();
			productImage.setName(requestImage.getFileName());
			productImage.setProduct(productForm.getProduct());
			imageToSave.add(productImage);
		}
		Set<ProductCategory> productCategory = addCategoryProduct(productForm.getChosedProductCategory(), product);
		product.setProductcategory(productCategory);
		//Setting Auction end date from parsed String varaible to Timestamp
		product.setAuctionStartDate(auctionService.getAuctionStartDate());
		product.setAuctionEndDate(auctionService.parseStringToTimestamp(productForm.getAuctionEndDate()));
		productService.addProduct(product);
		productService.addProductImage(imageToSave);

		model.addAttribute("taxList", taxlist);
		requestImages.clear();
		return "addProduct";
	}

	/***************************************************
	 * URL: /rest/controller/upload upload(): receives files
	 * 
	 * @param request
	 *            : MultipartHttpServletRequest auto passed
	 * @param response
	 *            : HttpServletResponse auto passed
	 * @return LinkedList<FileMeta> as json format
	 ****************************************************/
	@RequestMapping(value = "/manageproduct/addProduct.do", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response,
			HttpServletRequest servletRequest) {

		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;

		String savePath = servletRequest.getSession().getServletContext().getRealPath("/");
		savePath = savePath + "WEB-INF";
		String resourcesAdditionalPath = "/resources/productImages/";

		// 2. get each file
		while (itr.hasNext()) {

			// 2.1 get next MultipartFile
			mpf = request.getFile(itr.next());

			// 2.2 if files > 10 remove the first from the list
			if (requestImages.size() >= 10)
				requestImages.pop();
			// 2.3 create new fileMeta
			fileMeta = new FileMeta();
			// String fileContextPath = resourcesAdditionalPath + fileIterator +
			// "_" + mpf.getOriginalFilename();
			String UniqueFileName = productService.getUniqueFileName();
			String fileContextPath = resourcesAdditionalPath + UniqueFileName;
			fileMeta.setFileName(UniqueFileName);
			fileMeta.setPath(fileContextPath);

			try {
				fileMeta.setBytes(mpf.getBytes());
				System.out.println(savePath + fileContextPath);
				// copy file to local disk (make sure the path "e.g.
				// D:/temp/files" exists)
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(savePath + fileContextPath));

				// System.out.println(savePath + fileContextPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.4 add to files
			requestImages.add(fileMeta);

		}

		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8
		// Kb","fileType":"image/png"},...]
		return requestImages;

	}

	/***************************************************
	 * URL: /rest/controller/get/{value} get(): get file as an attachment
	 * 
	 * @param response
	 *            : passed by the server
	 * @param value
	 *            : value from the URL
	 * @return void
	 ****************************************************/
	@RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response, @PathVariable String value) {
		FileMeta getFile = requestImages.get(Integer.parseInt(value));
		try {
			response.setContentType(getFile.getFileType());
			response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
			FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Set<ProductCategory> addCategoryProduct(List<Integer> userCategoryList, Product product) {

		Set<ProductCategory> productCategorySet = new HashSet<>();
		List<Category> categoryList = categoryService.findAllCategory();

		for (Category category : categoryList) {
			for (Integer userCategory : userCategoryList) {

				if (userCategory == category.getCategoryId()) {
					ProductCategory pr = new ProductCategory();
					pr.setProduct(product);
					pr.setCategory(category);
					productCategorySet.add(pr);
					System.err.println(category.getCategoryId());
				}
			}
		}
		return productCategorySet;
	}

	
	/**
	 * @param model
	 * @param producId
	 * @return It functionality must be changed, prevered copy all method ,and vievs and prepare a little changes ,but it will work pervectly
	 */
	@RequestMapping(value = "/manageproduct/manage/{producId}/product", method = RequestMethod.GET)
	public String editProduct(Model model, @PathVariable int producId) {

		ProductForm productForm = new ProductForm();
		Product product = productService.getProductById(producId);
		List<Integer> chosedProductCategory = categoryService.getIdProductAcignedCategory(producId);
		productForm.setProduct(product);
		productForm.setManufacturerID(Long.toString(product.getManufacturer().getManufacturerId()));
		productForm.setTaxID(Long.toString(product.getTax().getTaxId()));
		model.addAttribute("chosedProductCategory",chosedProductCategory);
		model.addAttribute("productForm", productForm);
		model.addAttribute("taxList", taxService.fintAllTaxes());
		model.addAttribute("categoryList", categoryService.findAllCategory());
		model.addAttribute("manufacturerList", productService.findAllManufacturer());
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/manageproduct/manage/{producId}/product", method = RequestMethod.POST)
	public String updateEditedProduct(Model model) {
		return "addProduct";
	}

}
