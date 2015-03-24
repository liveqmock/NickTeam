/**
 * [我的项目订单详细页面JS]
 */

var page_orderId = null;
var page_oderInfo = null;
var page_project_costs = null;

$(function() {
	page_orderId = $("#page_orderId").val();
	if (page_orderId) {
		loadOrderInfo();
	} else {
		$.manager.alert("系统提示", "当前订单信息不存在，请重新选择");
	}
});

/**
 * [获取订单信息]
 */
function loadOrderInfo() {
	var params = {
		"projectOrderCriteria.requirePage" : "false",
		"projectOrderCriteria.dstatus" : "normal",
		"projectOrderCriteria.id" : page_orderId,
		"projectOrderCriteria.needProjectInfo" : "y",
		"projectOrderCriteria.needSubProjectInfo" : "y",
		"projectOrderCriteria.needPassport" : "y",
		"projectOrderCriteria.needProjectHolder" : "y",
		"projectOrderCriteria.needCosts" : "y",
		"projectOrderCriteria.needInterviewer" : "y",
	};
	$.ajax({
		url : G_basePath + "/project/getProjectOrderListWithPage.action",
		type : "POST",
		data : params,
		dataType : "JSON",
		success : function(result) {
			if (1 == result.total) {
				/* 开始填写需要的信息 */
				// console.log(result.rows[0]);
				var object = result.rows[0];
				page_oderInfo = object;
				if (object) {
					$("#v_project_info_name").html(object.projectInfo.name);
					$("#v_sub_project_time").html(
							object.subProjectInfo.startDateStr + " - "
									+ object.subProjectInfo.endDateStr);
					$("#v_holder_name").html(object.projectHolder.name);
					if (object.costs) {
						var costList = object.costs;
						page_project_costs = object.costs;
						var costHtml = "";
						for (var i = 0; i < costList.length; i++) {
							costHtml += costList[i].targetTypeStr + ":"
									+ costList[i].cost
									+ costList[i].currencyStr;
							costHtml += "&nbsp;&nbsp;";
						}
						$("#v_costs").html(costHtml);
					}
					changeOrderStatusImage(object.status);
					loadOrderProcessLogs(1, 10);
				}
			} else {
				$.messager.alert("操作提示", "当前订单号不可用，请重新选择");
			}
		}
	});
}

/**
 * [更改订单状态图片样式]
 */
function changeOrderStatusImage(status) {
	console.log(status);
	var current = "current";
	var underWay = "underway";
	var have_done_content = "<s class='s-cat-35'></s>";
	var under_way_content = "<s class='s-cat-36'></s>";
	$(".step-div").removeClass(current);
	$(".step-div").removeClass(underWay);
	if ("waitJudgement" == status) {
		$("#1_status_bg").addClass(underWay);
		$("#1_status_flag").html(under_way_content);
	} else if ("judgementError" == status) {
		$("#1_status_bg").addClass(underWay);
		$("#1_status_flag").html(under_way_content);
		$("#1_status_content").html("审核失败");
	} else if ("waitSignPay" == status) {
		$("#1_status_bg").addClass(current);
		$("#1_status_flag").html(have_done_content);
		$("#2_status_bg").addClass(underWay);
		$("#2_status_flag").html(under_way_content);
	} else if ("waitInterview" == status) {
		$("#1_status_bg").addClass(current);
		$("#1_status_flag").html(have_done_content);
		$("#2_status_bg").addClass(current);
		$("#2_status_flag").html(have_done_content);
		$("#3_status_bg").addClass(underWay);
		$("#3_status_flag").html(under_way_content);
	} else if ("interViewSigned" == status) {
		$("#1_status_bg").addClass(current);
		$("#1_status_flag").html(have_done_content);
		$("#2_status_bg").addClass(current);
		$("#2_status_flag").html(have_done_content);
		$("#3_status_bg").addClass(current);
		$("#3_status_flag").html(have_done_content);
		$("#4_status_bg").addClass(underWay);
		$("#4_status_flag").html(under_way_content);
	} else if ("interViewFailed" == status) {
		$("#1_status_bg").addClass(current);
		$("#1_status_flag").html(have_done_content);
		$("#2_status_bg").addClass(current);
		$("#2_status_flag").html(have_done_content);
		$("#3_status_bg").addClass(current);
		$("#3_status_flag").html(have_done_content);
		$("#4_status_bg").addClass(underWay);
		$("#4_status_flag").html(under_way_content);
		$("#4_status_content").html("面试未通过");
	} else if ("waitProjectPay" == status) {
		$("#1_status_bg").addClass(current);
		$("#1_status_flag").html(have_done_content);
		$("#2_status_bg").addClass(current);
		$("#2_status_flag").html(have_done_content);
		$("#3_status_bg").addClass(current);
		$("#3_status_flag").html(have_done_content);
		$("#4_status_bg").addClass(current);
		$("#4_status_flag").html(have_done_content);
		$("#5_status_bg").addClass(underWay);
		$("#5_status_flag").html(under_way_content);
	} else if ("finish" == status) {
		$("#1_status_bg").addClass(current);
		$("#1_status_flag").html(have_done_content);
		$("#2_status_bg").addClass(current);
		$("#2_status_flag").html(have_done_content);
		$("#3_status_bg").addClass(current);
		$("#3_status_flag").html(have_done_content);
		$("#4_status_bg").addClass(current);
		$("#4_status_flag").html(have_done_content);
		$("#5_status_bg").addClass(current);
		$("#5_status_flag").html(have_done_content);
		$("#6_status_bg").addClass(underWay);
		$("#6_status_flag").html(under_way_content);
	} else if ("droped" == status) {
		$("#1_status_bg").addClass(underWay);
		$("#1_status_flag").html(under_way_content);
		$("#1_status_content").html("已作废");
	} else {
	}
}

