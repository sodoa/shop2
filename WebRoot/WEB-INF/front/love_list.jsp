<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/shop.css" type="text/css" rel="stylesheet" />

</head>
<body>

	<div class="header">
		<div class="top_left1">
			<a href="/center/my_center2.html"><img src="/theme/images/back.png" style="width: 12px"></a>
		</div>

		<div class="top_center1">商品收藏</div>

		<div class="top_right1">

		</div>

	</div>

	<div class="block">

		<ul>
			<c:forEach var="item" items="${list}">
				<li><div class="block-image">
						<img src="${item.thumbnail_url}" width="200" height="200" style="width: 100%"> 
					</div>
	
					<div class="block-titel">${item.goods_lname}</div>
					<div class="block-price">
						<p>&yen;${item.final_prices}</p>
						<p>
							<s>&yen;${item.orgin_prices }</s>
						</p>
						<p>${item.discount}折</p>
						<a href="javascript:;" onclick="del(this,'${item.love_id}')">删除收藏</a>
					</div></li>
				</c:forEach>

		</ul>

	</div>


	<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
function del(obj,id){
	
	dialog('删除提示','确认要删除吗？',function(){
		  var _data = {"id": id};
	      $.ajax({type:"POST",
	             url:"love-delete.html?t="+new Date().getTime(),
	             data:_data,
	             dataType:"json",
	             success:function(data){
	            	if(data.result ==0){
	            		location.replace(location.href);
	            	}
	            	else{
	            		alert(data.message);
	            	}
	             }
			});
	});

}
</script>
</body>
</html>


