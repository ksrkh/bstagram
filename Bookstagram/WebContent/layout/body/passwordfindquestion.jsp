<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
    
<script type="text/javascript">
function pwInfoCheck(ques_code,ans){
	var in_ques_code = $("#pwfind_question").val();
	var in_ans = $("#pwfind_answer").val();
	
	if(in_ques_code!=ques_code){
		alert("비밀번호 찾기 질문이 일치하지 않습니다");
		return false;
	}
	else if(ans!=in_ans){
		alert("비밀번호 찾기 답변이 일치하지 않습니다");
		return false;
	}
	
}
</script>
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
					<form class="form-horizontal" action="DispatcherServlet" method="post" name="LoginMainFrame" onsubmit="return pwInfoCheck(${requestScope.mvo.question_code},'${requestScope.mvo.pw_ans}');">
						<input type="hidden" name="command" value="passwordfind3">
						<input type="hidden" name="id" value="${requestScope.mvo.id }">
						<input type="hidden" name="pw" value="${requestScope.mvo.pw }">
						 <fieldset>
							<!-- 로고 -->
							<div class="form-group" style="margin-top: 65px" >
								<div class="col-lg-3"></div>
								<div class="col-lg-4"><img alt="" src="icon_img/pwfind_logo.png" style="width: 400px; height: 100px"></div>
								<div class="col-lg-3"></div>
							</div>
							
							<!-- 비밀번호찾기질문 -->
							<div class="form-group" style="margin-top: 30px; margin-bottom:15px">
								<div class="col-lg-3"></div>
								<div class="col-lg-5">
									<select class="form-control" name="pwfind_question" id="pwfind_question">
										<option value="">비밀번호찾기질문</option>
										<c:forEach items="${requestScope.question}" var="qlist">
											<option value="${qlist.question_code}">${qlist.question}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-lg-3"></div>
							</div>
							
							<!-- 비밀번호찾기질문답변 -->
							<div class="form-group" style="margin-top: 30px; margin-bottom:100px">
								<div class="col-lg-3"></div>
								<div class="col-lg-5">
									<input type="text" class="col-lg-12 form-control" id="pwfind_answer" name="pwfind_answer" placeholder="답변을 입력 해주세요.">
								</div>
								<div class="col-lg-3"><input type="submit" class="btn btn-info findpassword_btn" value="찾기" style="width: 140px"></div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->