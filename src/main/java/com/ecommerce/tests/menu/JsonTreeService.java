package com.ecommerce.tests.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface JsonTreeService {

	public JsonResponse JsonResponse(HttpServletRequest httpServletRequest);
	public ClientHttpRequest createClientHttpRequest(HttpServletRequest httpServletRequest);
	public List<Factor> createFactorsList(List<Node> allJsonNode, ClientHttpRequest clientHttpRequest);
 
}
