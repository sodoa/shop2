/*! js weidian 2015-06-25 */
Item.getDetailImg=function(){var a=Item.itemInfo;console.log(a),$("#detail_loading").remove();var b=a.Imgs.length;if(1===b)$("#detail_wrap").append("<img src='"+Item.imageSize(a.Imgs[0])+"' width=100%>"),a.titles&&a.titles[0]&&$("#detail_wrap").append('<p class="img_des">'+a.titles[0]+"</p>"),M.loadScript("http://s.koudai.com/script/item/video.js");else if(b>1){for(var c="",d=0;b>d;d++)a.Imgs[d]=Item.imageSize(a.Imgs[d]),c+="<img src='"+a.Imgs[d]+"' width=100%>",a.titles&&a.titles[d]&&(c+='<p class="img_des">'+a.titles[d]+"</p>");$("#detail_wrap").append(c),Number(a.next_page)?setTimeout(function(){console.log("trigger getNextImg"),Item.nextimg=!0,Item.getNextImg()},1e3):M.loadScript("http://s.koudai.com/script/item/video.js")}else 0===Number(a.next_page)&&$("#detail_wrap").append("<h2 class='c_txt'>用户太懒了。没有大图。</h2>")},Item.getNextImg=function(){if(console.log("getNextImg"),Item.nextimg){var a={itemID:Item.itemID(),page:Item.page};Item.nextimg=!1,M.jsonp("http://item.weidian.com/wd/item/getPubInfo?param="+M.toJSON(a),function(a){if(0===Number(a.status.status_code)){var b=a.result,c=b.Imgs.length;if(1===c){$("#detail_wrap").append("<img src='"+Item.imageSize(b.Imgs[0])+"' width=100%>");var d=$("#detail_wrap").find("img").length()-1;b.titles&&b.titles[d]&&$("#detail_wrap").append('<p class="img_des">'+b.titles[d]+"</p>")}else if(c>1){for(var e="",d=$("#detail_wrap").find("img").length(),f=0;c>f;f++)b.Imgs[f]=Item.imageSize(b.Imgs[f]),e+="<img src='"+b.Imgs[f]+"' width=100%>",b.titles&&b.titles[d+f]&&(e+='<p class="img_des">'+b.titles[d+f]+"</p>");$("#detail_wrap").append(e)}Number(b.next_page)?(Item.page++,Item.nextimg=!0,Item.getNextImg()):M.loadScript("http://s.koudai.com/script/item/video.js")}})}},Item.getDetailImg();