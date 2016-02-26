<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
	
<!doctype html>
<html class="no-js">
<head>
	<jsp:include page="header.jsp"></jsp:include>
	<link href="/theme/css/common.css" type="text/css" rel="stylesheet" />
	<link href="/theme/css/shop.css" type="text/css" rel="stylesheet" />
	
	<style>
		.rank{height:41px;margin: 2% 4%;}
		.rank p{margin:5px 0;}
		.rank p:first-child{max-width:70%;float:left;font-size:14px;padding:5px 0;color:#fff}
		.rank p:last-child{width:30%;float:left;text-align:center;line-height:30px}
		.paim ul li p{position: absolute;top:0; background: #FF0FCB;color: #fff;width: 96%;padding: 5px 2%;text-align: center;opacity: 0.9;}
	</style>
	
	
</head>
<body>

	<div class="header" style="z-index:2">
		<div class="top_left1" onclick="/"></div>
		<div class="top_center1">排名</div>
		<div class="top_right1">
			<a href="/center/cart.html"><img src="/theme/images/spc.png" style="width:29px;height:29px">
			</a>
		</div>
	</div>

<c:forEach items="${list}" var="item" >
	<div class="conter" style="background:#fff;padding-bottom:10px">
	<p style="font-size:14px;padding:2% 0;margin:2% 4%;border-bottom:#e6e6e6 solid 1px">${item.name }</p>
	
	
	<div class="block paim" style="border-bottom:#e6e6e6 solid 1px;margin-bottom:0">
		<ul>
			<c:forEach var="subItem" varStatus="s" end="1" items="${item.list}">
			<li><div class="block-image">
				<a href="/goods-${subItem.goodsId}.html" style="cursor: pointer;">
				<img src="${subItem.img}" onerror="imagerror(this)" style="width:100%">
				<p>NO.${s.index+1 }&emsp;销量：<font color="#fdb64d">${subItem.sellcount}</font></p>
				</div>
				<div class="block-titel">${subItem.desp}</div>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	
	<c:if test="${fn:length(item.list)>2}">
		<c:forEach items="${item.list}" var="subItem" varStatus="s" begin="2">
			<div class="rank">
				<a href="/goods-${subItem.goodsId}.html" style="cursor: pointer;">
				<p style="width: <fmt:formatNumber type='number' value='${(subItem.sellcount/item.list[0].sellcount)*100/2}' maxFractionDigits="2"></fmt:formatNumber>%;background:#fe0100;">&nbsp;${subItem.sellcount}</p>
				<p style="width:auto;max-width:50%;">&nbsp;&nbsp;NO.${s.index+1 }&nbsp;【${subItem.title}】</p>
				</a>
			</div>
		</c:forEach>
	</c:if>
	</div>
</c:forEach>
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>