<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<div class="left-nav">
	<div class="top-nav">
		<div class="top-nav-content">
			<c:if test="${'male'== sessionScope.PASSPORT_INFO.sex}">
       			<a href="<%=path%>/router/toStudentInfo.action"><img src="<%=path%>/resource/local/images/user-1.png" width="60" height="60" border="0" /></a>
   			</c:if>
   			<c:if test="${'femail'== sessionScope.PASSPORT_INFO.sex}">
       			<a href="<%=path%>/router/toStudentInfo.action"><img src="<%=path%>/resource/local/images/user-2.png" width="60" height="60" border="0" /></a>
   			</c:if>
			<div class="user-info">
				<span>Welcome!</span><br />
				<span>${sessionScope.PASSPORT_INFO.trueName}</span>
			</div>
		</div>
	</div>
	<ul>
		<li><a href="<%=path%>/router/toStudentIndex.action"><s class="s-cat-01 "></s>我的无涯</a></li>
		<li><a href="<%=path%>/router/toProjectApply.action"><s class="s-cat-03 "></s>项目申请</a></li>
		<li><a href="<%=path%>/router/toMyProjectOrder.action"><s class="s-cat-02 "></s>我的申请</a></li>
		<li><a href="<%=path%>/router/toMyFinance.action"><s class="s-cat-04 "></s>财富账户</a></li>
		<li><a href="<%=path%>/router/toStudentInfo.action"><s class="s-cat-05 "></s>基础资料</a></li>
	</ul>
</div>