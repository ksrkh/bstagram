<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript">
	function deleteLine(boardNo){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제가 완료 되었습니다");
			location.href="DispatcherServlet?command=lineDelete&boardNo="+boardNo;
		}
	}
	function updateLine(boardNo,line_content,tend_code){
		if(confirm("정말로 수정하시겠습니가?")){
		 	alert("수정페이지로 이동하겠습니다");
		 	location.href="DispatcherServlet?command=lineUpdateView&boardNo="+boardNo;
		}
	}
	
$(document).ready(function(){
	
	var sId=$(".idCheck").attr("id");
	function getPageList(board_no,member_id,line_content,nick,tend_code,
		mySympathy,sympathy,book_title,book_intro,book_author,book_publ,
		book_sdate,book_img){
		  var info="<div class='bg-faded p-4 my-4'>";
	      
		  info+="<div class='container'>";
	      if(member_id==sId){
		      info+="<div class='up_delete pull-right' style='margin-bottom:5px'>";
		      info+="<a href=";
		      info+="DispatcherServlet?command=lineUpdateView&boardNo=";
		      info+=board_no;
		      info+=" onclick='javascript:return confirm('";
		      info+="정말 수정하시겠습니까 ?')'>";
		      info+="<i class='fa fa-cog fa-spin' style='font-size:25px;' id='lineUpdateBtn'></i>";
		      info+="</a>";
		      info+="<a href=";
		      info+="DispatcherServlet?command=lineDelete&boardNo=";
		      info+=board_no;
		      info+=" onclick="
		      info+=" javascript:return confirm('정말 삭제하시겠습니까?')>";
		      info+="<i class='fa fa-trash-o' style='font-size:25px;' id='lineDeleteBtn'></i>";
		      info+="</a>"
		      info+="</div>";
	      }
	      info+="<div class='bg-faded p-4'  id='line_board_btn' data-toggle='collapse' data-target='#demo"; //toggle할 div 영역 잡아주고  target 설정 '#demo'로 설정해두었음
	      info+=board_no;
	      info+="'style='margin-top: 30px'>";
	      info+="<blockquote class='quote-box' style='background-color: #2d2d2d;'>";
	      info+="<p class='quotation-mark'>";
	      info+="“";
	      info+="</p>";   
	      info+="<p class='quote-text' id='line_content_login'>";
	      info+=line_content;
	      info+="</a>";
	      info+="</p>";
	      info+="<hr>";      
	      info+="<div class='blog-post-actions'>";
	      info+="<p class='blog-post-bottom pull-left'>";
	      info+=nick;
	      info+="</p>";
	      info+="<p class='blog-post-bottom pull-right' id='symapthy_plus'>";
	      
	      if(mySympathy==0){
		      info+="<img src='icon_img/like0.png' class='sympathy_img' id='";
		      info+=board_no; 
		      info+="' alt='' style='height:20px; width:20px; cursor: pointer'>";   
	      }else{
		      info+="<img src='icon_img/like1.png' class='sympathy_img' id='";
		      info+=board_no;
		      info+="' alt='' style='height:20px; width:20px; cursor: pointer'>";
	      }
	      
	      info+="<span id='sympathy_count";
		  info+=board_no;
		  info+="' class='badge quote-badge'>";
		  info+=sympathy;
		  info+="</span>";
	      info+="</p>";
	      info+="</div>";
	      info+="</blockquote>";                  
	      info+="<div id='demo";  //target toggle start
	      info+=board_no;
	      info+="' class='collapse' style='background-color: white; height:171px'>";                                             
	      info+="<div class='col-lg-2' id='book_image_area'>"; //책이미지 첫지점
		  info+="<img class='book_search_thumnail' height=171px width=120px src='";
		  info+=book_img;
		  info+="'>";
		  info+="</div>";
		  info+="<div class='col-lg-10'>";
		  info+="<div id='book_title_area' class='col-lg-12' style='padding-left: 0px; margin-bottom: 10px' >";
		  info+=book_title;
		  info+="</div>";
		  info+="<div id='book_author_area' class='col-lg-4' style='padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px'>";
		  info+=book_author;
		  info+="</div>";
		  info+="<div id='book_publisher_area' class='col-lg-4'>";
		  info+=book_publ;
		  info+="</div>";
		  info+="<div id='book_pubdate_area' class='col-lg-4'>";
		  info+=book_sdate;
		  info+="</div>";
		  info+="<div class='col-lg-12' style='padding-left: 0px' id='book_description_area'>";
		  info+=book_intro;
		  info+="</div>";
		  info+="</div>"; //책정보끝지점     
	      info+="</div>"; //target toggle close
	      info+="</div>"; //토글 영역
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
 			if(totalPage<startRowNumber){
 				alert("마지막 페이지입니다");
 				return false;
 			}
			getList(page);
			page++;
		}
	});
	var startRowNumber="";
	var totalPage="";
	function getList(page){
		$.ajax({
			type:"get",
			url:"DispatcherServlet",
			data:"command=pangingScroll&pageNo="+page,
			dataType:"json",
			success:function(data){
				startRowNumber=data.pagingBean.startRowNumber;
				totalPage=data.pagingBean.totalPage;
				var board_no="";
				var member_id="";
				var content="";
				var nick="";
				var tend_code="";
				var page_f="";
				var book_title="";
				var	book_intro="";
				var book_author="";
				var book_publ="";
				var book_sdate="";
				var book_img="";
				var mySympathy="";
				if(page==1){
			 		$("#loading").html("");
				} else if(page!=1){
					for(var i in data.list){						
						board_no=data.list[i].board_no;
						member_id=data.list[i].id;
						line_content=data.list[i].line_content;
						nick=data.list[i].nick;
						tend_code=data.list[i].tend_code;
						mySympathy=data.list[i].mySym;
						sympathy=data.list[i].sympathy;
						book_title=data.list[i].bookVO.book_title;
						book_intro=data.list[i].bookVO.book_intro;
						book_author=data.list[i].bookVO.book_author;
						book_publ=data.list[i].bookVO.book_publ;
						book_sdate=data.list[i].bookVO.book_sdate;
						book_img=data.list[i].bookVO.book_img;
						page_f=getPageList(board_no,member_id,line_content,nick,tend_code,
								mySympathy,sympathy,book_title,book_intro,book_author,book_publ,
								book_sdate,book_img);	
						$("#loading").append(page_f);	
					 }
				}		 
			} 		
			});//ajax
		
	} 
	//이미지 고정 이미지값
	  $(".sympathy_img").click(function() {
	       var id='${sessionScope.member.id}';
	       var sdf =$(".badge quote-badge").attr("id")          
	       if(id!=''){
	         var src=($(this).attr('src')==='icon_img/like0.png')
	            ?'icon_img/like1.png'
	            :'icon_img/like0.png'
	            $(this).attr('src',src);
	         id='${sessionScope.member.id}';
	         
	         var board_no=$(this).attr('id');
	         $.ajax({
		          type:"get",
		          url:"DispatcherServlet",
		          data:"command=sympathyService&id="+id+"&board_no="+board_no,
		          success:function(data){
		             $("#sympathy_count"+board_no).text(data);
		          }
	          });//ajax
	       }//if   
	   });//click 
		
	    //동적으로 생성되는 이미지 값 클릭
		$("#loading").on("click",".sympathy_img",function(){		
			var id='${sessionScope.member.id}';
		       if(id!=''){
		         var src=($(this).attr('src')==='icon_img/like0.png')
		            ?'icon_img/like1.png'
		            :'icon_img/like0.png'
		            $(this).attr('src',src);
		         id='${sessionScope.member.id}';
		         var board_no=$(this).attr('id');		   		         
		         $.ajax({
			        type:"get",
			        url:"DispatcherServlet",
			       	data:"command=sympathyService&id="+id+"&board_no="+board_no,
		         	success:function(data){
		            		$("#sympathy_count"+board_no).text(data);
		          	}
		     	 });//ajax
		   	  }//if   
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
	<div class="idCheck" id="${sessionScope.member.id}"></div>
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
		<div class="bg-faded p-4"  id='line_board_btn' data-toggle="collapse" data-target="#demo${lvo.board_no}" style="margin-top: 30px"> 
					<blockquote class="quote-box" style="background-color: #2d2d2d;">
						<p class="quotation-mark" style="margin-bottom:20px">
							“
						</p>
						<p class="quote-text" id="line_content">
						${lvo.line_content}
						</p>
						<hr>
						<div class="blog-post-actions">
							<p class="blog-post-bottom pull-left" id="line_nick">
								${lvo.nick}
							</p>
		                     <p class="blog-post-bottom pull-right">
		                     <c:choose>
		                     <c:when test="${lvo.mySympathy==0}">
		                        <img src="icon_img/like0.png" class="sympathy_img"id="${lvo.board_no}" alt="" style="height:20px; width:20px; cursor: pointer" >
		                     </c:when>
		                     <c:otherwise>
		                       <img src="icon_img/like1.png" class="sympathy_img"id="${lvo.board_no}" alt="" style="height:20px; width:20px; cursor: pointer" >
		                     </c:otherwise>
		                     </c:choose>       
		                  <span id="sympathy_count${lvo.board_no}" class="badge quote-badge">${lvo.sympathy}</span>
		               </p>
						</div>
					</blockquote>
					<div id="demo${lvo.board_no}" class="collapse" style="background-color: white; height:171px">			
					<div class="col-lg-2" id="book_image_area">
						<img class="book_search_thumnail" height=171px width=120px src="${lvo.bookVO.book_img}">
					</div>
					<div class="col-lg-10">
							<!-- 책제목 -->
							<div id="book_title_area" class="col-lg-12" style="padding-left: 0px; margin-bottom: 10px" >${lvo.bookVO.book_title}</div>
							<!-- 저자 -->
							<div id="book_author_area" class="col-lg-4" style="padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px">${lvo.bookVO.book_author}</div>
							<!-- 출판사 -->
							<div id="book_publisher_area" class="col-lg-4">${lvo.bookVO.book_publ}</div>
							<!-- 출판일자 -->
							<div id="book_pubdate_area" class="col-lg-4">${lvo.bookVO.book_sdate}</div>
							<!-- 책소개 -->
							<div class="col-lg-12" style="padding-left: 0px" id="book_description_area">${lvo.bookVO.book_intro}</div>
					</div>                   
	      	</div>                                                                    
	     </div>
		</div>
	</div>
	</div>
	</c:forEach>
	 <div id="loading"></div>
</div>
<!-- /.container -->