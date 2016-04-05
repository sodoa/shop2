<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://mos.xinfan.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">
<head>
<jsp:include page="header.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/theme/newest/css/order.css" />
<link rel="stylesheet" href="/theme/newest/css/jquery.spinner.css" />
<script type="text/javascript" src="/theme/js/jquery.spinner.js"></script>
</head>
<body>

<div class="g-doc">
    <div class="top-fxied">
            <header class="header"> 
                <div class="back"><a href="/"><span class="icon-back"></span></a></div> 
                <div class="title">购物车</div> 
                <div class="subMark"><p><a href="javascript:void(0)" onclick="empty_cart()">清空</a></p></div> 
            </header>
     </div>
    
    <div class="scroll-content">
    	
        <div class="order-manage"> 
               <ul class="m-shoppinglist">
               
               		<c:if test="${!CartInfoVo.hasGoods}">
						<div class="null_cart">
							<p>亲,您还没有任何商品！</p>
							<p>
								<a href="/">马上去购物吧!</a>
							</p>
						</div>
					</c:if>
		
					<c:if test="${CartInfoVo.hasGoods}">
						<c:forEach items="${CartInfoVo.carts}" var="cartitem" varStatus="st">
		                    <li>
		                    	<div class="item-laber">
		                        	<div class="checkbox">
		                        		<input type="checkbox" class="cartList-check" name="checkbox1" id="s11" checked="checked">
		                            </div>
		                        </div>
		                    	<div class="m-cartlist">
		                        
		                                        <div class="m-cartlist-img"><a href="/goods-${CartInfoVo.goods[st.index].goodsId}.html"><img  src="${CartInfoVo.goods[st.index].thumbnailUrl}"></a></div>
		                                        <div class="m-cartlist-info">
		                                            <h3>${CartInfoVo.goods[st.index].goodsName}</h3>
		                                            <p>${CartInfoVo.goods[st.index].goodsLname}</P>
		                                            <p class="price"><em class="txtOrange">&yen;${CartInfoVo.goods[st.index].finalPrices}</em>&nbsp;&nbsp;&nbsp;<del style="color:#999">&yen;${CartInfoVo.goods[st.index].orginPrices}</del></p>
		                                            <div class="num-btn"> <input type="text" class="spinner" data="${cartitem.cartId}" name="" value="${CartInfoVo.carts[st.index].quantity}" /></div>
		                                        </div>
		
		                          </div>
		                          <div class="m-carlist-btn" onclick="deleteRow();" data="${cartitem.cartId}"><span class="close-btn" ></span></div> 
		                    </li>
		                 </c:forEach>
                    </c:if>
               </ul>	
               
            <form action="/cart-number.html" id="number_operator_form" method="post">
				<input type="hidden" name="number_operator" /> 
				<input type="hidden" name="cartId" />
			</form> 

        </div>
      
       
    </div>
    
    <div class="bottom-fxied">
    <div class="m-shoppinglist-footer">
    <div class="m-shoppinglist-btn">
    	<c:if test="${CartInfoVo.hasGoods}">
                               <div class="info"><p>总金额：<span class="txtOrange">&yen;${CartInfoVo.totalAmount} </span></p><P class="subMark">原价：<del>&yen;${CartInfoVo.orginAmount}</del></P></div>
                                 <div class="btn">      
                                    <a  href="javascript:void(0)" class="orange-btn" onclick="javascript:goToOrder()">去结算</a>         
                                 </div>
                                </c:if>
                           </div>
    </div>
    </div>
</div>
	
	<script type="text/javascript">
		$(function() {
			
			$('.spinner').spinner({
				 max:30, 
				 min:1,
				 increase:function(cartid){
					$("#number_operator_form input[name='number_operator'] ").val("1");
					$("#number_operator_form input[name='cartId'] ").val(cartid);
					$("#number_operator_form").submit();
				 },
				 decrease:function(cartid){
						$("#number_operator_form input[name='number_operator'] ").val("2");
						$("#number_operator_form input[name='cartId'] ").val(cartid);
						$("#number_operator_form").submit();
				 }
			});

		});
		
		
		$(".shopDelet").click(function(){

			var _this=$(this);

			dialog("提醒","您确定要删除该商品么？",function(){						
				var cartId = _this.attr("data");
				window.location.href="cart-del.html?cid="+cartId;
			});

		});
		
		
		function empty_cart(){
			dialog("提醒","您确定要清空购物车？",function(){						
				window.location.href="empty_cart.html";
			});
		}
		
		function goToOrder(){
			window.location.href = "/center/order.html?p=" + GetUrlRelativePath();
		}
		
	</script>

</body>
</html>


