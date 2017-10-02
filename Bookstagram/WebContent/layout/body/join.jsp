<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<form class="form-horizontal">
						<fieldset>
							<legend>Wellcome to Bookstgram</legend>
							
							<!-- 이메일 -->
							<div class="form-group" style="margin-top: 30px">
								<label for="inputEmail" class="col-lg-2 control-label">*아이디(이메일)</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="inputEmail" placeholder="이메일을 입력 해주세요.">
								</div>
								<div class="col-lg-6">
									<input type="button" class="btn btn-info" value="중복확인">
								</div>
							</div>
							
							<!-- 비밀번호 -->
							<div class="form-group">
								<label for="inputPassword" class="col-lg-2 control-label">*비밀번호</label>
								<div class="col-lg-4">
									<input type="password" class="form-control" id="inputPassword" placeholder="비밀번호를 입력해주세요.">
								</div>
								<div class="col-lg-6">
									<!-- 추후 비밀번호 유효성검사를 위한 라벨입니다. -->
								</div>
							</div>
							
							<!-- 비밀번호 확인 -->
							<div class="form-group">
								<label for="inputPasswordConfirm" class="col-lg-2 control-label">*비밀번호 확인</label>
								<div class="col-lg-10">
									<input type="password" class="form-control" id="inputPassword" placeholder="비밀번호를 한번 더 확인합니다.">
								</div>
							</div>
							
							<!-- 닉네임 -->
							<div class="form-group">
								<label for="inputNickName" class="col-lg-2 control-label">*닉네임</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="inputNickName" placeholder="닉네임을 입력해주세요.">
								</div>
								<div class="col-lg-6">
									<input type="button" class="btn btn-info" value="중복확인">
								</div>
							</div>
							
							<!-- 나이 -->
							<div class="form-group">
								<label for="inputAge" class="col-lg-2 control-label">*나이</label>
								<div class="col-lg-4">
									<input type=number class="form-control" min="0" max="100">
								</div>
							</div>
							
							<!-- 비밀번호 찾기 질문 -->
							<div class="form-group">
								<label for="select" class="col-lg-2 control-label">*비밀번호 찾기 질문</label>
								<div class="col-lg-10">
									<select class="form-control" id="select">
										<option>당신의 고향은?</option>
										<option>당신의 출신 중학교는?</option>
										<option>당신의 첫 사랑은?</option>
										<option>당신의 어머니 이름은?</option>
										<option>당신의 아버지 이름은?</option>
									</select><br>
								</div>
							</div>
							
							<!-- 비밀번호 찾기 답변 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">*비밀번호 찾기 답변</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="findPwAnswer" placeholder="비밀번호 찾기 답변">
								</div>
							</div>
							
							<!-- 선호하는 성향(최대3개까지 선택가능) -->
							<!-- 스크립트로 3개까지만 선택하게 해야함 -->
							<!-- for문으로 4개씩 끊어서 출력하는 알고리즘 짜야 함 -->
							<div class="form-group">
								<label class="col-lg-2 control-label">성향</label>
								<div class="col-lg-10">
									<div class="checkbox">
										<label>
											<input type="checkbox"> 슬픈
										</label>
										<label>
											<input type="checkbox"> 분노
										</label>
										<label>
											<input type="checkbox"> 사랑
										</label>
										<label>
											<input type="checkbox"> 허무
										</label>
									</div>
									<div class="checkbox">
										<label>
											<input type="checkbox"> 기쁜
										</label>
										<label>
											<input type="checkbox"> 우정
										</label>
										<label>
											<input type="checkbox"> 믿음
										</label>
										<label>
											<input type="checkbox"> 성찰
										</label>
									</div>
									<div class="checkbox">
										<label>
											<input type="checkbox"> 행복
										</label>
										<label>
											<input type="checkbox"> 여유
										</label>
										<label>
											<input type="checkbox"> 희망
										</label>
										<label>
											<input type="checkbox"> 기타
										</label>
									</div>
								</div>
							</div>
							
							<div class="form-group" style="margin-top: 300px; text-align:center">
								<div class="col-lg-10 col-lg-offset-2">
									<button type="reset" class="btn btn-default">취소</button>
									<button type="submit" class="btn btn-primary">가입</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->