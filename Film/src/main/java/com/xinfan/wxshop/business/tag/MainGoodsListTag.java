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
import com.xinfan.wxshop.common.context.AppContextHolder;

/**
 * @author Administrator
 * 
 */
public class MainGoodsListTag extends SimpleTagSupport {

	private int size = 5;

	private int type = 1;

	public void doTag() throws JspException, IOException {

		GoodsService GoodsService = AppContextHolder
				.getBean(GoodsService.class);

		List<Goods> list = null;
		if (type == 1) {
			list = GoodsService.getMainTopBurstGoods(size);
		} else {
			list = GoodsService.getMainTopHotGoods(size);
		}

		getJspContext().setAttribute("goods_list", list);
		getJspBody().invoke(null);

	}

}
