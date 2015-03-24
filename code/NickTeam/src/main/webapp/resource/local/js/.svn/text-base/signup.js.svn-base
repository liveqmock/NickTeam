/**
 * [注册页面JS]
 */

$(function() {
});

/**
 * [执行异步注册请求]
 */
function doSignUpAjax() {
	$('#sign_up_form').form(
			{
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
							$.messager.alert("系统提示", "输入的两次密码不匹配");
							passwordFlag = false;
						}
					}
					// 检查表单
					var formFlag = false;
					formFlag = $('#sign_up_form').form("validate");
					if (passwordFlag && formFlag) {
						return true;
					} else {
						return false;
					}
				},
				success : function(data) {
					var result = JSON.parse(data);
					if ("SUCCESS" == result.invokeState) {
						$.messager.alert("注册结果", "注册成功！");
						window.location.href = G_basePath
								+ "/router/toStudentIndex.action";
					} else {
						$.messager.alert("注册结果", result.result);
					}
				}
			});
	$('#sign_up_form').submit();
}

/**
 * [显示协议框]
 */
function showXYDialog() {
	$('#xy_dialog').show();
	$('#xy_dialog').window({
		width : 800,
		height : 400,
		title : "无涯用户协议"
	});
}
