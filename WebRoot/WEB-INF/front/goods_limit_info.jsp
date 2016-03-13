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
<link type="text/css" href="/theme/css/slider.css" rel="stylesheet" />
<script type="text/javascript" src="/theme/js/jquery.touchSlider.js"></script>
<script type="text/javascript" src="/jslib/timecountdown/timeCountDown.js"></script>

<style type="text/css">

.shopcart{
	clear:both;
	padding-left:5px;
	padding-right:5px;
	min-width:30%;
	height:40px;
	background-color:#fff;
	border:1px solid #eee;
	position:fixed;
	bottom:50px;

	max-width: 340px;
    min-width: 140px;
} 
.shopcart button{
	margin-left:5px;
	height:30px;
	margin-top:5px;
	background-color:#ff2d49;
	border:0;
	font-size:14px;
	color:#FFF;
	border-radius:5px;
}

.share{
	margin-top:50px;
	position: absolute;
	top: 0px;
	width:100%;
	right: 0px;
	z-index: 999;
}
.share ul{
	
}
.share ul .wenz{
	width:33.333333%;
	height:100px;
	float:left;
	background-color:#ececec;
	text-align:center;
}
.share ul .wenz img{
	width:20%;
	margin-top:15px;
}

.detailsBlock11{width:100%;background-color:#fff}

.timecount{
	border:1px solid #eee;
	padding-left:5px;
	padding-right:5px;
}

iframe{ height:100%; width:100%; overflow:auto; }   

</style>

</head>
<body>

	<div class="header">
		<div class="top_left1">
			<a href="/"><img src="/theme/images/back.png" style="width:12px"></a>
		</div>
		<div  class="top_center1">
			活动商品
		</div>
		<div class="top_right1" >
			<a href="/cart.html"><img src="/theme/images/spc.png" style="width:29px;height:29px"></a>
		</div>
	</div>
	
	<div class="detailsBlock1">
		<div>
			<div class="main_visual" style="height: 200px;">
		
				<div class="flicking_con">
		
					<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
		
					<a href="#">5</a>
		
				</div>
		
				<div class="main_image">
		
					<ul>
						<c:forEach var="item" items="${gImages}">
							<li><img  onerror="imagerror(this)" src="${item.imageUrl}" style="width:100%;height:100%;" /></li>
						</c:forEach>
					</ul>
		
					<a href="javascript:;" id="btn_prev"><</a> <a href="javascript:;"
						id="btn_next">></a>
				</div>
			</div>
		</div>
		<div>
			<p>${goods.goodsLname}</p>
			<p>&yen;${goods.finalPrices}</p><p><s>&yen;${goods.orginPrices}</s></p><p>${goods.discount}折</p>
			<div class="collection" style="cursor: pointer;" onclick="addLove(${goods.goodsId})">
				<div><img src="/theme/images/details/love.png"></div>
				<p>收藏</p>
			</div>
		</div>
		<div style="margin: 5px;padding: 5px;">
			<p>
				库存：${goodslimit.totalAmount-goodslimit.buyLimit}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			   <span id="day" class="timecount"></span>天<span id="hour" class="timecount"></span>时
			   <span id="mini" class="timecount"></span>分 <span id="sec" class="timecount"></span>秒</p>
			
		</div>
	</div>
	
	
	<div class="clear"></div>
	<div class="detailsBlock2">
		<div class="detailsConter">
				<div style="clear: both;word-wrap:break-word;overflow-wrap:break-word;"  id="htmlwrap">
						<iframe id="htmlframe" name="htmlframe" onload="setIframeHeight(this)" style="z-index: 9999" frameborder="0" scrolling="no" src="/goods-html.html?s=${goods.summary}" width="100%"  ></iframe>
				</div>
		</div>
	</div>
	
	<c:if test="${canBuy}">
		<div class="shopcart">
			<button style="cursor: pointer;    font-family: 'Microsoft YaHei';width:90px;" id="put_goods_to_order">直接购买</button>
			<button style="cursor: pointer;    font-family: 'Microsoft YaHei';width:90px;" id="put_goods_in_cart">加入购物车</button>
		</div>
	</c:if>
	
	<jsp:include page="scrollup.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="/jslib/swipe/jquery.touchSwipe.min.js"></script>
	
	<script type="text/javascript">

	var title = '${goods.goodsLname}||<sp:config id="goal.title"></sp:config>'	;
	var imgUrl = 'http://'+window.location.host+":"+window.location.port+"${goods.thumbnailUrl}";

	function getMenuShareTimeline(wxsid){
		
		var shareid = wxsid;
		var link = addUrlPara('wxsid',shareid);
		
		return {
		    title: title, // 分享标题
		    link: link, // 分享链接
		    imgUrl: imgUrl, // 分享图标
		    success: function () { 
		    	alert('分享成功');
		    },
		    cancel: function () { 
		    	alert('分享失败');
		    }
		};
	}

	function getMenuShareAppMessage(wxsid){
		
		var shareid = wxsid;
		var link = addUrlPara('wxsid',shareid);
		
		return {
		    title: title, // 分享标题
		    desc: title, // 分享描述
		    link: link, // 分享链接
		    imgUrl: imgUrl, // 分享图标
		    type: 'link', // 分享类型,music、video或link，不填默认为link
		    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
		    success: function () { 
		    	alert('分享成功');
		    },
		    cancel: function () { 
		    	alert('分享失败');
		    }
		};
		
	}

	function getMenuShareQQ(wxsid){
		
		var shareid = wxsid;
		var link = addUrlPara('wxsid',shareid);
		
		return {
		    title: title, // 分享标题
		    desc: title, // 分享描述
		    link: link, // 分享链接
		    imgUrl: imgUrl, // 分享图标
		    success: function () { 
		    	alert('分享成功');
		    },
		    cancel: function () { 
		    	alert('分享失败');
		    }
		};
	}
	
	$(function(){
		var d = new Date(parseFloat('${timelimit}'));
		var obj = {
			 day: document.getElementById("day"),
		     sec: document.getElementById("sec"),
		     mini: document.getElementById("mini"),
		     hour: document.getElementById("hour")
		}
		fnTimeCountDown(d, obj);
	});
			
	$(function(){
		
		var current_goods_id = '${goods.goodsId}';
		
		$("#put_goods_in_cart").click(function(){
			
			$.ajax({type:"POST",
	             url:"/put-goods-cart.html",
	             data:{"goodsId" : current_goods_id},
	             dataType:"json",
	             success:function(data){
	            	if(data.result ==0){
	            		alert('添加成功');
	            	}
	            	else{
	            		alert('添加失败:'+data.message);
	            	}
	             }
			});
			
		});
		
		//put_goods_to_order
		
		$("#put_goods_to_order").click(function(){
			
			$.ajax({type:"POST",
	             url:"/put-goods-cart.html",
	             data:{"goodsId" : current_goods_id},
	             dataType:"json",
	             success:function(data){
	            	if(data.result ==0){
	            		window.location.href = "/cart.html";
	            	}
	            	else{
	            		alert('添加失败:'+data.message);
	            	}
	             }
			});
			
		});

	});
	
	
	function setIframeHeight(iframe) {
		if (iframe) {
			var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
			if (iframeWin.document.body) {
				iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
				$("#htmlwrap").css({"height":iframe.height});
			}
	  	}
	};
	
	function addLove(gid){
		
		checkLogin(function(){
			$.ajax({type:"POST",
	             url:"/center/love-add.html",
	             data:{"goodsId" : gid},
	             dataType:"json",
	             success:function(data){
	            	if(data.result ==0){
	            		alert(data.message);
	            	}
	            	else{
	            		alert(data.message);
	            	}
	             }
			});
			
		},function(){
			window.location.href = "/login.html?p="+GetUrlRelativePath();
		});
	}
	
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

				}, 2000);



				$(".main_visual").hover(function() {

					clearInterval(timer);

				}, function() {

					timer = setInterval(function() {

						$("#btn_next").click();

					}, 2000);

				});



				$(".main_image").bind("touchstart", function() {

					clearInterval(timer);

				}).bind("touchend", function() {

					timer = setInterval(function() {

						$("#btn_next").click();

					}, 2000);

				});



			});
	
	</script>

</body>
</html>


