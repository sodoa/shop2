/**
 * 
 */
package com.xinfan.wxshop.business.tag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.SearchWords;
import com.xinfan.wxshop.common.cache.CacheHolder;

/**
 * @author Administrator
 * 
 */
public class SearchWordsListTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {

		ArrayList<SearchWords> list = (ArrayList<SearchWords>) CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_SEARCHWORDS_CACHE);

		getJspContext().setAttribute("list", list);
		getJspBody().invoke(null);

	}

}
