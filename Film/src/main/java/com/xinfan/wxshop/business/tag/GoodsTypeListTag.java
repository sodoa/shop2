/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.cache.utils.GoodsTypeUtils;
import com.xinfan.wxshop.business.entity.GoodsType;

/**
 * @author Administrator
 * 
 */
public class GoodsTypeListTag extends SimpleTagSupport {

	private int size = 5; 

	private String topGoodsType = "0";

	public void doTag() throws JspException, IOException {

		List<GoodsType> list = GoodsTypeUtils.getLevel2GoodsType(topGoodsType,
				size);

		getJspContext().setAttribute("goodstype_list", list);
		getJspBody().invoke(null);

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTopGoodsType() {
		return topGoodsType;
	}

	public void setTopGoodsType(String topGoodsType) {
		this.topGoodsType = topGoodsType;
	}

}
