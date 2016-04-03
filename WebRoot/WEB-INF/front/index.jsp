<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div class="g-doc">
		<div class="top-fxied">
			<header class="index-top-bar">
				<div class="s-input-select">
					<form method="get" class="searchForm">
						<div class="text-area">
							<input id="search_word" type="text" name="keyword" class="text" maxlength="18" id="keyword" value="搜索您想要的宝贝" >
						</div>
						<input type="submit" class="btn-sub">
					</form>
				</div>
				<a href="/cart.html" class="top-bar-cart">
					<div class="icons-cart">
						<i class="cart-sales-nums">0</i>
					</div>
				</a>
			</header>
		</div>
		<div class="scroll-content" style="margin: 0.75rem auto 0.83rem">
			<!-- 内容区域 -->
			<div class="scrollview">
				<!-- 焦点图 -->
				<div class="m-slider">
					<div class="m-slider-con-wrap" id="JslideWrap" style="display: block;">
						<div class="m-slider-con">
							<a class="m-slider-item" href="javascript:void(0);">
								<img src="/theme/newest/images/index-pic1.jpg" />
							</a>
							<a class="m-slider-item" href="javascript:void(0);">
								<img src="/theme/newest/images/index-pic2.jpg" />
							</a>
						</div>
					</div>
					<div class="m-slider-nav" id="JslideNav"></div>
				</div>
				<!-- 菜单选择 -->
				<div class="m-block m-menu">
					<div class="m-labels">
						<a href="g-s.html?theme=1" class="ico-fruit">全部水果</a>
						<a href="g-s.html?theme=4" class="ico-girlfriend">送女友</a>
						<a href="g-s.html?theme=2" class="ico-parents">孝敬爸妈</a>
					</div>
					<div class="m-labels">
						<a href="g-s.html?theme=3" class="ico-player">游戏玩家</a>
						<a href="g-l.html?theme=20" class="ico-activity">火爆活动</a>
						<a href="ac.html" class="ico-money">分销赚钱</a>
					</div>
				</div>
			</div>
			<!-- 火爆单品 -->
			<div class="m-block">
				<div class="m-index-th">爆品</div>
				<div class="m-con">
					<ul class="list-pic">
						<c:forEach var="item" items="${burstList}">
							<li>
								<a href="/goods-${item.goodsId}.html">
									<img src="${item.thumbnailUrl}" onerror="imagerror(this)" width="694" height="284" defimage="defimage"> <span><p class="discount">${item.discount}折</p>
										<p class="name" style="overflow: hidden; width: 60%">${item.goodsLname}</p></span>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="scrollup.jsp"></jsp:include>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	
	<script type="text/javascript" src="/theme/js/wap.js"></script>
		<script type="text/javascript">
		$(function(){
			
			$("#search_word").bind("focusin",function(){
				window.location.href= "/g-s.html?theme=1";
			});
			
		});
	</script>
</body>
</html>