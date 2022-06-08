var $body_tag = document.querySelector("body")
var $dark = document.querySelector(".dark");
var $dark1 = document.querySelector(".dark1");
var $popupLogin = document.querySelector("#login-box");
var $popupSignup = document.querySelector("#signup-box");
var $popupAgree = document.querySelector("#agree");

// 로그인 클릭할때
function openPopLogin(){
	$popupSignup.setAttribute("class", "popup");
    $dark.setAttribute("class", "dark active");
    $popupLogin.setAttribute("class", "popup active");
    $body_tag.setAttribute("class", "not_scroll");
}

// 회원가입 클릭할때
function openPopSignUp(){
	$popupLogin.setAttribute("class", "popup");
    $dark.setAttribute("class", "dark active");
    $popupSignup.setAttribute("class", "popup active");
    $body_tag.setAttribute("class", "not_scroll");
}

// 약관보기(회원가입버튼) 클릭 할때
function openAgree(){
    $dark1.setAttribute("class", "dark1 active1");
    $popupAgree.setAttribute("class", "popup1 active2");
}

// 검은배경 클릭할때 (로그인, 회원가입 닫기)
function closePop(){
    $dark.setAttribute("class", "dark");
    $popupLogin.setAttribute("class", "popup"); // 로그인 닫기
    $popupSignup.setAttribute("class", "popup"); // 회원가입 닫기
    $popupAgree.setAttribute("class", "popup1"); // 약관 닫기
    $body_tag.setAttribute("class", "");
}

// 검은배경 클릭할때 (약관동의 닫기)
function closeAgree(){
    $dark1.setAttribute("class", "dark1");
    $popupAgree.setAttribute("class", "popup1"); // 약관 닫기
}




// 로그인
const loginEmail = document.getElementById("loginEmail");
const loginPw = document.getElementById("loginPw");
const emailComment = document.getElementById("emailComment");
const pwComment = document.getElementById("pwComment");

// 정규식
const nameExp = /^[a-zA-Z0-9가-힣]{2,10}$/;
const emailExp = /^[\w\-\_]{3,}\@[\w\-\_]+(\.\w+){1,3}$/;
const pwExp = /^[\w!@#_-]{6,30}$/;

// 회원가입
const signUpName = document.getElementById("signUpName");
const signUpEmail = document.getElementById("signUpEmail");
const signUpPw = document.getElementById("signUpPw");

const nameMessage = document.getElementById("nameMessage");
const emailMessage = document.getElementById("emailMessage");
const pwMessage = document.getElementById("pwMessage");





// 로그인 시 이메일(아이디)/비밀번호 유효성 검사
function loginValidate() { 

    // 이메일이 입력되지 않은 경우 false를 반환
    if(loginEmail.value.trim().length==0){
        alert("이메일을 입력해주세요.");
        loginEmail.value = ""; 
        loginEmail.focus(); 
        return false; 
    }

    // 이메일 정규식 검사
    if(!emailExp.test(loginEmail.value)){
        emailComment.innerText="정확하지 않은 이메일입니다."
        loginEmail.focus(); 
        return false; 
    }else{
        emailComment.innerText="";
    }

    // 비밀번호를 입력하지 않은 경우 false 반환
    if(loginPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.");
        loginPw.value = ""; 
        loginPw.focus(); 
        return false; 
    }

    // 비밀번호 정규식 검사
    if(!pwExp.test(loginPw.value)){
        pwComment.innerText="비밀번호는 6자리 이상 30자리 이하입니다."
        loginPw.focus();
        return false; 
    }else{
        pwComment.innerText="";
    }

    return true;
};

loginEmail.addEventListener("input",function(){
    emailComment.innerText="";
})

loginPw.addEventListener("input",function(){
    pwComment.innerText="";
})





// 회원가입 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    signUpName : false,
    signUpEmail : false,
    signUpPw : false,
};

// 이름 유효성 검사
signUpName.addEventListener("input", function(){

    if(signUpName.value.length==0 || !nameExp.test(signUpName.value)){
        nameMessage.innerText="영어/숫자/한글 2~10글자 사이로 작성해주세요.";

        checkObj.signUpName=false; // 유효하지 않은 상태
        return;
    }else{
        nameMessage.innerText="";
        checkObj.signUpName=true; // 유효한 상태
    } 
})


// 이메일 유효성 검사
signUpEmail.addEventListener("input", function(){

    if(signUpEmail.value.length==0){
        emailMessage.innerText="메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm","error");

        checkObj.signUpEmail=false; // 유효하지 않은 상태
        return;
    }

    if(emailExp.test(signUpEmail.value)){

        // ****** 이메일 중복 검사(ajax) 진행 ******
        $.ajax({
			url: "emailDupCheck", 
			data : {"memberEmail" : signUpEmail.value},
			type : "GET", 
			success : function(result){
                if(result==1) { // 중복임
                    emailMessage.innerText = "이미 가입된 이메일입니다."
                    checkObj.signUpEmail=false; // 유효하지 않은 상태
                } else{
                    emailMessage.innerText = ""
                    checkObj.signUpEmail=true; // 유효한 상태 
                }
			},
			error : function(){

			}
		});

    }else{
        emailMessage.innerText = "이메일 형식이 올바르지 않습니다."

        checkObj.signUpEmail=false; // 유효하지 않은 상태
    }
})


