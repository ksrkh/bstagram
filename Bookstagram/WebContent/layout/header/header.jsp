<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 가장 상단부에 위치한 검색창과 로그인 버튼입니다. -->
<div class="top-bar">
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
		<div class="form-group" style="margin-top: 5px">
			<input type="text" class="form-control" placeholder="Searcch" style="width: 150px; display: block; float: left">
			<button type="submit" class="btn btn-default" style="margin-left: 5px">Submit</button>
			<button type="button" class="btn btn-default" style="float: right;">Login</button>
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
					<a class="nav-link text-uppercase text-expanded" href="book_review.jsp">Book-Review</a>
				</li>
				
				<!-- Creation -->
				<li class="nav-item px-lg-4">
					<a class="nav-link text-uppercase text-expanded" href="creation.jsp">Creation</a>
				</li>
			</ul>
		</div>
	</div>
</nav>