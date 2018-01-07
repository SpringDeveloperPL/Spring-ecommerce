package com.ecommerce.tests.menu;

public class Factor {

	private String id;
	private String text;
	private Status state;
	private boolean children;
	private Integer type;
	
	public Factor() { 
		
	}
	public Factor(String id, String text, Status state, boolean children, Integer type) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.children = children;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Factor [id=" + id + ", text=" + text + ", state=" + state + ", children=" + children + ", type=" + type
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Status getState() {
		return state;
	}
	public void setState(Status state) {
		this.state = state;
	}
	public boolean isChildren() {
		return children;
	}
	public void setChildren(boolean children) {
		this.children = children;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
