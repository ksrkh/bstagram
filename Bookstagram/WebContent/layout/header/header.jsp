<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="css/mystyle.css" rel="stylesheet">
<!-- 가장 상단부에 위치한 검색창과 로그인 버튼입니다. -->
<div class="top-bar">
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
		<div class="form-group" style="margin-top: 5px">
			<c:choose>
				<c:when test="${sessionScope.member == null }">
					<!-- 로그인 전 -->
					<button type="button" class="btn btn-default login_btn" style="float: right">Login</button>
				</c:when>
				<c:otherwise>
					<!-- 로그인 후 -->
					<div class="btn-group" style="float: right; margin-right: 10px">
						<a href="#" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-expanded="false">마이페이지</a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=myInfo">내 정보</a></li>
							<li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=viewMyBoard&b_name=1">내 한줄 관리</a></li>
							<li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=viewMyBoard&b_name=2">내 독후감 관리</a></li>
							<li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=viewMyBoard&b_name=3">내 창작글 관리</a></li>
							<li class="divider"></li>
							<li><a href="#" id="logout">로그아웃</a></li>
						</ul>
					</div>
					<c:if test="${sessionScope.member.tier == 3}">
						<!-- 관리자 일경우만 보여주는 페이지 -->
						<div class="btn-group" style="float: right; margin-right: 10px">
							<a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">관리자페이지</a>
							<ul class="dropdown-menu">
								<li><a href="DispatcherServlet?command=cmstendpage">한줄메모 성향 관리</a></li>
								<li><a href="DispatcherServlet?command=cmsgenrepage">도서리뷰 장르 관리</a></li>
								<li><a href="DispatcherServlet?command=cmscategorypege">창작마당 분야 관리</a></li>
								<li><a href="DispatcherServlet?command=cmspwquestionpage">비밀번호찾기 질문 관리</a></li>
								<!-- <li><a href="ex-cms_img.jsp">배경 이미지 관리</a></li>  -->
								<li class="divider"></li>
								<li><a href="DispatcherServlet?command=cmsboardlistpage">전체게시물관리</a></li>
								<li><a href="DispatcherServlet?command=cmsmemberlistpege">전체회원관리</a></li>
							</ul>
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="col-sm-1"></div>
</div>
	
<!-- 로고 -->
<div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">
	<a href="DispatcherServlet?command=lineList"><img alt="" src="icon_img/logo_white.png" style="width: 400px; height: 300px"></a>
</div>
    
<!-- 네비게이션 바 -->
<nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
	<div class="container">
	
		<a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Bookstagram</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		        
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav mx-auto">
				<!-- One-Line-Memo -->
				<li class="nav-item px-lg-4">
					<a class="nav-link text-uppercase text-expanded" href="DispatcherServlet?command=lineList">One-Line-Memo</a>
				</li>
				
				<!-- Book-Review -->
				<li class="nav-item px-lg-4">
					<a class="nav-link text-uppercase text-expanded" href="DispatcherServlet?command=reviewboardlist">Book-Review</a>
				</li>
				
				<!-- Creation -->
				<li class="nav-item px-lg-4">
					<a class="nav-link text-uppercase text-expanded" href="DispatcherServlet?command=createboardlist">Creation</a>
				</li>
			</ul>
		</div>
	</div>
</nav>


<!-- 로그인 창입니다. -->
<div class="setDiv">
	<div class="mask"></div>
	<div class="window" style="width: 350px; height: 225px; border-radius: 10px">
		<a href="#" class="close">X&nbsp;</a>
		<div style="text-align: center; margin-bottom: 10px">
			<h2><strong>로그인</strong></h2>
			<hr>
		</div>
		<div style="width: 350px;height: 150px">
			<form action="DispatcherServlet" id="loginFrame" method="post">
				<input type="hidden" name="command" value="Login">
				<div class="form-group" style="width: 350px; height: 36px;">
					<label class="col-lg-4 control-label" style="padding-top: 4px">아이디</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" id="userid" name="id" placeholder="아이디">
					</div>
				</div>
				<div class="form-group" style="width: 350px; height: 36px;">
					<label class="col-lg-4 control-label" style="padding-top: 4px">비밀번호</label>
					<div class="col-lg-8">
						<input type="password" class="form-control" id="userpw" name="pw" placeholder="비밀번호">
					</div>
				</div>
			
				<div class="form-group" style="width: 350px; height: 36px;margin-top: 15px">
					<label class="col-lg-6 control-label" style="padding-top: 4px">
					<a href="DispatcherServlet?command=JoinForm">회원가입</a>&nbsp;
					<a href="DispatcherServlet?command=PasswordFindForm">비밀번호찾기</a>
					</label>
					<div class="col-lg-6">
						<input type="submit" class="btn btn-info login" value="로그인" style="width: 140px">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>