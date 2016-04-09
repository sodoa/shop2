<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html><html lang="en"><head>      <jsp:include page="../head.jsp"></jsp:include><script type="text/javascript" src="/jslib/uiadmin/lib/My97DatePicker/WdatePicker.js"></script><script type="text/javascript" src="/jslib/uiadmin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script></head><body><nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>用户管理<span class="c-gray en">&gt;</span>用户分析 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav><div class="pd-20">	<div class="text-c"> 二级下线数：		<input type="text"  id="level2Num" class="input-text" style="width:120px;" value="20">		<input type="text" class="input-text" style="width:250px" placeholder="输入会员电话号码" id="user_phone" name="">		<button type="submit" class="btn btn-success radius" id="btn_search" name="" ><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>	</div>	<div class="mt-20">	<table class="table table-border table-bordered table-hover table-bg table-sort">		<thead>			<tr class="text-c">                                            <th>用户ID</th>                                            <th>用户名称</th>                                            <th>帐号</th>                                            <th>注册时间</th>                                            <th>注册类型</th>                                            <th>下线数量（二级）</th>                                            <th>操作</th>                                        </tr>		</thead>		<tbody>	                                    			</tbody>	</table>	</div></div><script type="text/javascript">var datatable = null;$(function(){	datatable = $('.table-sort').dataTable({		"bStateSave": true,//状态保存        responsive: true,        "searching": false,        "processing": true,        "serverSide": true,        "ordering": false,        "bLengthChange": false,        "info":     false,        "paging":   true,        "ajax": {        	"url":"/admin/customer-listlayer-page.jspx",        	"type":"post",        	"data":function(d){        		getParamter(d);       		 }		},        "columnDefs": [                       {                           "render": function ( data, type, row ) {                        	   return "";							},                           "targets": 6                       },                       {                            "render": function ( data, type, row ) {                        	                           	   if(data == 1){                        		   return '维信用户';                        	   }                        	   else if(data == 2){                        		   return '网站用户';                        	   }                           },                           "targets": 4                	                       	                          },                       {                            "render": function ( data, type, row ) {                  				if(data!=null){                  					return new Date(data).formatShort();                  				}                           },                           "targets": 3                	                       	                          },{                    	   "render" :function(data,type,row){                    		   return '<u style="cursor:pointer" class="text-primary" onclick="member_show('+row[0]+')">' +data+ '</u>';                    	   },                    	   "targets":2                       }                   ]	});			$("#btn_search").click(function(){		reload();	});	});	function reload(){	 datatable.fnClearTable(0);       datatable.fnDraw(); //重新加载数据 }function getParamter(data){	var level2Num = $("#level2Num").val();	var user_phone = $("#user_phone").val();	data['level2Num']=level2Num;	data['user_phone'] = user_phone;}/*用户-添加*/function member_add(title,url,w,h){	layer_show(title,url,w,h);}/*用户-查看*/function member_show(id){	layer_show('用户查看',"customer-info.jspx?id="+id,600,450);}</script></body></html>