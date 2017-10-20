<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		전체 회원 관리
	</div>

	<div class="bg-faded p-4 my-4">
		<form name="memberFrame">
		<table class="table table-hover">
			<thead class="cms-thead">
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>나이</th>
					<th>성향1</th>
					<th>성향2</th>
					<th>성향3</th>
					<th>회원등급</th>
					<th>가입날짜</th>
					<th>수정</th>
				</tr>
			</thead>
			<tbody class="cms-tbody">
				<!-- start // 추후 for로 돌릴 구간입니다. -->
				<c:forEach items="${requestScope.member.list }" var="member">
				<tr class="cmsmemberlist_tr">
					<!-- 아이디 -->
					<td style="padding-top: 15px" class="cmsmemberid">${member.id}</td>
					<!-- 비밀번호 -->
					<td class="cmsmemberpw"><input type="password" class="form-control" id="password" placeholder="비밀번호" size="10" value="${member.pw}"></td>
					<!-- 나이 -->
					<td class="cmsmemberage"><input type=number class="form-control" id="age" name="age" min="0" max="100" value="${member.age}"></td>
					<!-- 성향1 -->
					<td class="cmsmmembertend1">
						<select class="form-control" id="select" name="tend_code">
							<c:forEach items="${requestScope.tend}" var="tend">
								<c:choose>
			                        <c:when test="${tend.tend_name == member.tend_name}">
										<option value="${tend.tend_code}" selected="selected">${tend.tend_name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tend.tend_code}">${tend.tend_name}</option>
									</c:otherwise>
                            	</c:choose>
							</c:forEach>
						</select>
					</td>
					<!-- 성향2 -->
					<td class="cmsmmembertend2">
						<select class="form-control" id="select" name="tend_code2">
							<c:forEach items="${requestScope.tend}" var="tend">
								<c:choose>
			                        <c:when test="${tend.tend_name == member.tend_name2}">
										<option value="${tend.tend_code}" selected="selected">${tend.tend_name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tend.tend_code}">${tend.tend_name}</option>
									</c:otherwise>
                            	</c:choose>
							</c:forEach>
						</select>
					</td>
					<!-- 성향3 -->
					<td class="cmsmmembertend3">
						<select class="form-control" id="select" name="tend_code3">
							<c:forEach items="${requestScope.tend}" var="tend">
								<c:choose>
			                        <c:when test="${tend.tend_name == member.tend_name3}">
										<option value="${tend.tend_code}" selected="selected">${tend.tend_name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tend.tend_code}">${tend.tend_name}</option>
									</c:otherwise>
                            	</c:choose>
							</c:forEach>
						</select>
					</td>
					<!-- 회원등급 -->
					<td class="tier">
						<select class="form-control" id="select" name="tier">
							<c:forEach items="${requestScope.tier}" var="tier">
								<c:choose>
			                        <c:when test="${tier.tier_name == member.tier_name}">
										<option value="${tier.tier}" selected="selected">${tier.tier_name}</option>
									</c:when>
									<c:otherwise>
										<option value="${tier.tier}">${tier.tier_name}</option>
									</c:otherwise>
                            	</c:choose>
							</c:forEach>
						</select>
					</td>
					<td style="padding-top: 15px">17-10-02</td>
					<td class="cmsmemberupt_btn"><button type="button" class="btn btn-primary">수정</button></td>
				</tr>
				</c:forEach>
				
				<!-- end // 추후 for 로 돌릴 구간입니다. -->
			</tbody>
		</table>
		</form>
	</div>
	
	<c:set var="pb" value="${requestScope.member.pagingBean}"></c:set>
	<div class="bg-faded p-4 my-4">
		<div style="width: 50%; margin: 0 auto;text-align: center">
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a href="DispatcherServlet?command=cmsmemberlistpege&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a href="DispatcherServlet?command=cmsmemberlistpege&pageNo=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"> <a href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a href="DispatcherServlet?command=cmsmemberlistpege&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	
	
</div>
<!-- /.container -->