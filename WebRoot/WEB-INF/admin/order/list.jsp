<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html><html lang="en"><head>      <jsp:include page="../head.jsp"></jsp:include><script type="text/javascript" src="/jslib/uiadmin/lib/My97DatePicker/WdatePicker.js"></script><script type="text/javascript" src="/jslib/uiadmin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script></head><body><nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>订单管理<span class="c-gray en">&gt;</span>订单列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav><div class="pd-20">	<div class="text-c"> 日期范围：		<input type="text" onfocus="WdatePicker()" id="datemin" class="input-text Wdate" style="width:120px;">		-		<input type="text" onfocus="WdatePicker()" id="datemax" class="input-text Wdate" style="width:120px;">		<input type="text" class="input-text" style="width:150px" placeholder="订单号" id="orderId" name="">		<input type="text" class="input-text" style="width:150px" placeholder="用户帐号" id="account" name="">		<span class="select-box" style="width:150px">		<select class="select" name="state" size="1" id="state">				<option value="" selected>全部</option>				<option value="0">未支付</option>				<option value="1">已支付</option>				<option value="2">已出货</option>				<option value="3">已评价</option>		</select>		</span>		<button type="submit" class="btn btn-success radius" id="btn_search" name="" ><i class="Hui-iconfont">&#xe665;</i> 搜订单</button>	</div>	<div class="mt-20">	<table class="table table-border table-bordered table-hover table-bg table-sort" width="100%">		<thead>			<tr class="text-c">                                            <th>订单号</th>                                            <th>收货信息</th>                                            <th>用户帐号</th>                                            <th>下单时间</th>                                            <th>订单金额</th>                                            <th>订单状态</th>                                            <th>操作</th>                                        </tr>		</thead>		<tbody>	                                    			</tbody>	</table>	</div></div><script type="text/javascript">var datatable = null;$(function(){	datatable = $('.table-sort').dataTable({		"bStateSave": true,//状态保存        responsive: true,        "searching": false,        "processing": true,        "serverSide": true,        "ordering": false,        "bLengthChange": false,        "info":     false,        "paging":   true,        "ajax": {        	"url":"order-list-page.jspx",        	"type":"post",        	"data":function(d){        		getParamter(d);       		 }		},        "columnDefs": [                       {                           "render": function ( data, type, row ) {                        	   var array = new Array();                        	   array.push('<a title="定单详情" href="javascript:;" onclick="order_detail(this,'+row[0]+')" class="ml-5" style="text-decoration:none">详情</a>');                               return array.join("");                           },                           "targets": 6                       },                       {                            "render": function ( data, type, row ) {                        	                           	   var array = new Array();                        	                           	   if(data ==  0){                        		   array.push('未付款');                        	   }else if(data == 1){                        		   array.push('已付款');                        		   array.push('&nbsp;&nbsp;&nbsp;<a class="btn btn-primary radius" onclick="order_out('+row[0]+')" href="javascript:;"><i class="Hui-iconfont"></i> 出货</a>');                        	   }else if(data == 2){                        		   array.push('已出货');                    	  	   }else if(data == 3){                    		  	   array.push('已评价');                    	       }                     	                           	                     			   return array.join("");                           },                           "targets": 5               	                       	                          },                       {                            "render": function ( data, type, row ) {                  				if(data!=null){                  					return new Date(data).formatLong();                  				}                           },                           "targets": 3             	                       	                          },{                    	   "render" :function(data,type,row){                    		   return '<u style="cursor:pointer" class="text-primary" onclick="order_detail(this,'+row[0]+')">' +data+ '</u>';                    	   },                    	   "targets":2                       }                   ]	});			$("#btn_search").click(function(){		reload();	});	});	function reload(){	 datatable.fnClearTable(0);       datatable.fnDraw(); //重新加载数据 }function getParamter(data){	var startdate = $("#datemin").val();	var enddate = $("#datemax").val();	var account = $("#account").val();	var orderId = $("#orderId").val();	var state = $("#state").val();			data['startdate']=startdate;	data['enddate']=enddate;	data['account'] = account;	data['orderId'] = orderId;	data['state'] = state;}function order_detail(obj,id){	order_out(id);}function order_out(id){		var index = parent.layer.open({		type : 2,		title : '订单出货',		content : 'order-info.jspx?oid='+id	});	parent.layer.full(index);	}</script></body></html>