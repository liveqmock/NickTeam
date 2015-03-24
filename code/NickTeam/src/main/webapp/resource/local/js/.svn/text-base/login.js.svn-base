/**
 * [登录页面JS]
 */

$(function() {

});

/**
 * [执行异步登录功能]
 */
function doAjaxLogin() {
	$('#login_form').form({
		url : G_basePath + "/user/login.action",
		onSubmit : function() {
			return $('#login_form').form("validate");
		},
		success : function(data) {
			var result = JSON.parse(data);
			if ("SUCCESS" == result.invokeState) {
				location.href = G_basePath + "/router/toStudentIndex.action";
			} else {
				$.messager.alert("登录结果", result.result);
			}
		}
	});
	$('#login_form').submit();
}

function toSignUp() {
	window.location.href = G_basePath + "/router/toSignUp.action";
}

/**
 * [打开密码忘记对话框]
 */
function openPasswordForgetDialog() {
	$('#password_forget_dialog').show();
	$('#password_forget_dialog').window({
		width : 250,
		height : 120,
	});
}
