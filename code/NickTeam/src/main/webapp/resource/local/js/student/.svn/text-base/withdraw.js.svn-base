/**
 * [提现]
 */

/**
 * [执行提现请求-异步提交]
 */
function doAjaxWithdraw() {
	$.messager.confirm("系统提示", "确定提交提现申请吗?", function(flag) {
		if (flag) {
			$('#withdraw_form').form({
				url : G_basePath + "/finance/createWithdrawDetail.action",
				onSubmit : function() {
					return $('#withdraw_form').form("validate");
				},
				success : function(data) {
					console.log(data);
					var result = JSON.parse(data);
					if ("SUCCESS" == result.invokeState) {
						$.messager.alert("充值结果:", "提现请求提交成功");
					} else {
						$.messager.alert("充值结果:", result.result);
					}
				}
			});
			$('#withdraw_form').form('submit');
		} else {

		}
	});
}