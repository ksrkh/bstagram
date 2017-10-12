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
	 * 회원가입 시 체크박스 이벤트
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
	if(0 == id.length){
		$('#dupleMessage').text('');
	} else if(3 < id.length){
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
	}else{
		$('#dupleMessage').text('4글자이상 12글자미만으로 입력해주세요.');
		$('#dupleMessage').css("color","#ff6b6b");
	}
}

/**
 * 비밀번호 유효성 검사
 */
function chkPassword(){
	var id = $('.form-group #id').val();
	var password = $('.form-group #pw').val();
	var checkNumber = password.search(/[0-9]/g);
	var checkEnglish = password.search(/[a-z]/ig);
	
	if(!/^[a-zA-Z0-9]{6,15}$/.test(password)){
		$('#checkPwMessage').text('숫자와 영문자 조합으로 6~15자리를 사용해야 합니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
	} else if(checkNumber <0 || checkEnglish <0){
		$('#checkPwMessage').text('숫자와 영문자를 혼용하여야 합니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
	} else if(/(\w)\1\1\1/.test(password)){
		$('#checkPwMessage').text('444같은 문자를 4번 이상 사용하실 수 없습니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
	} else if(password.search(id) > -1){
		$('#checkPwMessage').text('비밀번호에 아이디가 포함되었습니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
	} else {
		$('#checkPwMessage').text('사용 가능한 비밀번호 입니다.');
		$('#checkPwMessage').css("color","#1cbeff");
	}
}

/**
 * 비밀번호 확인 검사
 */
function chkConfirmPw(){
	var pw = $('.form-group #pw').val();
	var confirm_pw = $('.form-group #confirm_pw').val();
	if(pw == confirm_pw){
		$('#checkConfirmPwMessage').text('비밀번호가 일치 합니다.');
		$('#checkConfirmPwMessage').css("color","#1cbeff");
	}else{
		$('#checkConfirmPwMessage').text('비밀번호가 일치하지 않습니다.');
		$('#checkConfirmPwMessage').css("color","#ff6b6b");
	}
}

/**
 * 회원가입 닉네임 중복체크
 */
function dupleNick(){
	var nick = $('.form-group #nick').val();
	if(0 == nick.length){
		$('#dupleNickMessage').text('');
	} else if(2 < nick.length){
		$.ajax({
			type:"get",
			url: "DispatcherServlet",
			data:"command=dupleNickCheck&nick="+nick,
			success:function(data){//data로 서버의 응답 정보가 들어온다.
				if(data == "yes"){
					$('#dupleNickMessage').text('사용 가능한 닉네임입니다.');
					$('#dupleNickMessage').css("color","#1cbeff");
				}else{
					$('#dupleNickMessage').text('사용 불가능한 닉네임입니다.');
					$('#dupleNickMessage').css("color","#ff6b6b");
				}
			},
			timeout: 3000,
			error: function() {
				alert("timeout error");
			}
		});
	}else{
		$('#dupleNickMessage').text('3글자이상 8글자미만으로 입력해주세요.');
		$('#dupleNickMessage').css("color","#ff6b6b");
	}
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
