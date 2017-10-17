<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript">
$(document).ready(function(){	
	
	var page=1;
	$(function(){
		getList(page);
		page++;
	});
	
	$(window).scroll(function() {
		if($(window).scrollTop() >=$(document).height()-$(window).height()){
			getList(page);
			page++;
		}
	});
	
	function getList(page){
		$.ajax({
			type:"get",
			url:"DispatcherServlet",
			data:"command=pangingScroll&pageNo="+page,
			dataType:"json",
			success:function(data){
				if(page==1){
					$("#loading").html("로딩중입니다");					
				}
				var info="";
				var info="<tr>";
				info+="<td>"+data.ename+"</td>";
				
				if(page!=1){
					for(var i in data.list){
						
						info+="<tr>";
						info+="<td>"+data.list[i].nick+"</td>";
						info+="</tr>"
						
						$("#loading").append(info);	
						alert(page);
					 }
				}else{
					$("#loading").html("마지막 페이지 입니다");
				} 
				}
			 
			
		});//ajax
	}   
     $("#sympathy-click").click(function() {
     	alert("공감 upup");
     });//click 공감
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
		<div class="text-heading text-muted text-lg" id="pagin">Welcome To</div>
			<h1 class="my-2">Bookstagram</h1>
		</div>
	</div>
	<!-- 추후 For로 돌릴 공간. -->
	<c:forEach var="lvo" items="${requestScope.lineList.list}" varStatus="order">
	<c:set value="${lvo.board_no}"  var="p" />
	<div class="hover_no" id="${lvo.board_no}">
	<div class="bg-faded p-4 my-4"  id="line_board_btn">
		<div class="container">
		<c:if test="${lvo.id==sessionScope.member.id}">
			<div class="up_delete pull-right" style="margin-bottom:5px">				
				<a href="DispatcherServlet?command=lineUpdateView&boardNo=${lvo.board_no}&line_content=${lvo.line_content}&tend_code=${lvo.tend_code}"
				 onclick="javascript:return confirm('정말 수정하시겠습니까?')"><i class="fa fa-cog fa-spin" style="font-size:25px;" id="lineUpdateBtn"></i></a>
			    <a href="DispatcherServlet?command=lineDelete&boardNo=${lvo.board_no}" onclick="javascript:return confirm('정말 삭제하시겠습니까?')"><i class="fa fa-trash-o" style="font-size:25px;" id="lineDeleteBtn"></i></a>
			</div>
		</c:if> 
			<blockquote class="quote-box" style="background-color: #2d2d2d;">
				<p class="quotation-mark" style="margin-bottom:20px">
					“
				</p>
				<c:choose>
					<c:when test="${sessionScope.member!=null}">
						<p class="quote-text" id="line_content_login">
							${lvo.line_content}
						</p>
					</c:when>
					<c:otherwise>
						<p class="quote-text" id="line_content">
							${lvo.line_content}
						</p>
					</c:otherwise>
				</c:choose>
				<hr>
				<div class="blog-post-actions">
					<p class="blog-post-bottom pull-left" id="line_nick">
						${lvo.nick}
					</p>
					<p class="blog-post-bottom pull-right">
						       <a href="#"><img src="icon_img/like0.png"></a> 
						       <a href="#"><img src="icon_img/like1.png"></a>  		
						<span class="badge quote-badge">${lvo.sympathy}</span>
					</p>
				</div>
			</blockquote>
		</div>
	</div>
	</div>
	</c:forEach>
	 <div id="loading"></div>
</div>
<!-- /.container -->