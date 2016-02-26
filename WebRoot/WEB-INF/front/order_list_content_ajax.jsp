<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="item" items="${list}">
		<div class="order_address">
			<p>${item.order.receiverName}:</p>
			<p>${item.order.receiverAddress }</p>
		</div>
			
			
		<c:forEach var="form" items="${item.form}">
			<ul>
				<li><img src="${form.goods.thumbnailUrl}"></li>
				<li><p>${form.goods.goodsLname}</p>
					<p>&yen;${form.detail.finalPrice}</p>
					<p>x ${form.detail.quantity}</p></li>
			</ul>
		</c:forEach>
		
		<div class="order_cost">
			<p>共1件商品</p>
			<p>实付&yen;${item.order.totalAmount}</p>
			<p>运费&yen;</p>
		</div>
		
		
		<!-- UNPAY("未支付", 0), PAYED("已支付", 1), SHIPPED("已出货", 2), COMMENT("已评价", 3); -->
		<c:choose>
			<c:when test="${item.order.status == 0}">
				<div class="count_order">
					<p style="cursor: pointer;" onclick="toPay(${item.order.orderId})">去结算</p>
					<p style="cursor: pointer;" onclick="toCancel(${item.order.orderId})">取消订单</p>
				</div>
			</c:when>
			<c:when test="${item.order.status == 1}">
				
			</c:when>
			<c:when test="${item.order.status == 2}">
				<div class="count_order">
					<p style="cursor: pointer;" onclick="toComment(${item.order.orderId})">去评论</p>
				</div>				
			</c:when>
			<c:when test="${item.order.status == 3}">
			
			</c:when>
		</c:choose>
		
		
</c:forEach>