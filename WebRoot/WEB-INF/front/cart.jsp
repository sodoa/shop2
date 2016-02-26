<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<div class="header">
		<div class="top_left1" ><a href="/" ><img src="/theme/images/back.png" style="width:12px"></a></div>
		<div  class="top_center1">
			购物车
		</div>
		<div class="top_right1"><a href="javascript:void(0)" onclick="empty_cart()">清空</a></div>
	</div>

	<div class="clear"></div>


	<div class="shop_carlist">
	
		<c:if test="${!CartInfoVo.hasGoods}">
			<div class="null_cart">
				<p>亲,您还没有任何商品！</p>
				<p>
					<a href="/">马上去购物吧!</a>
				</p>
			</div>
		</c:if>
		
		<c:if test="${CartInfoVo.hasGoods}">
			<c:forEach items="${CartInfoVo.carts}" var="cartitem" varStatus="st">
			<ul>
				<li class="shopSelect">√</li>
				<li><a href="/goods-${CartInfoVo.goods[st.index].goodsId}.html"><img src="${CartInfoVo.goods[st.index].thumbnailUrl}"
					style="width: 100px; height: 100px"></a></li>
				<li>
					<p>${CartInfoVo.goods[st.index].goodsName}</p>
					<p>${CartInfoVo.goods[st.index].goodsDes }</p>
					<div class="updateShopNum">
						<p style="cursor: pointer;" name="number_jianjian" id="number_jianjian_${cartitem.cartId}" data="${cartitem.cartId}">-</p>
						<input type="number" name="number_value" readonly="readonly" id="number_value_${cartitem.cartId}" data="${cartitem.cartId}" " value="${cartitem.quantity}" />
						<p style="cursor: pointer;" name="number_jiajia" id="number_jiajia_${cartitem.cartId}" data="${cartitem.cartId}">+</p>
					</div>
				</li>
				<li>
					<p>&yen;${CartInfoVo.goods[st.index].finalPrices}</p>
					<p>
						<s>&yen;${CartInfoVo.goods[st.index].orginPrices}</s>
					</p>
					<div class="shopDelet" data="${cartitem.cartId}">
						<img src="/theme/images/shopCar/delet.png" style="width: 16px;">
					</div>
				</li>
			</ul>
		</c:forEach>
		
		</c:if>

	</div>
	
	<form action="/center/cart-number.html" id="number_operator_form" method="post">
		<input type="hidden" name="number_operator" /> 
		<input type="hidden" name="cartId" />
	</form>

 	<c:if test="${CartInfoVo.hasGoods}">
	<ul class="shop_carTopay">
		<li style="cursor: pointer;"><p onclick="javascript:window.location.href='/center/order.html'" >去结算</p></li>
		<li><p > <span  style="font-size: 16px;color: red;"> 合计：&yen;${CartInfoVo.totalAmount} </span> &nbsp; 原价：<del>&yen;${CartInfoVo.orginAmount}</del></p></li>
	</ul>
	</c:if>
	
	
	<script type="text/javascript">
		$(function() {

			$("*[name='number_jiajia'] ").click(function() {
								var cartid = $(this).attr("data");
								$("#number_operator_form input[name='number_operator'] ").val("1");
								$("#number_operator_form input[name='cartId'] ").val(cartid);
								$("#number_operator_form").submit();
							});

			$("*[name='number_jianjian']")
					.click(
							function() {
								var cartid = $(this).attr("data");
								$("#number_operator_form input[name='number_operator'] ").val("2");
								$("#number_operator_form input[name='cartId'] ").val(cartid);
								$("#number_operator_form").submit();
							});

		});
		
		
		$(".shopDelet").click(function(){

			var _this=$(this);

			dialog("提醒","您确定要删除该商品么？",function(){						
				var cartId = _this.attr("data");
				window.location.href="cart-del.html?cid="+cartId;
			});

		});
		
		
		function empty_cart(){
			dialog("提醒","您确定要清空购物车？",function(){						
				window.location.href="empty_cart.html";
			});
		}
		
	</script>

</body>
</html>


