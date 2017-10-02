<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기능의 UI를 담당하는 부분(컨테이너) -->
<div class="container">
	<!-- 현재 페이지의 타이틀  -->
	<div class="tagline-upper text-left text-heading text-shadow text-white d-none d-lg-block" style="margin-top: 5px">
		One-Line-Memo
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
					<img class="d-block img-fluid w-100" src="img/slide-1.jpg" alt="">
					<div class="carousel-caption d-none d-md-block">
						<h3 class="text-shadow">First Slide</h3>
						<p class="text-shadow">This is the caption for the first slide.</p>
					</div>
				</div>
			
				<div class="carousel-item">
					<img class="d-block img-fluid w-100" src="img/slide-2.jpg" alt="">
					<div class="carousel-caption d-none d-md-block">
						<h3 class="text-shadow">Second Slide</h3>
						<p class="text-shadow">This is the caption for the second slide.</p>
					</div>
				</div>
				
				<div class="carousel-item">
					<img class="d-block img-fluid w-100" src="img/slide-3.jpg" alt="">
					<div class="carousel-caption d-none d-md-block">
						<h3 class="text-shadow">Third Slide</h3>
						<p class="text-shadow">This is the caption for the third slide.</p>
					</div>
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
			<blockquote class="quote-box" style="background-color: #4ADFCC;">
				<p class="quotation-mark">
					“
				</p>
				<p class="quote-text">
					Don't believe anything that you read on the internet, it may be fake. 
				</p>
				<hr>
				
				<div class="blog-post-actions">
					<p class="blog-post-bottom pull-left">
						Abraham Lincoln
					</p>
					<p class="blog-post-bottom pull-right">
						<span class="badge quote-badge">896</span>  ❤
					</p>
				</div>
			</blockquote>
		</div>
	</div>
	
	<!-- 임시2 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<blockquote class="quote-box" style="background-color: #222222;">
				<p class="quotation-mark">
					“
				</p>
				<p class="quote-text">
					Don't believe anything that you read on the internet, it may be fake. 
				</p>
				<hr>
				
				<div class="blog-post-actions">
					<p class="blog-post-bottom pull-left">
						Abraham Lincoln
					</p>
					<p class="blog-post-bottom pull-right">
						<span class="badge quote-badge">896</span>  ❤
					</p>
				</div>
			</blockquote>
		</div>
	</div>
		  
	<!-- 임시3 -->
	<div class="bg-faded p-4 my-4">
		<div class="container">
			<blockquote class="quote-box" style="background-color: #0078FF;">
				<p class="quotation-mark">
					“
				</p>
				<p class="quote-text">
					Don't believe anything that you read on the internet, it may be fake. 
				</p>
				<hr>
				
				<div class="blog-post-actions">
					<p class="blog-post-bottom pull-left">
						Abraham Lincoln
					</p>
					<p class="blog-post-bottom pull-right">
						<span class="badge quote-badge">896</span>  ❤
					</p>
				</div>
			</blockquote>
		</div>
	</div>
</div>
<!-- /.container -->