/**
 * [获取订单处理日志]
 */
function loadOrderProcessLogs(page, rows) {
	if (page_orderId) {
		var params = {
			"businessProcessLogCriteria.requirePage" : "true",
			"businessProcessLogCriteria.dstatus" : "normal",
			"businessProcessLogCriteria.targetId" : page_orderId,
			"businessProcessLogCriteria.targetType" : "projectOrder",
			"rows" : rows,
			"page" : page,
		};
		$.ajax({
			url : G_basePath
					+ "/share/getBusinessProcessLogListWithPage.action",
			type : "POST",
			data : params,
			dataType : "JSON",
			success : function(result) {
				// console.log(result);
				if (result.rows) {
					// 将列表写入页面
					putProjectOrderProcessLogToPage(result.rows,
							"project_order_process_log_grid");
					// 生成分頁信息
					$('#project_order_process_log_pager').pagination({
						pageList : [ 10, 20 ],
						total : result.total,
						pageSize : params.rows,
						pageNumber : params.page,
						onSelectPage : function(pageNumber, pageSize) {
							loadOrderProcessLogs(pageNumber, pageSize);
						}
					});
				}
			}
		});
	}
}

/**
 * [将处理日志写入页面]
 * 
 * @param list
 */
function putProjectOrderProcessLogToPage(list, elementId) {
	var html = "<tr><td width='15%;' class='b-blue'>操作</i></td><td width='25%;'  class='b-blue'>当前状态</td><td  class='b-blue'>操作时间</td></tr>";
	var element = $("#" + elementId).html(html);
	if (list && 0 < list.length) {
		for (var i = 0; i < list.length; i++) {
			var object = list[i];
			html += "<tr>";
			if ("judgementError" == object.nextStatus && 0 == i) {
				html += "<td><a href='javascript:returnToWaitJudgement("
						+ object.targetId + ");'>完善与重审</a></td>";
			} else if ("waitSignPay" == object.nextStatus && 0 == i) {
				html += "<td><a href='javascript:payEntryFree("
						+ object.targetId + ");'>支付报名费</a></td>";
			} else if ("interViewSigned" == object.nextStatus && 0 == i) {
				html += "<td><a href='javascript:showInterViewInfo("
						+ JSON.stringify(object) + ");'>查看面试信息</a></td>";
			} else if ("waitProjectPay" == object.nextStatus && 0 == i) {
				html += "<td><a href='javascript:payProjectFree("
						+ object.targetId + ");'>全款支付</a></td>";
			} else {
				html += "<td><s class='s-cat-39'></s></i></td>";
			}
			html += "<td>" + object.nextStatusStr + "</td>";
			html += "<td>" + object.createTimeStr + "</td>";
			html += "</tr>";
		}
	}
	element.html(html);
}

/**
 * [展示面试信息]
 * 
 * @param object
 */
function showInterViewInfo() {
	if (page_oderInfo) {
		$('#interview_info_dialog').show();
		$('#interview_info_dialog').window({
			width : 900,
			height : 150,
		});
		if (0 != page_oderInfo.interviewerId) {
			$("#v_interviewer_startTime").html(
					page_oderInfo.interviewStartTimeStr);
			$("#v_interviewer_endTime").html(page_oderInfo.interviewEndTimeStr);
		} else {
		}
		if (page_oderInfo.interviewer) {
			$("#v_interviewer_trueName").html(
					page_oderInfo.interviewer.trueName);
		}
	} else {

	}
}

/**
 * [展示面试结果信息]
 * 
 * @param object
 */
