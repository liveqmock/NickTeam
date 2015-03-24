<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎注册</title>
<jsp:include page="include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/signup.js"></script>
</head>
<body>
	<div id="index-bg">
		<div class="clear" style="height: 50px;"></div>
			<form id="sign_up_form" action="#" method="post">
				<div class="cotent-sign-center">
					<div class="sign-content">
						<div class="logo"></div>
						<div class="line-red"></div>
						<div class="member">
							<s class="s-cat-25"></s>
							<h2>
								会员注册 &nbsp;&nbsp;<span>带<b class="b-red">*</b>为必填项，剩余项可以在注册完毕进入系统后再补充完善。为了保证您能顺利申请成功我们的项目，请保证填写信息的真实有效性。
								</span>
							</h2>
						</div>
						<div class="record password">
							<dl>
								<dt>
									<b class="b-red">*</b>
									<span>电子邮箱</span>
									<input id="su_email" name="passport.email" placeholder="请输入邮箱地址" class="input-300 easyui-validatebox" data-options="required:true,validType:'email'">
								</dt>
							</dl>
							<dl>
								<dt>
									<b class="b-red">*</b>
									<span>手机号码</span>
									<input id="su_mobile" name="passport.mobile" placeholder="请输入手机号码" class="input-300 easyui-validatebox" data-options="required:true,validType:'length[11,11]'">
								</dt>
							</dl>
							<dl>
								<dt>
									<b class="b-red">*</b>
									<span>登陆密码</span>
									<input id="su_password1" name="passport.password" placeholder="请输入密码" type="password" class="input-300 easyui-validatebox" data-options="required:true,validType:'length[6,8]'">
								</dt>
							</dl>
							<dl>
								<dt>
									<b class="b-red">*</b>
									<span>确认密码</span>
									<input id="su_password2" placeholder="请确认密码" type="password" class="input-300 easyui-validatebox" data-options="required:true,validType:'length[6,8]'">
								</dt>
							</dl>
						</div>
						<div class="dashed-gray"></div>
						<div class="clear" style="height: 10px;"></div>
					</div>
					<div class="record-two">
						<div style="text-indent: 112px;">
							<p>你是通过什么方式了解到我们的？</p>
							<div class="div-label">
								<label><input name="passport.fromType" type="radio" value="school" /> 学校 </label>
								<label><input name="passport.fromType" type="radio" value="organization" /> 机构 </label>
								<label><input name="passport.fromType" type="radio" value="teacher" /> 老师 </label>
								<label><input name="passport.fromType" type="radio" value="classmate" /> 同学 </label>
								<label><input name="passport.fromType" type="radio" value="senior" /> 上届学长/学姐 </label>
								<label><input name="passport.fromType" type="radio" value="homepage" /> 无涯教育官网 </label>
							</div>
							<div class="clear" style="height: 0px;"></div>
							<div class="dashed-gray"></div>
							<p>
								在注册之前请阅读我们的<a href="#" target="_blank">注册协议</a> &nbsp;&nbsp;
								<input id="aggee" type="checkbox" checked="checked"/><label> 我同意</label>
							</p>
						</div>
						<a href="javascript:doSignUpAjax();" class="btn-blue medium" style="margin-left: 112px;">立即注册</a>
					</div>
					<div class="clear" style="height: 80px;"></div>
				</div>
			</form>
		<div class="clear" style="height: 50px;"></div>
	</div>

</body>
</html>