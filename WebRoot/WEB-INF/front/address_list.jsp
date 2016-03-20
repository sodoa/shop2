<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<div class="header">
		<div class="top_left1">
			<a href="/center/my_center.html"><img src="/theme/images/back.png" style="width: 12px"></a>
		</div>
		<div class="top_center1">收货地址管理</div>
		<div class="top_right1">
			<p><a href="/center/address_add.html?from=${from}">新增</a></p>
		</div>
	</div>

	<div class="clear"></div>

	<c:forEach var="item" items="${list}">
		<div class="block3">
			<table>
				<tr>
					<td>收件人：${item.receiverName}</td>
					<td>${item.receiverPhone}</td>
				</tr>
				<tr>
					<td>${item.address}</td>
				</tr>
			</table>
			<div>
				<ul>
					<li class="address_select  <c:if test='${item.isdefault==1}'>address_cur</c:if>" >
						
						<a href="/center/address_default.html?id=${item.deliveryId}&from=${from}&opt=${opt}">
							<c:choose>
								<c:when test="${opt==1}">选择收货地址</c:when>
								<c:otherwise>
									选择默认地址
								</c:otherwise>
							</c:choose>
						</a>
						
					</li>
					
					<li class="address_edit"><a href="/center/address_edit.html?id=${item.deliveryId}&from=${from}">编辑</a></li>
					
					<li class="address_delete" data="${item.deliveryId}"><a class="am-icon-close">删除</a></li>
				</ul>
			</div>
		</div>
	</c:forEach>

	<div style="height: 80px;"></div>
	
	<script type="text/javascript">
		
		
		$(function(){
			
			$(".address_select").click(function(){
					if(!$(this).hasClass("address_cur")){
						$(".address_select").removeClass("address_cur");
						$(this).addClass("address_cur");
					}
			});
			
			$(".address_delete").click(function(){
				var _this=$(this);
				dialog("提醒","您确认要删除该地址信息么？",function(){
				  	window.location.href="/center/address_delete.html?id="+_this.attr('data')+"&from=${from}";
				});
			});
			
		})
		
		
	</script>
		

	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


