package com.xinfan.wxshop.business.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.entity.Order;

public class OrderBean {

	private Order order;

	private List<Map> form = new ArrayList<Map>();

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Map> getForm() {
		return form;
	}

	public void setForm(List<Map> form) {
		this.form = form;
	}

}
