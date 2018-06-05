<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form>
		<input type="text" id="uname" />
		<input type="password" id="pwd" />
	</form> -->
	<p>
		Name: <span id="uname"></span><br />
		Password: <span id="pwd"></span><br />
</p>
	
	<script type="text/javascript">
		var JsonTemp = {
				"name":"sunhui",
				"password":"sh152332"
		};
		document.getElementById("uname").innerHTML=JsonTemp.name
		document.getElementById("pwd").innerHTML=JsonTemp.password
	</script>
</body>
</html>