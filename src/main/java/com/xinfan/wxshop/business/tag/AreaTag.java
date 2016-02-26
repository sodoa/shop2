/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.cache.utils.AreaUtils;
import com.xinfan.wxshop.business.entity.Area;

/**
 * @author Administrator
 * 
 */
public class AreaTag extends SimpleTagSupport {

	private String code;

	private int type = 1;

	public void doTag() throws JspException, IOException {

		String outString = null;

		if (type == 1) {
			Area area = AreaUtils.getArea(code);
			if (area != null) {
				outString = area.getName();
			}
		} else if (type == 2) {
			outString = AreaUtils.getFullAreaName(code);
		}

		JspWriter out = getJspContext().getOut();
		out.print(outString);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
