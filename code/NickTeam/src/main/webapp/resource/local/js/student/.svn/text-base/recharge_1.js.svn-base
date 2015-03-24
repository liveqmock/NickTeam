/**
 * [充值界面1JS]
 */

$(function() {

});

/**
 * [执行充值-异步提交]
 */
function doAjaxRecharge() {
	$('#recharge_form').form(
			{
				url : G_basePath + "/finance/createChargeDetail.action",
				onSubmit : function() {
					return $('#recharge_form').form("validate");
				},
				success : function(data) {
					console.log(data);
					var result = JSON.parse(data);
					if ("SUCCESS" == result.invokeState) {
						if (result.result) {
							location.href = G_basePath
									+ "/router/toRecharge2.action?detailId="
									+ result.result;
						}
					} else {
						$.messager.alert("充值结果:", result.result);
					}
				}
			});
	$('#recharge_form').form('submit');
}