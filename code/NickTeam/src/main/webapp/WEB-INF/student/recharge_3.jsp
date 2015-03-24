<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>充值－完成充值</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/recharge_3.js"></script>
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
										<b class="b-red"><s class="s-cat-21"></s>充值－完成充值</b>&nbsp;&nbsp;&nbsp;<span class="font-12">Recharge Finish</span>
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
					
						<div class="recharge-step">
							<h5>账户充值</h5>
	                        <div class="recharge-input">
	                        	<div class="recharge-auto"><s class="s-cat-43"></s><h5 class="b-green">充值完成，等待审核！</h5></div>
	                        </div>
	                        <div class="recharge-submit">
	                        	<div class="recharge-submit">
		                        	<div class="clear" style="height:16px;"></div>
		                        	<a href="<%=path %>/router/toMyFinance.action" class="x-small a-red" style="float:right;">返回我的账户</a>
		                        </div>
	                        </div>
                        </div>
                        
						<div class="recharge-step">
	                        <!-- 图片显示区域 -->
	                        <div id="recharge_detail_images"></div>
	                   		<div class="clear"></div>
                        </div>
                        
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
</body>
</html>