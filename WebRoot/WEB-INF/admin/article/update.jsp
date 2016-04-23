<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html><html lang="en"><head>   <jsp:include page="../head.jsp"></jsp:include><link href="/jslib/uiadmin/lib/icheck/icheck.css" rel="stylesheet" type="text/css" /><link href="/jslib/uiadmin/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" /><link href="/jslib/uiadmin/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" /><script type="text/javascript" src="/jslib/uiadmin/lib/My97DatePicker/WdatePicker.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/icheck/jquery.icheck.min.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/Validform/5.3.2/Validform.min.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/webuploader/0.1.5/webuploader.min.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/ueditor/1.4.3/ueditor.config.js"></script><script type="text/javascript" src="/jslib/uiadmin/lib/ueditor/1.4.3/ueditor.all.min.js"> </script><script type="text/javascript" src="/jslib/uiadmin/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script></head><body><div class="pd-20">	<form action="./save-update.jspx" method="post" class="form form-horizontal" id="form-submit" enctype="multipart/form-data">		<input type="hidden" name="id" value="${bean.id}"  id="id"/>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>标题：</label>			<div class="formControls col-10">				<input type="text" class="input-text"  datatype="s2-100" placeholder=""  name="title" value="${bean.title}">			</div>		</div>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>简略：</label>			<div class="formControls col-10">				<input type="text" class="input-text" datatype="s2-300"  placeholder=""  name="summary" value="${bean.summary}">			</div>		</div>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>分类栏目：</label>			<div class="formControls col-4"> <span class="select-box">				<select name="classify" class="select" datatype="*1-100">						<option value="">请选择</option>						<sp:dict_option_tag type="article_classify" value="${bean.classify}">						</sp:dict_option_tag>				</select>				</span> </div>		</div>		<div class="row cl">			<label class="form-label col-2">产品关键字：</label>			<div class="formControls col-10">				<input type="text" name="keywords" id="keywords" placeholder="多个关键字用英文逗号隔开，限10个关键字"  value="${bean.keywords}" class="input-text">			</div>		</div>		<div class="row cl">			<label class="form-label col-2">缩略图：</label>			<div class="formControls col-10">				<input type="file" name="img"  accept="image/*"  class="input-text"/>				<img src="${bean.img}" width="100" height="100"/>			</div>		</div>		<div class="row cl">			<label class="form-label col-2">详细内容：</label>			<textarea style="display: none;" id="content" name="content"></textarea>			<div class="formControls col-10"> 				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 			</div>		</div>		<div class="row cl">			<div class="col-10 col-offset-2">				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>			</div>		</div>	</form></div><script>$(function(){	$("#form-submit").Validform({		tiptype:3,		callback:function(form){			$("#content").val(UE.getEditor('editor').getContent());			return true;		}	});});</script><script type="text/javascript">$(function(){	$('.skin-minimal input').iCheck({		checkboxClass: 'icheckbox-blue',		radioClass: 'iradio-blue',		increaseArea: '20%'	});	});$(function(){	var ue = UE.getEditor('editor');	ue.ready(function() {		ue.setContent('${html}',false,true);	});});</script></body></html>