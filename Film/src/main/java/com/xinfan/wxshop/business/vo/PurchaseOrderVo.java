package com.xinfan.wxshop.business.vo;

import java.util.List;

import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderDetail;

public class PurchaseOrderVo {

	private Order order;

	private List<OrderDetail> detail;

	public PurchaseOrderVo(Order order, List<OrderDetail> detail) {
		super();
		this.order = order;
		this.detail = detail;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<OrderDetail> detail) {
		this.detail = detail;
	}

}
