<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div
		class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block"
		style="margin-top: 5px">
		창작공간
		<button type="button" class="btn btn-primary creation_write">글쓰기</button>
	</div>

	<div class="bg-faded p-4 my-4">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>게시물 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>

				<!-- start for -->
				<c:forEach var="cbvo" items="${requestScope.clist.list}">
					<tr>
						<td>${cbvo.board_no}</td>
						<td>${cbvo.nick}</td>
						<c:choose>
							<c:when test="${sessionScope.member!=null}">
								<td><a
									href="DispatcherServlet?command=createpostdetail&board_no=${cbvo.board_no}">${cbvo.create_title}</a></td>
							</c:when>
							<c:otherwise>
								<td>${cbvo.create_title}</td>
							</c:otherwise>
						</c:choose>
						<td>${cbvo.board_regdate}</td>
						<td>${cbvo.hit}</td>
					</tr>
				</c:forEach>
				<!-- end for -->
			</tbody>
		</table>
	</div>
	<c:set var="pb" value="${requestScope.clist.pagingBean}"></c:set>
	<div class="bg-faded p-4 my-4">
		<div style="width: 50%; margin: 0 auto;">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a href="DispatcherServlet?command=createboardlist&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a href="DispatcherServlet?command=createboardlist&pageNo=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"> <a href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a href="DispatcherServlet?command=createboardlist&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<!-- /.container -->