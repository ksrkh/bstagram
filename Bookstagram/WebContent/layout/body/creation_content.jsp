<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function golist(){
	location.href="ex-creation.jsp";
}
function deleteCreatePost(){
	if(confirm("창작 글을 삭제하시겠습니까?")){
		location.href="DispatcherServlet?command=createpostingdelete&board_no=${requestScope.cbdvo.board_no}";
		}
}
function updateCreatePost(){
	if(confirm("창작 글을 수정하시겠습니까?")){
		location.href="DispatcherServlet?command=createupdateview&board_no=${requestScope.cbdvo.board_no}";
		}		
}
</script>

<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container" style="margin-bottom: 50px">
	<!-- 현재 페이지의 타이틀  -->
	<!-- <div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		책속의 한줄
	</div> -->  
	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component col-lg-12">
					<div class="col-lg-12">
					<form class="form-horizontal">
						<fieldset>
							<!-- 타이틀 -->
							<legend style="padding-bottom: 15px"><b>창작글</b></legend>
							
							<!-- 게시글 제목 부분 -->
							<div class="col-lg-12" style="border-bottom: #848484 1px solid; padding-left: 30px">
								<div class="form-group">
									<!-- 제목 -->
									<label style="float: left">${requestScope.cbdvo.create_title}</label>
									<!-- 작성일자 -->
									<label style="float: right"><b>작성일자</b>&nbsp;&nbsp; ${requestScope.cbdvo.board_regdate}</label>
								</div>
							</div>
							
							<!-- 게시글 작성자 부분 -->
							<div class="col-lg-12" style="border-bottom: #848484 1px solid; padding-left: 30px; padding-top: 10px">
								<div class="form-group">
									<!-- 작성자 -->
									<label style="float: left"><b>작성자</b>&nbsp;&nbsp; ${requestScope.cbdvo.nick}</label>
									<!-- 조회수 -->
									<label style="float: right"><b>조회수</b>&nbsp;&nbsp; ${requestScope.cbdvo.hit}</label>
								</div>
						    </div>
							
							<!-- 내용 부분 -->
							<div class="col-lg-12" style="border-bottom: #848484 1px solid; padding-left: 30px; padding-top: 15px">
								<div class="form-group">
							 		<br>${requestScope.cbdvo.create_content}
									<br><br><br><br><br><br><br><br><br><br><br><br>
									<br><br><br><br><br><br><br><br><br><br><br><br>
									<br><br><br><br><br><br><br><br><br><br><br><br>
						      	</div>
						    </div>
						</fieldset>
					</form>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 작성 버튼/취소 버튼 -->
		<div class="row" style="margin-bottom: 30px">
			<div class="col-lg-12">
				<button type="reset" class="btn btn-default"  style="float:right" onclick="golist()">목록으로</button>
				<!-- 작성자와 정보가 일치했을시에만 보여줍니다. -->		
				<c:choose>
					<c:when test="${requestScope.cbdvo.id==sessionScope.member.id}">
				<button type="submit" class="btn btn-primary" style="float:left; margin-right: 10px" onclick="deleteCreatePost()">삭제</button>
				<button type="submit" class="btn btn-primary" style="float:left" onclick="updateCreatePost()">수정</button>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->