// 비밀번호 유효성 검사
signUpPw.addEventListener("input",function(){

    if(signUpPw.value.length==0){
        pwMessage.innerText="영어, 숫자, 특수문자(!,@,#,-._) 6~30글자 사이로 작성해주세요.";

        checkObj.signUpPw=false; // 유효하지 않은 상태
        return;
    }

    if(pwExp.test(signUpPw.value)){ // 비밀번호 유효할때
        pwMessage.innerText="";
        checkObj.signUpPw=true; // 유효한 상태

    } else{
        pwMessage.innerText="비밀번호 형식이 유효하지 않습니다.";
        checkObj.signUpPw=false; // 유효하지 않은 상태
    }  
});


// 회원가입 버튼 클릭 시 유효성 검사가 완료되었는지 검사
document.getElementById("signup-btn").addEventListener("click",function(){

    let str;
    for(let key in checkObj){ // 객체용 향상된 for문
        if(!checkObj[key]){ // 현재 접근중인 key의 value가 false인 경우
            
            switch(key){
                case "signUpName": str="닉네임을"; break;
                case "signUpEmail": str="이메일을"; break;
                case "signUpPw": str="비밀번호를"; break;    
            }

            document.getElementById(key).focus();
            alert(str+"다시 입력해주세요.");
            return;
        }
    }

    // 모두 유효하면 약관동의 팝업 열기
    openAgree();
});

const agree1 = document.getElementById("agree1");
const agree2 = document.getElementById("agree2");

// 약관동의 체크되어 있으면 가입submit
function signUpValidate(){

    if(agree1.checked && agree2.checked){
        return true;
    }else{
        alert("약관에 동의해주세요");
        return false;
    }
}



// 상영중인 영화 정보 노출
(function(){

    $.ajax({
        url: "movie/nowShowing",
        dataType: "json", 
        success: function(list){
		
            console.log(list);
			const ul = document.getElementsByClassName("movie-list")[0];
            ul.innerHTML="";

			for(let movie of list){
                const li = document.createElement("li");
                const a = document.createElement("a");
                a.setAttribute("herf","#");
                
                const divMovie = document.createElement("div");
                divMovie.setAttribute("class","movie");
                
                const divMovieTop = document.createElement("div");
                divMovieTop.setAttribute("class","movie-top");

                const divMoviePoster = document.createElement("div");
                divMoviePoster.setAttribute("class","movie-poster");

                const img = document.createElement("img");
                img.setAttribute("src",movie.posterImage); // 데이터 입력후 확인하기

                divMoviePoster.append(img);

                const divRanking = document.createElement("div");
                divRanking.setAttribute("class","ranking");
                divRanking.innerText=movie.movieNo // 해당 데이터 없음, 순위 컬럼추가 후 다시 확인하기

                divMovieTop.append(divMoviePoster);
                divMovieTop.append(divRanking);

                const divMovieBottom = document.createElement("div");
                divMovieBottom.setAttribute("class","movie-bottom");

                const divMovieTitle = document.createElement("div");
                divMovieTitle.setAttribute("class","movie-title");
                divMovieTitle.innerText=movie.movieTitle // 데이터 입력후 확인하기

                const divMovieYC = document.createElement("div");
                divMovieYC.setAttribute("class","movie-year-contry");
                divMovieYC.innerText=movie.releaseYear+" ・ "+movie.country // 데이터 입력후 확인하기

                const divAvg = document.createElement("div");
                divAvg.setAttribute("class","average");
                
                const span1 = document.createElement("span");
                span1.innerText="평균"

                const svg = document.createElement("svg");
                svg.setAttribute("width","12");
                svg.setAttribute("height","10");
                svg.setAttribute("viewBox","0 0 12 10");
                svg.setAttribute("xmlns","http://www.w3.org/2000/svg");
                svg.setAttribute("fill","#555765");
                //svg.setAttribute("class","css-1g90l0x"); 필요없겠지?

                const path = document.createElement("path");
                path.setAttribute("fill-rule","evenodd");
                path.setAttribute("clip-rule","evenodd");
                path.setAttribute("d","M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z");

                svg.append(path);

                const span2 = document.createElement("span");
                span2.innerText="3.3 별점데이터 입력후 수정" // 데이터 입력후 수정-평균별점

                divAvg.append(span1);
                divAvg.append(svg);
                divAvg.append(span2);

                const divShowingInfo = document.createElement("div");
                divShowingInfo.setAttribute("class","showing-info");
                divShowingInfo.innerText="예매율 "+movie.ticketing+" ・ 누적 관객 "+movie.audience // 데이터 입력후 확인하기

                divMovieBottom.append(divMovieTitle);
                divMovieBottom.append(divMovieYC);
                divMovieBottom.append(divAvg);
                divMovieBottom.append(divShowingInfo);

                divMovie.append(divMovieTop);
                divMovie.append(divMovieBottom);
                a.append(divMovie);
                li.append(a);
                ul.append(li);

			}
		},
        error: function(){
            console.log("에러발생");
            console.log(request.responseText);
        }
    })

})();



// 검색
document.getElementById("search-btn").addEventListener("click",function(){

    const query = document.getElementById("query");
    const queryExp = /^[a-zA-Z0-9가-힣]{1,10}$/;
    const searchForm = document.getElementsByName("search-form");

    // 검색어 유효성 검사
    if( !queryExp.test(query.value) ){
        alert("영어/숫자/한글 1~10글자 사이로 작성해주세요.");
        query.value = "";
        query.focus();
        return;
    }

    // 검색어가 작성된 경우
    if(query.value.trim().length!=0){
        searchForm[0].submit();
    }

})