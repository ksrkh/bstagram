<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<script type="text/javascript">
function contentCheck(){
	var flag=true;
	var f=document.create;
	if(f.title.value==""){
		alert("제목을 입력하세요!");
		flag=false;
	}else if(f.content.value==""){
		alert("내용을 입력하세요!");
		flag=false;
	}else if(f.bgNo.value==""){
		alert("배경 이미지를 선택하세요!");
		flag=false;
	}
	return flag;
}

function backgroundNo(bgno){
	$('.hidden_bg_value').val(bgno);
}
function writecancle(){
	location.href="DispatcherServlet?command=createboardlist";
}
</script>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<!-- <div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		책속의 한줄
	</div> -->
	  
	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component col-lg-12">
					<div class="col-lg-1"></div>
					<div class="col-lg-10">
					<form class="form-horizontal" method="post" action="DispatcherServlet" id="create" name="create" onsubmit="return contentCheck()">
					<input type="hidden" name="command" value="createpostwrite">
					<input type="hidden" name="id" value="${sessionScope.member.id}">
	
						<fieldset>
								<legend>창작하기</legend>
							<!-- 창작글 제목 -->
							<div class="form-group" style="margin-top: 20px; margin-bottom: 20px">
								<div class="col-lg-2" style="padding-right: 0px">
									<select class="form-control" id="select" name="tend_code">
										<c:forEach var="cate" items="${requestScope.category}">
										<option value="${cate.category}">${cate.category_name}</option>			
										</c:forEach>
									</select>
								</div>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="title" name="title" placeholder="창작글 제목">
								</div>
							</div>
							
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12">
									<textarea class="form-control ta text-white" rows="25" id="content" name="content" placeholder="내용을 입력하세요."></textarea>
						      	</div>
						    </div>
	
						    <!-- 배경 선택 부분 -->
						    <!-- 2차구현 예정입니다. -->
							<div class="bg-faded p-4 my-4 form-group" style="margin-left: 0px;margin-right: 0px">
							    <div class="col-lg-12" style="margin-top: 5px; text-align: center">
								    <div class="radio" style="padding-top: 0px; padding-bottom: 0px">
								    	<label><input type="radio" name="bgNo" id="radio_bg2" value="" class="hidden_bg_value">이미지로 하기</label>
								    	<label><input type="radio" name="bgNo" id="radio_bg3" value="" class="hidden_bg_value" onclick="backgroundNo(0)" >선택안함</label>
								    </div>
							    </div>
						    </div>
							
							<!-- 창작게시판의 배경 템플릿 입니다. -->
							<div id="bg_template" class="bg-faded p-4 my-4 form-group" style="margin-left: 0px;margin-right: 0px; display: none">
								<div id="scroll_wrap" class="col-lg-12">
									<!-- 왼쪽 슬라이드 버튼 -->
									<div class="col-lg-1" style="padding-top: 30px">
										<span class="left"><img src="http://bimage.interpark.com/renewPark/welcome/main1111/btn_c_left_on.gif" alt=""></span>
									</div>
									<!-- 추후 for로 돌릴 템플릿 경로 -->
									<div class="col-lg-10">
										<div class="scroll">
											<ul class="board_background" style="padding-left: 0px">					
											<c:forEach items="${requestScope.bglist}" var="bg">
												<c:if test="${bg.bg_no!=0}">
													<li><img class="write_bg" src="icon_img/write_bg${bg.bg_path}" alt="" onclick="backgroundNo(${bg.bg_no})"></li>
												</c:if>
											</c:forEach>
											</ul>
										</div>
									</div>
									<!-- 오른쪽 슬라이드 버튼 -->
									<div class="col-lg-1" style="padding-top: 30px">
										<span class="right"><img src="http://bimage.interpark.com/renewPark/welcome/main1111/btn_c_right_on.gif" alt=""></span>	
									</div>
								</div>
							</div>
							
						</fieldset>
						<input type="hidden" class="hidden_bg_value" name="bgNo" id="bgNo" value="0">
					</form>
					</div>
					<div class="col-lg-1"></div>
				</div>
			</div>
		</div>
	
		<!-- 작석 버튼/취소 버튼 -->
		<div class="row" style="text-align:center; margin-top: 25px; margin-bottom: 50px">
			<div class="col-lg-12">
				<button type="reset" class="btn btn-default" onclick="writecancle()">작성 취소</button>
				<button type="submit" class="btn btn-primary" form="create">작성 완료</button>
			</div>
		</div>
	</div>
</div>
<!-- /.container -->