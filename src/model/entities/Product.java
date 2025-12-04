
package model.entities;

import exception.StockException;

public class Product {
	private String name;
	private Double price;
	private Integer quantity;
	private Integer id;

	public Product() {
	}

	public Product(int id, String name, Double price, int quantity) throws StockException {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int ID(int id) throws StockException {
		if (id != this.id || this.id == -0) {
			throw new StockException("ID Invalido!");
		}
		return id;

	}

	public String toString() {
		return "ID: " + getId() + " " + "Nome: " + getName() + " " + "Preco: " + getPrice() + " " + "Quantidade: "
				+ getQuantity();
	}
}
