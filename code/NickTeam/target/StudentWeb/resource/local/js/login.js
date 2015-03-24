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
			if("SUCCESS" == result.invokeState){
				location.href = G_basePath + "/router/toStudentIndex.action";
			}else{
				$.messager.alert("登录结果" , result.result);
			}
		}
	});
}

function toSignUp(){
	window.location.href = G_basePath + "/router/toSignUp.action";
}

