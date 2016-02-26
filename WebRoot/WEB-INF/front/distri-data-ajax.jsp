<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="item" items="${list}">
<table>
	<tr>
		<td>${item.chargeName}</td>
		<td style="color: red;">提层金额：${item.income}&yen;  &nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">消费金额：${item.charge}&yen;&nbsp;&nbsp;提层比例：${item.rate} &nbsp;&nbsp;分级：${item.level}级 &nbsp;&nbsp;下线用户：${item.downlineName}&nbsp;&nbsp;消费时间:<sp:dateformat time="${item.consumeDate}"/></td>
	</tr>
</table>
</c:forEach>
