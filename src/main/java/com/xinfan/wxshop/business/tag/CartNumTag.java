/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.common.context.AppContextHolder;

/**
 * @author Administrator
 * 
 */
public class CartNumTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {

		int num = 0;

		String session = ((PageContext) super.getJspContext()).getSession().getId();
		if (session != null) {
			CartService bean = AppContextHolder.getBean(CartService.class);
			num = bean.getCartNumBySessionId(session);
		}

		getJspContext().getOut().print(num);
	}

}
