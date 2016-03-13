<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/myCenter.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="/jslib/lightbox/css/lightbox.css" media="screen"/>
<script src="/jslib/lightbox/js/lightbox-2.6.min.js"></script>
</head>
<body>

	<div class="header">
		<div class="titel">我的个人中心</div>
		<div class="top_right">
			<a href="/cart.html"><img src="/theme/images/spc.png"
				style="width: 29px; height: 29px">
			<div class="shopcount"></div> </a>
		</div>
	</div>
	<div class="block">
		<table style="width: 100%;margin-left: 10px;margin-right: 10px;">
			<tr><td>帐号信息：</td><td>${customer.displayname} /<b>${customer.account}</td><td rowspan="4"><a class="example-image-link" href="/center/distri-image.html" data-lightbox="example-1"><img id="example2" class="example-image" width="120" height="120" src="/center/distri-image.html" ></a></td></tr>
			<tr><td>帐号金额：</td><td style="color: red;">${wallet.balance}&yen;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="./tranfer.html" style="font-size: 11px;color: orange;">领取红包</a></td><td></td></tr>
			<tr><td>累计提层：</td><td style="color: red;">${wallet.distrBalance}&yen;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<a href="./distri-tip.html" style="font-size: 11px;color: orange;">提层说明</a></td><td></td></tr>
		</table>
	</div>

	<div class="clear"></div>
	<div class="block1">
		<ul>
			<li>
				<div><a href="order_list.html?li=2"><img src="/theme/images/myCenter/1.png">
				<p style="background-color: red;border-radius:10px;left:10px;top:10px;z-index: 999;width:10px;height:10px;padding:4px;position: absolute">2</p>
				<p>待付款</p></a></div></li>
			<li><a href="order_list.html?li=3"><img src="/theme/images/myCenter/2.png">
				<p>待发货</p></a></li>
			<li><a href="order_list.html?li=4"><img src="/theme/images/myCenter/3.png">
				<p>待收货</p></a></li>
			<li><a href="order_list.html?li=5"><img src="/theme/images/myCenter/4.png">
				<p>待评价</p></a></li>
		</ul>
	</div>

	<div class="clear"></div>
	<div class="block2">
		<a href="/center/order_list.html">
		<div>
			<img src="/theme/images/myCenter/5.png">
		</div>
		<p class="name">订单列表</p>
		<p class="to">
			<img src="/theme/images/myCenter/right.png">
		</p>
		</a>
	</div>
	
	<div class="clear"></div>
	<div class="block2">
		<a href="/center/distri.html">
		<div>
			<img src="/theme/images/myCenter/5.png">
		</div>
		<p class="name">分层列表</p>
		<p class="to">
			<img src="/theme/images/myCenter/right.png">
		</p>
		</a>
	</div>	
	
	<div class="clear"></div>
	<div class="block2">
		<a href="/center/layer_list.html">
		<div>
			<img src="/theme/images/myCenter/5.png">
		</div>
		<p class="name">下线用户</p>
		<p class="to">
			<img src="/theme/images/myCenter/right.png">
		</p>
		</a>
	</div>		

	<div class="clear"></div>
	<div class="block2">
		<a href="/center/love.html">
		<div>
			<img src="/theme/images/myCenter/6.png" style="width: 16px; height: 18px">
		</div>
		<p class="name">我的收藏</p>
		<p class="to">
			<img src="/theme/images/myCenter/right.png">
		</p>
		</a>
	</div>

	<div class="clear"></div>
	<div class="block2">
		<a href="/center/address_list.html" style="display: block;">
			<div>
				<img src="/theme/images/myCenter/7.png" style="width: 16px; height: 18px">
			</div>
			<p class="name">地址管理</p>
			<p class="to">
				<img src="/theme/images/myCenter/right.png">
			</p>
		</a>
	</div>

	<div class="clear"></div>
	<div class="block2">
		<a href="tel:<sp:config id="service.telphone"></sp:config>">
		<div>
			<img src="/theme/images/myCenter/8.png" style="width: 16px; height: 18px">
		</div>
		<p class="name">客服(<sp:config id="service.telphone"></sp:config>)</p>
		<p class="to">
			<img src="/theme/images/myCenter/right.png">
		</p>
		</a>
	</div>

	<div class="clear"></div>
	<div class="block2">
		<a href="/center/setting.html">
			<div>
				<img src="/theme/images/myCenter/9.png" style="width: 16px; height: 18px">
			</div>
			<p class="name">设置</p>
			<p class="to">
				<img src="/theme/images/myCenter/right.png">
			</p>
		</a>
	</div>
	
	<script>
$(function(){
	$("#example2").imgbox();
});
</script>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>


