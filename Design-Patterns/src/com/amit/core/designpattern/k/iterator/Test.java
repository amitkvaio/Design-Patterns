package com.amit.core.designpattern.k.iterator;

public class Test {

	public static void main(String[] args) {
		ProductCollectionImpl products = new ProductCollectionImpl();
		products.addProduct(new Product("IPhone"));
		products.addProduct(new Product("Samsung"));
		products.addProduct(new Product("Mac Book"));

		Iterator iterator = products.createIterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			System.out.println(product.getName());
		}
	}
}
