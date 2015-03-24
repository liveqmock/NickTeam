<%@page import="com.wuya.base.enumerate.YesOrNoEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>项目订单详细</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/my_project_order_detail.js"></script>
</head>
<body>
	<div id="index-bg">
		<div class="content">
			<div class="logo"></div>
			<div class="center apply-pages" style="background: #f6f6f6;">
				<jsp:include page="../include/student/left_menu.jsp"></jsp:include>
				<div class="right-content">
					<div class="right-content-top">
						<div class="icon-info">
							<ul>
								<li class="pages-apply">
									<h5>
										<b class="b-red"><s class="s-cat-21"></s>我的订单详细</b>&nbsp;&nbsp;&nbsp;<span
											class="font-12">Program Order Detail</span>
									</h5>
								</li>
							</ul>
							<ul style="float: right; margin-right: 20px;">
								<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
								<li><a href="<%=path%>/router/exist.action"><s
										class="s-cat-10 current"></s><i class="s-cat-11">Log out</i> </a></li>
							</ul>
						</div>
					</div>
					<!-- 页面内容部分 -->
					<div class="right-content-main">
						<div class="clear" style="height: 30px;"></div>
						<div class="apply-step">
							<!--申请项目步骤开始-->
							<div class="apply-step-title">
								<div id="1_status_bg" class="step-div">
	                                <div class="step-div-center">
	                                    <div class="step-div-auto"><i id="1_status_flag">1</i></div>
	                                    <span id="1_status_content" class="step-div-span">初步审核</span>
	                                </div>
	                                <span class="bar"></span>
	                            </div>
	                            <div id="2_status_bg" class="step-div">
	                                <div class="step-div-center">
	                                    <div class="step-div-auto"><i id="2_status_flag">2</i></div>
	                                    <span class="step-div-span">缴纳报名费</span>
	                                </div>
	                                <span class="bar"></span>
	                            </div>
	                            <div id="3_status_bg" class="step-div">
	                                <div class="step-div-center">
	                                    <div class="step-div-auto"><i id="3_status_flag">3</i></div>
	                                    <span class="step-div-span">待面试通知</span>
	                                </div>
	                                <span class="bar"></span>
	                            </div>
	                            <div id="4_status_bg" class="step-div">
	                                <div class="step-div-center">
	                                    <div class="step-div-auto"><i id="4_status_flag">4</i></div>
	                                    <span id="4_status_content" class="step-div-span">进行面试</span>
	                                </div>
	                                <span class="bar"></span>
	                            </div>
	                            <div id="5_status_bg" class="step-div">
	                                <div class="step-div-center">
	                                    <div class="step-div-auto"><i id="5_status_flag">5</i></div>
	                                    <span class="step-div-span">待缴项目费</span>
	                                </div>
	                                <span class="bar"></span>
	                            </div>
	                            <div id="6_status_bg" class="step-div">
	                                <div class="step-div-center">
	                                    <div class="step-div-auto"><i id="6_status_flag">6</i></div>
	                                    <span class="step-div-span">申请完成</span>
	                                </div>
	                                <span class="bar" style="display:none;"></span>
	                            </div>
							</div>
							<!--申请项目步骤结束-->
							<div class="clear" style="height: 50px;"></div>
							<div class="xq-center">
								<div class="xq-center-auto">
									<h5>
										<s class="s-cat-37"></s><span id="v_project_info_name"></span>
									</h5>
									<div class="xq_time">
											<span class="text_size_16">项目时间：</span>
											<span id="v_sub_project_time" class="text_size_16"></span>
											<span class="text_size_16">&nbsp;&nbsp;&nbsp;&nbsp;</span>
											<span class="text_size_16">实习公司：</span>
											<span id="v_holder_name" class="text_size_16"></span>
											</br>
											<span>相关费用:&nbsp;&nbsp;</span><span id="v_costs"></span>
									</div>
									<table id="project_order_process_log_grid" width="880" cellpadding="0" cellspacing="0" id=tab1></table>
								</div>
							</div>
							<div class="clear" style="height: 10px;"></div>
							<div id="project_order_process_log_pager" style="width: 100%;"></div>
						</div>
						<div class="clear" style="height: 50px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 弹出框区域 开始 -->
	<!-- 面试信息框 -->
	<div id="interview_info_dialog" style="display: none;" title="面试信息">
		<div class="after-title">
            <p class="b-blue">面试官基本信息：</p>
            <div class="title-message">
                <dl>
                    <dt>真实姓名：<span class="t_c_gray" id="v_interviewer_username"></span></dt>
                </dl>
                <dl>
                    <dt>面试开始时间：<span class="t_c_red" id="v_interviewer_startTime"></span></dt>
                    <dt>面试结束时间：<span class="t_c_red" id="v_interviewer_endTime"></span></dt>
                </dl>
            </div>
        </div>
	</div>
	
	<!-- 面试信息框 -->
	<div id="interview_result_dialog" style="display: none;" title="面试结果信息">
		<div class="after-title">
            <p class="b-blue">面试结果信息：</p>
            <div class="title-message">
                <dl>
                    <dt>面试结果：<span class="t_c_gray" id="v_interview_result_flag"></span></dt>
                </dl>
            </div>
            <div class="title-message">
                <dl>
                    <dt>面试官评价：<span class="t_c_gray" id="v_interview_result"></span></dt>
                </dl>
            </div>
        </div>
	</div>
	
	<!-- 面试结果信息框 -->
	<!-- 
	<div id="interview_result_info_dialog" style="display: none;" title="面试信息">
		<div class="after-title">
            <p class="b-blue">面试信息：</p>
            <div class="title-message">
                <dl>
                    <dt>面试结果：<span class="t_c_gray" id="v_interview_result_flag"></span></dt>
                </dl>
            </div>
            <div class="clear"></div>
            <div class="title-message">
                <dl>
                    <dt>面试官评价：<span class="t_c_gray" id="v_interview_result"></span></dt>
                </dl>
            </div>
        </div>
		<div class="clear" style="height:10px;"></div>
		<div class="t_center">
			<a onclick="javascript:doAjaxRequireReInterview(${orderId});" class="easyui-linkbutton">请求重新面试</a>
			<a onclick="javascript:doAjaxGiveupOrder(${orderId});" class="easyui-linkbutton mgl_20">放弃订单</a>
		</div>
	</div>
	 -->
	
	<!-- 项目费用付款信息框 -->
	<div id="project_all_fee_pay_dialog" style="display: none;" title="项目费用付款信息">
		<input id="v_p_a_f_ticketId" type="hidden" value="0">
		<div class="after-title">
            <p class="b-blue">项目付款信息：</p>
            <div class="">
                <dl>
                    <dt>费用信息：<span class="t_c_gray" id="v_p_a_f_costs"></span></dt>
                </dl>
            </div>
            <div class="clear" style="height: 20px;"></div>
            <div class="">
                <dl>
                    <dt><span>是否需要代购机票：</span>
                    	<select id="v_p_a_f_need_air_ticket" class="easyui-combobox">
                    		<%=YesOrNoEnum.getAsDropDownOption() %>
                    	</select>
                    </dt>
                </dl>
            </div>
            <div class="clear" style="height: 20px;"></div>
            <div class="">
                <dl>
                    <dt><span>机票信息：</span>
                    	<span id="v_p_a_f_air_ticket_info"></span>
                    </dt>
                </dl>
            </div>
            <div class="clear" style="height: 20px;"></div>
            <div class="">
                <dl>
                    <dt>费用总计：<span class="t_c_red" id="v_p_a_f_all_costs"></span></dt>
                </dl>
            </div>
        </div>
		<div class="clear" style="height:10px;"></div>
		<div class="t_center">
			<a onclick="javascript:doAjaxPayAllOrderFee(${orderId});" class="easyui-linkbutton">确认支付</a>
		</div>
	</div>
	
	<!-- 机票选择信息框 -->
	<div id="air_ticket_pick_dialog" style="display: none;" title="选择机票">
		<table id="air_ticket_pick_grid"></table>
	</div>
	
	<!-- 弹出框区域 结束 -->
	
	<!-- 隐藏域 -->
	<input id="page_orderId" type="hidden" value="${orderId}">
</body>
</html>