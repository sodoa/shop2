/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.cache.utils.GoodsTypeUtils;
import com.xinfan.wxshop.business.entity.GoodsType;

/**
 * @author Administrator
 * 
 */
public class GoodsTypeNametTag extends SimpleTagSupport {

	private String id;

	public void doTag() throws JspException, IOException {
		GoodsType type = GoodsTypeUtils.getGoodsType(id);
		JspWriter out = this.getJspContext().getOut();
		out.print(type == null ? "" : type.getGoodstypeName());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
