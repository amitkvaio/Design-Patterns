package com.amit.core.designpattern.k.iterator;

public class ProductCollectionImpl implements Collection {

	int numberOfProducts = 0;
	Product[] products;

	public ProductCollectionImpl() {
		products = new Product[10];
	}

	public void addProduct(Product product) {
		products[numberOfProducts] = product;
		numberOfProducts = numberOfProducts + 1;
	}

	@Override
	public Iterator createIterator() {
		return new ProductIteratorImpl(products);
	}
}
