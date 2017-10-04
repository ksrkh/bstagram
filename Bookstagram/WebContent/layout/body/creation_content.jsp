<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container" style="margin-bottom: 50px">
	<!-- 현재 페이지의 타이틀  -->
	<!-- <div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		책속의 한줄
	</div> -->
	  
	<div class="bg-faded p-4 my-4">
		<div class="row">
			<div class="col-lg-12">
				<div class="well bs-component col-lg-12">
					<div class="col-lg-12">
					<form class="form-horizontal">
						<fieldset>
							<!-- 타이틀 -->
							<legend style="padding-bottom: 15px"><b>창작글</b></legend>
							
							<!-- 게시글 제목 부분 -->
							<div class="col-lg-12" style="border-bottom: #848484 1px solid; padding-left: 30px">
								<div class="form-group">
									<!-- 제목 -->
									<label style="float: left">제목입니다. 블라블라 블라.제목입니다.</label>
									<!-- 작성일자 -->
									<label style="float: right"><b>작성일자</b>&nbsp;&nbsp;2017-10-02</label>
								</div>
							</div>
							
							<!-- 게시글 작성자 부분 -->
							<div class="col-lg-12" style="border-bottom: #848484 1px solid; padding-left: 30px; padding-top: 10px">
								<div class="form-group">
									<!-- 작성자 -->
									<label style="float: left"><b>작성자</b>&nbsp;&nbsp;john@example.com</label>
									<!-- 조회수 -->
									<label style="float: right"><b>조회수</b>&nbsp;&nbsp;0</label>
								</div>
						    </div>
							
							<!-- 내용 부분 -->
							<div class="col-lg-12" style="border-bottom: #848484 1px solid; padding-left: 30px; padding-top: 15px">
								<div class="form-group">게시물 내용이 올공간입니다.<br>
									<br><br><br><br><br><br><br><br><br><br><br><br>
									<br><br><br><br><br><br><br><br><br><br><br><br>
									<br><br><br><br><br><br><br><br><br><br><br><br>
						      	</div>
						    </div>
						</fieldset>
					</form>
					</div>
				</div>
			</div>
		</div>
	
		<!-- 작석 버튼/취소 버튼 -->
		<div class="row" style="margin-bottom: 30px">
			<div class="col-lg-12">
				<button type="reset" class="btn btn-default"  style="float:right">목록으로</button>
				<!-- 작성자와 정보가 일치했을시에만 보여줍니다. -->
				<button type="submit" class="btn btn-primary" style="float:left; margin-right: 10px">삭제</button>
				<button type="submit" class="btn btn-primary" style="float:left">수정</button>
			</div>
		</div>
	</div>
	
</div>
<!-- /.container -->