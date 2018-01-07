package com.ecommerce.tests.menu;

public class Status {

	@Override
	public String toString() {
		return "Status [opened=" + opened + "]";
	}

	private boolean opened;

	public Status(boolean opened) {
		super();
		this.opened = opened;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}
}
