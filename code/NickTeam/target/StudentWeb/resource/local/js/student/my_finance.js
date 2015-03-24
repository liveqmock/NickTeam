/**
 * [财富账户页面JS]
 */

$(function() {
	loadFinanceAccount(G_passportId);
});

/**
 * [获取财富账户]
 * 
 * @param passportId
 */
function loadFinanceAccount(passportId) {
	if (passportId) {
		var params = {
			"financeAccountCriteria.dstatus" : "normal",
			"financeAccountCriteria.requirePage" : false,
			"financeAccountCriteria.passportId" : passportId,
			"rows" : 1,
			"page" : 1
		};
		$.ajax({
			url : G_basePath + "/finance/getFinanceAccountWithPage.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				console.log(result);
				if (result) {
					var object = result.rows[0];
					$("#page_accountId").val(object.id);
					$("#v_canUseMoney").html("￥" + object.canUseMoneyStr);
					$("#v_frozenMoney").html("￥" + object.frozenMoneyStr);
					loadAccountDetail(1, 10);
				}
			}
		});
	} else {

	}
}

/**
 * [获取账户明细]
 */
function loadAccountDetail(page, rows) {
	var accountId = $("#page_accountId").val();
	if (accountId) {
		var params = {};
		params["financeAccountDetailCriteria.dstatus"] = "normal";
		params["financeAccountDetailCriteria.accountId"] = accountId;
		params["financeAccountDetailCriteria.requirePage"] = true;
		params["rows"] = rows;
		params["page"] = page;
		$.ajax({
			url : G_basePath
					+ "/finance/getFinanceAccountDetailListWithPage.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				console.log(result);
				if (result) {
					putAccountDetailToPage(result.rows);
					/* 生成分页数据 */
					$('#account_detail_list_pager').pagination({
						pageList : [ 10, 20 ],
						total : result.total,
						pageSize : params.rows,
						pageNumber : params.page,
						onSelectPage : function(pageNumber, pageSize) {
							loadAccountDetail(pageNumber, pageSize);
						}
					});
				}
			}
		});
	}
}

/**
 * [显示明细列表]
 * 
 * @param list
 */
function putAccountDetailToPage(list) {
	if (list && 0 < list.length) {
		$("#account_detail_list").html("");
		var html = "";
		for (var i = 0; i < list.length; i++) {
			var object = list[i];
			if (i % 2 == 0) {
				html += "<tr class='t2'>";
			} else {
				html += "<tr class='t1'>";
			}
			html += "<td style='width:3%;'></td>";
			html += "<td style='width:18%;'>" + object.createTimeStr + "</td>";
			if ("recharge" == object.type) {
				html += "<td style='width:12%;'><a href='" + G_basePath + "/router/toRecharge2.action?detailId=" + object.id + "'>" + object.typeStr + "</a></td>";
				html += "<td class='b-green' style='width:15%;'><s class='s-cat-40'></s>"
						+ object.priceStr + "</td>";
			} else if ("withdraw" == object.type) {
				html += "<td style='width:12%;'>" + object.typeStr + "</td>";
				html += "<td class='b-red' style='width:15%;'><s class='s-cat-41'></s>"
					+ object.price + "</td>";
			} else {
				html += "<td style='width:12%;'>" + object.typeStr + "</td>";
				html += "<td class='b-green' style='width:15%;'></s>"
					+ object.price + "</td>";
			}
			if ("recharge" == object.type) {
				html += "<td style='width:30%;'>用户常规充值费用-需管理员审核</td>";
			} else if ("withdraw" == object.type) {
				html += "<td style='width:30%;'>用户常规提现-需管理员审核</td>";
			} else {
				html += "<td style='width:30%;'>其他</td>";
			}
			html += "<td class='b-red' style='width:13%;'>" + object.statusStr + "</td>";
			if ("waitJudgement" == object.status) {
				html += " <td><s class='s-cat-42'></s></td>";
			} else {
				html += " <td><s class='s-cat-42' style='display:none;'></s></td>";
			}
			html += "</tr>";
		}
		$("#account_detail_list").html(html);
	}
}

/**
 * [跳转到充值步骤1界面]
 */
function toRechargeStep1() {
	var accountId = $("#page_accountId").val();
	if (accountId) {
		window.location.href = G_basePath
				+ "/router/toRecharge1.action?accountId=" + accountId;
	}
}