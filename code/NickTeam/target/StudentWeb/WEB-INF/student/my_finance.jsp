<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的财富账户</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/my_finance.js"></script>
</head>
<body>
	<div id="index-bg">
		<div class="content">
			<div class="logo"></div>
			<div class="center apply-pages">
				<jsp:include page="../include/student/left_menu.jsp"></jsp:include>
				<div class="right-content">
					<!-- 右侧头部内容部分 -->
					<div class="right-content-top">
						<div class="icon-info">
							<ul>
								<li class="pages-apply">
									<h5>
										<b class="b-red"><s class="s-cat-21"></s>财富账户</b>&nbsp;&nbsp;&nbsp;<span class="font-12">Project Order</span>
									</h5>
								</li>
							</ul>
							<ul style="float: right; margin-right: 20px;">
								<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
								<li><a href="<%=path%>/router/exist.action"><s class="s-cat-10 current"></s><i class="s-cat-11">Log out</i></a></li>
							</ul>
						</div>
					</div>
					<div class="right-content-message">
                    	<div class="user-advices">
                        	<a href="#" target="_blank"><img src="<%=path%>/resource/local/images/user-1.jpg" border="0" /></a>
                            <div class="user-info-large">
                            	<span><h1>${sessionScope.PASSPORT_INFO.trueName}</h1>
                                	<s class="s-cat-12"></s>
                                    <s class="s-cat-12"></s>
                                    <s class="s-cat-12"></s>
                                    <s class="s-cat-12"></s>
                                    <s class="s-cat-13"></s>
                                </span><br />
                                <span>学生&nbsp;&nbsp;&nbsp;&nbsp;</span><br />
                                <span><s class="s-cat-14"></s><h4>已申请项目05项</h4></span>
                            </div>
                        </div>
                        <div class="user-residue">
                        	<h3>可用余额</h3><h2><b id="v_canUseMoney" class="b-red">￥0.00</b></h2>
                        </div>
                        <div class="user-residue" style="margin-left: 20px;">
                        	<h3>冻结金额</h3><h2><b id="v_frozenMoney" class="b-blue">￥0.00</b></h2>
                        </div>
                         <div class="recharge-btn">
                         	<a href="javascript:void(0);" onclick="javascript:toRechargeStep1();" class="x-small a-red">充值</a>
                         	<!-- <a href="#" class="x-small a-blue">取现</a> -->
                         </div>
                    </div>
					<!-- 页面内容部分 -->
					<div class="right-content-main">
					
                        <div class="clear" style="height:30px;"></div>
						<div class="recharge-list" style="min-height: 500px;">
	                    	<div class="recharge-title"><h5 class="b-blue">账户动态</h5></div>
	                        <div class="recharge-record">最新账户记录&nbsp;&nbsp;&nbsp;&nbsp;
	                        	<!-- <a href="#" target="_blank">&nbsp;充值记录&nbsp; |&nbsp;</a>
	                            <a href="#" target="_blank">&nbsp;提现记录&nbsp; |&nbsp;</a> -->
	                        </div>
	                        <table class="recharge-table" width="1070" cellpadding="0" cellspacing="0" id="account_detail_list"></table>
	                        <div class="clear" style="height:10px;"></div>
	                    </div>
	                    <div class="recharge-list">
	                        <div id="account_detail_list_pager" style="width: 100%;"></div>
	                        <div class="clear" style="height:30px;"></div>
	                    </div>
	                    
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- 隐藏域 -->
	<input id="page_accountId" type="hidden" value="" />
</body>
</html>