<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
	회원가입
	</div>

	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component">
					<form class="form-horizontal" action="DispatcherServlet" method="post" name="JoinFrame">
						<fieldset>
							<legend>Wellcome to Bookstgram</legend>
							
							<!-- 이메일 -->
							<div class="form-group" style="margin-top: 30px; margin-bottom:15px">
								<label for="inputEmail" class="col-lg-2 control-label">*아이디(이메일)</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="id" name="id" placeholder="이메일을 입력 해주세요." onkeyup="dupleId()">
								</div>
								<div class="col-lg-6">
									<label id="dupleMessage" style="margin-top: 5px"></label>
								</div>
							</div>
							
							<!-- 비밀번호 -->
							<div class="form-group" style="margin-bottom:15px">
								<label for="inputPassword" class="col-lg-2 control-label">*비밀번호</label>
								<div class="col-lg-4">
									<input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력해주세요.">
								</div>
								<div class="col-lg-6">
									<!-- 추후 비밀번호 유효성검사를 위한 라벨입니다. -->
								</div>
							</div>
							
							<!-- 비밀번호 확인 -->
							<div class="form-group" style="margin-bottom:15px">
								<label for="inputPasswordConfirm" class="col-lg-2 control-label">*비밀번호 확인</label>
								<div class="col-lg-10">
									<input type="password" class="form-control" id="confirm_pw" name="confirm_pw" placeholder="비밀번호를 한번 더 확인합니다.">
								</div>
							</div>
							
							<!-- 닉네임 -->
							<div class="form-group" style="margin-bottom:15px">
								<label for="inputNickName" class="col-lg-2 control-label">*닉네임</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="nick" name="nick" placeholder="닉네임을 입력해주세요.">
								</div>
								<div class="col-lg-6">
									<input type="button" class="btn btn-info" value="중복확인">
								</div>
							</div>
							
							<!-- 나이 -->
							<div class="form-group" style="margin-bottom:15px">
								<label for="inputAge" class="col-lg-2 control-label">*나이</label>
								<div class="col-lg-4">
									<input type=number class="form-control" id="age" name="age" min="0" max="100">
								</div>
							</div>
							
							<!-- 비밀번호 찾기 질문 -->
							<div class="form-group">
								<label for="select" class="col-lg-2 control-label">*비밀번호 찾기 질문</label>
								<div class="col-lg-10" style="height: 50px">
									<select class="form-control" name="pw_question" id="pw_question">
										<c:forEach items="${requestScope.question}" var="qlist">
											<option value="${qlist.question_code}">${qlist.question}</option>
										</c:forEach>
									</select><br>
								</div>
							</div>
							
							<!-- 비밀번호 찾기 답변 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">*비밀번호 찾기 답변</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="pw_answer" name="pw_answer" placeholder="비밀번호 찾기 답변">
								</div>
							</div>
							
							<!-- 선호하는 성향(최대3개까지 선택가능) -->
							<!-- 스크립트로 3개까지만 선택하게 해야함 -->
							<!-- for문으로 4개씩 끊어서 출력하는 알고리즘 짜야 함 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">선호하는 성향<br>(최대3개까지 선택가능)</label>
								<div class="col-lg-10">
									<div class="checkbox">
									<c:forEach items="${requestScope.tend}" var="tlist">
										<label><input type="checkbox" name="tend_code" value="${tlist.tend_code}">${tlist.tend_name}</label>
									</c:forEach>
									</div>
									<div class="checkbox"></div>
									<div class="checkbox"></div>
								</div>
							</div>
							
							<div class="form-group" style="margin-top: 300px; text-align:center">
								<div class="col-lg-10 col-lg-offset-2">
									<button type="reset" class="btn btn-default">취소</button>
									<button type="submit" class="btn btn-primary">가입</button>
								</div>
							</div>
							<input type="hidden" name="command" value="Join">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->