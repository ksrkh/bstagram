<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		Book-Review
	<button type="button" class="btn btn-primary bookreview_write">글쓰기</button>
	</div>
	  
	<!-- start 추후 For로 돌릴 공간. -->
	<c:forEach items="${requestScope.reviewlist}"  var="review">
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<div style="display: block; float: left">
				<img height=171px width=120px src="https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg">
			</div>
			<div style="float: left; margin-left: 20px">
				<h3 style="margin-top: 3px; margin-bottom:5px"><strong><a href="DispatcherServlet?command=reviewdetail&review_no=${review.board_no}">${review.review_title}</a></strong></h3>
				<!-- 줄을 넘기지 않고 예쁘게 보여줘야 합니다. 글자수 70~75자   줄수 4줄, -->
				
				<h4><strong>${review.bookVO.book_title}</strong></h4>
				<strong>${review.bookVO.book_author} </strong> | ${review.bookVO.book_publ} | ${review.bookVO.book_sdate}<br>
			</div>
		</div>
	</div>
	</c:forEach>
	<!-- end 추후 For로 돌릴 공간. -->
</div>
<!-- /.container -->