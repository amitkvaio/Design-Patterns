package com.amit.core.designpattern.e.proxy;

import java.util.ArrayList;
import java.util.List;

public class CustomerProxyImpl implements Customer {

	CustomerImpl impl = new CustomerImpl();
	
	@Override
	public int getId() {
		return impl.getId();
	}

	@Override
	public List<Order> getOrders() {
		List<Order> listOrder = new ArrayList<>();
		Order order1 = new Order();
		order1.setId(100);
		order1.setProductName("IPHONE");
		order1.setQuantity(100);

		Order order2 = new Order();
		order1.setId(101);
		order1.setProductName("MAC");
		order1.setQuantity(50);
		
		listOrder.add(order1);
		listOrder.add(order2);
		return listOrder;
	}

}
