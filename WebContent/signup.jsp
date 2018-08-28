<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./css/master.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="js/bootstrap.min.js"></script>
	<script src="./js/master.js"></script>
    <title>경기대학교 중고거래</title>
</head>
<body>
<div class="container">
   <!--배너부분 jquery활용해서 처리-->
  <header id="banner" class="jumbotron"></header>

<!--본 화면-->
              <!-- 모달창 -->
<div class="row">
    <div class="col-md-6">
      <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">알림</h4>
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--// 모달창 -->
            <hr/>
                <!-- 본문 들어가는 부분 -->

        <form class="form-horizontal" role="form" method="post" action="javascript:alert( 'success!' );">
            <div class="form-group">
                <label for="provision" class="control-label">회원가입약관</label>
                <div class="col-lg-10" id="provision">
                    <textarea class="form-control" rows="8" style="resize:none">
약관동의
                    </textarea>
                    <div class="radio">
                        <label>
                            <input type="radio" id="provisionYn" name="provisionYn" value="Y" autofocus="autofocus" checked>
                            동의합니다.
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" id="provisionYn" name="provisionYn" value="N">
                            동의하지 않습니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="memberInfo" class="control-label">개인정보취급방침</label>
                <div class="col-lg-10" id="memberInfo">
                    <textarea class="form-control" rows="8" style="resize:none">
개인정보의 항목 및 수집방법
                    </textarea>
                    <div class="radio">
                        <label>
                            <input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y" checked>
                            동의합니다.
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" id="memberInfoYn" name="memberInfoYn" value="N">
                            동의하지 않습니다.
                        </label>
                    </div>
                </div>
            </div>
    </div>
    <div class="col-md-6">
              <div class="modal fade" id="defaultModal">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title">알림</h4>
                          </div>
                          <div class="modal-body">
                              <p class="modal-contents"></p>
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                          </div>
                      </div><!-- /.modal-content -->
                  </div><!-- /.modal-dialog -->
              </div><!-- /.modal -->
              <!--// 모달창 -->
              <hr/>
                  <!-- 본문 들어가는 부분 -->

</form>

         <form class="form-horizontal" role="form" method="post" action="signup.do" onsubmit='return checkfield();' name="join" >
              <div class="form-group" id="divId">
                  <label for="inputId" class="control-label">아이디</label>
                  <div class="col-lg-10">
                      <input type="text" class="form-control onlyAlphabetAndNumber" id="id" name="id" data-rule-required="true" placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다." maxlength="30">
                      <div align="right"><input id="double" type="button" class="btn btn-outline-secondary" value="중복검사" onclick="doublecheck();return false;"></div>
                  </div>
              </div>
              <div class="form-group" id="divPassword">
                  <label for="inputPassword" class="control-label">패스워드</label>
                  <div class="col-lg-10">
                      <input type="password" class="form-control" id="pw1"  name="pw1" data-rule-required="true" placeholder="패스워드" maxlength="30">
                  </div>
              </div>
              <div class="form-group" id="divPasswordCheck">
                  <label for="inputPasswordCheck" class="control-label">패스워드 확인</label>
                  <div class="col-lg-10">
                      <input type="password" class="form-control" id="pw2" name="pw2" data-rule-required="true" placeholder="패스워드 확인" maxlength="30">
                  </div>
              </div>
              <div class="form-group" id="divName">
                  <label for="inputName" class=" control-label">이름</label>
                  <div class="col-lg-10">
                      <input type="text" class="form-control onlyHangul" id="name" name="name" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15">
                  </div>
              </div>

              <div class="form-group" id="divNickname">
                  <label for="inerested" class=" control-label">전공</label>
                 <div class="col-lg-10">
                      <input type="text" class="form-control onlyHangul" id="interested" name="interested" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15">
                  </div>
              </div>

              <div class="form-group" id="divEmail">
                  <label for="inputEmail" class=" control-label">이메일</label>
                  <div class="col-lg-10">
                      <input type="email" value="${email}" class="form-control" id="email" name="email" data-rule-required="true" maxlength="40">
                  </div>
              </div>
              <div class="form-group" id="divPhoneNumber">
                  <label for="inputPhoneNumber" class=" control-label">휴대폰 번호</label>
                  <div class="col-lg-10">
                      <input type="tel" class="form-control onlyNumber" id="phoneNumber" name="phonenumber" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
                  </div>
              </div>
              <div class="form-group">
                  <label for="inputPhoneNumber" class=" control-label">성별</label>
                  <div class="col-lg-10">
                      <select class="form-control" id="gender" name="gender">
                          <option value="M">남</option>
                          <option value="F">여</option>
                      </select>
                  </div>
              </div>
              <!--
              <div class="form-group">
                  <label for="inputEmailReceiveYn" class=" control-label">이메일 수신여부</label>
                  <div class="col-lg-10">
                      <label class="radio-inline">
                          <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="Y" checked> 동의합니다.
                      </label>
                      <label class="radio-inline">
                          <input type="radio" id="emailReceiveYn" name="emailReceiveYn" value="N"> 동의하지 않습니다.
                      </label>
                  </div>
              </div>
              <div class="form-group">
                  <label for="inputPhoneNumber" class=" control-label">SMS 수신여부</label>
                  <div class="col-lg-10">
                      <label class="radio-inline">
                          <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="Y" checked> 동의합니다.
                      </label>
                      <label class="radio-inline">
                          <input type="radio" id="smsReceiveYn" name="smsReceiveYn" value="N"> 동의하지 않습니다.
                      </label>
                  </div>
              </div>
            -->
              <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-10"align="right">
                      <button type="submit" class="btn btn-outline-secondary">Sign in</button>
                  </div>
              </div>
          </form>
  </div>
  </div>

    <!--바닥부분 jquery 활용-->
   <footer id="footer" class="footer"></footer>
</div>




</body>
</html>
