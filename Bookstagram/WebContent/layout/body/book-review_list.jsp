<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">

    
</script>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		Book-Review
	<c:if test="${sessionScope.member!=null}">
	<button type="submit" class="btn btn-primary bookreview_write">글쓰기</button>
	</c:if>
	</div>
	  
	<!-- start 추후 For로 돌릴 공간. -->
	<c:forEach items="${requestScope.reviewlist.list}"  var="review">
	<div class="bg-faded p-4 my-4">
		<div class="container">
		<div class="col-sm-2">
			<div style="display: block; float: left">
				<img height=171px width=120px src="${review.bookVO.book_img}">
			</div>
			</div>
			<div class="col-sm-10">
				
					<h3 style="margin-top: 3px; margin-bottom:5px">
						<c:choose>
								<c:when test="${sessionScope.member!=null}">
										<strong><a href="DispatcherServlet?command=reviewdetail&review_no=${review.board_no}&id=${sessionScope.member.id}">${review.review_title}</a></strong>
								</c:when>
								<c:otherwise>
										<strong>${review.review_title} </strong>
								</c:otherwise>
						</c:choose>	
						<font style="float: right; " size="2">조회수&nbsp;&nbsp; ${review.hit} </font>
					</h3>
					
					<!-- 줄을 넘기지 않고 예쁘게 보여줘야 합니다. 글자수 70~75자   줄수 4줄, -->
					<div style="height:75px">${review.review_content }</div>
						<div style="float: bottom; margin-top: 5px">
						<h4><strong>[${review.genre_name}] ${review.bookVO.book_title}</strong></h4>
						<div style="float: left"><strong>${review.bookVO.book_author} </strong> | ${review.bookVO.book_publ} | ${review.bookVO.book_sdate}</div>
						<div style="float: right"> 작성자 | ${review.nick } |</div>
					</div>
			</div>
		</div>
	</div>
	</c:forEach>
	<!-- end 추후 For로 돌릴 공간. -->
	 <c:set var="pb" value="${requestScope.reviewlist.pagingBean}"></c:set>
	<div class="bg-faded p-4 my-4">
		<div style="width: 50%; margin: 0 auto; text-align: center">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a href="DispatcherServlet?command=reviewboardlist&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a href="DispatcherServlet?command=reviewboardlist&pageNo=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"> <a href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a href="DispatcherServlet?command=reviewboardlist&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<!-- /.container -->