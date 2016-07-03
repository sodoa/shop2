package com.xinfan.wxshop.business.vo;

import java.util.List;

import com.xinfan.wxshop.business.entity.Cart;
import com.xinfan.wxshop.business.entity.Goods;

public class CartInfoVo {

	private boolean hasGoods;
	
	public boolean isHasGoods() {
		return hasGoods;
	}

	public void setHasGoods(boolean hasGoods) {
		this.hasGoods = hasGoods;
	}

	private List<Cart> carts;

	private List<Goods> goods;

	private float totalAmount;

	private float saveAmount;

	private float orginAmount;
	
	private boolean hasPostage = true;
	
	

	public boolean isHasPostage() {
		return hasPostage;
	}

	public void setHasPostage(boolean hasPostage) {
		this.hasPostage = hasPostage;
	}

	public float getOrginAmount() {
		return orginAmount;
	}

	public void setOrginAmount(float orginAmount) {
		this.orginAmount = orginAmount;
	}

	public float getSaveAmount() {
		return saveAmount;
	}

	public void setSaveAmount(float saveAmount) {
		this.saveAmount = saveAmount;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

}
