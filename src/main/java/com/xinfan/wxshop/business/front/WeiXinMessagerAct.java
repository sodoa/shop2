package com.xinfan.wxshop.business.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thoughtworks.xstream.XStream;
import com.xinfan.wxshop.business.entity.RedRecord;
import com.xinfan.wxshop.business.pay.weixin.utils.Sha1Util;
import com.xinfan.wxshop.business.service.RedPacketService;
import com.xinfan.wxshop.business.util.SerializeXmlUtil;
import com.xinfan.wxshop.business.vo.InputMessage;
import com.xinfan.wxshop.business.vo.OutputMessage;
import com.xinfan.wxshop.common.config.FileConfig;

@Controller
public class WeiXinMessagerAct {

	private static final Logger logger = LoggerFactory.getLogger(WeiXinMessagerAct.class);

	@Autowired
	private RedPacketService RedPacketService;

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>1348831860</CreateTime> <MsgType><![CDATA[text]]></MsgType>
	 * <Content><![CDATA[this is a test]]></Content>
	 * <MsgId>1234567890123456</MsgId> </xml>
	 */

	@RequestMapping("/weixin/messger")
	public void weixin1(HttpServletRequest request, HttpServletResponse response) throws IOException {

		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			System.out.println(signature);
			System.out.println(timestamp);
			System.out.println(nonce);
			System.out.println(echostr);
			access(request, response);
		} else {
			// 进入POST聊天处理
			logger.info("enter post");
			try {
				// 接收消息并返回消息
				acceptMessage(request, response);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private String access(HttpServletRequest request, HttpServletResponse response) {
		
		String token = FileConfig.getInstance().getString("weixin.messager.token");
		
		// 验证URL真实性
		System.out.println("进入验证access");
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串
		List<String> params = new ArrayList<String>();
		params.add(token);
		params.add(timestamp);
		params.add(nonce);
		
		logger.info(params.toString());
		
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String temp = Sha1Util.getSha1(params.get(0) + params.get(1) + params.get(2));
		if (temp.equals(signature)) {
			try {
				response.getWriter().write(echostr);
				logger.info("成功返回 echostr：" + echostr);
				return echostr;
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		logger.info("失败 认证 echostr：" + echostr);
		return null;
	}
	
	public static void main(String[] args){
		
		String xml = "<xml><ToUserName><![CDATA[gh_46560b440d13]]></ToUserName><FromUserName><![CDATA[oVProsuNsZqTdBjfhcgvHcaz139o]]></FromUserName><CreateTime>1456566768</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[计算机中]]></Content><MsgId>6255906633401811497</MsgId></xml> ";
		// 将xml内容转换为InputMessage对象
		XStream xs = SerializeXmlUtil.createXstream();
		xs.processAnnotations(InputMessage.class);
		xs.processAnnotations(OutputMessage.class);
		xs.alias("xml", InputMessage.class);
		InputMessage inputMsg = (InputMessage) xs.fromXML(xml.toString());
		
		System.out.println(inputMsg);
	}

	private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 处理接收消息
		ServletInputStream in = request.getInputStream();
		// 将POST流转换为XStream对象
		XStream xs = SerializeXmlUtil.createXstream();
		xs.processAnnotations(InputMessage.class);
		xs.processAnnotations(OutputMessage.class);
		// 将指定节点下的xml节点数据映射为对象
		xs.alias("xml", InputMessage.class);
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		
		logger.info("" +xmlMsg.toString());
		
		// 将xml内容转换为InputMessage对象
		InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());

		String servername = inputMsg.getToUserName();// 服务端
		String custermname = inputMsg.getFromUserName();// 客户端
		long createTime = inputMsg.getCreateTime();// 接收时间
		Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间

		// 取得消息类型
		String msgType = inputMsg.getMsgType();
		// 根据消息类型获取对应的消息内容
		if (msgType.equals("text") && inputMsg.getContent().contains("红包")) {
			// 文本消息
			logger.info("开发者微信号：" + inputMsg.getToUserName());
			logger.info("发送方帐号：" + inputMsg.getFromUserName());
			logger.info("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));
			logger.info("消息内容：" + inputMsg.getContent());
			logger.info("消息Id：" + inputMsg.getMsgId());
			
			String msgContent = "";
			
			try{
				
				RedRecord record = new RedRecord();
				record.setFromusername(inputMsg.getFromUserName());
				record.setMsgid(String.valueOf(inputMsg.getMsgId()));
				record.setClientIp(request.getRemoteAddr());
				msgContent = RedPacketService.updatePickupRedPacket(record);
			}
			catch(Exception e){
				logger.error(e.getMessage(),e);
				msgContent = "红包领取失败";
			}
			
			StringBuffer str = new StringBuffer();
			str.append("<xml>");
			str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
			str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
			str.append("<CreateTime>" + returnTime + "</CreateTime>");
			str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
			str.append("<Content><![CDATA[" + msgContent + "]]></Content>");
			str.append("</xml>");
			logger.info(str.toString());
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(str.toString());
		}
	}

}
