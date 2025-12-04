package model.entities;

import java.util.ArrayList;
import java.util.List;

import exception.StockException;

public class StockManager {
	private List<Product> pd = new ArrayList<>();

	public StockManager() {
	}

	public StockManager(List<Product> pd) {
		this.pd = pd;
	}

	public List<Product> getPd() {
		return pd;
	}

	public void addProduct(Product addPD) {
		pd.add(addPD);
	}

	public void removeProduct(int removePD) throws StockException {
		if (pd.isEmpty()) {
			throw new StockException("Lista vazia!");
		}
		Product findProduct = null;
		for (Product p : pd) {
			if (removePD == p.getId()) {
				findProduct = p;
			}
		}
		if (findProduct == null) {
			throw new StockException("Produto nao encontrado");
		}
		pd.remove(findProduct);
	}

	public String findProduct(int id) throws StockException {
		if (pd.isEmpty()) {
			throw new StockException("Lista vazia!");
		}
		for (Product p : pd) {
			if (p.getId() == id) {
				return p.toString();
			}
		}
		throw new StockException("Item não encontrado!");

	}

	public int totalStock() throws StockException {
		int resultTotalStock = 0;
		if (pd.isEmpty()) {
			throw new StockException("Catalogo de produtos vazio. Cadastre os produtos primeiro!");
		}
		for (Product p : pd) {
			resultTotalStock += p.getQuantity();
		}
		return resultTotalStock;
	}

	public double totalPriceInStock() throws StockException {
		double resultPrice = 0.0;
		if (pd.isEmpty()) {
			throw new StockException(
					"Catalogo de produtos vazio. Cadastre os produtos primeiro, para calcular os produtos!");
		}
		for (Product p : pd) {
			resultPrice = p.getPrice() * p.getQuantity();
		}
		return resultPrice;
	}
	
	public void updateItem(Product p, int id)throws StockException {
		if (pd.isEmpty()) {
			throw new StockException(
					"Catalogo de produtos vazio. Cadastre os produtos primeiro, para calcular os produtos!");
		}
		for (int i=0; i<pd.size(); i++) {
			if(pd.get(i).getId() == id) {
				pd.set(i, p);
			}
		}
	}
	
	
}