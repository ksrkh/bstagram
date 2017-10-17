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
    	location.href="DispatcherServlet?command=tendList";
	});
    
    $("#book_search").keypress(function(e) { 
	    if (e.keyCode == 13){
	    	var book = $(this).val();
	    	var command = $('#searchbook').val();
			$.ajax({
				type:"get",
				url: "DispatcherServlet",
				data:"command="+command+"&book_search="+book,
				dataType:"json",
				success:function(data){//data로 서버의 응답 정보가 들어온다.
					for(var i in data.items) {
						$("#searchForm").css("display","block");
						book_title=data.items[i].title;
						book_author=data.items[i].author;
						book_publisher=data.items[i].publisher;
						book_pubdate=data.items[i].pubdate;
						book_description=data.items[i].description;
						book_image=data.items[i].image;
						/*$("#searchForm").append(addSearchForm(book_image, book_title, book_author, book_publisher, book_pubdate, book_description));*/
						$(".book_search_thumnail").attr('src',book_image);
						$("#book_title_area").html(book_title);
						$("#book_author_area").html(book_author);
						$("#book_publisher_area").html(book_publisher);
						$("#book_pubdate_area").html(book_pubdate);
						$("#book_description_area").html(book_description);
					}
				}
			});
		}    
	});
    
    
    
    //책검색시 여러게 보여주기
    function addSearchForm(thumnail, title, author, publisher, pubdate, description){
		var data = thumnail+"@"+title+"@"+author+"@"+publisher+"@"+pubdate+"@"+description;
    	
    	var info="<div class='form-group' style='margin-bottom:15px; padding-left: 20px'>";
    	info+="<input class='hidden_data' type='hidden' value='"+data+"'>";
    	info+="<div class='col-lg-2' id='book_image_area'>";
		info+="<img class='book_search_thumnail' height=171px width=120px src='";
		info+=thumnail;
		info+="'></div><div class='col-lg-10'><div id='book_title_area' class='col-lg-12' style='padding-left: 0px; margin-bottom: 10px'>"
		info+=title;
		info+="</div><div id='book_author_area' class='col-lg-4' style='padding-left: 0px; margin-bottom: 10px; margin-left:0px; margin-right: 0px'>";
		info+=author;
		info+="</div><div id='book_publisher_area' class='col-lg-4'>";
		info+=publisher;
		info+="</div><div id='book_pubdate_area' class='col-lg-4'>";
		info+=pubdate;
		info+="</div><div class='col-lg-12' style='padding-left: 0px' id='book_description_area'>";
		info+=description;
		info+="</div></div></div>";
		return info;
    }
    
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
	   	location.href="DispatcherServlet?command=reviewwritebutton";
	});
	 
	 
	//창작게시판 글쓰기 버튼
	$('.creation_write').click(function () {
		location.href="DispatcherServlet?command=createwriteview";
	});
	
	
	//로그인 버튼 클릭시 submit
	$('.login').click(function () {
		var id = $('#userid').val();
		var pw = $('#userpw').val();
		location.href="DispatcherServlet?command=Login&id="+id+"&pw="+pw;
	});
	
	//메인로그인 버튼 클릭시 submit
	$('.main_login').click(function () {
		var id = $('#usermainid').val();
		var pw = $('#usermainpw').val();
		location.href="DispatcherServlet?command=Login&id="+id+"&pw="+pw;
	});
	
	//로그아웃 버튼 클릭시 submit
	$('#logout').click(function () {
		location.href="DispatcherServlet?command=Logout";
	});
	
	/**
	 * 회원가입 시 체크박스 이벤트
	 */
	$("input[name=tend_code]:checkbox").change(function() {
        if( $("input[name=tend_code]:checkbox:checked").length == 3 ) {
            $(":checkbox:not(:checked)").attr("disabled", "disabled");
        }else if( $("input[name=tend_code]:checkbox:checked").length == 4){
        	alert("성향은 최대 3개까지 선택가능합니다");
        	$("input[name=tend_code]").prop("checked",false);
        }
        else {
            $("input[name=tend_code]:checkbox").removeAttr("disabled");
        }
    });
	
	//성향 수정 버튼 클릭시
	$(".tend_tr .tend_update button").click(function(){
		var tend_code = $(this).parent().parent().find('.tend_code').text();
		var tend_name = $(this).parent().parent().find('.tend_name').find(':input[name=tend_name]').val();
		location.href="DispatcherServlet?command=cmstendupdate&tend_code="+tend_code+"&tend_name="+tend_name;
	});
	
	//성향 삭제 버튼 클릭시
	$(".tend_tr .tend_delete button").click(function(){
		var tend_code = $(this).parent().parent().find('.tend_code').text();
		var tend_name = $(this).parent().parent().find('.tend_name').find(':input[name=tend_name]').val();
		location.href="DispatcherServlet?command=cmstenddelete&tend_code="+tend_code;
	});
	
	
	//장르 수정 버튼 클릭시
	$(".genre_tr .genre_update button").click(function(){
		var genre_code = $(this).parent().parent().find('.genre_code').text();
		var genre_name = $(this).parent().parent().find('.genre_name').find(':input[name=genre_name]').val();
		location.href="DispatcherServlet?command=cmsgenreupdate&genre_code="+genre_code+"&genre_name="+genre_name;
	});
	
	//장르 삭제 버튼 클릭시
	$(".genre_tr .genre_delete button").click(function(){
		var genre_code = $(this).parent().parent().find('.genre_code').text();
		var genre_name = $(this).parent().parent().find('.genre_name').find(':input[name=genre_name]').val();
		location.href="DispatcherServlet?command=cmsgenredelete&genre_code="+genre_code;
	});
	
	
	//분류 수정 버튼 클릭시
	$(".category_tr .category_update button").click(function(){
		var category_code = $(this).parent().parent().find('.category_code').text();
		var category_name = $(this).parent().parent().find('.category_name').find(':input[name=category_name]').val();
		location.href="DispatcherServlet?command=cmscategoryupdate&category_code="+category_code+"&category_name="+category_name;
	});
	
	//분류 삭제 버튼 클릭시
	$(".category_tr .category_delete button").click(function(){
		var category_code = $(this).parent().parent().find('.category_code').text();
		var category_name = $(this).parent().parent().find('.category_name').find(':input[name=category_name]').val();
		location.href="DispatcherServlet?command=cmscategorydelete&category_code="+category_code;
	});
	
	
	//비밀번호찾기 질문 수정 버튼 클릭시
	$(".findPw_tr .findPw_update button").click(function(){
		var findPw_code = $(this).parent().parent().find('.findPw_code').text();
		var findPw_name = $(this).parent().parent().find('.findPw_name').find(':input[name=pw_question]').val();
		location.href="DispatcherServlet?command=cmspwquestionupdate&findPw_code="+findPw_code+"&findPw_name="+findPw_name;
	});
	
	//관리자페이지 게시글 삭제 버튼 클릭시
	$(".cmsboardlist_tr .cmsboarddlt_btn button").click(function(){
		var board_no = $(this).parent().parent().find('.cmsboardno').text();
		var boardtype_no = $(this).parent().parent().find('.cmsboardno').find(':input[name=cmsboardtypeno]').val();
		location.href="DispatcherServlet?command=cmsboarddelete&board_no="+board_no+"&boardtype_no="+boardtype_no;
	});
	
	//관리자페이지 회원 수정 버튼 클릭시
	$(".cmsmemberlist_tr .cmsmemberupt_btn button").click(function(){
		var id = $(this).parent().parent().find('.cmsmemberid').text();
		var pw = $(this).parent().parent().find('.cmsmemberpw').find('#password').val();
		var age = $(this).parent().parent().find('.cmsmemberage #age').val();
		var tend1 = $(this).parent().parent().find('.cmsmmembertend1 select option:selected').val();
		var tend2 = $(this).parent().parent().find('.cmsmmembertend2 select option:selected').val();
		var tend3 = $(this).parent().parent().find('.cmsmmembertend3 select option:selected').val();
		var tier = $(this).parent().parent().find('.tier select option:selected').val();
		location.href="DispatcherServlet?command=cmsmemberudt&id="+id+"&pw="+pw+"&age="+age+"&tend1="+tend1+"&tend2="+tend2+"&tend3="+tend3+"&tier="+tier;
	});
	
});

