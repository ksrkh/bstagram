<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function() {	
	var book_title="";
	var book_author="";
	var book_publisher="";
	var book_pubdate="";
	var book_description="";
	var book_image="";
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
		var member_id=$(".write_id").attr("id");
		if(content.length>110){
		alert("110자 이상은 입력하실 수 없습니다.");
		}else if(content==""){
			alert("게시물을 작성해주세요");
		}else if(tendComp.length==0){
			alert("하나의 성향을 선택해주세요.");
		}else if(content!=""){
			if(confirm("게시글을 작성하시겠습니까?")){					
				var book_title_p="";
				var book_author_p="";
				var book_publisher_p="";
				var book_pubdate_p="";
				var book_description_p="";
				var book_image_p="";
				for(var i=0;i<book_title.length;i++){
					book_title_p+=book_title[i];
				}
				for(var i=0;i<book_author.length;i++){
					book_author_p+=book_author[i];
				}
				for(var i=0;i<book_publisher.length;i++){
					book_publisher_p+=book_publisher[i];
				}
				for(var i=0;i<book_pubdate.length;i++){
					book_pubdate_p+=book_pubdate[i];
				}
				for(var i=0;i<book_description.length;i++){
					book_description_p+=book_description[i];
				}
				for(var i=0;i<book_image.length;i++){
					book_image_p+=book_image[i];
				}
				location.href="DispatcherServlet?command=lineWrite&line_content="+content+"&tend_code="+tendComp
						+"&member_id="+member_id+"&book_title="+book_title_p+"&book_author="+book_author_p
						+"&book_publisher="+book_publisher_p+"&book_pubdate="+book_pubdate_p
						+"&book_img="+book_image_p		
						+"&book_description="+book_description_p;
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
							<!-- 책검색 -->
							<div class="form-group">
								<div class="col-lg-12">
									<input type="text" class="form-control" name="book_search" id="book_search" placeholder="책 검색">
								</div>
							</div>
							
							<!-- 책검색내용이 보여질 폼입니다. -->
							<div id="searchForm" class="form-group" style="display:none; margin-bottom:15px; padding-left: 20px">
								<!-- 기본이미지가 보여지는 곳이며, 검색 이후 검색된 이미지로 변경됩니다. -->
								<div class="col-lg-2" id="book_image_area">
									<img height=171px width=120px src="https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg">
								</div>
								<div class="col-lg-10">
									<!-- 책제목 -->
									<div class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px" id="book_title_area">
										<input type="text" class="form-control" id="book_title" placeholder="책제목" readonly="readonly">
									</div>
									<!-- 저자 -->
									<div class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px" id="book_author_area">
										<input type="text" class="form-control" id="author" placeholder="저자" readonly="readonly" value="이기주">
									</div>
									<!-- 출판사 -->
									<div class="col-lg-4" id="book_publisher_area"> 
										<input type="text" class="form-control" id="publisher" placeholder="출판사" readonly="readonly" value="말글터">
									</div>
									<!-- 출판일자 -->
									<div class="col-lg-4" id="book_pubdate_area">
										<input type="text" class="form-control" id="pubdate" placeholder="출판일자" readonly="readonly" value="2016.08.19">
									</div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px" id="book_description_area">
										<textarea class="form-control" rows="4" id="description" placeholder="책소개" readonly="readonly" style="resize: none"></textarea>
									</div>
								</div>
							</div>
							
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12">
									<textarea class="form-control ta" rows="5" id="content" placeholder="내용을 입력하세요." style="resize: none"></textarea>
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
				<div class="write_id" id="${sessionScope.member.id }"></div>
				<button type="reset" class="btn btn-default" id="cancelBtn" onclick="">작성 취소</button>
				<button type="submit" class="btn btn-primary" id="writeLineBtn">작성 완료</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->