<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<script type="text/javascript">
		$(document).ready(function(){			
			$("#returnlist").click(function() {
				if(confirm("게시글을 작성을 취소하시겠습니까?")){
					location.href="DispatcherServlet?command=reviewboardlist";		
					}
			});//returnlist.click
			
			$("#reviewupdate").click(function(){
				var boardNo = $("#board_no").val();
				var title = $("#review_title").val();
				var content = $("#review_content").val();
				var genre = $("#select").val();
				if(title==""){
					alert("제목을 작성해주세요");
				}else if(content==""){
					alert("게시물을 작성해주세요");
				}else if(content!=""&&title!=""){
					if(confirm("게시글을 작성하시겠습니까?")){			
					location.href="DispatcherServlet?command=reviewupdate&board_no="+boardNo+"&review_title="+title+"&review_content="+content+"&review_genre="+genre;
					}
				}
				})//reviewupdate
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
					<div class="form-horizontal"  id="review" >
					
						<fieldset>
							<legend>독후감 작성</legend>
							<!-- 독후감 제목 -->
							<div class="form-group" style="margin-top: 20px; margin-bottom: 20px">
								<div class="col-lg-2" style="padding-right: 0px">
								
									<select class="form-control" id="select" name="review_genre">
											<c:forEach items="${requestScope.genreList}" var="genre">
													<c:choose>
														<c:when test="${genre.genre == requestScope.review_update.genre}">
															<option value="${genre.genre}" selected="selected">${genre.genre_name}</option>	
														</c:when>
														<c:otherwise>
															<option value="${genre.genre}">${genre.genre_name}</option>	
														</c:otherwise>
													</c:choose>
											</c:forEach>
									</select>
									
								</div>
								<div class="col-lg-10">
									<input type="text" class="form-control" maxlength="48"  id="review_title" name="review_title" placeholder="독후감 제목" value="${requestScope.review_update.review_title }">
								</div>
							</div>
							
							<!-- 내용 입력 부분 -->
							<div class="form-group">
								<div class="col-lg-12">
									<strong><textarea style="resize:none; font-size:15px;" class="form-control ta" rows="20" id="review_content" name="review_content" placeholder="내용을 입력하세요.">${requestScope.review_update.review_content }</textarea></strong>
						      	</div>
						    </div>
							
					
							
							<!-- 기존책내용이 보여질 폼입니다. -->
							<div id="searchForm" class="form-group" style="display:block; margin-bottom:15px; padding-left: 20px">
								<!-- 기본이미지가 보여지는 곳이며, 검색 이후 검색된 이미지로 변경됩니다. -->
								<div class="col-lg-2" id="book_image_area">
									<img class="book_search_thumnail" height=171px width=120px src="${requestScope.review_update.bookVO.book_img}">
								</div>
								<div class="col-lg-10">
									<!-- 책제목 -->
									<div id="book_title_area" class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px" >${requestScope.review_update.bookVO.book_title }</div>
									<!-- 저자 -->
									<div id="book_author_area" class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px">${requestScope.review_update.bookVO.book_author }</div>
									<!-- 출판사 -->
									<div id="book_publisher_area" class="col-lg-4">${requestScope.review_update.bookVO.book_publ }</div>
									<!-- 출판일자 -->
									<div id="book_pubdate_area" class="col-lg-4">${requestScope.review_update.bookVO.book_sdate }</div>
									<!-- 책소개 -->
									<div class="col-lg-12" style="padding-left: 0px" id="book_description_area">${requestScope.review_update.bookVO.book_intro }</div>
								</div>
							</div>
							<input id="searchbook" type="hidden" name="command" value="searchbook">
							<input type="hidden" id="board_no" value="${requestScope.review_update.board_no}">
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
				<button type="button" class="btn btn-default"  id="returnlist">수정 취소</button>
				<button type="button" class="btn btn-primary"  id="reviewupdate">수정 완료</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->