var chkJoinIdValue = false;
var chkJoinPwValue = false;
var chkJoinPwConfirmValue = false;
var chkJoinNickValue = false;

/**
 * 회원가입 중복체크
 */
function dupleId(){
	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	var id = $('.form-group #id').val();
	
	if(0 == id.length){
		$('#dupleMessage').text('');
		chkJoinValue = false;
	} else if(id.length<4 || id.length>30){
		$('#dupleMessage').text('4글자이상 30글자미만으로 입력해주세요.');
		$('#dupleMessage').css("color","#ff6b6b");
		chkJoinIdValue = false;
	} else if(!id.match(regExp)){
		$('#dupleMessage').text('이메일 형식에 맞지않은 아이디입니다.');
		$('#dupleMessage').css("color","#ff6b6b");
		chkJoinIdValue = false;
	} else{
		$.ajax({
			type:"get",
			url: "DispatcherServlet",
			data:"command=dupleIdCheck&id="+id,
			success:function(data){//data로 서버의 응답 정보가 들어온다.
				if(data == "yes"){
					$('#dupleMessage').text('사용 가능한 아이디입니다.');
					$('#dupleMessage').css("color","#1cbeff");
					chkJoinIdValue = true;
				}else{
					$('#dupleMessage').text('중복 된 아이디입니다.');
					$('#dupleMessage').css("color","#ff6b6b");
					chkJoinIdValue = false;
				}
			},
			timeout: 3000,
			error: function() {
				alert("timeout error");
			}
		});
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
		chkJoinPwValue = false;
	} else if(checkNumber <0 || checkEnglish <0){
		$('#checkPwMessage').text('숫자와 영문자를 혼용하여야 합니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
		chkJoinPwValue = false;
	} else if(/(\w)\1\1\1/.test(password)){
		$('#checkPwMessage').text('444같은 문자를 4번 이상 사용하실 수 없습니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
		chkJoinPwValue = false;
	} else if(password.search(id) > -1){
		$('#checkPwMessage').text('비밀번호에 아이디가 포함되었습니다.');
		$('#checkPwMessage').css("color","#ff6b6b");
		chkJoinPwValue = false;
	} else {
		$('#checkPwMessage').text('사용 가능한 비밀번호 입니다.');
		$('#checkPwMessage').css("color","#1cbeff");
		chkJoinPwValue = true;
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
		chkJoinPwConfirmValue = true;
	}else{
		$('#checkConfirmPwMessage').text('비밀번호가 일치하지 않습니다.');
		$('#checkConfirmPwMessage').css("color","#ff6b6b");
		chkJoinPwConfirmValue = false;
	}
}

/**
 * 회원가입 닉네임 중복체크
 */
function dupleNick(){
	var nick = $('.form-group #nick').val();
	if(0 == nick.length){
		$('#dupleNickMessage').text('');
		chkJoinNickValue = false;
	} else if(2 < nick.length){
		$.ajax({
			type:"get",
			url: "DispatcherServlet",
			data:"command=dupleNickCheck&nick="+nick,
			success:function(data){//data로 서버의 응답 정보가 들어온다.
				if(data == "yes"){
					$('#dupleNickMessage').text('사용 가능한 닉네임입니다.');
					$('#dupleNickMessage').css("color","#1cbeff");
					chkJoinNickValue = true;
				}else{
					$('#dupleNickMessage').text('사용 불가능한 닉네임입니다.');
					$('#dupleNickMessage').css("color","#ff6b6b");
					chkJoinNickValue = false;
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
		chkJoinNickValue = false;
	}
}

function chkSubmit(){
	var id = $('.form-group #id').val();
	var pw = $('.form-group #pw').val();
	var confirm_pw = $('.form-group #confirm_pw').val();
	var nick = $('.form-group #nick').val();
	var age = $('.form-group #age').val();
	var q_answer = $('.form-group #pw_answer').val();
	
	if(chkJoinIdValue == false || id.length == 0) {
		alert("아이디를 정확히 입력해주세요.");
	}else if(chkJoinPwValue == false || pw.length == 0) {
		alert("비밀번호 정확히 입력해주세요.");
	}else if(chkJoinPwConfirmValue == false || confirm_pw.length == 0) {
		alert("비밀번호 확인을 정확히 입력해주세요.");
	}else if(chkJoinNickValue == false || nick.length == 0) {
		alert("닉네임을 정확히 입력해주세요.");
	}else if(age.length == 0) {
		alert("나이를 입력해주세요.");
	}else if(q_answer.length == 0) {
		alert("비밀번호 찾기 답변을 입력해주세요.");
	}else if( $("input[name=tend_code]:checkbox:checked").length == 0 ) {
		if(confirm("성향은 회원가입 후 마이페이지에서 수정가능합니다.\n회원가입을 진행합니다.")){
			document.JoinFrame.submit();
		}else{
			return false;
		}
	}else{
		if(confirm("회원가입을 진행합니다.")){
			document.JoinFrame.submit();
		}else{
			return false;
		}
	}
}

function chkUpdateSubmit(){
	var id = $('.form-group #id').val();
	var pw = $('.form-group #pw').val();
	var confirm_pw = $('.form-group #confirm_pw').val();
	var nick = $('.form-group #nick').val();
	var age = $('.form-group #age').val();
	var q_answer = $('.form-group #pw_answer').val();
	
	if(pw.length == 0) {
		alert("비밀번호 정확히 입력해주세요.");
	}else if(confirm_pw.length == 0) {
		alert("비밀번호 확인을 정확히 입력해주세요.");
	}else if(nick.length == 0) {
		alert("닉네임을 정확히 입력해주세요.");
	}else if(age.length == 0) {
		alert("나이를 입력해주세요.");
	}else if(q_answer.length == 0) {
		alert("비밀번호 찾기 답변을 입력해주세요.");
	}else if( $("input[name=tend_code]:checkbox:checked").length == 0 ) {
		if(confirm("성향을 선택하지 않았습니다.\n수정하시겠습니까?")){
			document.UpdateFrame.submit();
		}else{
			return false;
		}
	}else{
		if(confirm("수정하시겠습니까?")){
			document.UpdateFrame.submit();
		}else{
			return false;
		}
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




/**
 *	성향추가
 */
function addTend(){
	document.tendForm.submit();
}

/**
*	장르추가
*/
function addGenre(){
	document.genreForm.submit();
}

/**
*	분야추가
*/
function addCategory(){
	document.categoryForm.submit();
}

/**
*	비밀번호찾기질문추가
*/
function addPwFindQuest(){
	document.pwfindQwForm.submit();
}



//검색기능
function bookSearch(){
	var book = $("#book_search").val();
	var command = $('#searchbook').val();
	var book_title;
	var book_author;
	var book_publisher;
	var book_pubdate;
	var book_description;
	var book_image;
	$.ajax({
		type:"get",
		url: "DispatcherServlet",
		data:"command="+command+"&book_search="+book,
		dataType:"json",
		success:function(data){//data로 서버의 응답 정보가 들어온다.
			for(var i in data.items) {
				$("#searchForm").css("display","block");
				book_title=data.items[i].title;
				book_author=data.items[i].author;
				book_publisher=data.items[i].publisher;
				book_pubdate=data.items[i].pubdate;
				book_description=data.items[i].description;
				book_image=data.items[i].image;
				/*$("#searchForm").append(addSearchForm(book_image, book_title, book_author, book_publisher, book_pubdate, book_description));*/
					$(".book_search_thumnail").attr('src',book_image);
					$("#book_title_area").html(book_title);
					$("#book_author_area").html(book_author);
					$("#book_publisher_area").html(book_publisher);
					$("#book_pubdate_area").html(book_pubdate);
					$("#book_description_area").html(book_description);
			}
		}
	});
}