<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html class="no-js">
<head>
<title>${bean.title}</title>
<meta name="keywords" content="${bean.keywords}" />
<meta name="description" content="${bean.summary}" />

<jsp:include page="header.jsp"></jsp:include>

<link href="/theme/css/common.css" type="text/css" rel="stylesheet" />
<link href="/theme/css/shop.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	
	.ac-content-wrap img{
		width: 100%;
	}
</style>
</head>
<body>
	<div class="header" style="z-index:2">
		<div class="top_left1" ><a href="ac.html"><img src="/theme/images/back.png" style="width:12px"></a></div>
		<div class="top_center1">分销软文</div>
		<div class="top_right1">
		</div>
	</div>

	<div class="block2" style="background-color: white;border: 1px solid #eee;padding-top: 5px;padding-bottom: 5px; overflow: hidden;">
		【<sp:dict_label_tag type="article_classify" value="${bean.classify}"></sp:dict_label_tag>】${bean.title}
		<div style="float: right;padding-right: 10px;">&nbsp;&nbsp;&nbsp;<sp:dateformat time="${bean.releasedate}" format="yyyy-MM-dd" /></div>
		
	</div>
	
	<div class="block2" style="background-color: white;padding-top: 5px;padding-left: 5px;padding-right: 5px;">
			<b>点击右上角将文章分享给朋友圈，可以你带来分销收入;
				<c:if test="${login==0}">
					分销前请先登录，否则分销无法绑定您的收益帐号，点击链接：&nbsp;&nbsp;
					<a style="background-color: red;padding:3px;" href="javascript:void(0);" id="put_goods_in_cart">登录</a>
				</c:if>
			</b>
	</div>	
	
	<div class="ac-content-wrap" style="background-color: white;padding-top: 5px;padding-left: 5px;padding-right: 5px;height: 100%;">
			${bean.content}
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
	$(function(){
		$("#put_goods_in_cart").click(function(){
			checkLogin(function(){
			},function(){
				window.location.href = "/login.html?p="+GetUrlRelativePath();
			});
		});
	});	
	
	
	var title = '${bean.title}||${bean.summary}';
	var imgUrl = 'http://'+window.location.host+":"+window.location.port+"${bean.img}";

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
	
	</script>

</body>
</html>