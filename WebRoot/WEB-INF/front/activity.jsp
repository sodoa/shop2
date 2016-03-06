<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/common.css" type="text/css" rel="stylesheet" />
<link href="/theme/css/shop.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<div  style="background-color: white;padding-top: 5px;padding-left: 5px;padding-right: 5px;widht:92%;    margin: 2% 4%;">
			<b>分享下面文章可以为您带来收益用户
			</b>
	</div>	
	
	<div class="block">

		<ul>
			<c:forEach var="item" items="${list}">
				<li>
					<a href="/ac-${item.id}.html">
					<div class="block-image">
						<img src="${item.img}" width="200" height="200"
							style="width: 100%">
					</div>

					<div class="block-titel">${item.title}</div>
					</a>
				</li>
			</c:forEach>
		</ul>

	</div>


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>