<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html><html lang="en"><head>      <jsp:include page="../head.jsp"></jsp:include><script type="text/javascript" src="/jslib/uiadmin/lib/My97DatePicker/WdatePicker.js"></script><script type="text/javascript" src="/jslib/uiadmin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script></head><body><nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>分销管理<span class="c-gray en">&gt;</span>软文管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav><div class="pd-20">	<a class="btn btn-primary radius" onclick="add()" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加</a>	<form action="#" method="post">	<div class="mt-20">			<table class="table table-striped table-bordered table-hover">				<thead>					<tr>						<th>#</th>						<th>标题</th>						<th>分类</th>						<th>发布时间</th>						<th>操作</th>					</tr>				</thead>				<tbody>					<c:forEach var="d" items="${list}" varStatus="s">						<tr>							<td>${s.index+1}</td>							<td><a style="color: red;" href="/ac-${d.id}.html" target="_blank">${d.title}</a></td>							<td><sp:dict_label_tag type="article_classify" value="${d.classify}"></sp:dict_label_tag></td>							<td> <sp:dateformat time="${d.releasedate}" format="yyyy-MM-dd"/> </td>							<td><a href="#" onclick="del('${d.id}')">删除</a>&nbsp;<a href="#" onclick="update('${d.id}')">修改</a></td>						</tr>					</c:forEach>				</tbody>			</table>		</div>	</form></div><script type="text/javascript">function add(){	//layer_show('增加软文','add.jspx?opt=1',700,800);		window.location.href = "add.jspx";}function update(id){	window.location.href = "update.jspx?id="+id;}function del(id){	layer.confirm('确认删除嘛？',function(index){	      $.ajax({type:"POST",	             url:"./del.jspx",	             data:{'id':id},	             dataType:"json",	             success:function(data){					if(data.result == 0){						//alert("删除成功");						layer.msg('已删除!',{icon:1,time:1000},function(){window.location.reload();});					}	             }			});	});}</script></body></html>