<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/jslib/uiadmin/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />

<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
<link href="/theme/css/order.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/jslib/uiadmin/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="/jslib/uiadmin/lib/Validform/5.3.2/Validform.min.js"></script> 

</head>
<body class="order">
	
	<form action="/center/take-order.html" id="order_form" method="post">
	
	<div class="header">
		<div class="top_left1" ><a href="/" ><img src="/theme/images/back.png" style="width:12px"></a></div>
		<div  class="top_center1">
			下订单
		</div>
		<div class="top_right1"></div>
	</div>

	<div class="clear"></div>
	
	<div class="shop_orderist">
		<input type="hidden" name="deliveryId" value="${address.deliveryId}" />
		<div class="address">
		    <div class="left"><img src="/assets/i/dingdanxiang/01.png"></div>
		    <div class="right">
			    <p>${address.receiverName}<span>${address.receiverPhone }</span></p>
			    <p>${address.address}</p>
		    </div>
		    <div class="edit">
		    	<p><a href="javascript:void();" onclick="selectAddress()">编辑</a></p>
		    </div>     
		</div>
	</div>
	
	<div class="shop_orderist2" style="height: 100px;background-color: #fff;" >
		<div class="address2">
		     <div class="left"><img src="/assets/i/dingdanxiang/03.PNG"></div>
		     <div class="right" style="margin-top: 10px;">
		     	<input type="hidden"  value="2" name="paytype" id="paytype" />
  
		     	
				<ul id="paytype_div">
					<li style="padding: 10px;margin:5px;border:1px solid #eee;cursor: pointer;">
						<span value="1"><img width="16" height="16" src="/theme/images/radio_no.png"></span><label>&nbsp;&nbsp;&nbsp;维信支付</label>
					</li>
					<li style="padding: 10px;margin:5px;border:1px solid #eee;cursor: pointer;">
						<span value="2"><img width="16" height="16" src="/theme/images/radio_yes.png"></span><label>&nbsp;&nbsp;&nbsp;支付宝支付</label>
					</li>
				</ul>
		     </div>
	     </div>
	</div>
		
	<div class="order_paylist">
		<div class="order_li">
			<c:if test="${CartInfoVo.hasGoods}">
				<c:forEach items="${CartInfoVo.carts}" var="cartitem" varStatus="st">
					<ul>
						<li style="width: 20%"><a href="/goods-${CartInfoVo.goods[st.index].goodsId}.html"><img src="${CartInfoVo.goods[st.index].thumbnailUrl}"
							style="width: 80px; height: 80px"></a></li>
						<li style="width: 70%">
							<p>${CartInfoVo.goods[st.index].goodsName}</p>
							<p style="word-break:break-all;overflow: hidden;word-wrap:break-word;">${CartInfoVo.goods[st.index].goodsDes }</p>
							<p>&yen;${CartInfoVo.goods[st.index].finalPrices}</p>
							<p>x ${CartInfoVo.carts[st.index].quantity}</p>  
						</li>
					</ul>
				</c:forEach>
			</c:if>				
		</div>
	</div>
	
	<div style="background-color:#fff;padding: 2px 10px 2px 10px;clear:both;" >
			<p style="float">给卖家留言:&emsp;</p>	
			<textarea  datatype="*0-100" name="order_remark" rows="3" cols="30" style="width:99%;border: 1px solid #eee;"></textarea>
	</div >
	
	
	<c:if test="${CartInfoVo.hasGoods}">
		<ul class="shop_carTopay">
			<li style="cursor: pointer;">
				<c:choose>
					<c:when test="${empty address}">
						<p style="color: gray;">去结算</p>
					</c:when>
					<c:otherwise>
						<p onclick="sumibtForm()">去结算</p>
					</c:otherwise>
				</c:choose>
			</li>
			<li><p> <span  style="font-size: 16px;color: red;"> 合计：&yen;${CartInfoVo.totalAmount} </span> &nbsp; 原价：<del>&yen;${CartInfoVo.orginAmount}</del></p></li>
		</ul>
	</c:if>
	
	</form>
	
	<div style="height: 60px;"></div>
	
<script type="text/javascript">
			
	$(function(){
		
		$("ul .toShowPayment").click(function(){
			
			//payment_li_current
			$("ul .toShowPayment").removeClass("payment_li_current");
			$(this).addClass("payment_li_current");
			$("#order_payment_type").val($(this).attr("type"));
			
		});
		
		//alert(typeof WeixinJSBridge);
		
		if (!isWeiXinBrowser()){
			$("#paytype_div>li:last").click();
			$("#paytype_div>li:first").remove();
		}
		
	});
	
	
	function sumibtForm(){
		$("#order_form").submit();
	}
	
	
	function selectAddress(){
		window.location.href="/center/address_list.html?from=/center/order.html&opt=1";
	}
	
	$(function(){
		$("#order_form").Validform({
			tiptype:2,
			callback:function(form){
				
				form[0].submit();
				//var index = parent.layer.getFrameIndex(window.name);
				//parent.layer.close(index);
			}
		});
		
		
		$("#paytype_div li").click(function(){
			var selectedValue = $(this).find("span").attr("value");
			$("#paytype").val(selectedValue);
			$(this).parent().find("span").each(function(){
				
				var listValue = $(this).attr("value");
				if(listValue == selectedValue){
					$(this).find("img").attr("src","/theme/images/radio_yes.png");
				}
				else{
					$(this).find("img").attr("src","/theme/images/radio_no.png");
				}
				
			});
		});
	});
	
</script>
	
</body>
</html>


