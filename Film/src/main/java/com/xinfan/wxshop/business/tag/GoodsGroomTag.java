/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.context.AppContextHolder;
import com.xinfan.wxshop.common.page.Pagination;

/**
 * @author Administrator
 * 
 */
public class GoodsGroomTag extends SimpleTagSupport {

	private int size = 5;

	private String typeLevel2;

	public void doTag() throws JspException, IOException {

		GoodsService service = AppContextHolder.getBean(GoodsService.class);
		DataMap param = new DataMap();
		param.put("typeLevel2", typeLevel2);

		Pagination page = new Pagination();

		page.setPageNo(1);
		page.setPageSize(size);

		List<Goods> list = service.getGoodsClassifySerchList(param, page);

		getJspContext().setAttribute("goods_groom_list", list);
		getJspBody().invoke(null);

	}

}
