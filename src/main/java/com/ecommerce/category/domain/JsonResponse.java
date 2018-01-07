package com.ecommerce.category.domain;

import java.util.List;

public class JsonResponse {

	@Override
	public String toString() {
		return "JsonResponse [status=" + status + ", prompt=" + prompt + ", factor=" + factor + "]";
	}

	private boolean status;
	private String prompt;
	private List<Factor> factor;

	public List<Factor> getFactor() {
		return factor;
	}

	public void setFactor(List<Factor> factor) {
		this.factor = factor;
	}

	public JsonResponse() {

	}

	public JsonResponse(boolean status, String prompt, List<Factor> factor) {
		super();
		this.status = status;
		this.prompt = prompt;
		this.factor = factor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

}
