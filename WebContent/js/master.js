//페이지가 로드되면 실행한다.

$(document).ready( function() {

	$("#banner").load("./sub/banner.html");

	//~이렇게 한줄만 해주면 알아서 contents에 testContents.html파일을 넣어 준다.

});


$(document).ready( function() {

	$("#footer").load("./sub/footer.html");

	//~이렇게 한줄만 해주면 알아서 contents에 testContents.html파일을 넣어 준다.

});

$(document).ready( function() {

	$("#loginOk").load("./sub/loginOk.html");

	//~이렇게 한줄만 해주면 알아서 contents에 testContents.html파일을 넣어 준다.

});
$(document).ready( function() {

	$("#loginNot").load("./sub/loginNot.html");

	//~이렇게 한줄만 해주면 알아서 contents에 testContents.html파일을 넣어 준다.

});



$(document).ready(function(){
	//세션아이디 확인용
	
	
	//var userid = "${sessionScope.interesr}";
	//alert("세션아이디 ="+userid);	 
	

	
});

function Logincheck(){
	var id=$("#id").val();
	var password=$("#password").val();
	
	$.ajax({
		type:"post",
		url:"Logincheck.do",
		data:{id:id,password:password},
		dataType:"json",
		success:function(data){
		if(data.idcheck==1){
			
			alert("로그인에 성공 하였습니다!");
			location.href="index.do";
		}
		else{
			alert("아이디 또는 비밀번호를 확인하여 주십시오");
		}
		
		
			},
		complete:function(data){
			
		},
		error:function(x,e){ if(x.status==0){ alert('You are offline!!n Please Check Your Network.'); }else if(x.status==404){ alert('Requested URL not found.'); }else if(x.status==500){ alert('Internel Server Error.'); }else if(e=='parsererror'){ alert('Error.nParsing JSON Request failed.'); }else if(e=='timeout'){ alert('Request Time out.'); }else {alert("오류");}}
		
	});
}

var flag=0;
function doublecheck(){
		
		var id=$("#id").val();
		
		$.ajax({
			type:"post",
			url:"doublecheck.do",
			data:{id:id},
			dataType:"json",
			success:function(data){
			if(data.idflag==1){
				
				alert("사용할 수 없는 아이디입니다");
				
			}
			else{
				flag=1;
				alert("사용할 수 있는 아이디입니다");
			}
				
			
				},
			complete:function(data){
				
			},
			error:function(x,e){ if(x.status==0){ alert('You are offline!!n Please Check Your Network.'); }else if(x.status==404){ alert('Requested URL not found.'); }else if(x.status==500){ alert('Internel Server Error.'); }else if(e=='parsererror'){ alert('Error.nParsing JSON Request failed.'); }else if(e=='timeout'){ alert('Request Time out.'); }else {alert("오류");}}
			
		});
	}



function checkfield(){
	 //var lan=${lno};
	 if(flag==0){
		 alert("아이디 중복체크를 해주세요!");
		 return false;
	 }
	 
	 if(document.join.id.value==""){ //id값이 없을 경우
	alert("아이디를 입력하세요!");
	       //메세지 경고창
	 return false;
	 }
	 else if(document.join.pw1.value==""){
		alert("비밀번호를 입력하세요!");
	 return false;
	 
	 }else if(document.join.pw2.value==""){
	alert("비밀번호 확인을 입력하세요!");
	 return false;
	 }
	 else if(document.join.name.value==""){
			alert("이름을 입력하세요!");
			 return false;
			 }
	 else if(document.join.pw1.value!=document.join.pw2.value){
	 //비밀번호와 비밀번호확인의 값이 다를 경우
	alert("비밀번호가 일치하지 않습니다.");
	 return false;
	 }
	 else if(exptext.test(document.join.email.value)==false){
	 //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
	 
	 alert("이 메일형식이 올바르지 않습니다.");
	 return false;
	 }
		 
	 else{
	alert("회원가입을 축하합니다.");
	return true;
	 }
	 

	 
	}


	   function discount(){
		   $("#Show").show(); 
	   }
function signUpCheck() {
    var form = document.signupform; // form name
    
    if(form.email.value.indexOf("@kyonggi.ac.kr") < 0) { // input name = email -> check 
        alert("@kyonggi.ac.kr 로만 가입이 가능합니다.");
        form.email.focus(); 
        return;
    }
    form.submit();
}

//이미지 클릭시 원본 크기로 팝업 보기
function doImgPop(img){ 
 img1= new Image(); 
 img1.src=(img); 
 imgControll(img); 
} 
  
function imgControll(img){ 
 if((img1.width!=0)&&(img1.height!=0)){ 
    viewImage(img); 
  } 
  else{ 
     controller="imgControll('"+img+"')"; 
     intervalID=setTimeout(controller,20); 
  } 
}
function viewImage(img){ 
 W=img1.width; 
 H=img1.height; 
 O="width="+W+",height="+H+",scrollbars=yes"; 
 imgWin=window.open("","",O); 
 imgWin.document.write("<html><head><title>:*:*:*: 이미지상세보기 :*:*:*:*:*:*:</title></head>");
 imgWin.document.write("<body topmargin=0 leftmargin=0>");
 imgWin.document.write("<img src="+img+" onclick='self.close()' style='cursor:pointer;' title ='클릭하시면 창이 닫힙니다.'>");
 imgWin.document.close();
}
 







