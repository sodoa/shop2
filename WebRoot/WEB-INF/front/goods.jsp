<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/newest/css/detail.css" type="text/css" rel="stylesheet" />
<script src="/theme/js/wap.js"></script>

<style type="text/css">


 .order_address{position:relative;border-top:#eee solid 1px;padding:10px}

.order_address p:nth-child(1){display:inline;font-size:14px;font-weight:700;}

.order_address p:nth-child(2){display:inline;}

 .order_address p:nth-child(3){float:right;color:#B3B3B3;font-size:9px;text-align:right;padding:2px}

 .order_address .myPhoto{width:38px;height:38px;border-radius:38px;position:relative;overflow:hidden;display:inline-block;vertical-align: middle;}

 .order_address .myName{margin-left:10px;font-size}

 .order_address .myAssess{margin:20px 0}

.order_cost{height:18px;position:relative;border-top:#eee solid 1px;padding:10px}

.order_cost p:nth-child(1){float:left}

.order_cost p:nth-child(2){float:right;padding:0 15px}

.order_cost p:nth-child(3){float:right;padding:0 15px}

iframe{ height:100%; width:100%; overflow:auto; }   


#htmlwrap img{
 width:100%;
 overflow:hidden;
}

</style>

</head>
<body>


<div class="g-doc">

     <header class="activity-header" style="position:absolute;z-index:100"> 
         <div class="back"><a href="/" ></a></div> 
         <div class="cart">
         		<a href="/cart.html"><i class="cart-sales-nums" style="position: relative;padding: 5px;float: right;"><sp:cart_num_tag></sp:cart_num_tag></i></a>
         </div>
         <div class="home"><a href="/"></a></div>
     </header>
    	
     <div class="m-slider" style="position:relative">
         <div class="m-slider-con-wrap" id="JslideWrap">
         <div class="m-slider-con" >
        	<c:forEach var="item" items="${gImages}">
        		<a class="m-slider-item" href="javascript:void(0);"><img style="max-width: 960px;" width="100%" height="60%"   src="${item.imageUrl}" /></a>
			</c:forEach>
         </div>
         </div>
         <div class="m-slider-nav" id="JslideNav"></div>
     </div>
       
       	
     <div class="m-block" style="overflow:hidden;border-top:none">
     	<div class="col-xs-9">
         <p class="m-txt">【${item.weight}${item.unit}】${goods.goodsLname}</p>
         <p class="m-change">&yen;${goods.finalPrices} <span class="discount">${goods.discount}折</span><span class="old">原价：&yen;${goods.orginPrices}</span></p>
         </div>
         <div class="col-xs-3"><a href="javascript:void(0);" onclick="addLove(${goods.goodsId})"><span class="favorite-btn btn" >收藏</span></a>
         </div>
     </div>
        
        <!-- 详情 -->
        <div class="m-tabs alter">
			<div class="m-tabs-nav">
                <a>商品详情</a>
                <a>用户口碑</a>
              </div>
        <div class="m-tabs-con-wrap">
        <div class="m-tabs-con">
        <div class="m-tabs-item">
			<div style="clear: both;word-wrap:break-word;overflow-wrap:break-word;"  id="htmlwrap">
					${html}
			</div>
         </div>
        <div class="m-tabs-item">
				<c:forEach var="item" items="${list}">
					<div class="order_address">
						<div class="myPhoto"><img src="/theme/newest/images/3.png" /></div>
						<p  class="myName">${item.customerName}</p>		
						</br>
						<p class="myAssess">${item.context}</p>					
					</div>
				</c:forEach>
				<p style="text-align: center;"><a href="/apprise-${goods.goodsId}.html">查看更多评论</a></p>			
        </div>
		</div>
		</div>
		</div>
       
       
      
<!-- 底部 -->
<div class="bottom-fxied">
	<div class="m-activity-footer">
    <div class="m-activity-btn">
        <div><a  href="javascript:void(0)" class="red-btn" id="put_goods_to_order">马上抢</a></div>  
     	<div><a  href="javascript:void(0)" class="orange-btn" id="put_goods_in_cart">加入购物车</a></div>    
     </div>
    </div>
</div>


<jsp:include page="scrollup.jsp"></jsp:include>

</div>
	
	
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
		
		var current_goods_id = '${goods.goodsId}';
		
		$("#put_goods_in_cart").click(function(){
			
			$.ajax({type:"POST",
	             url:"/put-goods-cart.html",
	             data:{"goodsId" : current_goods_id},
	             dataType:"json",
	             success:function(data){
	            	if(data.result ==0){
	            		alert('添加成功');
	            		$(".cart-sales-nums").html(data.num);
	            	}
	            	else{
	            		alert('添加失败');
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
	            		alert('添加失败');
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
	
	
	</script>

</body>
</html>


