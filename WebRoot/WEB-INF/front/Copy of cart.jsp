<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/theme/newest/css/order.css" />
<link rel="stylesheet" href="/theme/newest/css/jquery.spinner.css" />
<script type="text/javascript" src="/theme/js/jquery.spinner.js"></script>
</head>
<body>
	<div class="g-doc">
		<div class="top-fxied">
			<header class="header">
				<div class="back">
					<a href="/">
						<span class="icon-back"></span>
					</a>
				</div>
				<div class="title">购物车</div>
				<div class="subMark">
					<p><a href="javascript:void(0)" onclick="empty_cart()">清空</a></p>
				</div>
			</header>
		</div>
		<div class="scroll-content">
			<div class="order-manage">
				<ul class="m-cartlist">
					<li>
						<div class="item-laber">
							<div class="checkbox">
								<input type="checkbox" class="cartList-check" name="checkbox1" id="s11" checked="checked">
							</div>
						</div>
						<div class="m-tab-list">
							<div class="m-cartlist-img">
								<img src="images/furit.jpg">
							</div>
							<div class="m-cartlist-info">
								<h3>顶级红富士苹果热卖 5斤包邮</h3>
								<p>第二件半价越南红心火龙果1kg 第二件</P>
								<p>¥12.8 20.8</p>
								<div class="num-btn">
									<input type="text" class="spinner" />
								</div>
							</div>
						</div>
					</li>
				</ul>
				
			</div>
		</div>
		<div class="m-tab-btn">
			<div class="info">
				共<span class="txtOrange">3</span>件商品 共计：<span class="txtOrange">¥258.5</span>
			</div>
			<div class="btn">
				<a class="h" href="#">取消订单</a>
				<a class="">去结算</a>
			</div>
		</div>
	</div>
	
	
	
	
	
	<div class="header">
		<div class="top_left1">
			<a href="/">
				<img src="/theme/images/back.png" style="width: 12px">
			</a>
		</div>
		<div class="top_center1">购物车</div>
		<div class="top_right1">
			<a href="javascript:void(0)" onclick="empty_cart()">清空</a>
		</div>
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
					<li>
						<a href="/goods-${CartInfoVo.goods[st.index].goodsId}.html">
							<img src="${CartInfoVo.goods[st.index].thumbnailUrl}" style="width: 100px; height: 100px">
						</a>
					</li>
					<li>
						<p>${CartInfoVo.goods[st.index].goodsName}</p>
						<p>${CartInfoVo.goods[st.index].goodsDes }</p>
						<div class="updateShopNum">
							<p style="cursor: pointer;" name="number_jianjian" id="number_jianjian_${cartitem.cartId}" data="${cartitem.cartId}">-</p>
							<input type="number" name="number_value" readonly="readonly" id="number_value_${cartitem.cartId}" data="${cartitem.cartId}"
								" value="${cartitem.quantity}" />
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
	<form action="/cart-number.html" id="number_operator_form" method="post">
		<input type="hidden" name="number_operator" /> <input type="hidden" name="cartId" />
	</form>
	<c:if test="${CartInfoVo.hasGoods}">
		<ul class="shop_carTopay">
			<li style="cursor: pointer;">
				<p onclick="javascript:goToOrder()">去结算</p>
			</li>
			<li>
				<p>
					<span style="font-size: 16px; color: red;"> 合计：&yen;${CartInfoVo.totalAmount} </span> &nbsp; 原价：
					<del>&yen;${CartInfoVo.orginAmount}</del>
				</p>
			</li>
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
		
		function goToOrder(){
			window.location.href = "/center/order.html?p=" + GetUrlRelativePath();
		}
		
	</script>
</body>
</html>
