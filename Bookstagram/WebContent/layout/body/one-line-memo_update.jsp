<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<form class="form-horizontal" id="writeForm">
					
						<fieldset>
							<legend>책속의 한줄</legend>
							<!-- 내용 입력 부분 -->
							<div class="form-group" style="margin-top: 50px">
								<div class="col-lg-12">
									<textarea class="form-control ta" rows="15" id="content" placeholder="내용을 입력하세요." style="resize: none; background-image: url('img/write/write_bg6.jpg');">
									${requestScope.line_content}
									</textarea>
						      	</div>
						    </div>
						    
						    <!-- 배경 선택 부분 -->
						    <!-- 2차구현 예정입니다. -->
							<div class="bg-faded p-4 my-4 form-group" style="margin-left: 0px;margin-right: 0px">
							    <div class="col-lg-12" style="margin-top: 5px; text-align: center">
								    <div class="radio" style="padding-top: 0px; padding-bottom: 0px">
								    	<label><input type="radio" name="content_bg" id="radio_bg1" value="content_bg1">색상으로 하기</label>
								    	<label><input type="radio" name="content_bg" id="radio_bg2" value="content_bg2" checked="checked">이미지로 하기</label>
								    	<label><input type="radio" name="content_bg" id="radio_bg3" value="content_bg3">선택안함</label>
								    </div>
							    </div>
						    </div>
							
							<!-- 한줄 메모의 배경 템플릿 입니다. -->
							<div id="bg_template" class="bg-faded p-4 my-4 form-group" style="margin-left: 0px;margin-right: 0px">
								<div id="scroll_wrap" class="col-lg-12">
									<!-- 왼쪽 슬라이드 버튼 -->
									<div class="col-lg-1" style="padding-top: 30px">
										<span class="left"><img src="http://bimage.interpark.com/renewPark/welcome/main1111/btn_c_left_on.gif" alt=""></span>
									</div>
									<!-- 추후 for로 돌릴 템플릿 경로 -->
									<div class="col-lg-10">
										<div class="scroll">
											<ul class="board_background" style="padding-left: 0px">
												<li><img class="write_bg" src="img/write/write_bg11.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg12.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg8.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg4.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg5.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg6.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg7.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg3.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg9.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg10.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg1.jpg" alt=""></li>
												<li><img class="write_bg" src="img/write/write_bg2.jpg" alt=""></li>
											</ul>
										</div>
									</div>
									<!-- 오른쪽 슬라이드 버튼 -->
									<div class="col-lg-1" style="padding-top: 30px">
										<span class="right"><img src="http://bimage.interpark.com/renewPark/welcome/main1111/btn_c_right_on.gif" alt=""></span>	
									</div>
								</div>
							</div>
							
							<!-- 책검색 -->
							<div class="form-group" style="margin-bottom:15px">
								<div class="col-lg-12">
									<input type="text" class="form-control" name="book_search" id="book_search" placeholder="책 검색">
								</div>
							</div>
							
							<!-- 책검색내용이 보여질 폼입니다. -->
							<div class="form-group" style="margin-bottom:15px; padding-left: 20px">
								<!-- 기본이미지가 보여지는 곳이며, 검색 이후 검색된 이미지로 변경됩니다. -->
								<div class="col-lg-2" id="book_image_area">
									<img height=171px width=120px src="${requestScope.updateBvo.book_img}">
								</div>
								<div class="col-lg-10">
									<!-- 책제목 -->
									<div class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px" id="book_title_area">
										<input type="text" class="form-control" id="book_title" placeholder="${requestScope.updateBvo.book_title}">
									</div>
									<!-- 저자 -->
									<div class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px" id="book_author_area">
										<input type="text" class="form-control" id="author" placeholder="${requestScope.updateBvo.book_author}">
									</div>
									<!-- 출판사 -->
									<div class="col-lg-4" id="book_publisher_area"> 
										<input type="text" class="form-control" id="publisher" placeholder="${requestScope.updateBvo.book_publ}">
										 
									</div>
									<!-- 출판일자 -->
									<div class="col-lg-4" id="book_pubdate_area">
										<input type="text" class="form-control" id="pubdate" placeholder="${requestScope.updateBvo.book_sdate}">
										
									</div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px" id="book_description_area">
										<textarea class="form-control" rows="4" id="description" placeholder="책소개"
										 readonly="readonly" style="resize: none">${requestScope.updateBvo.book_intro}</textarea>
									</div>
								</div>
							</div>
							
							<!-- 한줄 메모의 성향을 선택할 공간 입니다. ltList-->
							<div class="bg-faded p-4 my-4">
								<div class="checkbox" style="padding-top: 0px"><h4>성향을 선택해주세요</h4>
									<c:forEach items="${requestScope.ultList}" var="tendList">
									<label><input type="checkbox" value="${tendList.tend_code}" name="tend_ck" id="tend_ck"> ${tendList.tend_name}</label>
									</c:forEach>
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
		<div class="row" style="text-align:center; margin-top: 50px; margin-bottom: 100px">
			<div class="col-lg-12">
				<button type="reset" class="btn btn-default" id="">수정 취소</button>
				<button type="submit" class="btn btn-primary" id="">수정 완료</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->