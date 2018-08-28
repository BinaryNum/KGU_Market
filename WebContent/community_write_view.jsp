<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <div id="content" class="row">
    <!--로그인jquery 활용---->
      <section id="login" class="col-md-3">
      	<c:if test="${userid eq null}">
      		<div id="loginNot">
	          
         	</div>
         </c:if>
         <c:if test="${userid ne null}">
         <h5> ${userid} 님!</h5>
         	<div id="loginOk">
	         	
            </div>
         </c:if>
         
      </section>
      
      
      <!--메인 컨텐츠-->
      <div id="main" class="col-md-9">
          <section id="board">
            <!--게시판<-->
              <h3>커뮤니티</h3>
            <table class="table">
          
		<form action="community_write.do" method="post" >
		<input  type="hidden" name="bName" value="${userid}">
			<tr>
				<td> 제목 </td>
				<td> <input class="form-control" type="text" name="bTitle" size = "50"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea class="form-control" name="bContent" rows="10" ></textarea> </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit"  class="btn" value="입력"> &nbsp;&nbsp; <a href="community_list.do?i=0">목록보기</a></td>
			</tr>
		</form>
	</table>

          </section>
      </div>
  </div>

    <!--바닥부분 jquery 활용-->
   <footer id="footer" class="footer"></footer>
</div>
</body>
</html>
