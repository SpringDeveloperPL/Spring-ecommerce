package com.ecommerce.tests.menu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;


@Service
public class JsonTreeServiceImpl implements JsonTreeService {

	@Override
	public JsonResponse JsonResponse(HttpServletRequest httpServletRequest) {

		List<Node> allJsonNode = new ArrayList<>();
		List<JsonResponse> allJsonNode2 = new ArrayList<>();

		
		/* [id,parent,type,name */
		
		Node node1 = new Node(0, -1, 2, "Root1");
		Node node2 = new Node(1, 0, 2, "Knot1");
		Node node3 = new Node(2, 0, 2, "Knot2");
		Node node4 = new Node(3, 1, 3, "Leof1");
		Node node5 = new Node(4, 2, 3, "Leof2");
		Node node6 = new Node(5, 0, 2, "Knot3");
		Node node7 = new Node(6, 5, 3, "Leof2");
		Node node8 = new Node(7, -1, 0, "Root2");
		Node node9 = new Node(8, 7, 2, "Knot4");

		allJsonNode.add(node1);
		allJsonNode.add(node2);
		allJsonNode.add(node3);
		allJsonNode.add(node4);
		allJsonNode.add(node5);
		allJsonNode.add(node6);
		allJsonNode.add(node7);
		allJsonNode.add(node8);
		allJsonNode.add(node9);		
		
		// JsonTree tree = new JsonTree(true, "", new Factor("filter_0_1",
		// "Knot1", new States(false), true, 1));
		// JsonTree tree2 = new JsonTree(true, "", new Factor("filter_0_8",
		// "Knot2", new States(false), false, 2));

		ClientHttpRequest clientHttpRequest = createClientHttpRequest(httpServletRequest);
		JsonResponse jsonResponse = new JsonResponse();
		List<Factor> factorsList = new ArrayList<>();

		if (clientHttpRequest.getVer().equals(null)) {
			clientHttpRequest.setVer(1.0);
		}

		clientHttpRequest.setPfx("filer_0_");
		try {
			clientHttpRequest.setFid(clientHttpRequest.getId().replace(clientHttpRequest.getPfx(), ""));
			System.out.println("pfx "+clientHttpRequest.getPfx());
			System.out.println("id "+clientHttpRequest.getId());
			System.out.println("fid "+clientHttpRequest.getFid());

			System.out.println(clientHttpRequest.getFid());
		} catch (Exception e) {
			System.err.println("zjebales replace");
		}
		jsonResponse.setStatus(true);
		jsonResponse.setPrompt("");

		if (clientHttpRequest.getCmd().equals("opn")) {
			factorsList = createFactorsList(allJsonNode, clientHttpRequest);
			jsonResponse.setFactor(factorsList);

		}

		// Factor factor1 = new Factor("filer_0_0", "Root1", new Status(false),
		// true, 1);
		// Factor factor2 = new Factor("filer_0_7", "Root2", new Status(false),
		// true, 0);
		//
		// List<Factor> listFactor = new ArrayList<>();
		// listFactor.add(factor1);
		// listFactor.add(factor2);

		// jsonResponse.setFactor(listFactor);

		return jsonResponse;
	}

	/* [id,parent,type,name */
	public List<Factor> createFactorsList(List<Node> allJsonNode, ClientHttpRequest clientHttpRequest) {
		List<Factor> factorsList = new ArrayList<>();
		String state = "";
		System.out.println("przed");
		
		for (Node node : allJsonNode) {
			System.out.println(node.getParent()+"n parent=="+clientHttpRequest.getFid()+"fid");

			if (node.getParent().toString().equals(clientHttpRequest.getFid().toString())) {
				
				System.out.println("obiekt");
				Factor factor = new Factor();

				for (Node n : allJsonNode) {
					if (n.getType() != 0) {
						n.setType(1);

					}
					factor.setState(new Status(false));

				}

				try {
					if (clientHttpRequest.getVer() == 3.0)
						factor.setState(new Status(false));
					factor.setChildren(node.getType()<2);

					factor.setId(clientHttpRequest.getPfx() + "" + node.getId().toString());
				} catch (Exception e) {
					System.err.println("zjebales id");
				}
				factor.setText(node.getName());
				factor.setType(node.getType());
				factorsList.add(factor);

			}

		}

		// }
		System.err.println(factorsList.toString());
		return factorsList;
	}

	public ClientHttpRequest createClientHttpRequest(HttpServletRequest httpServletRequest) {

		ClientHttpRequest clientHttpRequest = new ClientHttpRequest(httpServletRequest.getParameter("cmd"),
				httpServletRequest.getParameter("id"), httpServletRequest.getParameter("cmt"),
				httpServletRequest.getParameter("tid"), Integer.parseInt(httpServletRequest.getParameter("tzo")),
				Double.parseDouble(httpServletRequest.getParameter("ver")));

		return clientHttpRequest;
	}

}
