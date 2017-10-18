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
							<div class="form-group" style="margin-top: 65px; margin-bottom: 80px" >
								<div class="col-lg-3"></div>
								<div class="col-lg-4"><img alt="" src="icon_img/pwfind_logo.png" style="width: 400px; height: 100px"></div>
								<div class="col-lg-3"></div>
							</div>
							
							
							<!-- 비밀번호찾기질문답변 -->
							<div class="form-group" style="margin-top: 30px; margin-bottom:100px">
								<div class="col-lg-2"></div>
								<div class="col-lg-5">
									<label for="select" class="col-lg-12 control-label"><b>${requestScope.id}</b>&nbsp;회원님의 비밀번호 찾기 결과입니다.</label>
									<label for="select" class="col-lg-12 control-label">회원님의 비밀번호는&nbsp; <b>${requestScope.pw}</b> &nbsp;입니다.</label>
									<label for="select" class="col-lg-12 control-label"><a href="DispatcherServlet?command=LoginFail">click>로그인페이지로 go!</a></label>
								</div>
								<div class="col-lg-3"></div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->