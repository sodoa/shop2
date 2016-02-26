<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
<link href="/jslib/uiadmin/lib/laypage/1.2/skin/laypage.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/jslib/uiadmin/lib/laypage/1.2/laypage.js"></script>

</head>
<body>

	<div class="header">
		<div class="top_left1">
			<a href="/goods-${goodsId}.html"><img src="/theme/images/back.png" style="width:12px"></a>
		</div>
		<div  class="top_center1">
			商品评论
		</div>
	</div>
	

	<div class="order_paylist">

		<div class="order_li" style="margin:0" id="page-comtain">
		
		</div>
		<div id="page-next"></div>
	</div>	

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="/jslib/swipe/jquery.touchSwipe.min.js"></script>
	
	<script type="text/javascript">
			
	$(function(){
		
		var goodsId = '${goodsId}';
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
		             url:"/apprise-list-"+goodsId+".html?t=",
		             data:{'page':pageNo},
		             dataType:"json",
		             success:function(data){
						if(data.result == 0){
							parse(data.list);
						}
		             }
				});
		}
		
		function parse(dataList){
			 
	        var htmlArray = new Array();
	        
	        for(var i=0;i<dataList.length;i++){
	        	
	        	var beanObj = dataList[i];
	        
		        htmlArray.push('<div class="order_address">');
		        htmlArray.push('	<div class="myPhoto"><img src="/theme/images/3.png" style="width:100%"/></div>');
		        htmlArray.push('	<p  class="myName">');
		        htmlArray.push(beanObj.customerName);
		        htmlArray.push('</p></br>');
		        
		        htmlArray.push('<p class="myAssess">');
		        htmlArray.push(beanObj.context);
		        htmlArray.push('</p></div>');
		      
	        }
	        
	        $('#page-comtain').append(htmlArray.join(""));
		}
		
	});
	
	
	</script>

</body>
</html>


