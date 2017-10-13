<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("deleteMember").click(function() {
		return confirm("회원 탈퇴하시겠습니까?");
	});
});
</script> 
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
		<div class="row" style="margin-top: 0px; padding-top: 0px">
			<div class="col-lg-12">
				
				<div class="col-lg-4" >
							<div class="col-lg-12">
								<div class="m_container">
										<div class="bg-faded p-4 my-4">
										<div class="text-center mt-4">
										<h4 class="my-2">내 정보</h4>
										</div>
								<div class="col-lg-4" >
								<img class="d-block img-fluid w-100" src="img/users.png" alt="" style="height:80px; width:100px">		
								</div>
											<h5>아이디:${sessionScope.member.id}</h5>
											<h5>닉네임:${sessionScope.member.nick}</h5> 
											<h5>나이: ${sessionScope.member.age}</h5> 
											<h5>가입일자: ${sessionScope.member.regdate}</h5> 
							</div>
						</div>
				</div>
				</div>
				
				
				<div class="col-lg-4" >
							<div class="col-lg-12">
								<div class="m_container">
										<div class="bg-faded p-4 my-4">
										<div class="text-center mt-4">
										<h4 class="my-2">회원 정보 수정</h4>
										</div>
								<a href="${pageContext.request.contextPath}/DispatcherServlet?command=updateMemberInfo">
								<img class="d-block img-fluid w-100" src="img/001-user.png" alt="" style="height:80px; width:70px; padding-left:90px; padding-right:90px">
								</a>	
									&nbsp;
				</div>
				</div>
				</div>
				</div>
				
				
				<div class="col-lg-4" >
							<div class="col-lg-12">
								<div class="m_container">
										<div class="bg-faded p-4 my-4">
										<div class="text-center mt-4">
										<h4 class="my-2">회원 탈퇴</h4>
										</div>
								<a href="${pageContext.request.contextPath}/DispatcherServlet?command=deleteMemberInfo&id=${sessionScope.member.id}">
								<img id="deleteMember" class="d-block img-fluid w-100" src="img/002-user-1.png" alt="" style="height:80px; width:70px; padding-left:90px; padding-right:90px">
								</a>
									&nbsp;
				</div>
				</div>
				</div>
				</div>
				
				
				
			
			
			

</div>
</div>
</div>




<!-- 
<div class="container">
	현재 페이지의 타이틀 
<div class="bg-faded my-4" style="padding: 0px">
		<div class="row" style="margin-top: 0px; padding-top: 0px">
			<div class="col-lg-12">
				<div class="col-lg-4" style="border-right: #cccccc 1px solid; margin-top: 0px; padding-top: 0px">
	
				1<br>
				2<br>
				</div>
				<div class="col-lg-4">
				2
				</div>
				<div class="col-lg-4">
				3
				</div>
			</div>
		</div>
</div>

</div> -->





<!-- <div class="m_container">
<div class="bg-faded p-4 my-4">
			
		dd<br>
		dd<br>
		ddd<br>
		d<br>
		d<br>
		dsfs<br>
		fs<br>
		fds<br>
</div>
<div class="bg-faded p-4 my-4">
			
		dd<br>
		dd<br>
		ddd<br>
		d<br>
		d<br>
		dsfs<br>
		fs<br>
		fds<br>
</div>
<div class="bg-faded p-4 my-4">
			
		dd<br>
		dd<br>
		ddd<br>
		d<br>
		d<br>
		dsfs<br>
		fs<br>
		fds<br>
</div>
</div> 
</div> -->

<!-- <div class="m_container">
<div class="bg-faded p-4 my-4">
		<div class="container">
			<div style="float: left; margin-left: 20px">
				ddd
			</div>
		</div>
</div>
</div> -->




