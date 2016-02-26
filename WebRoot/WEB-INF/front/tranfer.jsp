<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
<form id="regist_form" action="/center/transfer.html" method="post" class="am-form am-form-horizontal data-am-validator">

<div class="title">
    <div class="title1">
    <a href="/center.html"><img src="/assets/i/title.png"></a>
    </div>
    <div class="title2">
    <h2>领取红包</h2>
    </div> 
</div>

<div class="blank">
</div>

<div class="Textpassword">
    <div class="left" style="width:25%;margin-left: 10px;">
    </div>
    
   	 您有 &nbsp;<span style="color:red;font-size:16px;">${wallet.balance}&yen;</span>&nbsp;可以领取（只能在微信当中领取）
</div>

<div class="password">
     <div class="left" style="width:25%;margin-left: 10px;"">
     	红包金额（元）：
     </div>
     <input type="text"  id="money" name="money"  style="width: 70%;height:88px;border: 0px;" placeholder="红包金额" required maxlength="30" >
</div>

	<c:if test="${fn:length(msg)>0}">
	<div id="login_error_msg_group" class="am-alert am-alert-secondary" data-am-alert >
		<p>${msg}</p>
	</div>
	</c:if>

<div class="Reg">
    <button class="am-btn am-btn-default am-radius" type="submit" id="submit_form">发送红包</button>
</div>
</form>
	
	<script type="text/javascript">
		$(function(){
			  validate();
			  
			  if(!isWeiXinBrowser()){
				  $("#submit_form").attr("disabled","disabled");
				 // $("#money").attr("disabled","disabled");
				  $("#money").val("红包只能在维信当中使用");
			  }
		});

		function validate() {
			
			$('#regist_form').validator({
								submit : function() {
									var formValidity = this.isFormValid();
									if (formValidity) {
										
										var balance = '${wallet.balance}';
										var inputBalance = $("#money").val();
										
										if(balance<inputBalance){
											alert("余额不足");
											return false;
										}
										
										if(inputBalance>200){
											alert("一次性最多200元");
											return false;
										}
										
										//$(this).submit();
										return true;
									}
									return false;
				}
			});
		}
	</script>

</body>
</html>


