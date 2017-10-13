<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript">
$(document).ready(function(){
                    lastPostFunc();
                $(window).scroll(function(){
                    if($(window).scrollTop() == $(document).height() - $(window).height()){
                            lastPostFunc();
                        }
                    });
			var start=0;
            var last=10;   
            function lastPostFunc(){
                $.post("파일경로", {start:start, last:last}, function(data){
                                $("#paginScroll").append(data);
                                start += last;
                     });
            }
     $("#sympathy-click").click(function() {
     	alert("공감 upup");
     });//click 공감
/*     $("#detail_view_click").click(function() {
     	alert("로그인 해주세요");
    	
	}); */
	$("#lineDeleteBtn").click(function() {
		if(confirm("정말 삭제하시겠습니까?")){
			alert("asd");
			location.href="DispatcherServlet?command=lineDetail";	
			}
	});
	$("#lineUpdateBtn").click(function() {
		if(confirm("정말 수정하시겠습니까?")){
				location.href="";	
			}
	}); 
});//ready
</script>
<style type="text/css">
	a:link{text-decoration:none;}
	a:hover{color:#cc3300;}
	a:active{color:#ff00cc;text-decoration:none;}
</style> 
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
	
		One-Line-Memo
	<c:if test="${sessionScope.member!=null}">
	<button type="button" class="btn btn-primary linememo_write" >글쓰기</button>
	</c:if>
	</div>
	  
	  
	<div class="bg-faded p-4 my-4">
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			
			<div class="carousel-inner" role="listbox">
				<div class="carousel-item active">
					<img class="d-block img-fluid w-100" src="img/1.jpg" alt="">
				</div>
			
				<div class="carousel-item">
					<img class="d-block img-fluid w-100" src="img/2.jpg" alt="">
				</div>
				
				<div class="carousel-item">
					<img class="d-block img-fluid w-100" src="img/3.jpg" alt="">
				</div>
			</div>
			
			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		
		<!-- Welcome Message -->
		<div class="text-center mt-4">
		<div class="text-heading text-muted text-lg">Welcome To</div>
			<h1 class="my-2">Bookstagram</h1>
		</div>
	</div>
	<!-- 추후 For로 돌릴 공간. -->
	<c:forEach var="lvo" items="${requestScope.lineList}">
	<div class="bg-faded p-4 my-4"  id="line_board_btn">
	<div class="up_delete pull-right">
	<a href=""><i class="fa fa-cog fa-spin" style="font-size:25px;" id="lineUpdateBtn"></i></a>
    <a href=""><i class="fa fa-trash-o" style="font-size:25px;" id="lineDeleteBtn"></i></a>
	</div>
		<div class="container" >
			<blockquote class="quote-box" style="background-color: #4ADFCC;">
				<p class="quotation-mark">
					“
				</p>
				<c:choose>
				<c:when test="${sessionScope.member!=null}">
				<p class="quote-text">
					<a href="DispatcherServlet?command=lineDetail&boardNo=${lvo.board_no}">${lvo.line_content}</a>
				</p>
				</c:when>
				<c:otherwise>
				<p class="quote-text">
				${lvo.line_content}
				</p>
				</c:otherwise>
				</c:choose>
				<hr>
				
				<div class="blog-post-actions" >
					<p class="blog-post-bottom pull-left">
						${lvo.nick}
					</p>
					<p class="blog-post-bottom pull-right">
						<i class="fa fa-heart" id="sympathy-click" style="font-size:20px;color:red"></i><span class="badge quote-badge" style="height:25px; width:50px; text-center;">${lvo.hit}</span>
					</p>
				</div>
			</blockquote>
		</div>
	</div>
</c:forEach>
</div>
<!-- /.container -->