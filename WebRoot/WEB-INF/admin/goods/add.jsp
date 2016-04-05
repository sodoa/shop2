<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html><html lang="en"><head>   <jsp:include page="../head.jsp"></jsp:include><link href="/jslib/uiadmin/lib/icheck/icheck.css" rel="stylesheet" type="text/css" /><link href="/jslib/uiadmin/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" /><link href="/jslib/uiadmin/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" /><script type="text/javascript" src="/jslib/uiadmin/lib/My97DatePicker/WdatePicker.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/icheck/jquery.icheck.min.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/Validform/5.3.2/Validform.min.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/webuploader/0.1.5/webuploader.min.js"></script> <script type="text/javascript" src="/jslib/uiadmin/lib/ueditor/1.4.3/ueditor.config.js"></script><script type="text/javascript" src="/jslib/uiadmin/lib/ueditor/1.4.3/ueditor.all.min.js"> </script><script type="text/javascript" src="/jslib/uiadmin/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script></head><body><div class="pd-20">	<form action="goods-save.jspx" method="post" class="form form-horizontal" id="form-submit">		<input type="hidden" name="time" value="${time}"  id="time"/>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>产品标题：</label>			<div class="formControls col-10">				<input type="text" class="input-text" value="" datatype="s2-100" placeholder="" id="goods_name" name="goods_name">			</div>		</div>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>简略标题：</label>			<div class="formControls col-10">				<input type="text" class="input-text" datatype="s2-300" value="" placeholder="" id="goods_lname" name="goods_lname">			</div>		</div>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>分类栏目：</label>			<div class="formControls col-4"> <span class="select-box">				<select name="type_level1" class="select" datatype="*1-100">						<option value="">请选择</option>						<sp:goods_type_option_tag leaf="true"></sp:goods_type_option_tag>				</select>				</span> </div>			<label class="form-label col-2"><span class="c-red">*</span>排序值：</label>			<div class="formControls col-4">				<input type="text" class="input-text" value="0" datatype="n1-100" ignore="ignore" placeholder="" id="field_sort" name="sort">			</div>		</div>		<div class="row cl">			<label class="form-label col-2">产品属性：</label>			<div class="formControls col-4 skin-minimal">				<div class="check-box">					<label for="checkbox-hot">热销;</label>				    <input type="checkbox" id="checkbox-hot" name="hot" value="1">				</div>				    <div class="check-box">				    <label for="checkbox-burst">爆品;</label>				    <input type="checkbox" id="checkbox-burst" name="burst" value="1">				    </div>				    <div class="check-box">				    <label for="checkbox-fashion">营销;</label>				    <input type="checkbox" id="checkbox-fashion" name="fashion" value="1">					    </div>			    			</div>			<label class="form-label col-2">产品主题：</label>			<div class="formControls col-4">				<span class="select-box">				<select class="select" name="theme_type">					<sp:goods_theme_option_tag>					</sp:goods_theme_option_tag>				</select>				</span>			</div>					</div>		<div class="row cl">			<label class="form-label col-2">宣传页面：</label>			<div class="formControls col-10">				<input type="text" name="fashion_template" id="fashion_template" value="" class="input-text">			</div>		</div>		<div class="row cl">			<label class="form-label col-2">产地：</label>			<div class="formControls col-4">				<input type="text" name="goods_area" id="goods_area" placeholder="" value="" class="input-text">			</div>			<label class="form-label col-2">所属供应商：</label>			<div class="formControls col-4">				<input type="text" name="supplier" id="supplier" placeholder="" value="" class="input-text">			</div>		</div>		<div class="row cl">			<label class="form-label col-2">价格计算单位：</label>			<div class="formControls col-4"> <span class="select-box">				<select class="select" name="unit">					<option value="">请选择</option>					<sp:dict_option_tag type="goods_unit"></sp:dict_option_tag>				</select>				</span> </div>			<label class="form-label col-2">产品重量：</label>			<div class="formControls col-4">				<input type="text" name="weight" id="weight" placeholder="" value="" class="input-text" style="width:90%">				kg</div>		</div>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>产品展示价格：</label>			<div class="formControls col-4">				<input type="text" name="final_prices" id="final_prices" ignore="ignore" placeholder="" datatype="/^\d+(\.\d+)?$/"   value="" class="input-text" style="width:90%">				元</div>			<label class="form-label col-2"><span class="c-red">*</span>市场价格：</label>			<div class="formControls col-4">				<input type="text" name="orgin_prices" id="orgin_prices" ignore="ignore" placeholder="" datatype="/^\d+(\.\d+)?$/"  value="" class="input-text" style="width:90%">				元</div>		</div>		<div class="row cl">			<label class="form-label col-2">产品关键字：</label>			<div class="formControls col-10">				<input type="text" name="keywords" id="keywords" placeholder="多个关键字用英文逗号隔开，限10个关键字" value="" class="input-text">			</div>		</div>		<div class="row cl">			<label class="form-label col-2"><span class="c-red">*</span>产品摘要：</label>			<div class="formControls col-10">				<textarea id="goods_des" name="goods_des" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-2000" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,2000)"></textarea>				<p class="textarea-numberbar"><em class="textarea-length">0</em>/2000</p>			</div>		</div>		<div class="row cl">			<label class="form-label col-2">缩略图：</label>			<div class="formControls col-10">				<div class="uploader-thum-container">					<div id="uploader-demo" class="wu-example">					    <div id="fileList" class="uploader-list">					    </div>					    <div id="filePicker" class="webuploader-container"><div class="webuploader-pick">选择图片</div></div>					 </div>					</div>				</div>			</div>		</div>		<div class="row cl">			<label class="form-label col-2">详细内容：</label>			<textarea style="display: none;" id="summary" name="summary"></textarea>			<div class="formControls col-10"> 				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 			</div>		</div>		<div class="row cl">			<div class="col-10 col-offset-2">				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>			</div>		</div>	</form></div><script>$(function(){	$("#form-submit").Validform({		tiptype:3,		callback:function(form){						$("#summary").val(UE.getEditor('editor').getContent());						form[0].submit();			//var index = parent.layer.getFrameIndex(window.name);			//parent.layer.close(index);		}	});});</script><script type="text/javascript">$(function(){	$('.skin-minimal input').iCheck({		checkboxClass: 'icheckbox-blue',		radioClass: 'iradio-blue',		increaseArea: '20%'	});	});jQuery(function() {    var $ = jQuery,        $list = $('#fileList'),        // 优化retina, 在retina下这个值是2        ratio = window.devicePixelRatio || 1,        // 缩略图大小        thumbnailWidth = 100 * ratio,        thumbnailHeight = 100 * ratio,        // Web Uploader实例        uploader;    // 初始化Web Uploader    uploader = WebUploader.create({        // 自动上传。        auto: true,        // swf文件路径        swf: '/jslib/uiadmin/lib/webuploader/0.1.5/Uploader.swf',        // 文件接收服务端。        server: 'upload_goods_thumd.jspx?time=${time}',        // 选择文件的按钮。可选。        // 内部根据当前运行是创建，可能是input元素，也可能是flash.        pick: '#filePicker',        // 只允许选择文件，可选。        accept: {            title: 'Images',            extensions: 'gif,jpg,jpeg,bmp,png',            mimeTypes: 'image/*'        }    });    // 当有文件添加进来的时候    uploader.on( 'fileQueued', function( file ) {        var $li = $(                '<div id="' + file.id + '" class="file-item thumbnail">' +                    '<img>' +                    '<div class="info">' + file.name + '</div>' +                '</div>'                ),            $img = $li.find('img');        $list.append( $li );        // 创建缩略图        uploader.makeThumb( file, function( error, src ) {            if ( error ) {                $img.replaceWith('<span>不能预览</span>');                return;            }            $img.attr( 'src', src );        }, thumbnailWidth, thumbnailHeight );    });    // 文件上传过程中创建进度条实时显示。    uploader.on( 'uploadProgress', function( file, percentage ) {        var $li = $( '#'+file.id ),            $percent = $li.find('.progress span');        // 避免重复创建        if ( !$percent.length ) {            $percent = $('<p class="progress"><span></span></p>')                    .appendTo( $li )                    .find('span');        }        $percent.css( 'width', percentage * 100 + '%' );    });    // 文件上传成功，给item添加成功class, 用样式标记上传成功。    uploader.on( 'uploadSuccess', function( file ) {        $( '#'+file.id ).addClass('upload-state-done');    });    // 文件上传失败，现实上传出错。    uploader.on( 'uploadError', function( file ) {        var $li = $( '#'+file.id ),            $error = $li.find('div.error');        // 避免重复创建        if ( !$error.length ) {            $error = $('<div class="error"></div>').appendTo( $li );        }        $error.text('上传失败');    });    // 完成上传完了，成功或者失败，先删除进度条。    uploader.on( 'uploadComplete', function( file ) {        $( '#'+file.id ).find('.progress').remove();    });});$(function(){	var ue = UE.getEditor('editor');});</script></body></html>