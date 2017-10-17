<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
    $(document).ready(function(){	
    	function getPageList(board_no,member_id,line_content,nick){
    		info="<div class='bg-faded p-4 my-4'>";
    		info+="<div class='container'>";
    		info+="<blockquote class='quote-box' style='background-color: #4ADFCC;'>";
    		info+="<p class='quotation-mark'>";
    		info+="“";
    		info+="</p>";
    		info+="<p class='quote-text'>";
    		info+=line_content;
    		info+="</p>";
    		info+="<hr>";		
    		info+="<div class='blog-post-actions'>";
    		info+="<p class='blog-post-bottom pull-left'>";
    		info+=nick;
    		info+="</p>";
    		info+="<p class='blog-post-bottom pull-right'>";
    		info+="<span class='badge quote-badge'>";
    		info+="896</span> ❤";
    		info+="</p>";
    		info+="</div>";
    		info+="</blockquote>";
    		info+="</div>";
    		info+="</div>";
    		return info;
    	}
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
    			data:"command=pangingScroll&reviewpageNo="+page,
    			dataType:"json",
    			success:function(data){
    			/* 	if(page==1){
    					$("#loading").html("로딩중입니다");					
    				} */
    				var board_no="";
    				var member_id="";
    				var content="";
    				var nick="";
    				var page_f="";
    				if(page!=1){
    					for(var i in data.list){
    						board_no=data.list[i].board_no;
    						member_id=data.list[i].id;
    						line_content=data.list[i].line_content;
    						nick=data.list[i].nick;
    						page_f=getPageList(board_no,member_id,line_content,nick);
    						$("#loading").append(page_f);	
    					 }
    					} 
    				}	
    		});
    		
    	}
    
</script>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		Book-Review
	<c:if test="${sessionScope.member!=null}">
	<button type="submit" class="btn btn-primary bookreview_write">글쓰기</button>
	</c:if>
	</div>
	  
	<!-- start 추후 For로 돌릴 공간. -->
	<c:forEach items="${requestScope.reviewlist}"  var="review">
	<div class="bg-faded p-4 my-4">
		<div class="container">
		<div class="col-sm-2">
			<div style="display: block; float: left">
				<img height=171px width=120px src="https://search.pstatic.net/common/?src=http%3A%2F%2Fbookthumb.phinf.naver.net%2Fcover%2F109%2F245%2F10924505.jpg">
			</div>
			</div>
			<div class="col-sm-10">
				
					<h3 style="margin-top: 3px; margin-bottom:5px">
					<c:choose>
							<c:when test="${sessionScope.member!=null}">
							<div style="float: left; margin-left: 5px">
					<strong>
							<a href="DispatcherServlet?command=reviewdetail&review_no=${review.board_no}&id=${sessionScope.member.id}">${review.review_title}</a>
					</strong>
						</div>
							 <font style="float: right; " size="2">조회수&nbsp;&nbsp; ${review.hit} </font>
							</c:when>
							<c:otherwise>
					<strong>${review.review_title} </strong>
					 <font style="float: right; " size="2">조회수&nbsp;&nbsp; ${review.hit} </font>
							</c:otherwise>
					</c:choose>		
					</h3>
					<!-- 줄을 넘기지 않고 예쁘게 보여줘야 합니다. 글자수 70~75자   줄수 4줄, -->
					<br><br><div>${review.review_content }</div>
						<div style="float: bottom; margin-top: 5px">
					<h4><strong>${review.bookVO.book_title}</strong></h4>
					<div style="float: left"><strong>${review.bookVO.book_author} </strong> | ${review.bookVO.book_publ} | ${review.bookVO.book_sdate}</div>
					<div style="float: right"> 작성자 | ${review.nick } |</div>
					</div>
			</div>
		</div>
	</div>
	</c:forEach>
	<!-- end 추후 For로 돌릴 공간. -->
</div>
<!-- /.container -->