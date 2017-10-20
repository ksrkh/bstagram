<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		전체 게시물 관리
	</div>

	<div class="bg-faded p-4 my-4">
		<table class="table table-hover">
			<thead class="cms-thead">
				<tr>
					<th>게시물 번호</th>
					<th>게시판 이름</th>
					<th>작성자</th>
					<th>내용</th>
					<th>등록일자</th>
					<th>조회수</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody class="cms-tbody">
			
				<!-- start // 추후 for로 돌릴 구간입니다. -->
				<c:forEach items="${requestScope.board.list}" var="board">
				<tr class="cmsboardlist_tr">
					<td class="cmsboardno">${board.board_no}<input type="hidden" name="cmsboardtypeno" value="${board.boardtype_no}"></td>
					<td>${board.boardtype_name}</td>
					<td>${board.id}</td>
					<td>${board.content}</td>
					<td>${board.board_regdate}</td>
					<td>${board.hit}</td>
					<td class="cmsboarddlt_btn"><button type="button" class="btn btn-primary">삭제</button></td>
				</tr>
				</c:forEach>
				<!-- end // 추후 for 로 돌릴 구간입니다. -->
				
			</tbody>
		</table>
	</div>
	
	<c:set var="pb" value="${requestScope.board.pagingBean}"></c:set>
	<div class="bg-faded p-4 my-4">
		<div style="width: 50%; margin: 0 auto;text-align: center">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a href="DispatcherServlet?command=cmsboardlistpage&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a href="DispatcherServlet?command=cmsboardlistpage&pageNo=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"> <a href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a href="DispatcherServlet?command=cmsboardlistpage&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	
	
	
</div>
<!-- /.container -->