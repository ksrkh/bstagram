<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<script type="text/javascript">
		$(document).ready(function() {
			var book_title="";
			var book_author="";
			var book_publisher="";
			var book_pubdate="";
			var book_description="";
			var book_image="";
			
			
			
			
			$("#returnlist").click(function() {
				if(confirm("게시글을 작성을 취소하시겠습니까?")){
					location.href="DispatcherServlet?command=reviewboardlist";		
					}
			});//returnlist.click
			
			
			$("#reviewwrite").click(function(){
				var title = $("#review_title").val();
				var content = $("#review_content").val();
				var member_id=$(".write_id").attr("id");
				var genre = $("#select").val();
				
				var book_title_p=$("#book_title_area").text();
				var book_author_p=$("#book_author_area").text();
				var book_publisher_p=$("#book_publisher_area").text();
				var book_pubdate_p=$("#book_pubdate_area").text();
				var book_description_p=$("#book_description_area").text();
				var book_image_p=$(".book_search_thumnail").attr('src');
				
				if(title==""){
					alert("제목을 작성해주세요");
				}else if(content==""){
					alert("게시물을 작성해주세요");
				}else if(book_title_p == ""){
			         alert("도서 검색을 해주세요.");
			      }else if(content!=""&&title!=""){
					if(confirm("게시글을 작성하시겠습니까?")){			
//						var tt = book_title_p.replace('&',' ');
						
						location.href="DispatcherServlet?command=reviewwrite&review_title="+title
																		+"&review_content="+content
																		+"&review_genre="+genre
																		+"&member_id="+member_id
																		+"&review_book_title="+book_title_p
																		+"&review_author="+book_author_p
																		+"&review_publ="+book_publisher_p
																		+"&review_sdate="+book_pubdate_p
																		+"&review_book_img="+book_image_p
																		+"&review_book_description="+book_description_p;
					}
			}
				
				
				
			})//reviewwrite.click	
			
		})//ready
		
				
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
					<div class="form-horizontal"  id="review">
					<input type="hidden" name="command" value="reviewwrite">
					<div class="write_id" id="${sessionScope.member.id }"></div>
						<fieldset>
							<legend>독후감 작성</legend>
							<!-- 독후감 제목 -->
							<div class="form-group" style="margin-top: 20px; margin-bottom: 20px">
								<div class="col-lg-2" style="padding-right: 0px">
								
									<select class="form-control" id="select" name="review_genre">
									<c:forEach items="${requestScope.genreList}" var="genre">
										<option value="${genre.genre}">${genre.genre_name}</option>	
									</c:forEach>
									</select>
										
								</div>
								<div class="col-lg-10">
									<input type="text" class="form-control" maxlength="48" id="review_title" name="review_title" placeholder="독후감 제목">
								</div>
							</div>
							
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12">
									<strong><textarea style="resize:none; font-size:15px;" class="form-control ta" rows="20" id="review_content" name="review_content" placeholder="내용을 입력하세요."></textarea></strong>
						      	</div>
						    </div>
						    
							<!-- 책검색 -->
							<div class="form-group">
								<div class="col-lg-12">
									<div class="col-lg-11" style="margin-left: 0px; padding-left: 0px">
										<input type="text" class="form-control" name="book_search" id="book_search" placeholder="책을 검색해주세요.">
									</div>
									<div class="col-lg-1" style="margin-left: 0px; padding-left: 0px;margin-right: 0px; padding-right: 0px">
										<button type="button" class="btn btn-info" onclick="bookSearch()">책검색</button>
									</div>
								</div>
							</div>
							
							<!-- 책검색내용이 보여질 폼입니다. -->
							<div id="searchForm" class="form-group" style="display:none; margin-bottom:15px; padding-left: 20px">
								<!-- 기본이미지가 보여지는 곳이며, 검색 이후 검색된 이미지로 변경됩니다. -->
								<div class="col-lg-2" id="book_image_area">
									<img class="book_search_thumnail" height=171px width=120px src="">
								</div>
								<div class="col-lg-10">
									<!-- 책제목 -->
									<div id="book_title_area" class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px" ></div>
									<!-- 저자 -->
									<div id="book_author_area" class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px"></div>
									<!-- 출판사 -->
									<div id="book_publisher_area" class="col-lg-4"></div>
									<!-- 출판일자 -->
									<div id="book_pubdate_area" class="col-lg-4"></div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px" id="book_description_area"></div>
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
	
		<!-- 작성 버튼/취소 버튼 -->
		<div class="row" style="text-align:center; margin-top: 25px; margin-bottom: 50px">
			<div class="col-lg-12">
				<button type="button" class="btn btn-default" id="returnlist">작성 취소</button>
				<button type="button" class="btn btn-primary" id="reviewwrite">작성 완료</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->