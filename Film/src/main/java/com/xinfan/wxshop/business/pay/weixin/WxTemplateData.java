package com.xinfan.wxshop.business.pay.weixin;

public class WxTemplateData {
	private String value;
	private String color;
	

	public WxTemplateData(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
