<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <!-- META / CSS / Javascript /Font 등 설정정보 -->
  <!-- CSS			: css/mystyle.css 에서 작업하시면 됩니다. -->
  <!-- JavaScript	: script/myjs.js 에서 작업하시면 됩니다. -->
  <!-- 링크 걸린 순서 변경 시 코드 에러 생길 수 있습니다. -->
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>북스타그램 - 한줄 속의 공감</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="script/myJs.js" type="text/javascript"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/mystyle.css" rel="stylesheet">
    
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  </head>



  <!-- 실제 클라이언트에게 보여줄 레이아웃 구성입니다. -->
  <body>
  	<!-- 헤더 부분입니다. 검색/로그인/네비게이터 메뉴 바 -->
  	<div class="header">
		<c:import url="layout/header/header.jsp"></c:import>
	</div>
	
	<!-- 바디 부분입니다. -->
	<div class="body">
		<c:import url="${requestScope.url}"></c:import>
	</div>
	
	<!-- 푸터 부분입니다. -->
	<div class="footer">
		<c:import url="layout/footer/footer.jsp"></c:import>
	</div>
  </body>
</html>
