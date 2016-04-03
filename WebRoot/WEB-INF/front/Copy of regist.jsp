<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link rel="stylesheet" href="/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <link rel="stylesheet" href="/assets/css/register.css">
  <script src="/assets/js/jquery.min.js"></script>
  <script src="/assets/js/amazeui.min.js"></script>
  <script type="text/javascript" src="/resource/js/common.js"></script>
</head>
<body>

<form id="regist_form" class="am-form am-form-horizontal data-am-validator">
<div class="title">
    <div class="title1">
    	<a href="login.html"><img src="assets/i/title.png"></a>
    </div>
    <div class="title2">
    <h2>注册</h2>
    </div> 
</div>

<div class="blank">
</div>
<div class="Phonenum">
     <div class="left">
     <img src="assets/i/num.png">
     </div>
    <input type="text" id="regist_account" name="account" style="width: 85%;border:0px;" placeholder="输入手机号码" required>
     
</div>
<div class="Picpassword">
    <div class="left">
    <img src="assets/i/yan.PNG">
    </div>
    <input type="text" name="displayname" placeholder="称呼" style="width: 85%;border:0px;"  required maxlength="30">
</div>
<div class="Textpassword">
    <div class="left">
    <img src="assets/i/yan2.PNG">
    </div>
   <input type="text" id="verycode" name="verycode" style="width: 50%;border:0px;"  placeholder="验证码" required maxlength="30">
   <button id="get_very_code_btn" style="border:1px solid #eee;color: black;background-color: #fff;height: 60px;"  type="button" class="am-btn am-btn-secondary btn-loading-example"  data-am-loading="{loadingText: '发送当中...'}">获取验证码</button>
</div>
<div class="password">
     <div class="left">
     <img src="assets/i/pass.png">
     </div>
     <input type="text" name="password" placeholder="设个密码" style="width: 85%;border:0px;" required maxlength="30">
</div>

<div id="login_error_msg_group" class="am-alert am-alert-secondary" data-am-alert style="display: none;">
	<p></p>
</div>

<div class="Reg">
     <button style="" class="am-btn am-btn-default am-radius">立即注册</button>
</div>

</form>

	
	<script type="text/javascript">
		
		var p = '${p}';
	
		$(function(){
			
			  if ($.AMUI && $.AMUI.validator) {
			     $.AMUI.validator.patterns.mobile = /^\s*1\d{10}\s*$/;
			  }
			  
			  validate();
			  
			  reg_vercode_event();
					
		});
		
		
		function reg_vercode_event(){

			$("#get_very_code_btn").click(function(){
				    
			  var $btn = $(this);
				
			  var account = $("#regist_account").val();	   
			  
			  if(!$.AMUI.validator.patterns.mobile.test(account)){
        		$('#login_error_msg_group').show();
        		$("#login_error_msg_group  p").text("请输入正确的手机号码");
        		return ;
			  }
								  
			  var _data = {"account" : account};
			  
			  codetimeout();
			  
		      $.ajax({type:"POST",
		             url:"/get_very_code.html?t="+new Date().getTime(),
		             data:_data,
		             dataType:"json",
		             success:function(data){
		            	if(data.result ==0){
		            		//$("#verycode").val(data.code);
		            	}
		            	else{
		            		$('#login_error_msg_group').show();
		            		$("#login_error_msg_group  p").text(data.message);
		            		$("#login_error_msg_group").fadeOut(3000);
		            	}
		             }
				});
				    
			});
		}
		
		var timeObject = null;
		var timeset = 10;
		var time_less = 10;
		
		function codetimeout(){
			
			$("#get_very_code_btn").text("重新获取("+timeset+"s)");
			$("#get_very_code_btn").attr({"disabled":"disabled"});
			
			time_less =  timeset;
			
			timeObject = window.setInterval('repeatCodetimeout()',1000);
		}
		
		function repeatCodetimeout(){
			time_less --;
			$("#get_very_code_btn").text("重新获取("+time_less+"s)");
			
			if(time_less <=0){
				
				if (timeObject != null) {
					clearInterval(timeObject);
					$("#get_very_code_btn").text("获取验证码");
					$("#get_very_code_btn").removeAttr("disabled");
				}
			}
		}

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

										var _data = $("#regist_form")
												.serializeObject();

										showloading();

										$
												.ajax({
													type : "POST",
													url : "/regist.html?t="
															+ new Date()
																	.getTime(),
													data : _data,
													dataType : "json",
													success : function(data) {
														resetloading();
														if (data.result == 0) {
															if(p!=null && p.length>0){
																window.location.href = "" + p;
															}
															else{
																window.location.href = "/";
															}
														} else {
															$('#login_error_msg_group').show();
															$("#login_error_msg_group  p").text(data.message);
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


