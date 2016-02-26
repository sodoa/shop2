<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="stylesheet" href="/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <link rel="stylesheet" href="/assets/css/register.css">
  <script src="/assets/js/jquery.min.js"></script>
  <script src="/assets/js/amazeui.min.js"></script>
    <script type="text/javascript" src="/resource/js/common.js"></script>
</head>
<body>

<body class="chongzhi"> 
<form id="regist_form" class="am-form am-form-horizontal data-am-validator">

<div class="title">
    <div class="title1">
    <a href="/center/setting.html"><img src="/assets/i/title.png"></a>
    </div>
    <div class="title2">
    <h2>修改密码</h2>
    </div> 
</div>

<div class="blank">
</div>

<div class="Textpassword">
    <div class="left">
    <img src="/assets/i/yan2.PNG">
    </div>
     <input type="text" name="orgi_password"  style="width: 85%;height:88px;border: 0px;" placeholder="原始密码" required maxlength="30">
</div>
<div class="password">
     <div class="left">
     <img src="/assets/i/pass.png">
     </div>
     <input type="text" name="password"  style="width: 85%;height:88px;border: 0px;" placeholder="新密码" required maxlength="30">
</div>
<div id="login_error_msg_group" class="am-alert am-alert-secondary" data-am-alert style="display: none;">
	<p></p>
</div>

<div class="Reg">
    <button style="" class="am-btn am-btn-default am-radius">重置密码</button>
</div>
</form>
	
	<script type="text/javascript">
		$(function(){
			
			  if ($.AMUI && $.AMUI.validator) {
			     $.AMUI.validator.patterns.mobile = /^\s*1\d{10}\s*$/;
			  }
			  
			  validate();
		});
				
		
		function showloading() {
			$('.btn-loading-example').button('loading');
		}

		function resetloading() {
			$('.btn-loading-example').button('reset');
		}

		function validate() {

			$('#regist_form')
					.validator(
							{

								submit : function() {
									var formValidity = this.isFormValid();

									if (formValidity) {

										var _data = $("#regist_form").serializeObject();

										showloading();

										$
												.ajax({
													type : "POST",
													url : "/center/setpassword.html?t="
															+ new Date()
																	.getTime(),
													data : _data,
													dataType : "json",
													success : function(data) {
														resetloading();
														if (data.result == 0) {
															window.location.href = "/login.html";
														} else {
															$(
																	'#login_error_msg_group')
																	.show();
															$(
																	"#login_error_msg_group  p")
																	.text(
																			data.message);
															$("#login_error_msg_group").fadeOut(3000);
														}
													}
												});
									}

									return false;
								}
							});
		}
	</script>

</body>
</html>


