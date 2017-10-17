<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container" style="margin-bottom: 150px">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
	비밀번호 찾기
	</div>

	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component">
					<form class="form-horizontal" action="DispatcherServlet" method="post" name="LoginMainFrame">
						<fieldset>
							<!-- 로고 -->
							<div class="form-group" style="margin-top: 65px">
								<div class="col-lg-3"></div>
								<div class="col-lg-5"><img alt="" src="icon_img/pwfind_logo.png" style="width: 400px; height: 100px"></div>
								<div class="col-lg-2"></div>
							</div>
							
							<!-- 이메일 -->
							<div class="form-group" style="margin-top: 30px; margin-bottom:100px">
								<div class="col-lg-2"></div>
								<label for="inputEmail" class="col-lg-2 control-label">아이디</label>
								<div class="col-lg-3">
									<input type="text" class="col-lg-12 form-control" id="usermainid" name="id" placeholder="이메일을 입력 해주세요.">
								</div>
								<div class="col-lg-3"><input type="button" class="btn btn-info main_login" value="로그인" style="width: 140px"></div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->