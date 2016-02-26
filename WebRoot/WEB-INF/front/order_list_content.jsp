<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="order_paylist">

	<div class="null_cart">

		<p>亲,您还没有任何商品！</p>

		<p>
			<a href="/">马上去购物吧!</a>
		</p>

	</div>

	<div class="order_li" id="page-comtain">
		
	</div>
	
	<div class="order_li">
		<div id="page-next"></div>
	</div>

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
		             url:"/center/order_list_data.html",
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