function showInterViewResultInfo() {
	if (page_oderInfo) {
		$('#interview_result_info_dialog').show();
		$('#interview_result_info_dialog').window({
			width : 800,
			height : 220,
		});
		$("#v_interview_result_flag").html(page_oderInfo.interviewFlagStr);
		$("#v_interview_result").html(page_oderInfo.interviewResult);
	} else {

	}
}

/**
 * [支付报名费]
 */
function payEntryFree(orderId) {
	if (orderId && G_passportId) {
		// TODO 计算出报名费
		var entryfee = 0;
		if (page_project_costs && 0 < page_project_costs.length) {
			for (var i = 0; i < page_project_costs.length; i++) {
				if ("entryfee" == page_project_costs[i].type) {
					entryfee += page_project_costs[i].cost;
					continue;
				}
			}
			$.messager.defaults = {
				ok : "确定",
				cancel : "取消"
			};
			$.messager
					.confirm(
							"操作提示",
							"您确认支付报名费吗？报名费价格:" + entryfee + "人民币",
							function(flag) {
								if (flag) {
									var params = {
										"orderId" : orderId,
										"passportId" : G_passportId,
									};
									$
											.ajax({
												url : G_basePath
														+ "/project/payProjectOrderEntryFree.action",
												type : "POST",
												data : params,
												dataType : "JSON",
												success : function(result) {
													console.log(result);
													if (result) {
														if ("SUCCESS" == result.invokeState) {
															$.messager.alert(
																	"操作提示",
																	"支付成功");
															loadOrderInfo()
														} else {
															$.messager
																	.alert(
																			"操作提示",
																			result.result);
														}
													} else {

													}
												}
											});
								}
							});
		} else {
			$.messager.alert("操作提示", "本项目报名费等待管理员定义");
		}
	}
}

/**
 * [显示订单费用]
 */
function showCosts(isNeedAirTicket, airTicketInfo, costsElementId,
		totalElementId) {
	var costHtml = "";
	var totalCost = 0;
	$("#" + costsElementId).html(costHtml);
	$("#" + totalElementId).html(totalCost + "人民币");
	if (isNeedAirTicket && airTicketInfo) {// 如果需要机票
		costHtml += "机票费用:" + airTicketInfo.price + airTicketInfo.currencyStr
				+ "&nbsp;&nbsp;";
		totalCost += airTicketInfo.price;
	}
	if ("stepable" == page_oderInfo.payType) { // 按流程支付报名费
		for (var i = 0; i < page_project_costs.length; i++) {
			if ("entryfee" != page_project_costs[i].type) {
				costHtml += page_project_costs[i].targetTypeStr + ":"
						+ page_project_costs[i].cost
						+ page_project_costs[i].currencyStr;
				costHtml += "&nbsp;&nbsp;";
				totalCost += page_project_costs[i].cost;
			}
		}
	} else { // 和项目金额一起支付
		for (var i = 0; i < page_project_costs.length; i++) {
			costHtml += page_project_costs[i].targetTypeStr + ":"
					+ page_project_costs[i].cost
					+ page_project_costs[i].currencyStr;
			costHtml += "&nbsp;&nbsp;";
			totalCost += page_project_costs[i].cost;
		}
	}
	$("#" + costsElementId).html(costHtml);
	$("#" + totalElementId).html(totalCost + "人民币");
}

/**
 * [支付项目费用]
 * 
 * @param orderId
 */
function payProjectFree(orderId) {
	if (orderId && G_passportId) {
		$('#project_all_fee_pay_dialog').show();
		$('#project_all_fee_pay_dialog').window({
			width : 800,
			height : 400,
		});
		// 重置机票选择
		$("#v_p_a_f_ticketId").val(0);
		$("#v_p_a_f_air_ticket_info").html("");
		// 显示资费信息
		showCosts(false, null, "v_p_a_f_costs", "v_p_a_f_all_costs");
		// 给机票选择框配置事件
		$("#v_p_a_f_need_air_ticket").combobox(
				{
					onSelect : function(rec) {
						// 重置机票选择
						$("#v_p_a_f_ticketId").val(0);
						$("#v_p_a_f_air_ticket_info").html("");
						if ("y" == rec.value) {
							$('#air_ticket_pick_dialog').show();
							$('#air_ticket_pick_dialog').window({
								width : 800,
								height : 400,
							});
							loadAirTicketGrid();
						} else {
							// 显示资费信息
							showCosts(false, null, "v_p_a_f_costs",
									"v_p_a_f_all_costs");
						}
					}
				});
		$("#v_p_a_f_need_air_ticket").combobox("setValue", "n");
	}
}

/**
 * [支付全部订单费用]
 */
