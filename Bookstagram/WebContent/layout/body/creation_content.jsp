<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function golist(){
	location.href="DispatcherServlet?command=createboardlist";
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

function chReply(){
	var content=$('.form-horizontal #reply_content').val();
	if(content.length==0){
		alert("댓글을 입력하세요");
		return false;
	}
	return confirm("댓글을 작성하시겠습니까?");
}

function delReply(reply_no,board_type, id){
	if(confirm("덧글을 삭제하시겠습니까?")){
		location.href="DispatcherServlet?method=post&command=deleteReply&board_no=${requestScope.cbdvo.board_no}&id="+id+"&reply_no="+reply_no+"&board_type="+board_type;
		} 
}
</script>
<style>

#content-name {
    text-align: right;
} 
</style>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		창작 글
	</div> 
	
	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component col-lg-12">
					<div class="col-lg-12">
					<form class="form-horizontal">
						<fieldset>
							<!-- content 부분 -->
							<div class="col-lg-12" style="padding-left: 15px; padding-top: 0px">
								
									<!-- 이미지 선택안했을 시 -->
									<c:if test="${requestScope.cbdvo.bg_no == 0}">
									<div class="form-group" style="height: 500px">
										<div class="card-img-overlay" >
											<div class="text" >
												<div style="float: right; margin-right: 5px">
														<!-- 작성자 -->
															<b>작성자</b>&nbsp;&nbsp; ${requestScope.cbdvo.nick}&nbsp;&nbsp; 
														<!-- 조회수 -->
															<b>조회수</b>&nbsp;&nbsp; ${requestScope.cbdvo.hit}&nbsp;&nbsp; 
												</div>
												<h2 class="card-title text text-uppercase mb-0">${requestScope.cbdvo.create_title}</h2>
												<h4 class="text">${requestScope.cbdvo.board_regdate}</h4>
								 					<div>
								 						<br><br> &nbsp; ${requestScope.cbdvo.create_content}
														<br><br>
								 					</div>
											</div>
										</div>
									</div>
									</c:if>
									
									<!-- 이미지 선택했을 시 -->
									<c:if test="${requestScope.cbdvo.bg_no != 0}">
									<div class="form-group">
										<img class="write_bg img-fluid w-100" src="img/write/write_bg${requestScope.cbdvo.bg_path}" alt="">
										<div class="card-img-overlay bg-overlay" >
											<div class="text text-white" >
												<div style="float: right; margin-right: 5px">
														<!-- 작성자 -->
															<b>작성자</b>&nbsp;&nbsp; ${requestScope.cbdvo.nick}&nbsp;&nbsp; 
														<!-- 조회수 -->
															<b>조회수</b>&nbsp;&nbsp; ${requestScope.cbdvo.hit}&nbsp;&nbsp; 
												</div>
												<h2 class="card-title text-shadow text-white text-uppercase mb-0">${requestScope.cbdvo.create_title}</h2>
												<h4 class="text-shadow text-white">${requestScope.cbdvo.board_regdate}</h4>
								 					<div>
								 						<br><br> &nbsp; ${requestScope.cbdvo.create_content}
														<br><br>
								 					</div>
											</div>
										</div>
									</div>
									</c:if>

									
						    </div>
						</fieldset>
					</form>
    				</div>
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
<!-- /.container -->
<div class="container" style="margin-bottom: 50px">
	<div class="bg-faded p-4 my-4">
		<form class="form-horizontal" action="DispatcherServlet" id="reply" name="reply" method="post" onsubmit="return chReply()" method="post">
			<input type="hidden" name="board_no"value="${requestScope.cbdvo.board_no}">
			<input type="hidden" name="id"value="${sessionScope.member.id}">
			<input type="hidden" name="command" value="replyRegister">
			<input type="hidden" name="board_type" value="create">
			
			<div class="col-lg-11"> 
				<input type="text" class="form-control" id="reply_content" name="reply_content" placeholder="댓글을 입력하세요">
			</div>
			<div class="col-lg-1">
				<input type="submit" class="btn btn-primary" value="등록" style="width:100%" form="reply">
			</div>
		</form>
		<br><br><br>

		<table class="table table-hover">
			<c:forEach var="reVO" items="${requestScope.relist}">
				<c:choose>
					<c:when test="${reVO.id==sessionScope.member.id}">
						<tr>
							<td width="50"></td>
							<td width="150">${reVO.id}</td>
							<td width="1000">${reVO.reply_content} </td>
							<td width="200"><button type="submit" class="btn btn-primary" style="float:left">답글</button>
							<button type="submit" class="btn btn-primary" style="float:left" onclick="delReply(${reVO.reply_no},${requestScope.cbdvo.board_no},'${sessionScope.member.id }')">삭제</button>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td width="50"></td>
							<td width="150">${reVO.id}</td>
							<td width="1000">${reVO.reply_content}</td>
							<td width="200"><button type="submit" class="btn btn-primary" style="float:left">답글</button></td>
						</tr>
					</c:otherwise>		
			</c:choose>
		</c:forEach>
		</table>
	</div>
</div>