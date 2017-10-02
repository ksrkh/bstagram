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
			<input type="text" class="form-control" placeholder="Searcch" style="width: 150px; display: block; float: left">
			<button type="submit" class="btn btn-default" style="margin-left: 5px">검색</button>
			<button type="button" class="btn btn-default login_btn" style="float: right;" onclick="clicktest()">Login</button>
		</div>
	</div>
	<div class="col-sm-1"></div>
</div>
	
<!-- 로고 -->
<div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">
	<img alt="" src="img/logo_white.png" style="width: 400px; height: 300px">
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
					<a class="nav-link text-uppercase text-expanded" href="home.jsp">One-Line-Memo</a>
				</li>
				
				<!-- Book-Review -->
				<li class="nav-item px-lg-4">
					<a class="nav-link text-uppercase text-expanded" href="ex-book_review.jsp">Book-Review</a>
				</li>
				
				<!-- Creation -->
				<li class="nav-item px-lg-4">
					<a class="nav-link text-uppercase text-expanded" href="ex-creation.jsp">Creation</a>
				</li>
			</ul>
		</div>
	</div>
</nav>


<!-- 로그인 창입니다. -->
<div class="setDiv">
	<div class="mask"></div>
	<div class="window" style="width: 300px; height: 200px">
		<a href="#" class="close">X&nbsp;</a>
		<div style="text-align: center; margin-bottom: 10px">
			<h2><strong>로그인</strong></h2>
			<hr>
		</div>
		<div style="width: 300px;height: 50px">
			<div style="width: 125px;float: left;padding-left: 30px">아이디</div>
			<div style="width: 175px;float: left"><input type="text"></div>
			<div style="clear:both; width: 125px;float: left;padding-left: 30px">비밀번호</div>
			<div style="width: 175px;float: left"><input type="text"></div>
		</div>
		<div style="width: 300px;height: 24px;padding-left: 30px; margin-top: 10px">
			<a href="ex-join.jsp">회원가입</a>
			<a href="#">비밀번호 찾기</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="로그인" style="width: 75px">
		</div>
	</div>
</div>