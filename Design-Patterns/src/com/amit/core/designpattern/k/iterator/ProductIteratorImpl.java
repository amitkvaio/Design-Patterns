package com.amit.core.designpattern.k.iterator;

public class ProductIteratorImpl implements Iterator {

	Product[] products;
	int pos = 0;

	public ProductIteratorImpl(Product[] products) {
		this.products = products;
	}

	@Override
	public boolean hasNext() {
		if (pos >= products.length || products[pos]==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		return products[pos++];
	}

}
