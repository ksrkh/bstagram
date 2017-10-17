<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
	비밀번호찾기
	</div>

	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component">
					<form class="form-horizontal" action="DispatcherServlet" method="post" name="LoginMainFrame">
						<fieldset>
							<!-- 로고 -->
							<div class="form-group" style="margin-top: 65px">
								<div class="col-lg-4"></div>
								<div class="col-lg-6"><img alt="" src="icon_img/main_text_black.png" style="width: 330px; height: 170px"></div>
								<div class="col-lg-2"></div>
							</div>
							
							<!-- 이메일 -->
							<div class="form-group" style="margin-top: 30px; margin-bottom:15px">
								<div class="col-lg-3"></div>
								<label for="inputEmail" class="col-lg-2 control-label">아이디</label>
								<div class="col-lg-3">
									<input type="text" class="col-lg-12 form-control" id="usermainid" name="id" placeholder="이메일을 입력 해주세요.">
								</div>
								<div class="col-lg-2"></div>
							</div>
							<!-- 비밀번호 -->
							<div class="form-group" style="margin-bottom:15px">
								<div class="col-lg-3"></div>
								<label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
								<div class="col-lg-3">
									<input type="password" class="form-control" id="usermainpw" name="pw" placeholder="비밀번호를 입력해주세요.">
								</div>
								<div class="col-lg-2"></div>
							</div>
							<!-- 비밀번호 -->
							<div class="form-group" style="margin-bottom:80px">
								<div class="col-lg-4"></div>
								<div class="col-lg-2">
									<label for="inputPassword" class="control-label" style="margin-right: 5px; padding-right: 5px">
										<a href="DispatcherServlet?command=JoinForm">회원가입</a>
									</label>
									<label for="inputPassword" class="control-label" style="margin-left: 0px; padding-left: 0px">
										<a href="DispatcherServlet?command=PasswordFindForm">비밀번호 찾기</a>
									</label>
								</div>
								<div class="col-lg-4" style="margin-left: 10px">
									<input type="button" class="btn btn-info main_login" value="로그인" style="width: 140px">
								</div>
								<div class="col-lg-2"></div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->