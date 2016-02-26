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

</head>
<body class="order">
	
	<div class="header">
		<div class="top_left1" ><a href="/" ><img src="/theme/images/back.png" style="width:12px"></a></div>
		<div  class="top_center1">
			支付宝支付
		</div>
		<div class="top_right1"></div>
	</div>

	<div class="clear"></div>
	
	<div class="shop_orderist">
			${html}
	</div>
	
	<div style="height: 60px;"></div>
	
</body>
</html>


