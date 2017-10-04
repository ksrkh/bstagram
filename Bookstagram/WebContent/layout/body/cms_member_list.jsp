<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		전체 회원 관리
	</div>

	<div class="bg-faded p-4 my-4">
		<table class="table table-hover">
			<thead class="cms-thead">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>나이</th>
					<th>성향1</th>
					<th>성향2</th>
					<th>성향3</th>
					<th>회원등급</th>
					<th>가입날짜</th>
					<th>수정</th>
				</tr>
			</thead>
			<tbody class="cms-tbody">
				<!-- start // 추후 for로 돌릴 구간입니다. -->
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				
				
				
				
				
				<!-- 2행 -->
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				<tr>
					<!-- 아이디 -->
					<td style="padding-top: 15px">
						abcdefgh1234@naver.com
					</td>
					<!-- 비밀번호 -->
					<td>
						<input type="password" class="form-control" id="password" placeholder="비밀번호" size="10">
					</td>
					<!-- 나이 -->
					<td>
						<input type=number class="form-control" id="age" name="age" min="0" max="100" value="20">
					</td>
					<!-- 성향1 -->
					<td>
						<select class="form-control" id="select" name="tend_code">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향2 -->
					<td>
						<select class="form-control" id="select" name="tend_code2">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					<!-- 성향3 -->
					<td>
						<select class="form-control" id="select" name="tend_code3">
							<option value="0">없음</option>
							<option value="1">슬픈</option>
							<option value="2">분노</option>
							<option value="3">사랑</option>
							<option value="4">허무</option>
							<option value="5">기쁜</option>
							<option value="6">우정</option>
							<option value="7">믿음</option>
							<option value="8">성찰</option>
							<option value="9">행복</option>
							<option value="10">여유</option>
							<option value="11">희망</option>
							<option value="12">기타</option>
						</select>
					</td>
					
					
					<!-- 회원등급 -->
					<td>
						<select class="form-control" id="select" name="tier">
							<option value="0">탈퇴회원</option>
							<option value="1">회원</option>
							<option value="2">운영자</option>
							<option value="3">관리자</option>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td><button type="button" class="btn btn-primary">수정</button></td>
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