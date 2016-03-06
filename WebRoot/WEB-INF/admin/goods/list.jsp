<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html><html lang="en"><head>      <jsp:include page="../head.jsp"></jsp:include><script type="text/javascript" src="/jslib/uiadmin/lib/My97DatePicker/WdatePicker.js"></script><script type="text/javascript" src="/jslib/uiadmin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script></head><body><nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>商品管理<span class="c-gray en">&gt;</span>商品列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav><div class="pd-20">	<div class="text-c">		<form action="" id="submit_form">		<span class="select-box" style="width:100px">			<select class="select" name="burst" size="1" >					<option value="" selected>爆品属性</option>					<option value="0">非爆品</option>					<option value="1">爆品</option>			</select>		</span>				<span class="select-box" style="width:100px">			<select class="select" name="hot" size="1">					<option value="" selected>热品属性</option>					<option value="0">非热品</option>					<option value="1">热品</option>			</select>		</span>			<span class="select-box" style="width:100px">			<select class="select" name="type_level2" size="1" id="state">					<option value="" selected>商品分类</option>					<sp:goods_type_option_tag ></sp:goods_type_option_tag>			</select>		</span>		<span class="select-box" style="width:100px">			<select class="select" name="theme_type" size="1">					<option value="" selected>所有主题</option>					<sp:dict_option_tag type="goods_theme_type" >					</sp:dict_option_tag>									</select>		</span>					<span class="select-box" style="width:100px">			<select class="select" name="goods_status" size="1" id="state">					<option value="" selected>商品状态</option>					<option value="0">未上架</option>					<option value="1">已上架</option>			</select>		</span>				<input type="text" class="input-text" style="width:250px" placeholder="输入商品名称" name="goods_name">		<button type="button" class="btn btn-success radius" id="btn_search" name="" ><i class="Hui-iconfont">&#xe665;</i> 搜商品</button>		</form>	</div>	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="product_add('添加产品','product-add.html')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></span> </div>	<div class="mt-20">	<table class="table table-border table-bordered table-hover table-bg table-sort">		<thead>			<tr class="text-c">                                            <th>商品ID</th>                                            <th>商品名称</th>                                            <th>商品描述</th>                                            <th>单价</th>                                            <th>发布时间</th>                                            <th>状态</th>                                            <th>热销</th>                                            <th>爆品</th>                                            <th>营销</th>                                            <th>操作</th>                                        </tr>		</thead>		<tbody>	                                    			</tbody>	</table>	</div></div><script type="text/javascript">var datatable = null;$(function(){	datatable = $('.table-sort').dataTable({		"bStateSave": true,//状态保存        responsive: true,        "searching": false,        "processing": true,        "serverSide": true,        "ordering": false,        "info":     false,        "paging":   true,        "ajax": {        	"url":"goods-list-page.jspx",        	"type":"post",        	"data":function(d){        		getParamter(d);       		 }		},        "columnDefs": [                       {                           "render": function ( data, type, row ) {                        	   var array = new Array();                        	   if(row[5] == 0){                        		  array.push('/<a style="text-decoration:none" onClick="goods_state(this,'+row[0]+',1)" href="javascript:;" title="上架">上架</a>');                        	   }                        	   else{                        		   array.push('/<a style="text-decoration:none" onClick="goods_state(this,'+row[0]+',0)" href="javascript:;" title="下架">下架</a>');                        	   }                        	   if(row[6] == 0){                         		  array.push('/<a style="text-decoration:none" onClick="goods_hot(this,'+row[0]+',1)" href="javascript:;" title="热销">热销</a>');                         	   }                         	   else{                         		   array.push('/<a style="text-decoration:none" onClick="goods_hot(this,'+row[0]+',0)" href="javascript:;" title="不热销">不热销</a>');                         	   }                       	                           	   if(row[7] == 0){                          		  array.push('/<a style="text-decoration:none" onClick="goods_burst(this,'+row[0]+',1)" href="javascript:;" title="爆品">爆品</a>');                          	   }                          	   else{                          		   array.push('/<a style="text-decoration:none" onClick="goods_burst(this,'+row[0]+',0)" href="javascript:;" title="不爆品">不爆品</a>');                          	   }                          	   //                        	   if(row[8] == 0){                        		                             		  array.push('/<a style="text-decoration:none" onClick="goods_fashion(this,'+row[0]+',1)" href="javascript:;" title="营销">营销</a>');                           	   }                           	   else{                           		   array.push('/<a style="text-decoration:none" onClick="goods_fashion(this,'+row[0]+',0)" href="javascript:;" title="不营销">不营销</a>');                           	   }                          	   //                        	                           	   array.push('/<a title="删除" href="javascript:;" onclick="goods_del(this,'+row[0]+')" class="ml-5" style="text-decoration:none">删除</a>');                        	   array.push('/<a title="修改" href="javascript:;" onclick="goods_mod(this,'+row[0]+')" class="ml-5" style="text-decoration:none">修改</a>');                        	   array.push('/<a title="SLASH" href="javascript:;" onclick="goods_slash(this,'+row[0]+')" class="ml-5" style="text-decoration:none">SLASH</a>');                        	   array.push('/<a title="fashion" href="javascript:;" onclick="goods_fashion(this,'+row[0]+')" class="ml-5" style="text-decoration:none">FASHION</a>');                               return array.join("");                           },                           "targets": 9                       },                       {                            "render": function ( data, type, row ) {                        	                           	   if(data == 1){                        		   return '<span class="td-status"><span class="label label-success radius">已上架</span></span>';                        	   }                        	   else{                        		   return '<span class="td-status"><span class="label label-defaunt radius">已下架</span></span>';                        	   }                           },                           "targets": 5                   	                       	                          },                       {                            "render": function ( data, type, row ) {                        	                           	   if(data == 1){                        		   return '营销商品';                        	   }                        	   else if(data == 0){                        		   return '非营销商品';                        	   }                           },                           "targets": 8               	                       	                          },                       {                            "render": function ( data, type, row ) {                        	                           	   if(data == 1){                        		   return '热销';                        	   }                        	   else if(data == 0){                        		   return '非热销';                        	   }                           },                           "targets": 7               	                       	                          },                       {                            "render": function ( data, type, row ) {                        	                           	   if(data == 1){                        		   return '爆品';                        	   }                        	   else if(data == 0){                        		   return '非爆品';                        	   }                           },                           "targets": 6               	                       	                          },                       {                            "render": function ( data, type, row ) {                  				if(data!=null){                  					return new Date(data).formatShort();                  				}                           },                           "targets": 4                	                       	                          }                       ,{//                           "render": function ( data, type, row ) {									return '<a href="javascript:;" onClick="product_detail('+row[0]+')">'+data+'</a>';                          },                          "targets":1                         	                          }                   ]	});			$("#btn_search").click(function(){		reload();	});	});	function reload(){	 datatable.fnClearTable(0);       datatable.fnDraw(); //重新加载数据 }function getParamter(data){	var form_data = $("#submit_form").serializeObject();	for(var key in form_data){		data[key] = form_data[key];	}}//goods_statefunction goods_state(obj,id,state){	layer.confirm('确认要操作商品状态吗？',function(index){	  var _data = {"id": id,'state' : state};      $.ajax({type:"POST",             url:"goods-state.jspx?t="+new Date().getTime(),             data:_data,             dataType:"json",             success:function(data){            	if(data.result ==0){            		layer.msg('操作成功!',{icon:1,time:1000});            		reload();            	}            	else{            		layer.msg(data.message,{icon:1,time:1000});            	}             }		});	});}function goods_hot(obj,id,state){	layer.confirm('确认要操作商品状态吗？',function(index){	  var _data = {"id": id,'state' : state};      $.ajax({type:"POST",             url:"goods-hot.jspx?t="+new Date().getTime(),             data:_data,             dataType:"json",             success:function(data){            	if(data.result ==0){            		layer.msg('操作成功!',{icon:1,time:1000});            		reload();            	}            	else{            		layer.msg(data.message,{icon:1,time:1000});            	}             }		});	});}function goods_burst(obj,id,state){	layer.confirm('确认要操作商品状态吗？',function(index){	  var _data = {"id": id,'state' : state};      $.ajax({type:"POST",             url:"goods-burst.jspx?t="+new Date().getTime(),             data:_data,             dataType:"json",             success:function(data){            	if(data.result ==0){            		layer.msg('操作成功!',{icon:1,time:1000});            		reload();            	}            	else{            		layer.msg(data.message,{icon:1,time:1000});            	}             }		});	});}function goods_fashion(obj,id,state){	layer.confirm('确认要操作商品状态吗？',function(index){	  var _data = {"id": id,'state' : state};      $.ajax({type:"POST",             url:"goods-fashion.jspx?t="+new Date().getTime(),             data:_data,             dataType:"json",             success:function(data){            	if(data.result ==0){            		layer.msg('操作成功!',{icon:1,time:1000});            		reload();            	}            	else{            		layer.msg(data.message,{icon:1,time:1000});            	}             }		});	});}function goods_del(obj,id){	layer.confirm('确认要删除吗？',function(index){	  var _data = {"id": id};      $.ajax({type:"POST",             url:"goods-delete.jspx?t="+new Date().getTime(),             data:_data,             dataType:"json",             success:function(data){            	if(data.result ==0){            		layer.msg('已删除!',{icon:1,time:1000});            		reload();            	}            	else{            		layer.msg(data.message,{icon:1,time:1000});            	}             }		});	});}function goods_mod(obj,id){	var index = layer.open({		type: 2,		title: '修改商品',		content: 'goods-update.jspx?id='+id	});	layer.full(index);}function goods_slash(obj,id){	parent.createTab("goods-image-list.jspx?id="+id,"照片列表");}function goods_fashion(obj,id){	parent.createTab("goods-fashion-list.jspx?id="+id,"Fashion照片列表");}//goods_slash//goods_mod/*图片-添加*/function product_add(){	var index = layer.open({		type: 2,		title: '添加商品',		content: 'goods-add.jspx'	});	layer.full(index);}function product_detail(id){	var index = layer.open({		type: 2,		title: '商品详情',		content: 'goods-detail.jspx?id='+id	});	layer.full(index);}</script></body></html>