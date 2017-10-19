<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function lineDelete(boardNO){
	location.href="DispatcherServlet?command=lineDelete&boardNo="+boardNO;
}
function lineUpdate(boardNO,tend_code,line_content){
	location.href="DispatcherServlet?command=lineUpdateView&boardNo="+boardNO+"&tend_code="+tend_code+"&line_content="+line_content;
}
</script>


<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container" style="margin-bottom: 250px">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		내 한줄 관리
	</div>

	<div class="bg-faded p-4 my-4">
		<table class="table table-hover">
			<thead class="my-thead">
				<tr>
					<th>게시물 번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일자</th>
					<th>공감</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody class="my-tbody">
			
			<c:forEach var="bvo" items="${requestScope.lvo.list}">
				<tr>
				<td>${bvo.board_no}</td>
				<td>${bvo.id} </td>
				<td>${bvo.line_content}</td>
				<td>${bvo.board_regdate}</td>
				<td>${bvo.hit}</td>
				<td><button type="button" class="btn btn-primary" onclick="lineUpdate(${bvo.board_no},${bvo.tend_code},'${bvo.line_content}')">수정</button></td>
				<td><button type="button" class="btn btn-primary" onclick="lineDelete(${bvo.board_no})">삭제</button></td>
				
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="bg-faded p-4 my-4">
		<div style="width: 50%; margin: 0 auto; ">
		<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">	
					<li><a href="DispatcherServlet?command=viewMyBoard&pageNo=${pb.startPageOfPageGroup-1}&b_name=1">&lt; &lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${pb.nowPage!=i}">
					<li><a href="DispatcherServlet?command=viewMyBoard&pageNo=${i}&b_name=1">${i}</a></li> 
					</c:when>
					<c:otherwise>
					<li class="active"><a href="#" >${i}</a></li>
					</c:otherwise>
					</c:choose>
					&nbsp;
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">	
					<li><a href="DispatcherServlet?command=viewMyBoard&pageNo=${pb.endPageOfPageGroup+1}&b_name=1">&gt; &gt;</a></li>
				</c:if>
		 	</ul>
	 	</div>
	</div>
	
</div>
<!-- /.container -->