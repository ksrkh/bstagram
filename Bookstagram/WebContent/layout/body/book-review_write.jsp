<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<script type="text/javascript">
		function search(){
			alert(document.insertForm.book_search.value);
			var book = document.insertForm.book_search.value;
			$.ajax({
				type:"get",
				url: "DispatcherServlet",
				data:"command=searchbook&book_search="+book,
				dataType:"json",
				success:function(data){//data로 서버의 응답 정보가 들어온다.
					alert(data);
					$("#book_intro").html(data);
				}			
			});
	}			
</script>
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
					<form class="form-horizontal"  id="insertreview" action="DispatcherServlet" method="post" name="insertForm">
					<input type="hidden" name="command" value="reviewwrite">
						<fieldset>
							<legend>독후감 작성</legend>
							<!-- 독후감 제목 -->
							<div class="form-group" style="margin-top: 20px; margin-bottom: 20px">
								<div class="col-lg-2" style="padding-right: 0px">
									<select class="form-control" id="select" name="tend_code">
										<option value="1">소설</option>
										<option value="2">에세이/시</option>
										<option value="3">경영/경제</option>
										<option value="4">자기계발</option>
										<option value="5">인문/사회/역사</option>
										<option value="6">건강/다이어트</option>
										<option value="7">가정/생활</option>
										<option value="8">종교</option>
										<option value="9">여행</option>	
									</select>
								</div>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="title" name="title" placeholder="독후감 제목">
								</div>
							</div>
							
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12">
									<textarea class="form-control ta" rows="30" id="content" placeholder="내용을 입력하세요."></textarea>
						      	</div>
						    </div>
						    
						    <!-- 배경 선택 부분 -->
						    <!-- 2차구현 예정입니다. -->
							<div class="bg-faded p-4 my-4 form-group" style="margin-left: 0px;margin-right: 0px">
							    <div class="col-lg-12" style="margin-top: 5px; text-align: center">
								    <div class="radio" style="padding-top: 0px; padding-bottom: 0px">
								    	<label><input type="radio" name="content_bg" id="radio_bg1" value="content_bg1">색상으로 하기</label>
								    	<label><input type="radio" name="content_bg" id="radio_bg2" value="content_bg2">이미지로 하기</label>
								    	<label><input type="radio" name="content_bg" id="radio_bg3" value="content_bg3" checked="checked">선택안함</label>
								    </div>
							    </div>
						    </div>
							
							<!-- 독후감의 배경 템플릿 입니다. -->
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
									<input type="text" class="form-control" name="book_search" id="book_search" placeholder="책 검색" onkeypress="if(event.keyCode==13) {search(); return false;}">
								</div>
							</div>
							
							<!-- 책검색내용이 보여질 폼입니다. -->
							<div class="form-group" style="margin-bottom:15px; padding-left: 20px">
								<!-- 기본이미지가 보여지는 곳이며, 검색 이후 검색된 이미지로 변경됩니다. -->
								<div class="col-lg-2">
									<img height=171px width=120px src="https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg">
								</div>
								<div class="col-lg-10">
									<!-- 책제목 -->
									<div class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px">
										<input type="text" class="form-control" id="book_title" placeholder="책제목" readonly="readonly" value="">
									</div>
									<!-- 저자 -->
									<div class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px">
										<input type="text" class="form-control" id="author" placeholder="저자" readonly="readonly" value="">
									</div>
									<!-- 출판사 -->
									<div class="col-lg-4"> 
										<input type="text" class="form-control" id="publ" placeholder="출판사" readonly="readonly" value="">
									</div>
									<!-- 출판일자 -->
									<div class="col-lg-4">
										<input type="text" class="form-control" id="sdate" placeholder="출판일자" readonly="readonly" value="">
									</div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px">
										<textarea class="form-control" rows="4" id="book_intro" placeholder="책소개" readonly="readonly" style="resize: none"></textarea>
									</div>
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
		<div class="row" style="text-align:center; margin-top: 25px; margin-bottom: 50px">
			<div class="col-lg-12">
				<button type="button" class="btn btn-default">작성 취소</button>
				<button type="button" class="btn btn-primary"  form="insertreview">작성 완료</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->