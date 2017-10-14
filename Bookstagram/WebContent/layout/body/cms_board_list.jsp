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
					<th>작성자</th>
					<th>제목</th>
					<th>작성일자</th>
					<th>조회수</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody class="cms-tbody">
			
				<!-- start // 추후 for로 돌릴 구간입니다. -->
				<tr>
					<td>1</td>
					<td>john@example.com</td>
					<td>제목입니다. 블라블라 블라.제목입니다. 블라블라 블라.제목입니다. 블라블라 블라.제목입니다. 블라블라 블라</td>
					<td>2017-10-02</td>
					<td>0</td>
					<td><button type="button" class="btn btn-primary">삭제</button></td>
				</tr>
				
				<!-- end // 추후 for 로 돌릴 구간입니다. -->
				
			</tbody>
		</table>
	</div>
	
	<div class="bg-faded p-4 my-4">
		<div style="width: 50%; margin: 0 auto; ">
			<ul class="pagination">
				<li><a href="#">&lt; &lt;</a></li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><a href="#">6</a></li>
			    <li><a href="#">7</a></li>
			    <li><a href="#">8</a></li>
			    <li><a href="#">9</a></li>
			    <li><a href="#">10</a></li>
			    <li><a href="#">11</a></li>
			    <li><a href="#">12</a></li>
			    <li><a href="#">13</a></li>
				<li><a href="#">&gt; &gt;</a></li>
		 	</ul>
	 	</div>
	</div>
</div>
<!-- /.container -->