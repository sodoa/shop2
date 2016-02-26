<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>

<script type="text/javascript" src="/jslib/loading/js/msgbox.js"></script>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
<link href="/theme/css/order.css" type="text/css" rel="stylesheet" />
<link href="/jslib/loading/css/msgbox.css" type="text/css" rel="stylesheet" />

</head>
<body class="order">
	
	<div class="header">
		<div class="top_left1" ><a href="/" ><img src="/theme/images/back.png" style="width:12px"></a></div>
		<div  class="top_center1">
			微信支付
		</div>
		<div class="top_right1"></div>
	</div>

	<div class="clear"></div>
	
	<div class="shop_orderist">
		
		<div id="tipmsg" class="" style="border: 1px solid #eee;padding-top: 10px;padding-bottom: 10px;padding-left: 30px;text-align: center;">
				正在支付当中...
				
		</div>
		
		<div>  		 "appId" : "${appId}","timeStamp" : "${timeStamp}", "nonceStr" : "${nonceStr}", "package" : "${packageValue}","signType" : "MD5", "paySign" : "${sign}" 
		</div>
		<div id="fakeloader"></div>
		<div style="margin-top: 20px;margin-bottom:20px;text-align: center;">
			<a href="/center/order_list.html" style="padding: 5px;border: 1px solid #eee;">返回订单中心</a>
			<a href="/" style="padding: 5px;border: 1px solid #eee;">返回首页</a>
		</div>
		
	  <script type="text/javascript">
	  
	  $(function(){
		  
		  ZENG.msgbox.show("正在初始安全支付...", 6);
		  
		  if (typeof WeixinJSBridge == "undefined"){
			   if( document.addEventListener ){
			       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
			   }else if (document.attachEvent){
			       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
			       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
			   }
			}else{
			   onBridgeReady();
			}
		  
	  });
	  
  	function onBridgeReady(){
		 WeixinJSBridge.invoke('getBrandWCPayRequest',{
  		 "appId" : "${appId}","timeStamp" : "${timeStamp}", "nonceStr" : "${nonceStr}", "package" : "${packageValue}","signType" : "MD5", "paySign" : "${sign}" 
   			},function(res){
				WeixinJSBridge.log(res.err_msg);
// 				alert(res.err_code + res.err_desc + res.err_msg);
	            if(res.err_msg == "get_brand_wcpay_request:ok"){  
	                $("#tipmsg").html("微信支付成功!");
	            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
	                $("#tipmsg").html("微信支付成功!");
	            }else{  
	            	$("#tipmsg").html("支付失败!" + res.err_msg);
	            } 
	            
	            ZENG.msgbox._hide();
			});
	}
  </script>
	</div>
	
	<div style="height: 60px;"></div>
	
</body>
</html>


