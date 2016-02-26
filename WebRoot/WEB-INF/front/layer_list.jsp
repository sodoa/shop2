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
			<a href="/center/my_center2.html"><img src="/theme/images/back.png" style="width: 12px"></a>
		</div>
		<div class="top_center1">分销下级用户</div>
		<div class="top_right1">
			
		</div>
	</div>

	<div class="clear"></div>

	<c:forEach var="item" items="${list1}">
			<div class="block3" style="border: 0px">
				<table style="border: 0px">
					<tr>
						<td>【一级】：${item.displayname}</td>
						<td>${item.account}</td>
					</tr>
				</table>
			</div>
	</c:forEach>
	
	<c:forEach var="item" items="${list2}">
			<div class="block3" style="border: 0px">
				<table style="border: 0px">
					<tr>
						<td>【二级】：${item.displayname}</td>
						<td>${item.account}</td>
					</tr>
				</table>
			</div>
	</c:forEach>	

	<div style="height: 80px;"></div>

	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


