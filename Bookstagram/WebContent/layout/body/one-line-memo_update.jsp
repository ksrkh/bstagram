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
    	$("#updateCancelBtn").click(function() {
    		if(confirm("게시글을 수정을 취소하시겠습니까?")){
    			alert("게시글 수정이 취소되었습니다");
    			location.href="DispatcherServlet?command=lineList";		
    			}
    	});//cancelClick
    	$("#updateBtn").click(function() {
    		var board_no=$(".update_no").attr("id");  
			var line_content=$("#up_content").val();
			var tendComp= $("input[name=tend_ck]:checkbox:checked").length;
			var tendCode= $("input[name=tend_ck]:checkbox:checked").val();
    		
    		if(line_content == ""){
				alert("게시물을 작성해주세요");
			}else if(tendComp == 0){
				alert("하나의 성향을 선택해주세요.");
			}else if(confirm("게시글을 수정하시겠습니까?")){
	    		alert("게시글이 수정되었습니다.")
    			location.href="DispatcherServlet?command=lineUpdate&boardNo="+board_no
    					+"&line_content="+line_content+"&tend_code="+tendCode;
    		}
    	});//updatclick
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
					<div class="form-horizontal">
						<fieldset>
							<legend>책속의 한줄</legend>
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12">
									<textarea class="form-control ta" rows="5" id="up_content" style="resize: none">${requestScope.lvo.line_content}</textarea>											
						      	</div>
						    </div>
							

							<!-- 책검색내용이 보여질 폼입니다. -->
							<div id="searchForm" class="form-group" style="display:block; margin-bottom:15px; padding-left: 20px">
								<!-- 기본이미지가 보여지는 곳이며, 검색 이후 검색된 이미지로 변경됩니다. -->
								<div class="col-lg-2" id="book_image_area">
									<img class="book_search_thumnail" height=171px width=120px src="${requestScope.updateBvo.book_img}">
								</div>
								<div class="col-lg-10">
									<!-- 책제목 -->
									<div id="book_title_area" class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px" >
									${requestScope.updateBvo.book_title}
									</div>
									<!-- 저자 -->
									<div id="book_author_area" class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px">
									${requestScope.updateBvo.book_author}
									</div>
									<!-- 출판사 -->
									<div id="book_publisher_area" class="col-lg-4">
									${requestScope.updateBvo.book_publ}
									</div>
									<!-- 출판일자 -->
									<div id="book_pubdate_area" class="col-lg-4">
									${requestScope.updateBvo.book_sdate}</div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px" id="book_description_area">
									${requestScope.updateBvo.book_intro}
									</div>
								<div class="updat_no" id="${requestScope.lvo.board_no}"></div>
								</div>
							</div>
							
							<!-- 한줄 메모의 성향을 선택할 공간 입니다. ltList-->
							<div class="bg-faded p-4 my-4">
								<div class="checkbox" style="padding-top: 0px"><h4>성향을 선택해주세요</h4>
									<c:forEach items="${requestScope.ultList}" var="tendList">
										<c:choose>
											<c:when test="${requestScope.lvo.tend_code == tendList.tend_code}">
												<label><input type="checkbox" value="${tendList.tend_code}" name="tend_ck" id="tend_ck" checked="checked"> ${tendList.tend_name}</label>
											</c:when>
											<c:otherwise>
												<label><input type="checkbox" value="${tendList.tend_code}" name="tend_ck" id="tend_ck" disabled="disabled"> ${tendList.tend_name}</label>
											</c:otherwise>	
										</c:choose>
									</c:forEach>
								</div>
							</div>
							
							<input id="searchbook" type="hidden" name="command" value="searchbook">
						</fieldset>
					</div>
					</div>
					<div class="col-lg-1"></div>
				</div>
			</div>
		</div>
		
		<!-- 작석 버튼/취소 버튼 -->
		<div class="row" style="text-align:center; margin-top: 50px; margin-bottom: 100px">
			<div class="col-lg-12">
				<div class="update_no" id="${requestScope.lvo.board_no}"></div>
				<button type="reset" class="btn btn-default" id="updateBtn" onclick="">수정 완료</button>
				<button type="button" class="btn btn-primary" id="updateCancelBtn">수정 취소</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->