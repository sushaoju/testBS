function addSubPage(title,url){    
            var jq = top.jQuery;    
            if (jq("#tt").tabs('exists', title)){    
                jq("#tt").tabs('select', title);    
            } else {  
                 var content='<iframe src="'+url+'" frameborder="0" scrolling="auto" style="width:100%;height:100%;"></iframe>';
				jq('#tt').tabs('add',{
					title: title,
					content: content,
					closable: true
				});   
             }    
        }    