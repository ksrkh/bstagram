<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
    function returnlist(){
    	location.href="DispatcherServlet?command=reviewboardlist";
    }
     function deleteReview(){
    	if(confirm("글을 삭제하시겠습니까?")){
    		location.href="DispatcherServlet?command=reviewdelete&board_no=${requestScope.reviewdetail.board_no}";
    		}
    }
     function updateReview(){
    		if(confirm("글을 수정하시겠습니까?")){
    			location.href="DispatcherServlet?command=reviewupdatepage&board_no=${requestScope.reviewdetail.board_no}";
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

    function delReply(reply_no,board_type,id){
    	if(confirm("덧글을 삭제하시겠습니까?")){
    		location.href="DispatcherServlet?command=deleteReply&board_no=${requestScope.reviewdetail.board_no}&id="+id+"&reply_no="+reply_no+"&board_type="+board_type;
    		} 
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
					<form class="form-horizontal">
						<fieldset>
							<!-- 책제목 (독후감 제목) -->
							<legend style="padding-bottom: 15px"> <b>${requestScope.reviewdetail.review_title }</b>
							<font style="float: right; " size="2">조회수&nbsp;&nbsp; ${requestScope.reviewdetail.hit} </font>
							</legend>
							<font style="float: left;" size="2">작성일 |  ${requestScope.reviewdetail.board_regdate } |</font>
						<font style="float: right; " size="2">조회수&nbsp;&nbsp; ${requestScope.reviewdetail.hit} </font><br>
						
							<div class="form-group" style="margin-top: 20px; margin-bottom: 20px">
								<!-- 책의 Thumnail 이 보여질 부분 -->
								<div class="col-lg-4" style="padding-right: 0px">
									<img height=342px width=240px src="https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg">
								</div>
								<!-- 책의 상세 내용이 보여질 부분 -->
								<div class="col-lg-8">
									<!-- 저자,출판사,출판일자 -->
									<div class="row" style="margin-right: 0px">
										<div class="col-lg-12" style="border-bottom: #222222 1px solid;padding-bottom:8px">
											<div class="col-lg-4" style="padding-left: 0px">
												<label style="font-size: 15px"><b>저자</b></label>&nbsp;&nbsp;${requestScope.reviewdetail.bookVO.book_author }
											</div>
											<div class="col-lg-4" style="padding-left: 0px">
												<label style="font-size: 15px"><b>출판사</b></label>&nbsp;&nbsp;${requestScope.reviewdetail.bookVO.book_publ }
											</div>
											<div class="col-lg-4" style="padding-left: 0px">
												<label style="font-size: 15px"><b>출판일자</b></label>&nbsp;&nbsp;${requestScope.reviewdetail.bookVO.book_sdate }
											</div>
										</div>
									</div>
									<!-- 책소개  [최대13줄] -->
									<div class="row" style="margin-right: 0px">
										<div class="col-lg-12" style="border-bottom: #222222 1px solid; padding-top: 10px; padding-bottom:20px">
											<h4><b>소개</b></h4>
											<label style="font-size: 15px">
											${requestScope.reviewdetail.bookVO.book_intro}
											</label>
											<br><br><br><br><br><br><br><br><br>
										</div>
									</div>
								</div>
							</div>
							
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12" style="font-size: 14px">
									<b>${requestScope.reviewdetail.bookVO.book_title }</b><br>
									${requestScope.reviewdetail.review_content}
									 <br><br>
						      	</div>
						    </div>
						</fieldset>
					</form>
					</div>
					<div class="col-lg-1"></div>
				</div>
			</div>
		</div>
	
		<!-- 작석 버튼/취소 버튼 -->
		<div class="row" style="margin-bottom: 50px">
			<div class="col-lg-12">
				<button type="reset" class="btn btn-default"  style="float:right; margin-right: 10px" onclick="returnlist()">목록으로</button>
				<!-- 작성자와 정보가 일치했을시에만 보여줍니다. -->
				<c:if test="${requestScope.reviewdetail.id==sessionScope.member.id}">
				<button type="submit" class="btn btn-primary" style="float:left; margin-right: 10px; margin-left: 10px" onclick="deleteReview()">삭제</button>
				<button type="submit" class="btn btn-primary" style="float:left" onclick="updateReview()">수정</button>
				</c:if>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->

<!-- .container -->
<div class="container" style="margin-bottom: 50px">
	<div class="bg-faded p-4 my-4">
		<form class="form-horizontal" action="DispatcherServlet" id="reply" name="reply" onsubmit="return chReply()">
			<input type="hidden" name="board_no" value="${requestScope.reviewdetail.board_no}">
			<input type="hidden" name="id" value="${sessionScope.member.id}">
			<input type="hidden" name="command" value="replyRegister">
			<input type="hidden" name="board_type" value="review">
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
							<td width="1000">${reVO.reply_content}</td>
							<td width="200"><button type="submit" class="btn btn-primary" style="float:left">답글</button>
							<button type="submit" class="btn btn-primary" style="float:left" onclick="delReply(${reVO.reply_no},${requestScope.reviewdetail.boardtype_no},'${sessionScope.member.id }')">삭제</button></td>
							
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
<!-- /.container -->