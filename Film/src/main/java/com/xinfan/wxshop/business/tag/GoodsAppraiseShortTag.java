/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.common.context.AppContextHolder;
import com.xinfan.wxshop.common.page.Pagination;

/**
 * @author Administrator
 * 
 */
public class GoodsAppraiseShortTag extends SimpleTagSupport {

	private int size = 5;

	private int goodsId;

	public void doTag() throws JspException, IOException {

		AppraiseService service = AppContextHolder
				.getBean(AppraiseService.class);

		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(size);

		page = service.listGoodsAppraise(goodsId, page);

		getJspContext().setAttribute("goods_appraise_list", page.getList());
		getJspBody().invoke(null);

	}

}
