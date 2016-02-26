/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.context.AppContextHolder;

/**
 * @author Administrator
 * 
 */
public class TopGoodsListTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {

		GoodsService GoodsService = AppContextHolder
				.getBean(GoodsService.class);

		List<DataMap> list = GoodsService.getTopShowGoodsList();

		getJspContext().setAttribute("goods_list", list);
		getJspBody().invoke(null);

	}

}
