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
							<li><a href="tencent://message/?uin=2738270480&Site=&Menu=yes"><s class="s-cat-07"></s></a></li>
							<!-- <li><a href="#"><s class="s-cat-08"></s></a></li> -->
						</ul>
						<ul style="float: right; margin-right: 20px;">
							<!-- <li><a href="#" target="_blank"><s class="s-cat-09"></s></a></li> -->
							<li><a href="<%=path%>/router/exist.action"><s class="s-cat-10 current"></s><i class="s-cat-11">Log out</i></a></li>
						</ul>
					</div>
                    <div class="right-content-message">
                    	<div class="user-advices">
                    		<c:if test="${'male'== sessionScope.PASSPORT_INFO.sex}">
                       			<a href="<%=path%>/router/toStudentInfo.action"><img src="<%=path%>/resource/local/images/user-1.png" border="0" /></a>
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
                            	<a id="quick_nav_a" href="#"><img id="quick_nav_img" src="<%=path%>/resource/local/images/img-2.jpg" border="0"/></a>
                            </div>
                            <div class="apply-center t_center">
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
                            <div id="colee" style="overflow:hidden;height:436px;width:580px;">
                                <div id="colee1">
                                    <ul>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=55" target="_blank"><img src="<%=path%>/resource/local/images/new-1.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>无涯校方合作证书 </h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=55" target="_blank">无涯公司正式与上海光华学院剑桥国际中心、贵阳市第一中学、上海博华学院、太原四十八中签订合作证书。 </a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=55" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=47" target="_blank"><img src="<%=path%>/resource/local/images/new-2.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>无涯2015寒假香港BLP项目---教师寄语</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=47" target="_blank">2015年寒假，无涯公司一共邀请了20所全国重点高中的35位老师到香港考察项目，能够获得学生和老师的认可是我们最大的荣幸！</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=47" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=45" target="_blank"><img src="<%=path%>/resource/local/images/new-3.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>2014年全国20省，102所学校，超千名学员报名无涯香港实习项目</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=45" target="_blank">2014年全国20省，102所学校，超千名学员报名无涯香港实习项目</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=45" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=54" target="_blank"><img src="<%=path%>/resource/local/images/new-4.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>上海光明中学官方报道无涯香港BLP项目</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=54" target="_blank">继2014年暑假，上海光明中学又有数名同学参加了2015年寒假香港BLP项目，校方官方报道了此次香港BLP活动。</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=54" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=50" target="_blank"><img src="<%=path%>/resource/local/images/new-5.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>贵阳一中学生参加无涯2015寒假新加坡项目官方报道</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=50" target="_blank">2015年2月8日，贵阳一中数名同学在寒假中踏上了由无涯公司举办的新加坡互联网体验项目的旅程。七天时间虽短，丰富的内容却足以让同学们在自己年轻的简历上，增添绚烂的一笔。</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=50" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=49" target="_blank"><img src="<%=path%>/resource/local/images/new-6.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>上海交通大学Alevel国际课程中心官方报道无涯BLP项目</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=49" target="_blank">2015年2月7日至13日，上海交通大学Alevel国际课程3名学生赴港金融中心进行了为期7天的学习和实习，同学们在世界500强的舞台上更充分地实现自我，突破自我，放下课本，走向世界，在世界的舞台上尽显交大国际生的本色。</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=49" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=42" target="_blank"><img src="<%=path%>/resource/local/images/new-7.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>广州二中国际部对BLP项目进行官网报道</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=42" target="_blank">广州二中国际部高三（1）班李翰程同学参加无涯中学生香港实习项目获官网报道。</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=42" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=41" target="_blank"><img src="<%=path%>/resource/local/images/new-8.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>无涯教育携手汇丰银行举办“未来营销家”公益活动</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=41" target="_blank">2014年12月14日上午9时，上海各大知名高中的同学们如期到达坐落于陆家嘴上海国金中心的汇丰银行大楼，开始为期一日的社会实习拓展活动。本次实习的主题是：如何成为未来营销家，面对的群体是未来有意向从事金融行业的同学。</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/news.asp" target="_blank">MORE ></a></div>
                                        </li>
                                        <li>
                                            <div class="news-img"><a href="http://www.goabroad101.com/newsshow.asp?id=41" target="_blank"><img src="<%=path%>/resource/local/images/new-9.jpg"  border="0"/></a></div>
                                            <div class="news-text">
                                                <h3>上海光华学院剑桥国际中心官方报道无涯香港BLP项目</h3>
                                                <a href="http://www.goabroad101.com/newsshow.asp?id=52" target="_blank">2015年寒假，上海光华学院剑桥国际中心数名同学参加了无涯香港BLP项目，校方官方报道了此次项目。今天无涯带给你们的不仅仅是个项目，更是一个平台，让你去初步接触商业，初步接触国际金融，接触到五百强企业。你们能得到的除了名副其实的五百强高层推荐信，更有一个团队共同奋斗，共同进步克服一个个困难的回忆。</a>
                                                <h4>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-18"></s>
                                                    <s class="s-cat-19"></s>
                                                    &nbsp;&nbsp;五星好评
                                                </h4>
                                            </div>
                                            <div class="news-more"><a href="http://www.goabroad101.com/newsshow.asp?id=52" target="_blank">MORE ></a></div>
                                        </li>
                                    </ul>
                                </div>
                            	<div id="colee2"></div>
                            </div>
                            <div class="news-more-content"><a href="http://www.goabroad101.com/news.asp" target="_blank">查看更多>></a></div>
                        </div>
                    </div>
                    <div class="clear" style="height:20px;"></div>
                    <div class="map-content">
                    	<div class="map-left">
                        	<h5>最新项目&nbsp;&nbsp;&nbsp;<b class="b-gray">Latest Program</b></h5>
                            <div class="item"><s class="s-cat-20"></s><span class="b-red">3</span>个最新项目<p><b>open to the world，open to the opportunity</b></p></div>
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