<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!doctype html>
<html class="no-js">
<head>
	<jsp:include page="header.jsp"></jsp:include>
	
	<link href="/theme/css/index.css" type="text/css" rel="stylesheet" />
	<link type="text/css" href="/theme/css/slider.css" rel="stylesheet" />
	<script type="text/javascript" src="/theme/js/jquery.touchSlider.js"></script>
</head>
<body>
	<div class="header">
		<div class="top_left">
			<a href="#" style="position: absolute;top: 5px;left: 5px;"><img src="/theme/images/logo/logo.png" width="60" height="42"> </a>
		</div>
		<div class="top_center">
			<a href="#"><img src="/theme/images/Search.png"></a>
			<input name="search_word" id="search_word" placeholder="输入商品名称或关键字" maxlength="20" />
		</div>

		<div class="top_right">
			<a href="/cart.html"><img src="/theme/images/spc.png" style="width:29px;height:29px">
			</a>
		</div>
	</div>

	<script>

		function frame_animation() {
			var className = $("#frame")[0].className;
			if (className == 'frame') {
				$("#frame").removeClass("frame");
				$("#frame").addClass("frame_down");
			}

			if (className == 'frame_down') {
				$("#frame").removeClass("frame_down");
				$("#frame").addClass("frame_up");
			}

			if (className == 'frame_up') {
				$("#frame").removeClass("frame_up");
				$("#frame").addClass("frame_down");
			}
		}

	</script>

	<!--

轮播

	     

-->
	<script type="text/javascript">

		$(document).ready(

				function() {
					$dragBln = false;
					$(".main_image").touchSlider(
							{

								flexible : true,

								speed : 200,

								btn_prev : $("#btn_prev"),

								btn_next : $("#btn_next"),

								paging : $(".flicking_con a"),

								counter : function(e) {

									$(".flicking_con a").removeClass("on").eq(

											e.current - 1).addClass("on");

								}

							});



					$(".main_image").bind("mousedown", function() {

						$dragBln = false;

					});



					$(".main_image").bind("dragstart", function() {

						$dragBln = true;

					});



					$(".main_image a").click(function() {

						if ($dragBln) {

							return false;

						}

					});



					timer = setInterval(function() {

						$("#btn_next").click();

					}, 5000);



					$(".main_visual").hover(function() {

						clearInterval(timer);

					}, function() {

						timer = setInterval(function() {

							$("#btn_next").click();

						}, 5000);

					});



					$(".main_image").bind("touchstart", function() {

						clearInterval(timer);

					}).bind("touchend", function() {

						timer = setInterval(function() {

							$("#btn_next").click();

						}, 5000);

					});


				});
		
	</script>

	<div class="main_visual">

		<div class="flicking_con">

			<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>

			<a href="#">5</a>

		</div>

		<div class="main_image">

			<ul>

				<li><img src="/theme/images/slider/1.png"

					style="width:100%;height:100%;" /></li>

				<li><img src="/theme/images/slider/1.png"

					style="width:100%;height:100%;" /></li>

				<li><img src="/theme/images/slider/1.png"

					style="width:100%;height:100%;" /></li>

				<li><img src="/theme/images/slider/1.png"

					style="width:100%;height:100%;" /></li>

				<li><img src="/theme/images/slider/1.png"

					style="width:100%;height:100%;" /></li>

			</ul>

			<a href="javascript:;" id="btn_prev"></a> <a href="javascript:;"

				id="btn_next"></a>

		</div>

	</div>

	

	<ul class="focus">
		<!-- 此处由于inline-block属性BUG a标签结束标签必须分行写 -->
		<li><a href="g-s.html?init=12"><img src="/theme/images/index/focus1.png"></a></li> 
		<li><a href="g-s.html?init=12"><img src="/theme/images/index/focus2.png">
		</a></li> 
		<li><a href="g-s.html?init=12"><img src="/theme/images/index/focus3.png">
		</a></li> 
		<li><a href="g-s.html?init=12"><img src="/theme/images/index/focus4.png">
		</a></li> 
		<li><a href="/ac.html"><img src="/theme/images/index/focus5.png">
		</a></li> 
		<li><a href="/sh.html"><img src="/theme/images/index/focus6.png">
		</a></li> 
	</ul>
<script type="text/javascript">
	$(function(){
		
		$(".focus").css("height",($(".focus").width()/3)*(122/162)*2);
	});
	
</script>
	

	<div class=" focus3">

		<div class="bao"><p>爆品</p></div>
		<c:forEach var="item" items="${burstList}">
			<div class="shop"><a href="/goods-${item.goodsId}.html"><img src="${item.thumbnailUrl}" onerror="imagerror(this)" width="694" height="284" defimage="defimage">
				<span><p class="discount" >${item.discount}折</p><p class="name" style="overflow: hidden;width:60%">${item.goodsLname}</p></span>
				</a>
			</div>
		</c:forEach>
	</div>


	<div class="focus3">

		<div class="hot"><p>热卖</p></div>
		<c:forEach var="item" items="${hotList}">
			<div class="shop"><a href="/goods-${item.goodsId}.html"><img src="${item.thumbnailUrl}"  onerror="imagerror(this)" width="694" height="284">
				<span><p class="discount">${item.discount}折</p><p class="name" style="overflow: hidden;width:60%">${item.goodsLname}</p></span>				
				</a>
			</div>
		</c:forEach>
	</div>
	
	<script type="text/javascript">
	$(function(){
		var obj=$(".focus3 .discount");
		$.each(obj,function(i,item){
			
			var h1=$(".focus3 .discount").eq(i).height();
			var h2=$(".focus3 .name").eq(i).height();			
			if(h2>h1){
				$(".focus3 .discount").eq(i).css("margin-top",(h2-h1)/2)
				$(".focus3 .discount").eq(i).css("margin-bottom",(h2-h1)/2);
				$(".focus3 .shop").eq(i).css("padding-bottom",h2+20);
			}
		});
	});
	
</script>
	<a href="/cart.html">
		<div class="cart_btn for_gaq" data-for-gaq="进入购物车;店铺页">
			<span></span>
		</div>
	</a>
	
	
	<script type="text/javascript">
			
		$(function(){
			
			$("#search_word").bind("focusin",function(){
				window.location.href= "/g-s.html";
			});
			
		});
	
	</script>
	
	<jsp:include page="scrollup.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>