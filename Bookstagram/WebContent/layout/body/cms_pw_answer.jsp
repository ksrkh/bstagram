<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		비밀번호찾기 질문 관리
	</div>

	<div class="bg-faded p-4 my-4">
		<table class="table table-hover">
			<thead class="cms-thead">
				<tr>
					<th>질문 번호</th>
					<th style="width: 60%">비밀번호 찾기 질문</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody class="cms-tbody">
				<!-- start // 추후 for로 돌릴 구간입니다. -->
				<tr>
					<td style="font-size: 15px"><b>1</b></td>
					<td style="font-size: 15px"><input type="text" class="form-control" name="category_name" value="비밀번호질문" style="text-align: center; font-size: 15px"></td>
					<td><button type="button" class="btn btn-info" style="width: 100%">수정</button></td>
					<td><button type="button" class="btn btn-primary" style="width: 100%">삭제</button></td>
				</tr>
				<!-- end // 추후 for 로 돌릴 구간입니다. -->
			</tbody>
		</table>
	</div>
	
	<div class="bg-faded p-4 my-4">
		<div class="row">
			<label for="inputEmail" class="col-lg-1 control-label" style="margin-top:7px; margin-left:50px ;margin-right:0px; padding-right:0px; font-size: 15px"><b>분야</b></label>
			<div class="col-lg-9">
				<input type="text" class="form-control" name="category" placeholder="분야를 입력 해주세요.">
			</div>
			<div class="col-lg-1">
				<button type="button" class="btn btn-info" style="width: 100%">추가</button>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->