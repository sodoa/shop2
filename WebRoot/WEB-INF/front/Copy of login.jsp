<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title><sp:config id="goal.title"></sp:config>-登录</title>
  <link rel="stylesheet" href="/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <link rel="stylesheet" href="/assets/css/login.css">
  <script src="/assets/js/jquery.min.js"></script>
  <script src="/assets/js/amazeui.min.js"></script>
  <script type="text/javascript" src="/resource/js/common.js"></script>
  
  <style>
  #vld-tooltip {
    position: absolute;
    z-index: 1000;
    padding: 5px 10px;
    background: #F37B1D;
    min-width: 150px;
    color: #fff;
    transition: all 0.15s;
    box-shadow: 0 0 5px rgba(0,0,0,.15);
    display: none;
  }

  #vld-tooltip:before {
    position: absolute;
    top: -8px;
    left: 50%;
    width: 0;
    height: 0;
    margin-left: -8px;
    content: "";
    border-width: 0 8px 8px;
    border-color: transparent transparent #F37B1D;
    border-style: none inset solid;
  }
</style>


</head>

<body class="login">
<form id="login_form" class="am-form am-form-horizontal data-am-validator" method="post">
<div class="title">
    <div class="title1">
    	<a href="/"><img src="assets/i/title.png"></a>
    </div>
    <div class="title2">
    <h2>登录</h2>
    </div> 
</div>

<div class="num">
     <div class="left">
     <img src="assets/i/phone.PNG">
     </div>
     <input type="text" id="login_account" style="width:80%;border: 0px;"  name="account"  placeholder="输入您的手机号码"  required  maxlength="30" >
     
</div>
<div class="mima">
    <div class="left">
    <img src="assets/i/pass.png">
    </div>
    <input type="password" id="login_password" style="width:80%;border: 0px;" name="password" data-foolish-msg="把 IQ 卡密码交出来！"  placeholder="设置一个密码吧"  required maxlength="30">
</div>
<div style="height: 20px;"></div>
<div class="bottom">
    <div class="wenz" id="login_error_msg_group" style="display: none;">
    <p></p>
    </div>
    <button type="submit" class="am-btn am-btn-default am-radius">立即登录</button>
    <p><a href="/regist.html">注册</a><span><a href="/forget.html">忘记密码</a></span></p>

</div>
</form>
	
	<script type="text/javascript">
	
	var p = '${p}';
	
	
	$(function(){
		validate_login();
		
		init_validate();

	});
	
	function init_validate(){
			  var $form = $('#login_form');
			  var $tooltip = $('<div id="vld-tooltip">提示信息！</div>');
			  $tooltip.appendTo(document.body);

			  $form.validator();

			  var validator = $form.data('amui.validator');

			  $form.on('focusin focusout', '.am-form-error input', function(e) {
			    if (e.type === 'focusin') {
			      var $this = $(this);
			      var offset = $this.offset();
			      var msg = $this.data('foolishMsg') || validator.getValidationMessage($this.data('validity'));

			      $tooltip.text(msg).show().css({
			        left: offset.left + 10,
			        top: offset.top + $(this).outerHeight() + 10
			      });
			    } else {
			      $tooltip.hide();
			    }
			  });
	}
	
	function showloading(){
		$('.btn-loading-example').button('loading');
	}
	
	function resetloading(){
		$('.btn-loading-example').button('reset');
	}
	
	function validate_login(){

		 $('#login_form').validator({
	
			    submit: function() {
			        var formValidity = this.isFormValid();

			      	if(formValidity){
		        	 
					      var _data = $("#login_form").serializeObject();
					      
					      showloading();
					      
					      $.ajax({type:"POST",
					             url:"/login.html?t="+new Date().getTime(),
					             data:_data,
					             dataType:"json",
					             success:function(data){
					            	 resetloading();
					            	if(data.result ==0){
					            		$('#login_error_msg_group').show();
					            		$("#login_error_msg_group  p").text('登录成功');
					            		
					            		window.location.href = "/my.html?p="+p;
					            		
					            	}
					            	else{
					            		$('#login_error_msg_group').show();
					            		$("#login_error_msg_group  p").text(data.message);
					            		$("#login_error_msg_group").fadeOut(3000);
					            	}
					             }
							});
			      	};
			        
			        return false;
			      }
			  });
	}
		
		$("#login_form_btn").click(function(){
			
			//$('#login_form').validator();	
			
		});
	
	</script>

</body>
</html>


