<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我要提现</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/withdraw.js"></script>
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
										<b class="b-red"><s class="s-cat-21"></s>我要提现</b>&nbsp;&nbsp;&nbsp;<span class="font-12">Recharge How Much</span>
									</h5>
								</li>
							</ul>
							<ul style="float: right; margin-right: 20px;">
								<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
								<li><a href="<%=path%>/router/exist.action"><s class="s-cat-10 current"></s><i class="s-cat-11">Log out</i></a></li>
							</ul>
						</div>
					</div>
					<!-- 页面内容部分 -->
					<div class="right-content-main">
					
                    	<div class="clear" style="height:20px;"></div>
                    	<form id="withdraw_form" action="#" method="post">
                    		<input name="financeAccountDetail.accountId" type="hidden" value="${accountId }" />
                    		<input name="financeAccountDetail.type" type="hidden" value="withdraw" />
                    		<input name="financeAccountDetail.status" type="hidden" value="waitJudgement" />
                    		<input name="financeAccountDetail.currency" type="hidden" value="rmb" />
                    		<input name="financeAccountDetail.requireJudgement" type="hidden" value="y" />
							<div class="recharge-step">
		                    	<h5>账户充值</h5>
		                        <div class="recharge-input">
		                        	<label>转入金额：&nbsp;&nbsp;</label><input name="financeAccountDetail.price" type="text" class="input-175 easyui-numberbox" min="1" max="100000" precision="0" required="true" /> <label>&nbsp;元</label>
		                        </div>
		                        <div class="recharge-submit float_l">
		                        	<div class="clear" style="height:16px;"></div>
		                        	<a href="javascript:void(0);" onclick="javascript:doAjaxWithdraw();" class="x-small a-red">提交审核</a>
		                        	<a href="<%=path %>/router/toMyFinance.action" class="x-small a-red" style="float:right;">返回我的账户</a>
		                        </div>
		                    </div>
	                    </form>
	                   <div class="recharge-warm">
	                   		<div class="recharge-text">
	                        	<p class="b-red">温馨提示</p>
	                        	<br />
	                        	<h4><span>Question:什么能到账?</span><br />
	                        		<span>答：用户提交充值凭证后的三个工作日内，充值平台的预存金在退出充值平台后会解冻，成功退出后三个工作日内，预存金款项自然解冻。届时请到您的账户中查询确认。充值平台的预存金不支持部分解冻。</span><br />
	                        		<span>Question:什么能到账?</span>
								<br />
									<span>答：用户提交充值凭证后的三个工作日内，充值平台的预存金在退出充值平台后会解冻，成功退出后三个工作日内，预存金款项自然解冻。届时请到您的账户中查询确认。充值平台的预存金不支持部分解冻。</span></h4>
	                        </div>
	                   </div>
	                   <div class="clear" style="height:50px;"></div>
					
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- 隐藏域 -->
	<input id="page_accountId" type="hidden" value="${accountId }" />
</body>
</html>