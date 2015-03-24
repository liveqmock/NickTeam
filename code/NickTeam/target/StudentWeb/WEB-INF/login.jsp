<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统登录</title>
<jsp:include page="include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/login.js"></script>
</head>
<body>
	<div class="login-bg">
		<div class="login-logo"></div>
		<div class="clear" style="height: 70px;"></div>
		<div class="login-center">
			<div class="login-left">
				<div class="login-title">
					<s class="line-one"></s>
					<h1>无涯国际教育</h1>
					<s class="line-one"></s>
				</div>
				<div class="clear" style="height: 30px;"></div>
				<div class="login-text">
					<p>中国青少年INTERNATIONAL</p>
					<p>商业交流项目领导者EDUCATION</p>
				</div>
			</div>
			<div class="login-right">
				<div class="login-input-content">
					<form id="login_form" action="#">
						<p>登录您的账户</p>
						<input class="input-270" required="true" placeholder="用户名/邮箱地址/手机号码" name="token" />
						<input class="input-270" type="password" required="true" placeholder="密 码" name="password" />
						<button class="button-red" onclick="javascript:doAjaxLogin();">登 录</button>
						<h4 style="margin-top: 7px;">
							<a href="javascript:void(0);" onclick="javascript:toSignUp();" style="float: left;">注册</a>
								<span style="float: right">
							<a href="#">忘记密码</a></span>
						</h4>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>