<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>

<script type="text/javascript" src="/jslib/loading/js/msgbox.js"></script>
<link href="/theme/newest/css/order.css" type="text/css" rel="stylesheet" />
<link href="/jslib/loading/css/msgbox.css" type="text/css" rel="stylesheet" />

</head>
<body class="order">

<div class="g-doc">
    <div class="top-fxied">
            <header class="header"> 
                <div class="back"><a href="/"><span class="icon-back"></span></a></div> 
                <div class="title">红包结果</div> 
                <div class="subMark"><p></p></div> 
            </header>
  	</div>
    <div class="scroll-content">
		<div id="tipmsg" class="" style="border: 1px solid #eee;padding-top: 10px;padding-bottom: 10px;padding-left: 30px;text-align: center;">
				${msg}				
		</div>

		<div id="fakeloader"></div>
		<div style="margin-top: 20px;margin-bottom:20px;text-align: center;">
			<a href="/center/my_center.html" style="padding: 5px;border: 1px solid #eee;">返回用户中心</a>
			<a href="/" style="padding: 5px;border: 1px solid #eee;">返回首页</a>
		</div>
   </div>
</div>
	
</body>
</html>


