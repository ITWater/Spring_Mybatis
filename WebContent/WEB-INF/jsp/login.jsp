<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登陆</title>
</head>
<body>
	
	<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script language="javascript">
    	function checklogin(){
    		if(document.formLogin.username.value == '' && document.formLogin.password.value == ''){
    			window.alert("请输入用户名和密码!!");
    			document.formLogin.username.focus();
    		}
    		else if ( document.formLogin.username.value == '' ) {
				window.alert('请输入用户名!!');
				document.formLogin.username.focus();
			}else if ( document.formLogin.password.value == '') {
				window.alert('请输入密码!!');
				document.formLogin.password.focus();
			}else if ( document.formLogin.password.value.length < 6 ) {
				window.alert('密码长度应大于等于6!!');
				document.formLogin.password.focus();
			}
			else {
				return true;
				}
			return false;
    	}
	</script>

	${loginMessage}
	<form name="formLogin" action="${pageContext.request.contextPath}/login.action" method="post">
		用户账号：<input type="text" name="username" /> <br/>
		用户密码：<input type="password" name="password" /> <br/>
		<button type="submit" name="button" onclick="javascript: return checklogin()" >登陆</button>
	</form>
</body>
</html>