/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.entity.GoodsImage;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.common.context.AppContextHolder;

/**
 * @author Administrator
 * 
 */
public class GoodsNatvPictureTag extends SimpleTagSupport {

	private int size = 5;

	private int type = 1;

	private int goodsId;

	public void doTag() throws JspException, IOException {

		GoodsService GoodsService = AppContextHolder
				.getBean(GoodsService.class);

		List<GoodsImage> list = GoodsService.getGoodsImageList(goodsId, type,
				size);

		getJspContext().setAttribute("goods_image_list", list);
		getJspBody().invoke(null);

	}

}
