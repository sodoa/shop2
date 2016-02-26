$.ajaxSetup({  
	contentType:"application/x-www-form-urlencoded;charset=utf-8",  
	complete:function(XMLHttpRequest,textStatus){  
		//通过XMLHttpRequest取得响应头，sessionstatus，  
		try{
			var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");   
			if(sessionstatus=="timeout"){  
			//如果超时就处理 ，指定要跳转的页面  
				if(parent.window !=window){
					parent.window.location = '/login.jspx';
				}
				else{
					window.location = "/login.jspx";  
				}
			}  
		}catch(e){}
	}  
});