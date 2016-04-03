<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/theme/newest/css/order.css" />
<link href="/jslib/uiadmin/lib/laypage/1.2/skin/laypage.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/jslib/uiadmin/lib/laypage/1.2/laypage.js"></script>
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
				<div class="title">分成信息</div>
				<div class="subMark">
					<p></p>
				</div>
			</header>
		</div>
		<div class="order-scroll-content" style="margin-top: 0.9rem;">
			<div class="order-manage">
				<ul class="m-cartlist" id="page-comtain">

				</ul>
				<div id="page-next"></div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
			
	</div>
	
	<script type="text/javascript">
	var li = '${li}';
			
	$(function(){
		
		var totalPage = '${page.totalPage}';
		
		
		laypage({
		    cont: 'page-next', //容器。值支持id名、原生dom对象，jquery对象,
		    pages: '${page.totalPage}', //总页数
		    groups: 0, //连续分数数0
		    prev: false, //不显示上一页
		    next: '查看更多',
		    skin: 'flow', //设置信息流模式的样式
		    jump: function(obj){
		        if(obj.curr > totalPage){
		            this.next = '没有更多了';
		        }
		        else{
		        	ajaxPageContent(obj.curr);
		        }
		    }
		});
		
		
		function ajaxPageContent(pageNo){

		      $.ajax({type:"POST",
		             url:"/center/distri-data-ajax.html",
		             data:{'page':pageNo,'li':li},
		             dataType:"html",
		             success:function(data){
		            	 $('#page-comtain').append(data);
		             }
				});
		}
		
	});
	
	
	
	function toCancel(id){
		dialog('信息确认','确定 要删除订单嘛',function(){
			window.location.href="/center/order-del.html?id="+id+"&li="+li;
		});
	}
	
	function toPay(id){
		window.location.href="/center/order-info-"+id+".html?li="+li;
	}
	
	function toComment(id){
		window.location.href="/center/order-comment.html?id="+id+"&li="+li;		
	}
	
	</script>

</body>
</html>
