$( document ).ready( function() {
	
	/**
	 * 모든 페이지 공통 ( 메뉴바 )
	 */
    var jbOffset = $( '.navbar' ).offset();
    $( window ).scroll(function() {
        if ( $( document ).scrollTop() > jbOffset.top ) {
          $('.navbar').addClass('nav-fixed');
        }
        else {
          $('.navbar').removeClass('nav-fixed');
        }
    });
    
    
    /**
     * 헤더 공통 ( 로그인 팝업 )
     */
    // 로그인버튼을 클릭시 작동하며 검은 마스크 배경과 레이어 팝업을 띄웁니다.
    $('.login_btn').click(function(e){
        // preventDefault는 href의 링크 기본 행동을 막는 기능입니다.
        e.preventDefault();
        // 팝업창을 띄웁니다.
        wrapWindowByMask();
    });

    // 닫기(close)를 눌렀을 때 작동합니다.
    $('.window .close').click(function (e) {
        e.preventDefault();
        $('.mask, .window').hide();
    });

    // 뒤 검은 마스크를 클릭시에도 모두 제거하도록 처리합니다.
    $('.mask').click(function () {
        $(this).hide();
        $('.window').hide();
    });
    
    // 관리자페이지 버튼
    $('.management_btn').click(function () {
    	location.href="ex-cms.jsp";
	});
    
    
    /*
     * 한줄메모
     */
    //한줄메모 글쓰기버튼
    $('.linememo_write').click(function () {
    	location.href="ex-home_write.jsp";
	});
    
    //한줄메모작성 배경선택 애니메이션(왼쪽버튼,오른쪽버튼)
    var pos = 0;
	var li_width = 100;
	var totalWidth = $(".scroll li").width() * $(".scroll li").length;
	$(".scroll ul").width(totalWidth)	
	$(".right").click(function(){
		if (pos == totalWidth-400) {return false;}
		pos += li_width;
		$(".scroll").animate({scrollLeft: pos},500);
	});
	$(".left").click(function(){
		if (pos == 0) {return false;}
		pos -= li_width;
		$(".scroll").animate({scrollLeft: pos},500);
	});
	
	//배경 선택시 textarea 이미지 변경
	$(".scroll .board_background li img").click(function() {
		$(".col-lg-12 .ta").css("background-image","url('"+$(this).attr('src')+"')");
		$(this).parent().parent().parent().find(".board_background li").removeClass("on");
		$(this).parent().addClass("on");
	});
	
	
	//이미지로하기
	$(".radio label #radio_bg2").click(function() {
		$(".col-lg-12 .ta").css("background-image","url('img/write/write_bg6.jpg')");
		$("#bg_template").show();
	
	});
	
	//선택안함
	$(".radio label #radio_bg3").click(function() {
		$(".col-lg-12 .ta").css("background-image","url('')");
		$("#bg_template").hide();
	
	});
	
	
	//독후감쓰기 버튼
	$('.bookreview_write').click(function () {
	   	location.href="ex-book_review_write.jsp";
	});
	 
	 
	//창작게시판 글쓰기 버튼
	$('.creation_write').click(function () {
		location.href="ex-creation_write.jsp";
	});
	
	
	//로그인 버튼 클릭시 submit
	$('.login').click(function () {
		var id = $('#userid').val();
		var pw = $('#userpw').val();
		$.ajax({
			type:"get",
			url:"DispatcherServlet",
			data:"command=Login&id="+id+"&pw="+pw,
			success:function(data){//data로 서버의 응답 정보가 들어온다.
				if(data == "success"){
					alert("로그인 성공 하였습니다.");
					location.href="ex-home.jsp";
				}else{
					alert("로그인 실패 하였습니다.");
				}
			},
			timeout: 1000,
			error: function() {
				alert("timeout error");
			}
		});
	});
	
	//로그아웃 버튼 클릭시 submit
	$('#logout').click(function () {
		$.ajax({
			type:"get",
			url: "DispatcherServlet",
			data:"command=Logout",
			success:function(data){//data로 서버의 응답 정보가 들어온다.
				if(data == "success"){
					alert("로그아웃 성공");
					location.href="ex-home.jsp"
				}
			},
			timeout: 1000,
			error: function() {
				alert("timeout error");
			}
		});
	});
	
	/**
	 * 체크박스 이벤트
	 */
	$("input[name=tend_code]:checkbox").change(function() {
        if( $("input[name=tend_code]:checkbox:checked").length == 3 ) {
            $(":checkbox:not(:checked)").attr("disabled", "disabled");
        } else {
            $("input[name=tend_code]:checkbox").removeAttr("disabled");
        }
    });
});

/**
 * 회원가입 중복체크
 */
function dupleId(){
	var id = $('.form-group #id').val();
	$.ajax({
		type:"get",
		url: "DispatcherServlet",
		data:"command=dupleIdCheck&id="+id,
		success:function(data){//data로 서버의 응답 정보가 들어온다.
			if(data == "yes"){
				$('#dupleMessage').text('사용 가능한 아이디입니다.');
				$('#dupleMessage').css("color","#1cbeff");
			}else{
				$('#dupleMessage').text('사용 불가능한 아이디입니다.');
				$('#dupleMessage').css("color","#ff6b6b");
			}
		},
		timeout: 3000,
		error: function() {
			alert("timeout error");
		}
	});
}

/**
 * 헤더 로그인 팝업 펑션
 */
function wrapWindowByMask(){
    // 화면의 높이와 너비를 변수로 만듭니다.
    var maskHeight = $(document).height();
    var maskWidth = $(window).width();

    // 마스크의 높이와 너비를 화면의 높이와 너비 변수로 설정합니다.
    $('.mask').css({'width':maskWidth,'height':maskHeight});

    // fade 애니메이션 : 80%의 불투명으로 변합니다.
    $('.mask').fadeTo("slow",0.8);

    // 레이어 팝업을 가운데로 띄우기 위해 화면의 높이와 너비의 가운데 값과 스크롤 값을 더하여 변수로 만듭니다.
    var left = ( $(window).scrollLeft() + ( $(window).width() - $('.window').width()) / 2 );
    var top = ( $(window).scrollTop() + ( $(window).height() - $('.window').height()) / 2 );

    // css 스타일을 변경합니다.
    $('.window').css({'left':left,'top':top, 'position':'absolute'});

    // 레이어 팝업을 띄웁니다.
    $('.window').fadeIn(1000);
}
