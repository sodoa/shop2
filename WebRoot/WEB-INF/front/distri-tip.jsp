<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/theme/newest/css/order.css" />
<style type="text/css">
.desc {
    background: #d5d5d5;
    border-radius: 0.107rem;
    padding: 0.1rem;
    margin: 0.15rem 0;
    color: #000;
}
</style>
</head>
<body>

	<div class="g-doc">
		<div class="top-fxied">
			<header class="header">
				<div class="back">
					<a href="/center/my_center.html">
						<span class="icon-back"></span>
					</a>
				</div>
				<div class="title">分销说明</div>
				<div class="subMark">
					<p></p>
				</div>
			</header>
		</div>
		<div class="scroll-content">
				<div style="height: 100%">
					<div style="width:100%;">
						<img alt="" src="/theme/newest/images/share.jpg" width="49%" >
						<img id="example2" class="example-image" width="49%" src="/center/distri-image.html"  >
					</div>
					<div style="padding: 10px;" class="desc">通过扫描上方的“我的二维码”，赶快让朋友们注册“果然逗”，享受优质绿色的水果同时，轻松挣钱吧！</div>
				</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>


