<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function() {
	$("input[name=tend_ck]:checkbox").change(function() {
        if( $("input[name=tend_ck]:checkbox:checked").length==1) {
            $(":checkbox:not(:checked)").attr("disabled", "disabled");
        } else {
            $("input[name=tend_ck]:checkbox").removeAttr("disabled");
        }
    });//change
   
	$("#cancelBtn").click(function() {
		if(confirm("게시글을 작성을 취소하시겠습니까?")){
			location.href="DispatcherServlet?command=lineList";		
			}
	});//cancel click
	
	$("#writeLineBtn").click(function() {
		var content = $("#content").val();
		var tendComp=$("#writeForm :checkbox[name=tend_ck]:checked").val();
		if(content.length>110){
		alert("110자 이상은 입력하실 수 없습니다.");
		}else if(content==""){
			alert("게시물을 작성해주세요");
		}else if(tendComp.length==0){
			alert("하나의 성향을 선택해주세요.");
		}else if(content!=""){
			if(confirm("게시글을 작성하시겠습니까?")){
				location.href="DispatcherServlet?command=lineWrite&line_content="+content+"&tend_code="+tendComp;		
			}
	}
		
	}); //write click 
		//textarea 부분  $("#content").val()
});//ready
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
					<form class="form-horizontal" id="writeForm">
						<fieldset>
							<legend>책속의 한줄</legend>
							<!-- 내용 입력 부분 -->
							<div class="form-group" style="margin-top: 50px">
								<div class="col-lg-12">
									<textarea class="form-control ta" rows="15" id="content" placeholder="내용을 입력하세요." style="resize: none; background-image: url('img/write/write_bg6.jpg');"></textarea>
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
									<input type="password" class="form-control" id="book_search" placeholder="책 검색">
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
										<input type="text" class="form-control" id="book_title" placeholder="책제목" readonly="readonly" value="언어의온도">
									</div>
									<!-- 저자 -->
									<div class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px">
										<input type="text" class="form-control" id="author" placeholder="저자" readonly="readonly" value="이기주">
									</div>
									<!-- 출판사 -->
									<div class="col-lg-4"> 
										<input type="text" class="form-control" id="" placeholder="출판사" readonly="readonly" value="말글터">
									</div>
									<!-- 출판일자 -->
									<div class="col-lg-4">
										<input type="text" class="form-control" id="" placeholder="출판일자" readonly="readonly" value="2016.08.19">
									</div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px">
										<textarea class="form-control" rows="4" id="book_content" placeholder="책소개" readonly="readonly" style="resize: none">언어의 온도』의 저자 이기주는 엿듣고 기록하는 일을 즐겨 하는 사람이다. 그는 버스나 지하철에 몸을 실으면 몹쓸 버릇이 발동한다고 고백한다. 이 책은 저자가 일상에서 발견한 의미 있는 말과 글.  단어의 어원과 유래, 그런 언어가 지닌 소중함과 절실함을 농밀하게 담아낸 것이다.</textarea>
									</div>
								</div>
							</div>
							
							<!-- 한줄 메모의 성향을 선택할 공간 입니다. ltList-->
							<div class="bg-faded p-4 my-4">
								<div class="checkbox" style="padding-top: 0px"><h4>성향을 선택해주세요</h4>
									<c:forEach items="${requestScope.ltList}" var="tendList">
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
				<button type="reset" class="btn btn-default" id="cancelBtn">작성 취소</button>
				<button type="submit" class="btn btn-primary" id="writeLineBtn">작성 완료</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->