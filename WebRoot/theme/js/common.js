
	//对话框
	//单键对话框
	function dialog(titel,conter,callback){
	
		var obj="<div class=\"dialog\"><p>"+titel+"</p>"+
				"<p>"+conter+"</p>"+
				"<p id=\"identify\">是</p><p id=\"cancel\">否</p>"
				"</div>";
		$("body").append(obj);  
		
		$("#cancel").on("click",function(){		
			$(".dialog").remove();
		})
		$("#identify").on("click",function(){
			$(".dialog").remove();
			callback();
		});		
	}
	//双键对话框
	function dialog1(titel,conter){
		var obj="<div class=\"dialog\"><p>"+titel+"</p>"+
		         "<p>"+conter+"</p>"+
		         "<p id=\"cancel\">确定</p>"
				 "</div>";
		$("body").append(obj);  
		
		$("#cancel").on("click",function(){		
			$(".dialog").remove();
		});
		
	}
//返回上一页
	function return_prepage(){  
	  if(window.document.referrer!=""){  
		window.location.href=window.document.referrer;  
		}  
		  
	}  