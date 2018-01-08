package com.ecommerce.tests.menu;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface JsonTreeService {

	public JsonResponse JsonResponse(HttpServletRequest httpServletRequest);
	public ClientHttpRequest createClientHttpRequest(HttpServletRequest httpServletRequest);
	public List<Factor> createFactorsList(List<Node> allJsonNode, ClientHttpRequest clientHttpRequest);
 
}
