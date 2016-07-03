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
public class GoodsTypeOptionTag extends SimpleTagSupport {

	private String value = null;
	
	private String leaf = "false";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void doTag() throws JspException, IOException {
		List<GoodsType> list = GoodsTypeUtils.getGoodsTypeList("0");
		StringBuilder outString = new StringBuilder();
		doIterator(list, "0", outString, 0);
		this.getJspContext().getOut().print(outString.toString());
	}

	public void doIterator(List<GoodsType> list, String top, StringBuilder out, int level) {

		for (GoodsType type : list) {
			if (top.equals(type.getpGoodstype())) {

				out.append("<option "+ ("true".equals(leaf)&&"0".equals(type.getpGoodstype()) ? "disabled":"") + (type.getGoodstype().equals(value) ? "selected=\"selected\"" : "") + " value=\"" + type.getGoodstype() + "\">")
						.append(getLevelPrefix(level)).append(type.getGoodstypeName()).append("</option>");
				doIterator(list, type.getGoodstype(), out, level + 1);
			}
		}
	}

	private String getLevelPrefix(int level) {
		StringBuilder levelString = new StringBuilder();
		for (int i = 0; i < level; i++) {
			levelString.append("--|");
		}

		return levelString.toString();
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	
	
	

}
