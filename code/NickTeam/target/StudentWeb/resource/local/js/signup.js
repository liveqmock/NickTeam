/**
 * [注册页面JS]
 */

$(function() {
});

/**
 * [执行异步注册请求]
 */
function doSignUpAjax() {
	$('#sign_up_form').form({
		url : G_basePath + "/user/regist.action",
		onSubmit : function() {
			// 验证密码
			var passwordFlag = false;
			var password1 = $("#su_password1").val();
			var password2 = $("#su_password2").val();
			if (password1 && password2) {
				if (password1 == password2) {
					passwordFlag = true;
				} else {
					$.messager.alert("系统提示","输入的两次密码不匹配");
					passwordFlag = false;
				}
			}
			// 检查协议
			var aggreFlag = $("#aggee").attr("checked");
			if(!aggreFlag){
				$.messager.alert("系统提示","请勾选同意注册协议");
				aggreFlag = false;
			}
			// 检查表单
			var formFlag = false;
			formFlag = $('#sign_up_form').form("validate");
			if(passwordFlag && formFlag && aggreFlag){
				return true;
			}else{
				return false;
			}
		},
		success : function(data) {
			var result = JSON.parse(data);
			if ("SUCCESS" == result.invokeState) {
				$.messager.alert("注册结果", "注册成功！", "info", function () {
					window.location.href = G_basePath + "/router/toLogin.action";
		        });
			} else {
				$.messager.alert("注册结果", result.result);
			}
		}
	});
	$('#sign_up_form').submit();
}
