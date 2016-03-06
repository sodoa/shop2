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

</head>
<body>
	
	<div class="header">
		<div class="top_left1">
			<a href="/"><img src="/theme/images/back.png" style="width: 12px"></a>
		</div>
		<div class="top_center">
			<a href="#"><img src="/theme/images/Search.png"></a>
			<input name="search_word"  id="search_word" placeholder="输入商品名称或关键字" maxlength="20" value="${w}" />
		</div>
		<div class="top_right1">
			<a href="javascript:void(0)" onclick="GoCenterUrl('/cart.html')"><img
				src="/theme/images/spc.png" style="width: 29px; height: 29px">
			</a>

		</div>
	</div>
	
	<div class="category" style="display: none;position:absolute;z-index: 9999;width: 100%;height: 100%;top: 0px;">
		<div style="clear: both;width: 100%;display: inline-block;padding: 10px;margin: 10px;padding-left: 15px;">
			<input style="height: 32px;border:1px solid #eee;width:50%;" name="panel_search_word" id="panel_search_word" value="${w}"  placeholder="输入商品名称或关键字" maxlength="20">
			<a href="javascript:void(0);" onclick="panel_search_form()"><img src="/theme/images/Search.png" width="20" height="20"></a>
			<a style="padding: 5px;cursor: pointer;float: right;margin-right: 30px;" type="button" value="查询" onclick="panel_close_search()">关闭</a>
		</div>
		<div style="display: inline-block;width: 100%;padding: 10px;margin: 10px;border-top: 1px solid #eee;">
			<sp:search_words_list_tag>
				<c:forEach var="item" items="${list}">
					<a onclick="panel_pickup_words('${item.words}')" style="padding:5px;padding-right:10px;padding-top:5px;padding-bottom:5px;border:1px solid #eee;margin:5px;cursor: pointer;">${item.words}</a>
				</c:forEach>
			</sp:search_words_list_tag>
		</div>
	</div>
	
	<div class="conter" style="z-index:1;width:100%;">
		<div class="block">
			<ul id="page-comtain">
			</ul>
		</div>
		<div id="page-next"></div>
	</div>
	
<script>

function panel_close_search(){
	$(".category").hide();
}

function panel_pickup_words(keywords){
	$("#panel_search_word").val(keywords);
	panel_search_form();
}

function panel_search_form(){
	var w = $("#panel_search_word").val();
	//if(w.length>0){
	var encode_w = encodeURIComponent(w);
	window.location.href="g-s.html?w="+encode_w;
	//}
}

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
	             url:"/g-s-more.html",
	             data:{'page':pageNo,'w':cur},
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
		 
      var htmlArray = new Array();
      
      for(var i=0;i<dataList.length;i++){
      	
      	var item = dataList[i];
      
      	 htmlArray.push('<li> ');
      	 htmlArray.push('	<div class="block-image">');
      	 htmlArray.push('		<a href="goods-'+item.goodsId+'.html" ><img onerror="imagerror(this)"  src="'+item.thumbnailUrl+'"  style="width: 100%;height:200px;"> </a> ');
      	 htmlArray.push('	</div>');

      	 htmlArray.push('	<div class="block-titel">'+item.goodsLname+'</div>');
      	 htmlArray.push('	<div class="block-price">');
      	 htmlArray.push('		<p>&yen;'+item.finalPrices+'</p>');
      	 htmlArray.push('		<p>');
      	 htmlArray.push('			<s>&yen;'+item.orginPrices+'</s>');
      	 htmlArray.push('		</p>');
      	 htmlArray.push('		<p>'+item.discount+'折</p>');
      	 htmlArray.push('		<a href=""></a>');
      	 htmlArray.push('	</div>');
      	 htmlArray.push('</li>');
	      
      }
      
      $('#page-comtain').append(htmlArray.join(""));
	}
	

});

</script>

<jsp:include page="scrollup.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>


