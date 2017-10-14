<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
    function returnlist(){
    	location.href="DispatcherServlet?command=reviewboardlist";
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
							<legend style="padding-bottom: 15px"><b>${requestScope.reviewdetail.review_title }</b></legend>
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
				<button type="submit" class="btn btn-primary" style="float:left; margin-right: 10px; margin-left: 10px" onclick="deleteCreatePost()">삭제</button>
				<button type="submit" class="btn btn-primary" style="float:left" onclick="updateCreatePost()">수정</button>
				</c:if>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->