package com.xinfan.wxshop.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.RedPacketDao;
import com.xinfan.wxshop.business.dao.RedRecordDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.entity.RedPacket;
import com.xinfan.wxshop.business.entity.RedRecord;
import com.xinfan.wxshop.business.pay.hongbao.MoneyUtils;
import com.xinfan.wxshop.business.pay.weixin.WxHttpsUtils;
import com.xinfan.wxshop.common.config.FileConfig;
import com.xinfan.wxshop.common.util.JSONUtils;
import com.xinfan.wxshop.common.util.TimeUtils;

public class RedPacketService {

	private static final Logger logger = LoggerFactory.getLogger(RedPacketService.class);

	@Autowired
	private RedRecordDao redRecordDao;

	@Autowired
	private RedPacketDao redPacketDao;
	
	@Autowired
	private SequenceDao sequenceDao;

	public String updatePickupRedPacket(RedRecord record) {
		String lined = getLined();

		RedPacket packet = redPacketDao.selectByPrimaryKey(lined);
		if (packet == null) {
			return "今天的红包已经被瓜分完毕，明天中午12点继续投放";
		}

		if (packet.getPickup() >= packet.getTotal()) {
			return "今天的红包已经被瓜分完毕，明天中午12点继续投放";
		}

		RedRecord search = new RedRecord();
		search.setLined(lined);
		search.setFromusername(record.getFromusername());
		List<RedRecord> pickupList = redRecordDao.selectByFromusename(search);
		if (!pickupList.isEmpty()) {
			return "今天的红包已经领过了";
		}
		
		record.setCreatedate(TimeUtils.getCurrentTime());
		record.setRdid(sequenceDao.getSequence(SequenceConstants.SEQ_RED_RECORD));
		record.setAmount(packet.getAmount());
		record.setLined(lined);
		redRecordDao.insertSelective(record);
		
		RedPacket updatePacket = new RedPacket();
		updatePacket.setPickup(packet.getPickup()+1);
		updatePacket.setLined(lined);
		redPacketDao.updateByPrimaryKeySelective(updatePacket);
		
		// 商户相关资料
		String appid = FileConfig.getInstance().getString("weixin.appid");
		String appsecret = FileConfig.getInstance().getString("weixin.appsecret");
		String partner = FileConfig.getInstance().getString("weixin.mch_id");

		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
		
		String orderNNo =  MoneyUtils.getOrderNo(String.valueOf(record.getRdid()),partner); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nonce_str", MoneyUtils.buildRandom());//随机字符串
		map.put("mch_billno", orderNNo);//商户订单
		map.put("mch_id", partner);//商户号
		map.put("wxappid", appid);//商户appid
		//map.put("nick_name", "新帆科技");//提供方名称
		map.put("send_name", "果然逗红包");//用户名
		map.put("re_openid", record.getFromusername());//用户openid
		map.put("total_amount", record.getAmount());//付款金额
		//map.put("min_value", money *100);//最小红包
		//map.put("max_value", money *100);//最大红包
		map.put("total_num", 1);//红包发送总人数
		map.put("wishing", "果然逗日常红包，天天有领");//红包祝福语
		map.put("client_ip", record.getClientIp());//ip地址
		map.put("act_name", "日常红包");//活动名称
		map.put("remark", "果然逗日常红包，天天有领");//备注
		
		map.put("sign", MoneyUtils.createSign(map,appsecret));//签名
			
		Map<String,String> resultMap = WxHttpsUtils.SSLPostXmlWithResult(url, MoneyUtils.createXML(map));
		if(resultMap!=null){
			String return_code = resultMap.get("return_code");
			String return_msg = resultMap.get("return_msg");
			
			logger.info(JSONUtils.toJSONString(resultMap));
			
			if("SUCCESS".equalsIgnoreCase(return_code)){
				return "红包领取成功";
			}
		}

		return "红包领取失败";
	}

	private String getLined() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Date current = new Date();

		String lined = sdf.format(current);

		logger.info("lined : " + lined);

		return lined;

	}

}
