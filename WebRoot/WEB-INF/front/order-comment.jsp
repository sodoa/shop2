<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
  <link rel="stylesheet" href="/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="/assets/css/common.css">
  <link rel="stylesheet" href="/assets/css/register.css">
  <script src="/assets/js/jquery.min.js"></script>
  <script src="/assets/js/amazeui.min.js"></script>
    <script type="text/javascript" src="/resource/js/common.js"></script>
</head>
<body>

<body class="chongzhi"> 
<form id="regist_form" class="am-form am-form-horizontal data-am-validator" method="post" action="/center/save-order-comment.html">
<input type="hidden" name="li" value="${li}"/>
<input type="hidden" name="id" value="${id}"/>
<div class="title">
    <div class="title1">
    <a href="/center/order_list.html?li=${li}"><img src="/assets/i/title.png"></a>
    </div>
    <div class="title2">
    <h2>评论商品</h2>
    </div> 
</div>

<div class="blank" style="height: 10px;">
</div>

<div class="Textpassword" style="height: 140px;">
<textarea rows="6" cols="" style="width: 100%" name="comment" placeholder="请输入评论，不超过200个字" required  maxlength="200"></textarea>
</div>

<div class="Reg">
    <button style="" class="am-btn am-btn-default am-radius">提交评论</button>
</div>
</form>
	
	<script type="text/javascript">
		$(function(){
			
			  validate();
		});
				

		function validate() {

			$('#regist_form')
					.validator(
							{
								submit : function() {
									var formValidity = this.isFormValid();
									if (formValidity) {
										return true;
									}

									return false;
								}
							});
		}
	</script>

</body>
</html>


