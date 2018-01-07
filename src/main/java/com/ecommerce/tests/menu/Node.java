package com.ecommerce.tests.menu;

public class Node {

	private Integer id;
	private Integer parent;
	private Integer type;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node(Integer id, Integer parent, Integer type, String name) {
		super();
		this.id = id;
		this.parent = parent;
		this.type = type;
		this.name = name;
	}
	
	
}
