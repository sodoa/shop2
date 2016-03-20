<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript" src="/jslib/address/GlobalProvinces_main.js"></script>
<script type="text/javascript" src="/jslib/address/GlobalProvinces_extend.js"></script>
<script type="text/javascript" src="/jslib/address/initLocation.js"></script>
<script src="/jslib/uiadmin/lib/Validform/5.3.2/Validform.js"></script>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
<link href="/jslib/uiadmin/lib/Validform/5.3.2/style.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
	$(function() {
		initLocation({
			sheng_val : "${bean.province}",
			shi_val : "${bean.city}",
			xian_val : "${bean.county}"
		});
	});
</script>

<style type="text/css">
select{
width:100px;height:30px;border:1px solid #eee;
}
	input{height:30px;border: 1px solid #eee;}
</style>

</head>
<body>
	<div class="header">
		<div class="top_left1">
			<a href="/center/address_list.html?from=${from}"><img
				src="/theme/images/back.png" style="width: 12px"></a>
		</div>
		<div class="top_center1">修改收货地址</div>
		<div class="top_right1">
			<p>
				<a id="btn_complate">完成</a>
			</p>
		</div>
	</div>

	<div class="clear"></div>
	
	
	<div class="block4">
	<form action="address_esave.html" id="submit_form" >
		<input type="hidden" name="deliveryId" value="${bean.deliveryId}"/>
		<input type="hidden" name="from" value="${from}" />
		<ul>
			<li class=""><div>收货人</div><input id="receiverName" name="receiverName" datatype="s1-10" errormsg="请输出正确的收货人"  type="text" width="70%" placeholder="请输入收货人名称"   required value="${bean.receiverName}" /></li>
			<li><div>手机号码</div> <input name="receiverPhone" type="text" datatype="n8-15" errormsg="请输出正确的联系方式" placeholder="请输入收货人名称" value="${bean.receiverPhone}" /></li>
			<li><div>省市地址</div><span> <select 
						id="sheng" name="province" datatype="*" >
					</select> 省 <select id="shi" name="city" datatype="*" >
					</select> 市 <select id="xian" name="county" datatype="*" >
					</select> 县
				</span></li>
			<li><div>详细地址</div><input
						name="street" type="text" width="70%" datatype="s1-30" errormsg="请输出正确的详细地址" value="${bean.street}" required  placeholder="请输入收货人名称" /></li>
		</ul>
		</form>
	</div>
	
	
	<div style="height: 80px;"></div>

	<script type="text/javascript">
		$(function() {
			
			$("#submit_form").Validform({
				ajaxPost:true,
				tiptype:4,
				postonce:true,
				callback:function(data){
					layer.msg("添加失败：" + data.message);
					if (data.result == 0) {
						window.location.href = "/center/address_list.html?from=${from}";
					} else {
						layer.msg("添加失败：" + data.message);
					}
				}
			});
	
			$(".address_select").click(function() {
				if (!$(this).hasClass("address_cur")) {
					$(".address_select").removeClass("address_cur");
					$(this).addClass("address_cur");
				}
			});

			$("#btn_complate").click(function() {
				$("#submit_form").submit();
			});

		});
		
		
		
	</script>


	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


