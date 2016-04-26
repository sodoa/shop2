package com.xinfan.wxshop.business.front;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.cache.utils.ParamterUtils;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.DistributionService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.config.FileConfig;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.security.DesUtils;
import com.xinfan.wxshop.common.util.CookieUtils;

@Controller
public class DistributionAct {

	private static final Logger logger = LoggerFactory.getLogger(DistributionAct.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;

	@Autowired
	private AppraiseService AppraiseService;

	@Autowired
	private CustomerService CustomerService;

	@Autowired
	private DistributionService DistributionService;

	@RequestMapping("/center/distri.html")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/distri");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(40);
		page = DistributionService.pageNearCustomerDistributionList(customerId, page);

		mv.addObject("page", page);
		mv.addObject("menu_hit", 4);

		return mv;
	}

	@RequestMapping("/center/distri-data-ajax.html")
	public ModelAndView ajaxList(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("/front/distri-data-ajax");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

		Pagination page = RequestUtils.getPagination(request);
		page.setPageSize(5);
		page = DistributionService.pageNearCustomerDistributionList(customerId, page);

		mv.addObject("list", page.getList());

		return mv;
	}

	@RequestMapping("/distri-tip.html")
	public ModelAndView distriTip(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/distri-tip");

		String id = request.getParameter("id");
		mv.addObject("menu_hit", 4);
		mv.addObject("id", id);
		mv.addObject("random", new Date().getTime());
		return mv;
	}

	@RequestMapping("/center/tranfer.html")
	public ModelAndView tranfer(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/tranfer");

		Integer customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

		Wallet wallet = this.CustomerService.getWalletByCustomerId(customerId);
		mv.addObject("wallet", wallet);
		mv.addObject("menu_hit", 4);
		return mv;
	}

	@RequestMapping("/share.html")
	public ModelAndView share(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:/regist.html");

		String c = request.getParameter("c");

		if (c != null && c.length() > 0) {
			String customerId = c;
			CookieUtils.addCookie(request, response, "wxsid", customerId, 24 * 60 * 60, null);

			if (logger.isDebugEnabled()) {
				logger.info("share : " + customerId);
			}
		}

		return mv;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "LUmctvRztJNAUlSFAltHKNSS5CZtYEHIQjtP8xvre2it+HiQ2a4b2sl3c/O7TCcbSfle1rLpjam/7+Ju7hWf7w==";
		byte[] data = Base64.decodeBase64(s);
		System.out.println(data);
		String params = new String(DesUtils.decrypt(data, "password12345678"), "UTF-8");
		System.out.println(params);
	}

	@RequestMapping("/center/distri-image.html")
	public void distriImage(HttpServletRequest request, HttpServletResponse response) {
		try {

			Integer customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

			String desPassword = FileConfig.getInstance().getString("image.des.password", "password12345678");

			String domain = ParamterUtils.getString("web.domain", "http://11grand.cn") + "/share.html";

			domain += "?c=" + customerId;

			ByteArrayOutputStream out1 = QRCode.from(domain).to(ImageType.PNG).withSize(300, 300).stream();
			response.getOutputStream().write(out1.toByteArray());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
