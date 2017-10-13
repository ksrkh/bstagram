<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		도서리뷰 장르 관리
	</div>

	<div class="bg-faded p-4 my-4">
		<table class="table table-hover">
			<thead class="cms-thead">
				<tr>
					<th>장르 번호</th>
					<th style="width: 60%">장르 이름</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody class="cms-tbody">
				<!-- start // 추후 for로 돌릴 구간입니다. -->
				<tr>
					<td style="font-size: 15px"><b>1</b></td>
					<td style="font-size: 15px"><input type="text" class="form-control" name="genre_name" value="분노" style="text-align: center; font-size: 15px"></td>
					<td><button type="button" class="btn btn-info" style="width: 100%">수정</button></td>
					<td><button type="button" class="btn btn-primary" style="width: 100%">삭제</button></td>
				</tr>
				<!-- end // 추후 for 로 돌릴 구간입니다. -->
			</tbody>
		</table>
	</div>
	
	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="col-lg-10">
					<input type="text" class="form-control" name="genre" placeholder="장르를 입력 해주세요.">
				</div>
				<div class="col-lg-2">
					<button type="button" class="btn btn-info">추가</button>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
	</div>
</div>
<!-- /.container -->