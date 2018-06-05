<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json测试</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
	//请求json，输出json
	function requestJson(){
		$.ajax({
			type:'post',
			url:'${pageContent.request.contextPath}/requestJson.action',
			contextType:'application/json;charset=utf-8',
			//数据格式是json串
			data:'{"name":"手机","price":"6999"}',
			success:function(data){//返回json结果
				alert(data);
			}
		});
	}
	
	
	//请求key/value，输出Json
	function responseJson(){
		$.ajax({
			type:'post',
			url:'${pageContent.request.contextPath}/responseJson.action',
			//请求是key/value这里不需要指定contentType,因为默认就是key/value类型
			//contentType:'application/json;charset=utf-8'，
			//数据格式是json串，商品信息
			data:'name=手机&price=999',
			success:function(data){//返回json数据
				alert(data.name);
			}
		});
	}
</script>

</head>
<body>
	<input type="button" onclick="requestJson()" value="请求Json，输出json" />
	<input type="button" onclick="responseJson()" value="请求key/value，输出Json" />
</body>
</html>