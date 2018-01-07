package com.ecommerce.category.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.category.dao.CategoryDao;
import com.ecommerce.category.domain.Category;
import com.ecommerce.category.domain.ClientHttpRequest;
import com.ecommerce.category.domain.Factor;
import com.ecommerce.category.domain.JsonResponse;
import com.ecommerce.category.domain.Status;
import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.doimain.Product;
import com.ecommerce.category.domain.ProductCategory;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;

	@Override
	public List<Category> findAllCategory() {
		return categoryDao.findAllCategory();
	}

	public JsonResponse JsonResponse(HttpServletRequest httpServletRequest) {

		List<Category> categoryTree = new ArrayList<>();

		categoryTree = categoryDao.findAllCategory();

		/* [id,parent,type,name */

		ClientHttpRequest clientHttpRequest = createClientHttpRequest(httpServletRequest);
		JsonResponse jsonResponse = new JsonResponse();
		List<Factor> factorsList = new ArrayList<>();

		if (clientHttpRequest.getVer().equals(null)) {
			clientHttpRequest.setVer(1.0);
		}

		clientHttpRequest.setPfx("filer_0_");

		try {
			clientHttpRequest.setFid(clientHttpRequest.getId().replace(clientHttpRequest.getPfx(), ""));
			System.out.println("pfx " + clientHttpRequest.getPfx());
			System.out.println("id " + clientHttpRequest.getId());
			System.out.println("fid " + clientHttpRequest.getFid());

			System.out.println(clientHttpRequest.getFid());
		} catch (Exception e) {
			System.err.println("zjebales replace");
		}

		jsonResponse.setStatus(true);
		jsonResponse.setPrompt("");

		switch (clientHttpRequest.getCmd()) {
		// opening tree view
		case "opn":
			factorsList = createFactorsList(categoryTree, clientHttpRequest);
			jsonResponse.setFactor(factorsList);
			break;

		// rename category tree
		case "ren":
			changeNameCategory(Integer.parseInt(clientHttpRequest.getFid()), clientHttpRequest.getIdt());
			break;
		// delete category tree
		case "del":
			deleteCategory(Integer.parseInt(clientHttpRequest.getFid()));
			break;
		case "new":
			String parent = httpServletRequest.getParameter("pid").replace(clientHttpRequest.getPfx(), "");
			createCategory(clientHttpRequest.getIdt(), Integer.parseInt(parent));
			break;

		default:
			factorsList = createFactorsList(categoryTree, clientHttpRequest);
			jsonResponse.setFactor(factorsList);
			break;
		}

		return jsonResponse;
	}

	/* [id,parent,type,name */
	public List<Factor> createFactorsList(List<Category> categoryTree, ClientHttpRequest clientHttpRequest) {
		List<Factor> factorsList = new ArrayList<>();
		System.out.println("przed");

		for (Category category : categoryTree) {
			System.out.println(category.getParent() + "n parent==" + clientHttpRequest.getFid() + "fid");

			if (String.valueOf(category.getParent()).equals(clientHttpRequest.getFid().toString())) {

				System.out.println("obiekt");
				Factor factor = new Factor();

				for (Category c : categoryTree) {
					if (c.getType() != 0) {
						c.setType(1);

					}
					factor.setState(new Status(false));

				}

				try {
					if (clientHttpRequest.getVer() == 3.0)
						factor.setState(new Status(false));
					factor.setChildren(category.getType() < 2);

					factor.setId(clientHttpRequest.getPfx() + "" + category.getCategoryId());
				} catch (Exception e) {
					System.err.println("zjebales id");
				}
				factor.setText(category.getName());
				factor.setType(category.getType());
				factorsList.add(factor);

			}

		}

		// }
		System.err.println(factorsList.toString());
		return factorsList;
	}

	public ClientHttpRequest createClientHttpRequest(HttpServletRequest httpServletRequest) {

		ClientHttpRequest clientHttpRequest = new ClientHttpRequest(httpServletRequest.getParameter("cmd"),
				httpServletRequest.getParameter("idt"), httpServletRequest.getParameter("id"),
				httpServletRequest.getParameter("cmt"), httpServletRequest.getParameter("tid"),
				Integer.parseInt(httpServletRequest.getParameter("tzo")),
				Double.parseDouble(httpServletRequest.getParameter("ver")));

		if (httpServletRequest.getParameterMap().containsKey("id[]")) {
			clientHttpRequest.setId(httpServletRequest.getParameter("id[]"));
		}

		return clientHttpRequest;
	}

	public void changeNameCategory(int categoryId, String categoryName) {

		categoryDao.changeCategoryName(categoryId, categoryName);
	}

	@Override
	public void printHtppRequestConsole(HttpServletRequest httpServletRequest) {
		Enumeration<String> params = httpServletRequest.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			System.out.println(
					"Parameter Name - " + paramName + ", Value - " + httpServletRequest.getParameter(paramName));
		}
	}

	public void deleteCategory(int categoryId) {
		categoryDao.deleteCategory(categoryId);
	}

	@Override
	public void createCategory(String categoryName, int parent) {
		categoryDao.createCategory(categoryName, parent);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<>();
		List<ProductCategory> productCategoryList = productDao.findAllProductCategory();
		for (ProductCategory productCategory : productCategoryList) {
			if (category.equalsIgnoreCase(productCategory.getCategory().getName())) {
				productsByCategory.add(productCategory.getProduct());
			}
		}
		return productsByCategory;
	}

	@Override
	public List<ProductCategory> findAllProductCategory() {
		return categoryDao.findAllProductCategory();
	}

	public List<Integer> getIdProductAcignedCategory(int productId) {
		
		List<Integer> result = new ArrayList<>();
		List<ProductCategory> productCategoryList = productDao.findAllProductCategory();
		for (ProductCategory productCategory : productCategoryList) {
			if(productCategory.getProduct().getProductId()==productId) {
				result.add(productCategory.getProduct().getProductId());
			}
		}
		
		return result;
	}

	@Override
	public Category findCategoryByName(String name) {
		return categoryDao.findCategoryByName(name);
	}

	@Override
	public boolean isSetCategory(String categoryName) {

		List<Category> categoryList = categoryDao.findAllCategory();

		for(Category category: categoryList) {
			if(category.getName().equals(categoryName)) {
				return true;
			}
		}
		return false;
	}


}
