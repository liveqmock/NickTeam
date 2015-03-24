<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的主页</title>
<jsp:include page="../include/common_header.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/resource/local/js/student/index.js"></script>
</head>
<body>
	<div id="index-bg">
    	<div class="content">
        	<div class="logo"></div>
            <div class="center">
                <jsp:include page="../include/student/left_menu.jsp"></jsp:include>
                <div class="right-content">
                    <div class="right-content-top">
					<div class="icon-info">
						<ul>
							<li><a href="<%=path%>/router/toStudentInfo.action"><s class="s-cat-06"></s></a></li>
							<li><a href="#"><s class="s-cat-07"></s></a></li>
							<li><a href="#"><s class="s-cat-08"></s></a></li>
						</ul>
						<ul style="float: right; margin-right: 20px;">
							<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
							<li><a href="<%=path%>/router/exist.action"><s class="s-cat-10 current"></s><i class="s-cat-11">Log out</i></a></li>
						</ul>
					</div>
                    <div class="right-content-message">
                    	<div class="user-advices">
                    		<c:if test="${'male'== sessionScope.PASSPORT_INFO.sex}">
                       			<a href="<%=path%>/router/toStudentInfo.action"><img src="<%=path%>/resource/local/images/user-1.jpg" border="0" /></a>
                   			</c:if>
                   			<c:if test="${'femail'== sessionScope.PASSPORT_INFO.sex}">
                       			<a href="<%=path%>/router/toStudentInfo.action"><img src="<%=path%>/resource/local/images/user-2.png" border="0" /></a>
                   			</c:if>
                            <div class="user-info-large">
                            	<span>
                            		<h1>${sessionScope.PASSPORT_INFO.trueName}</h1>
                            		<s id="star_num"></s>
                                </span><br />
                                <span>学生&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">${sessionScope.PASSPORT_INFO.highSchoolName }</a></span><br />
                                <span><s class="s-cat-14"></s><h4 class="project_in_apply_num">已申请项目05项</h4></span>
                            </div>
                        </div>
                        <div class="user-residue">
                        	<h3>可用余额</h3><h2><b id="v_canUseMoney" class="b-red">￥0.00</b></h2>
                        </div>
                        <div class="user-residue" style="margin-left: 20px;">
                        	<h3>冻结金额</h3><h2><b id="v_frozenMoney" class="b-blue">￥0.00</b></h2>
                        </div>
                    </div>
                    <div class="right-content-center">
                    	<div class="apply">
                        	<h5><b class="b-red">我的申请项目</b>&nbsp;&nbsp;&nbsp;<span>My application</span></h5>
                            <div class="apply-content">
                            	<a id="quick_nav_img" href="#"><img src="<%=path%>/resource/local/images/img-2.jpg" border="0"/></a>
                            </div>
                            <div class="apply-center">
                            	<h1 class="b-blue project_in_apply_num"></h1>
                                <h4 class="b-blue"><a href="<%=path%>/router/toProjectApply.action">立即申请项目，迅速积累经验，为自己加油</a></h4>
                            </div>
                            <div class="apply-details">
                            	<ul>
                                	<li><a href="<%=path%>/router/toProjectApply.action" target="_blank"><s class="s-cat-16"></s>我要申请</a></li>
                                    <li style="border-right:none;"><a href="<%=path%>/router/toMyProjectOrder.action" target="_blank"><s class="s-cat-17"></s>我的申请</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="news-info">
                        	<h5>新闻动态&nbsp;&nbsp;<span class="b-blue" style="font-size: 13px;">News information</span></h5>
                            <ul>
                            	<li>
                                	<div class="news-img"><a href="#" target="_blank"><img src="<%=path%>/resource/local/images/new-1.jpg"  border="0"/></a></div>
                                    <div class="news-text">
                                    	<h3>2015全球未来领袖培养计划</h3>
                                        <a href="#" target="_blank">在社会发展瞬息万变与全球一体化趋势下，世界将对未来领袖提出
更为多元，更为严格的要求， “2015全球未来领袖培养计划”.......</a>
										<h4>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            &nbsp;&nbsp;五星好评
                                        </h4>
                                    </div>
                                    <div class="news-more"><a href="#" target="_blank">MORE ></a></div>
                                </li>
                                <li>
                                	<div class="news-img"><a href="#" target="_blank"><img src="<%=path%>/resource/local/images/new-2.jpg"  border="0"/></a></div>
                                    <div class="news-text">
                                    	<h3>2015全球未来领袖培养计划</h3>
                                        <a href="#" target="_blank">在社会发展瞬息万变与全球一体化趋势下，世界将对未来领袖提出
更为多元，更为严格的要求， “2015全球未来领袖培养计划”.......</a>
										<h4>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-19"></s>
                                            &nbsp;&nbsp;五星好评
                                        </h4>
                                    </div>
                                    <div class="news-more"><a href="#" target="_blank">MORE ></a></div>
                                </li>
                                <li>
                                	<div class="news-img"><a href="#" target="_blank"><img src="<%=path%>/resource/local/images/new-3.jpg"  border="0"/></a></div>
                                    <div class="news-text">
                                    	<h3>2015全球未来领袖培养计划</h3>
                                        <a href="#" target="_blank">在社会发展瞬息万变与全球一体化趋势下，世界将对未来领袖提出
更为多元，更为严格的要求， “2015全球未来领袖培养计划”.......</a>
										<h4>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-19"></s>
                                            &nbsp;&nbsp;五星好评
                                        </h4>
                                    </div>
                                    <div class="news-more"><a href="#" target="_blank">MORE ></a></div>
                                </li>
                                <li>
                                	<div class="news-img"><a href="#" target="_blank"><img src="<%=path%>/resource/local/images/new-4.jpg"  border="0"/></a></div>
                                    <div class="news-text">
                                    	<h3>2015全球未来领袖培养计划</h3>
                                        <a href="#" target="_blank">在社会发展瞬息万变与全球一体化趋势下，世界将对未来领袖提出
更为多元，更为严格的要求， “2015全球未来领袖培养计划”.......</a>
										<h4>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-18"></s>
                                            <s class="s-cat-19"></s>
                                            &nbsp;&nbsp;五星好评
                                        </h4>
                                    </div>
                                    <div class="news-more"><a href="#" target="_blank">MORE ></a></div>
                                </li>
                            </ul>
                            <div class="news-more-content"><a href="#" target="_blank">查看更多>></a></div>
                        </div>
                    </div>
                    <div class="clear" style="height:20px;"></div>
                    <div class="map-content">
                    	<div class="map-left">
                        	<h5>最新项目&nbsp;&nbsp;&nbsp;<b class="b-gray">Popular items</b></h5>
                            <div class="item"><s class="s-cat-20"></s><span class="b-red">3</span>个最新项目<p><b>最新</b>培训资源</p></div>
                            <div class="line" style="margin-left: 15px;"></div>
                            <div class="item-sub">
                            	<ul id="projectList">
                                </ul>
                            </div>
                        </div>
                        <div class="map-right">
                        	<li><img src="<%=path%>/resource/local/images/map-02.jpg"  border="0"/></li>
                        </div>
                    </div>
                    <div class="clear" style="height:40px;"></div>
                </div>
            </div>	
        </div>
    </div>
</body>