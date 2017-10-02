<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		Book-Review
	<button type="button" class="btn btn-primary" >글쓰기</button>
	</div>
	  
	  
	<!-- 슬라이드 애니메이션 박스 -->
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
	<!-- 임시1 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<img src="https://search.pstatic.net/common?type=ofullfill&size=120x171&quality=100&direct=true&src=http%3A%2F%2Fmovie.phinf.naver.net%2F20170920_253%2F1505868742045d4sSO_JPEG%2Fmovie_image.jpg">
		</div>
	</div>
	<!-- 임시2 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<img src="https://search.pstatic.net/common?type=ofullfill&size=120x171&quality=100&direct=true&src=http%3A%2F%2Fmovie.phinf.naver.net%2F20120525_174%2F1337921171775pbbKG_JPEG%2Fmovie_image.jpg">
		</div>
	</div>
	<!-- 임시3 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<img src="https://search.pstatic.net/common?type=ofullfill&size=120x171&quality=100&direct=true&src=http%3A%2F%2Fmovie.phinf.naver.net%2F20160106_138%2F1452044846608eaFcJ_JPEG%2Fmovie_image.jpg">
		</div>
	</div>
	<!-- 임시4 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<img src="https://search.pstatic.net/common?type=ofullfill&size=120x171&quality=100&direct=true&src=http%3A%2F%2Fmovie.phinf.naver.net%2F20170830_165%2F1504057663682Y7EEc_JPEG%2Fmovie_image.jpg">
		</div>
	</div>
	<!-- 임시5 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<img src="https://search.pstatic.net/common?type=ofullfill&size=120x171&quality=100&direct=true&src=http%3A%2F%2Fmovie.phinf.naver.net%2F20170712_245%2F149982527853229Stz_JPEG%2Fmovie_image.jpg">
		</div>
	</div>
	
	
</div>
<!-- /.container -->