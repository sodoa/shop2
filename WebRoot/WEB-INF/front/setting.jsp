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
		<div class="top_left1">
			<a href="/center/my_center.html"><img src="/theme/images/back.png" style="width: 12px"></a>
		</div>
		<div class="top_center1">设置</div>
		<div class="top_right1">
		</div>
	</div>

	<div class="clear"></div>

	<div class="block2">
		<a href="/center/setpassword.html">
		<div>
			<img src="/theme/images/myCenter/6.png" style="width: 16px; height: 18px">
		</div>
		<p class="name">修改密码</p>
		<p class="to">
		</p>
		</a>
	</div>
	<div class="clear"></div>
	
	<div class="block2">
		<a href="/center/about.html">
		<div>
			<img src="/theme/images/myCenter/6.png" style="width: 16px; height: 18px">
		</div>
		<p class="name">关于我们</p>
		<p class="to">
		</p>
		</a>
	</div>
	
	<div style="text-align: center;margin-top: 10px;" >
		<button type="button" onclick="javascript:window.location.href='/logout.html'"  style="cursor:pointer;padding : 5px ;width:300px;height: 60px;">退出登录</button>
	</div>

	<div style="height: 80px;"></div>

	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


