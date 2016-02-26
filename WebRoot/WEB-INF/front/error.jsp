<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/shop.css" type="text/css" rel="stylesheet" />
<link href="/theme/css/details.css" type="text/css" rel="stylesheet" />

<style type="text/css">

.detailsBlock11{width:100%;background-color:#fff}

</style>

</head>
<body>

	<div class="header">
		<div class="top_left1">
			<a href="/"><img src="/theme/images/back.png" style="width:12px"></a>
		</div>
		<div  class="top_center1">
			错误信息
		</div>
	</div>
	
	<div class="detailsBlock11">
			<div style="padding:10px;text-align: center;margin-top: 30px;margin-bottom: 30px;border: 1px solid #eee;">${msg}</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


