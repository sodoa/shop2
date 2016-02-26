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
			<a href="/center/cart.html"><img src="/theme/images/spc.png" style="width:29px;height:29px">
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

		<li><a href="g-s.html?init=11"><div><p>进口</p><p>欧美/日韩/东南亚</p></div>

		<div><img src="/theme/images/index/1.png"style="width:100%"></div></a>

		</li> 

		<li><a href="g-s.html?init=12"><div><p>进口</p><p>欧美/日韩/东南亚</p></div>

	

		<div><img src="/theme/images/index/2.png"style="width:100%"></div></a>

		</li> 

		<li><a href="#"><div><p>进口</p><p>欧美/日韩/东南亚</p></div>

		<div><img src="/theme/images/index/3.png"style="width:100%"></div></a>

		</li> 

		<li><a href="#"><div><p>进口</p><p>欧美/日韩/东南亚</p></div>

		<div><img src="/theme/images/index/4.png"style="width:100%"></div></a>

		</li> 

		<li><a href="#"><div><p>进口</p><p>欧美/日韩/东南亚</p></div>

		<div><img src="/theme/images/index/5.png"style="width:100%"></div></a>

		</li> 

		<li><a href="#"><div><p>进口</p><p>欧美/日韩/东南亚</p></div>

		<div><img src="/theme/images/index/6.png"style="width:100%"></div></a>

		</li> 

		<li><a href="#"><div><p>进口</p><p>欧美/日韩/东南亚</p></p></div>

		<div><img src="/theme/images/index/7.png"style="width:100%"></div></a>

		</li> 

		<li><a href="#"><div><p>进口</p><p>欧美/日韩/东南亚</h5></p></div>

		<div><img src="/theme/images/index/8.png"style="width:100%"></div></a>

		</li> 

	</ul>

	<script>

	 $(function(){

		$(".focus li:odd").css("border-left","#e6e6e6 solid 1px").css("float","right");

		$(".focus li:even").css("border-right","#e6e6e6 solid 1px");

	 });

	</script>

	

	<ul class="focus2">
		<li>

			<div><img src="/theme/images/index/9.png"></div>

			<div><p>2000</p><p>成交订单</p></div>

		</li

		><li>

			<div><img src="/theme/images/index/10.png" ></div>

			<div><p>1000</p><p>分享次数</p></div>

		</li

		><li>

			<div><img src="/theme/images/index/11.png"></div>

			<div><p>8000</h3><p>注册用户</p></div>

		</li>		
	</ul>

	

	<div class=" focus3">

		<div class="bao"><p>爆品</p></div>
		<c:forEach var="item" items="${burstList}">
			<div><a href="/goods-${item.goodsId}.html"><img src="${item.thumbnailUrl}" onerror="imagerror(this)" width="694" height="284" defimage="defimage">
				<span><p class="discount" style="margin:30px 0"  >${item.discount}折</p><p style="overflow: hidden;">${item.goodsLname}</p></span>
				</a>
			</div>
		</c:forEach>
	</div>

	<div class="focus3">

		<div class="hot"><p>热卖</p></div>
		<c:forEach var="item" items="${hotList}">
			<div><a href="/goods-${item.goodsId}.html"><img src="${item.thumbnailUrl}"  onerror="imagerror(this)" width="694" height="284">
				<span style="width:100%;">
					<div style="clear:both;width:30%; display:inline;"><p style="clear: both;" class="discount"  >${item.discount}折</p></div>
					<div style="clear:both;width:70%; display:inline;"><p style="clear: both;overflow: hidden;" >${item.goodsLname}</p></div>
				</span>
				</a>
			</div>
		</c:forEach>
	</div>
	
	<a href="/center/cart.html">
		<div class="cart_btn for_gaq" data-for-gaq="进入购物车;店铺页">
			<span></span>
		</div>
	</a>
	
	
	<script type="text/javascript">
			
		$(function(){
			
			$("#search_word").keydown(function(e){
				var theEvent = window.event || e; 
				var code = theEvent.keyCode || theEvent.which; 
				if (code == 13) { 
					var word = $(this).val();
					if(word == null || word.length ==0 || word.trim().length == 0){
						return;
					}
					window.location.href = "/s.html?w="+encodeURI(word);
				} 
			});
			
		});
	
	</script>
	
	<jsp:include page="scrollup.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>