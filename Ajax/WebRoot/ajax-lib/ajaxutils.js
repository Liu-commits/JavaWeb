// 创建异步对象
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}

/*请求方式method,*/
/*urlurl,*/
/*是否异步asyn,*/
/*请求体 params,*/
/*回调方法callback,*/
/*服务器响应数据转换成什么类型type*/

function ajax(option){
	//得到xmlHttp
	var xmlHttp = createXMLHttpRequest();
	
	//默认为GET
	if(!option.method){
		option.method = "GET";
	}
	//默认异步
	if(option.asyn == undefined){
		option.asyn = true;
	}
	//打开链接
	xmlHttp.open(option.method,option.url,option.asyn);
	//判断是否post
	if("POST" == option.method){
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}
	
	//发送请求
	xmlHttp.send(option.params);
	//注册监听
	xmlHttp.onreadystatechange = function(){
		//双重判断
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			var data;
			//获取服务器数据进行转换
			//默认纯文本
			if(!option.type){
				data = xmlHttp.responseText;
			}else if(option.type == "xml"){
				data = xmlHttp.responseXML;
			}else if(option.type == "text"){
				data = xmlHttp.responseText;
			}else if(option.type == "json"){
				var text = xmlHttp.responseText;
				data = eval("("+text+")");
			}
			//调用回调方法
			option.callback(data);
		}
	}
}