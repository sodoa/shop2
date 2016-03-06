<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript"
	src="/jslib/address/GlobalProvinces_main.js"></script>
<script type="text/javascript"
	src="/jslib/address/GlobalProvinces_extend.js"></script>
<script type="text/javascript" src="/jslib/address/initLocation.js"></script>
<script src="/jslib/html5val/jquery-html5Validate.js"></script>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
	$(function() {
		initLocation({
			sheng_val : "湖南",
			shi_val : "长沙",
			xian_val : ""
		});
	});
</script>

<style type="text/css">
select{
width:100px;height:30px;border:1px solid #eee;
}
</style>

<style>

	input, textarea{font-size:100%;}
	.w50{width:50px;}
	.w320{width:320px;}
	.w460{width:460px;}
	.co{color:#f30;}
	.bar_bg{display:inline-block; width:200px; height:16px; background-color:#e0e0e0;}
	.bar_btn{width:20px; height:20px; line-height:20px; margin-top:-3px; margin-left:-10px; border:1px solid #ccc; background-color:#fff; text-align:center; font-size:10px; position:absolute; cursor:pointer;}
	.bar_btn:hover{background-color:#f5f5f5;}
	.bar_btn:after{display:block; content:attr(data-content);}
	.submit{width:100px; height:32px;}
</style>

</head>
<body>
	<div class="header">
		<div class="top_left1">
			<a href="/center/address_list.html"><img
				src="/theme/images/back.png" style="width: 12px"></a>
		</div>
		<div class="top_center1">新增收货地址</div>
		<div class="top_right1">
			<p>
				<a id="btn_complate">完成</a>
			</p>
		</div>
	</div>

	<div class="clear"></div>

	<div class="block4">
	<form action="" id="submit_form" >
		<input type="hidden" name="deliveryId" value="${bean.deliveryId}"/>
		<input type="hidden" name="from" value="${from}"/>
		<ul>
			<li class=""><div>收货人</div><input id="receiverName" name="receiverName" type="text" width="70%" placeholder="请输入收货人名称"   required value="${bean.receiverName}" /></li>
			<li><div>手机号码</div> <input name="receiverPhone" type="text"  placeholder="请输入收货人名称" value="${bean.receiverPhone}" /></li>
			<li><div>省市地址</div><span> <select 
						id="sheng" name="province">
					</select> 省 <select id="shi" name="city">
					</select> 市 <select id="xian" name="county">
					</select> 县
				</span></li>
			<li><div>详细地址</div><input
						name="street" type="text" width="70%" value="${bean.street}" required  placeholder="请输入收货人名称" /></li>
		</ul>
		</form>
	</div>

	<div style="height: 80px;"></div>

	<script type="text/javascript">
		
		var from = '${from}';
	
		$(function() {

			$(".address_select").click(function() {
				if (!$(this).hasClass("address_cur")) {
					$(".address_select").removeClass("address_cur");
					$(this).addClass("address_cur");
				}
			});

			$("#btn_complate").click(function() {
								var _data = $("#submit_form").serializeObject();
								
								//$("#submit_form").submit();
								
								//$("#submit_form").html5Validate();
								
								//$("#submit_form").html5Validate(function() {
									$.ajax({
										type : "POST",
										url : "/center/address_save.html?t="
												+ new Date().getTime(),
										data : _data,
										dataType : "json",
										success : function(data) {
											if (data.result == 0) {
												window.location.href = "/center/address_list.html";
											} else {
												alert("添加失败："
														+ data.message);
											}
										}
									});
								//},{});
								
							});

		});
		
		
		
	</script>


	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


