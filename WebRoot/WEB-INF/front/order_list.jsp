<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
<link href="/jslib/uiadmin/lib/laypage/1.2/skin/laypage.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/jslib/uiadmin/lib/laypage/1.2/laypage.js"></script>

</head>
<body>
	<div class="header">
		<div class="top_left1" ><a href="/center/my_center.html"><img src="/theme/images/back.png" style="width:12px"></a></div>
		<div  class="top_center1">
			订单详情
		</div>
		<div class="top_right1"></div>
	</div>

	<div class="clear"></div>
	<div class="orderDetails_nav">
		<ul>
			<a href="order_list.html?li=1"><li><p <c:if test="${li=='1'}">class="cur"</c:if>>全部</p></li></a>

			<a href="order_list.html?li=2"><li><p <c:if test="${li=='2'}">class="cur"</c:if>>待付款</p></li></a>

			<a href="order_list.html?li=3"><li><p <c:if test="${li=='3'}">class="cur"</c:if>>待发货</p></li></a>

			<a href="order_list.html?li=4"><li><p <c:if test="${li=='4'}">class="cur"</c:if>>待收货</p></li></a>

			<a href="order_list.html?li=5"><li><p <c:if test="${li=='5'}">class="cur"</c:if>>已评价</p></li></a>

		</ul>

	</div>
	
	<jsp:include page="order_list_content.jsp"></jsp:include>
<script>

	$(function(){

		if($(".order_paylist .order_li").length>0){

			$(".order_paylist .null_cart").css("display","none");

		}else{

			$(".order_paylist ul").remove();

			$(".order_paylist .count_order").remove();

		}

	})

	$(".count_order p:last-child").click(function(){

			var _this=$(this);

			dialog("提醒","您确定要删除该订单么？",function(){						

				_this.parent().parent().remove();

				if($(".order_paylist .order_li").length==0){

					$(".order_paylist .null_cart").css("display","block");		

				}

			});

	});

</script>
		
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


