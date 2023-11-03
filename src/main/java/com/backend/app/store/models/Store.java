package com.backend.app.store.models;

public class Store {
	private Drawing drawing;
	private int quantity;

	public Store(Drawing drawing, int quantity) {
		this.drawing = drawing;
		this.quantity = quantity;
	}

	public Store() {
	}

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
