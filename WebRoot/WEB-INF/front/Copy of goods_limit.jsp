<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link href="/theme/css/shop.css" type="text/css" rel="stylesheet" />
<link href="/jslib/uiadmin/lib/laypage/1.2/skin/laypage.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/jslib/uiadmin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="/jslib/timecountdown/timeCountDown.js"></script>

<style type="text/css">
.countime{
	border:1px solid #eee;
	padding-left:5px;
	padding-right:5px;
}

.shop{
	border:1px solid #eee;
}
</style>

</head>
<body>
	
	<div class="header">
		<div class="top_left1">
			<a href="/"><img src="/theme/images/back.png" style="width: 12px;"></a>
		</div>
		<div class="top_center1">火爆活动
		</div>
		<div class="top_right1">
			<a href="javascript:void(0)" onclick="GoCenterUrl('/cart.html')"><img
				src="/theme/images/spc.png" style="width: 29px; height: 29px">
			</a>
		</div>
	</div>
	
	<div class="conter" style="z-index:1;width:100%;background-color: white;padding-top: 10px;">
		<div class="block">
			<ul id="page-comtain">
			</ul>
		</div>
		<div id="page-next"></div>
	</div>
	
<script>

function panel_search_form(){
	var w = $("#panel_search_word").val();
	//if(w.length>0){
	var encode_w = encodeURIComponent(w);
	window.location.href="g-l.html?w="+encode_w+"&theme="+theme;
	//}
}

var theme = "${theme}";

$(function(){

	var ch=$(".category").height();
	var hh=$(".header").height();

	//分类框动画

	$("#search_word").bind("focusin",function(){
		$(".category").show();
	});
	
	$("#panel_search_word").keydown(function(e){
		var theEvent = window.event || e; 
		var code = theEvent.keyCode || theEvent.which; 
		if (code == 13) { 
			var word = $(this).val();
			if(word == null || word.length ==0 || word.trim().length == 0){
				return;
			}
			panel_search_form();
			//window.location.href = "/s.html?w="+encodeURI(word);
		} 
	});
	
	//选择类别
	
	////////////////////////////////////////////////////////////////////////////////
	
	var cur = '${w}';
	var totalPage = '${page.totalPage}';
	
	laypage({
	    cont: 'page-next', //容器。值支持id名、原生dom对象，jquery对象,
	    pages: '${page.totalPage}', //总页数
	    groups: 0, //连续分数数0
	    prev: false, //不显示上一页
	    next: '查看更多',
	    skin: 'flow', //设置信息流模式的样式
	    jump: function(obj){
	        if(obj.curr > totalPage){
	            this.next = '没有更多了';
	        }
	        else{
	        	ajaxPageContent(obj.curr);
	        }
	    }
	});
	
	
	function ajaxPageContent(pageNo){

	      $.ajax({type:"POST",
	             url:"/g-l-more.html",
	             data:{'page':pageNo,'w':cur,'theme':theme},
	             dataType:"json",
	             success:function(data){
					if(data.result == 0){
						parse(data.list);
						document.body.scrollTop = document.body.scrollHeight;
					}
	             }
			});
	}
	
	function parse(dataList){
      
      for(var i=0;i<dataList.length;i++){
    	var htmlArray = new Array();
      	var item = dataList[i];
      	
      	var clockid = item.goodsId;
      	
      	htmlArray.push('<div class="shop" > ');
      	htmlArray.push('<a href="/gl-'+item.goodsId+'.html"><img ');
      	htmlArray.push('	src="'+item.thumbnailUrl+'" onerror="imagerror(this)" ');
      	htmlArray.push('	width="694" height="284" defimage="defimage"> <span style="float:left;width:100%;"><p class="discount" style="display:block;">'+item.discount+'折 &nbsp;<span>'+item.finalPrices+'</span>&nbsp;元</p> ');
      	htmlArray.push('		 ');
      	htmlArray.push('		<p class="name" style="overflow: hidden; width: 60%">'+item.goodsLname+'</p> <p id="'+clockid+'"> <span class="day countime" >33</span>天<span class="hour countime" ></span>时<span class="mini countime" ></span>分 <span class="sec countime" ></span>秒</p></span>');
      	htmlArray.push('</a>');
      	htmlArray.push(' </div>');
      	
		var d = new Date(parseFloat(item.timeLimit));
		
		$('#page-comtain').append(htmlArray.join(""));
		//alert($('#'+clockid+"  .day").html());
		var obj = {
				 day: $('#'+clockid+"  .day").get(0),
			     sec: $('#'+clockid+"  .sec").get(0),
			     mini: $('#'+clockid+" .mini").get(0),
			     hour: $('#'+clockid+" .hour").get(0)
			};
		 
		fnTimeCountDown(d, obj);
      }
     
	}

});

</script>

<jsp:include page="scrollup.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