function doAjaxPayAllOrderFee(orderId) {
	$.messager.defaults = {
		ok : "确定",
		cancel : "取消"
	};
	$.messager.confirm("操作提示", "您确认支付全部项目费用吗？", function(flag) {
		if (flag) {
			var params = {
				"orderId" : orderId,
				"ticketId" : $("#v_p_a_f_ticketId").val(),
			};
			console.log(params);
			$.ajax({
				url : G_basePath + "/project/payProjectOrderAllFree.action",
				type : "POST",
				data : params,
				dataType : "JSON",
				success : function(result) {
					console.log(result);
					if (result) {
						if ("SUCCESS" == result.invokeState) {
							$.messager.alert("操作提示", "支付成功");
							$("#project_all_fee_pay_dialog").dialog("close");
							loadOrderInfo()
						} else {
							$.messager.alert("操作提示", result.result);
						}
					} else {
					}
				}
			});
		}
	});
}

/**
 * [获取机票列表]
 */
function loadAirTicketGrid() {
	var params = {
		"transportTicketCriteria.dstatus" : "normal",
		"transportTicketCriteria.type" : "air",
		"transportTicketCriteria.requirePage" : true,
	};
	$('#air_ticket_pick_grid')
			.datagrid(
					{
						height : 340,
						pagination : true,
						url : G_basePath
								+ "/share/getTransportTicketListWithPage.action",
						queryParams : params,
						singleSelect : true,
						onSelect : function(rowIndex, rowData) {
						},
						columns : [ [
								{
									field : 'id',
									title : '操作',
									width : 100,
									align : "center",
									formatter : function(val, rec) {
										return "<a href='javascript:void(0);' onclick='javascript:pickTransportTicket("
												+ JSON.stringify(rec)
												+ ");'>选择</a>";
									}
								}, {
									field : 'startCity',
									title : '出发城市',
									width : 120,
									align : "center",
								}, {
									field : 'startStation',
									title : '出发机场',
									width : 120,
									align : "center",
								}, {
									field : 'endCity',
									title : '到达城市',
									width : 120,
									align : "center",
								}, {
									field : 'startStation',
									title : '到达机场',
									width : 120,
									align : "center",
								}, {
									field : 'price',
									title : '价格',
									width : 120,
									align : "center",
								}, {
									field : 'currencyStr',
									title : '币种',
									width : 120,
									align : "center",
								}, {
									field : 'updateTimeStr',
									title : '更新时间',
									width : 150,
									align : "center",
								} ] ]
					});
	var pager = $('#air_ticket_pick_grid').datagrid('getPager');
	$(pager).pagination({
		pageSize : 10,// 每页显示的记录条数，默认为10
		pageList : [ 10, 30 ],// 每页显示几条记录
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录    共 {total} 条记录',
	});
}

/**
 * [选择机票]
 * 
 * @param id
 */
function pickTransportTicket(ticket) {
	if (ticket && 0 != ticket.id) {
		$("#v_p_a_f_ticketId").val(ticket.id);
		$("#v_p_a_f_air_ticket_info").html(
				ticket.startCity + "-" + ticket.endCity + "&nbsp;&nbsp;费用:"
						+ ticket.price + ticket.currencyStr);
		// 显示资费信息
		showCosts(true, ticket, "v_p_a_f_costs", "v_p_a_f_all_costs");
		$("#air_ticket_pick_dialog").dialog("close");
	} else {
		$.messager.alert("操作提示", "选择的机票数据有误，尝试刷新重试");
	}
}

/**
 * [返回到等待审核状态]
 */
function returnToWaitJudgement(orderId) {
	$.messager.defaults = {
		ok : "修改我的信息",
		cancel : "再次提交审核"
	};
	$.messager
			.confirm(
					"操作提示",
					"您需要做什么？",
					function(data) {
						if (data) {
							window.location.href = G_basePath
									+ "/router/toStudentInfo.action";
						} else {
							$.messager.defaults = {
								ok : "是",
								cancel : "否"
							};
							$.messager
									.confirm(
											"操作提示",
											"您的信息是否修改好了，确定再次提交申请吗？",
											function(flag) {
												if (flag) {
													$
															.ajax({
																url : G_basePath
																		+ "/project/returnProjectOrderStatusToWaitJudgement.action",
																type : "POST",
																data : {
																	"orderId" : orderId
																},
																dataType : "JSON",
																success : function(
																		result) {
																	// console
																	// .log(result);
																	if (result) {
																		if ("SUCCESS" == result.invokeState) {
																			$.messager
																					.alert(
																							"系统提示",
																							"操作成功");
																			// 重新获取信息
																			loadOrderInfo();
																		} else {
																			$.messager
																					.alert(
																							"系统提示",
																							result.result);
																		}
																	}
																}
															});
												} else {

												}
											});
						}
					});
}

/**
 * [作废订单]
 * 
 * @param orderId
 */
function doAjaxGiveupOrder() {

}