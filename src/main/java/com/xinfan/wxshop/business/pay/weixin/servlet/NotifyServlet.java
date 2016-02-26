package com.xinfan.wxshop.business.pay.weixin.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinfan.wxshop.business.pay.weixin.utils.GetWxOrderno;
import com.xinfan.wxshop.business.pay.weixin.utils.RequestHandler;
import com.xinfan.wxshop.common.config.FileConfig;


public class NotifyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String rt_return_code = "";
		String rt_return_msg = "";
		try {
		
			BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
	        String line = null;
	        
	        StringBuilder sb = new StringBuilder();
	        while((line = br.readLine())!=null){
	            sb.append(line);
	        }
	        
	        SortedMap<String,String> resultMap = GetWxOrderno.doXMLParse(sb.toString());
			String return_code = resultMap.get("return_code");
			String return_msg = resultMap.get("return_msg");
			String result_code = resultMap.get("result_code");
			
			if("SUCCESS".equalsIgnoreCase(return_code) && "SUCCESS".equalsIgnoreCase(result_code)){
				
				checkSign(resultMap);
				
				String orderNo = resultMap.get("out_trade_no");
				
				rt_return_code = "SUCCESS";
				rt_return_msg = "ok";
				
				
			}
			else{
				rt_return_code = "FAIL";
				rt_return_msg = "call back : " + return_msg;
			}
			
		} catch (Exception e) {
			rt_return_code = "FAIL";
			rt_return_msg = "EXCEPTION";
		}
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("<xml>");
		buffer.append("<return_code><![CDATA[").append(rt_return_code).append("]]></return_code>");
		buffer.append("<return_msg><![CDATA[").append(rt_return_msg).append("]]></return_msg>");
		buffer.append("</xml>");
		
		ServletOutputStream os = response.getOutputStream();
		os.print(buffer.toString());
		os.flush();
		os.close();
	}
	
	
	public void checkSign(SortedMap<String, String> resultMap) {
		String sign = resultMap.get("sign");

		String secret = FileConfig.getInstance().getString("weixin.appsecret");

		String calSign = RequestHandler.createSign(resultMap, secret);

		if (!calSign.equals(sign)) {
			throw new RuntimeException("sign check error");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
