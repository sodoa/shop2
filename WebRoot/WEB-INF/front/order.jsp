<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/jslib/uiadmin/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="/theme/newest/css/order.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/jslib/uiadmin/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="/jslib/uiadmin/lib/Validform/5.3.2/Validform.min.js"></script> 
</head>
<body>

<div class="g-doc">
    <div class="top-fxied">
            <header class="header"> 
                <div class="back"><a href="#"><span class="icon-back"></span></a></div> 
                <div class="title">下订单</div> 
                <div class="subMark"><p></p></div> 
            </header>
  </div>
    <form action="/center/take-order.html" id="order_form" method="post">
    <div class="scroll-content">
    	<ul class="m-order-addresslist">       
                 <li>
					<input type="hidden" name="deliveryId" value="${address.deliveryId}" />
					<div class="m-order-address">
					    <p>${address.receiverName}<span>${address.receiverPhone }</span></p>
					    <p>${address.address}</p>
					</div>                 
               		<a href="javascript:void();"  class="m-order-address-edit" onclick="selectAddress()">编辑</a>  
         		 </li>
            </ul>
            
        <div class="order-manage"> 
               <ul class="m-cartlist bgWhite">
               		<c:if test="${CartInfoVo.hasGoods}">
						<c:forEach items="${CartInfoVo.carts}" var="cartitem" varStatus="st">
		               		<li>
		                    	<div class="m-tab-list">
	                                   <div class="m-cartlist-img"><img src="${CartInfoVo.goods[st.index].thumbnailUrl}" style="width: 80px; height: 80px"></div>
	                                   <div class="m-cartlist-info">
	                                       <h3>${CartInfoVo.goods[st.index].goodsName}</h3>
	                                       <h4>${CartInfoVo.goods[st.index].goodsLname}</h4>
	                                       <h5>&yen;${CartInfoVo.goods[st.index].finalPrices} <span class="m-cartlist-nums">x ${CartInfoVo.carts[st.index].quantity}</span></h5>
	                                   </div>
		                      </div> 
		                    </li>
						</c:forEach>
					</c:if>	
               </ul>	 
         </div>
        
        <div class="m-trade-pay">
        	<div class="pay-cell">
                <div class="pay-hd"><input type="checkbox" class="cartList-check" name="checkbox1" checked="checked"></div>
                <div class="pay-bd"><span class="zIcon"></span></div>
                <div class="pay-ft">
      				<span value="1"><img width="16" height="16" src="/theme/images/radio_no.png"></span><label>&nbsp;&nbsp;&nbsp;维信支付</label>          
               	</div>
            </div>
            <div class="pay-cell">
                <div class="pay-hd"><input type="checkbox" class="cartList-check" name="checkbox1" value="2"></div>
                <div class="pay-bd"><span class="wIcon"></span></div>
                <div class="pay-ft"><span value="2"><img width="16" height="16" src="/theme/images/radio_yes.png"></span><label>&nbsp;&nbsp;&nbsp;支付宝支付</label></div>
            </div>
        </div>
 
        <div class="m-trade-pay">
			<p style="float">给卖家留言:&emsp;</p>	
			<textarea  datatype="*0-100" name="order_remark" rows="3" cols="30" style="width:99%;border: 1px solid #eee;"></textarea>
        </div> 
      
       <div class="m-cells-title">
       <p style="float">给卖家留言:&emsp;</p>	
			<textarea  datatype="*0-100" name="order_remark" rows="3" cols="30" style="width:99%;border: 1px solid #eee;"></textarea>
       </div>
       <div class="">
       
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
	
       </div>
    </div>
    </form>
    
    <div style="height: 60px;"></div>
    
</div>

	
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


