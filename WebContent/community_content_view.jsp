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
		<form action="community_modify.do" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<td> 번호 </td>
				<td> ${content_view.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${content_view.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> ${content_view.bName}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> ${content_view.bTitle}</td>
			</tr>
			<tr>
				<td> 내용 </td><td></td>
			</tr>
				<td colspan="2">
      				
    			${content_view.bContent}
    			</td>
			</tr>
			<!--<c:if test="${userid eq contentview.bName }"></c:if>-->
			<c:choose>
			<c:when test="${userid eq content_view.bName }">
			<tr >
				<td colspan="2">
				<a href ="community_content_modify.do?bId=${content_view.bId}"> 
				<button class="btn btn-secondary" type="button">수정</button></a> &nbsp;&nbsp; 
				<a href="community_list.do?i=0">목록보기</a> &nbsp;&nbsp; 
				<a href="community_delete.do?bId=${content_view.bId}&bStep=${content_view.bStep}&bGroup=${content_view.bGroup } ">삭제</a> &nbsp;&nbsp; <a href="community_reply_view.do?bId=${content_view.bId}">답변</a></td>
			</tr>
			</c:when>
			<c:when test="${userid eq null }">
			<tr >
				<td colspan="2">
				<a href="community_list.do?i=0">목록보기</a> &nbsp;&nbsp; </td>
			</tr>
			</c:when>
			<c:when test="${userid ne null }">
			<tr >
				<td colspan="2">
				
				<a href="community_list.do?i=0">목록보기</a> &nbsp;&nbsp; 
				 <a href="community_reply_view.do?bId=${content_view.bId}">답변</a></td>
			</tr>
			</c:when>
			</c:choose>
			
		</form>
	</table>

<!-- 댓글 보여주기 -->
	<table class="table">
        <c:forEach items="${comments}" var="cm">
        	<tr>
				<form action="community_comment_delete.do" method="post">
				        <th>ID</th>
				        <td> ${cm.userId }</td>
				        <th> 내용 </th>
				        <td> ${cm.contents}</td>
				        <td>
				         	<c:if test="${userid eq cm.userId }">
				         	<input type=submit value="delete" /> 
				         	</c:if>
				         </td>
					         <input type=hidden name =bId value="${content_view.bId}" />
					         <input type=hidden name="cId" value="${cm.cId }" />
					
				         </form>
			</tr>
      </c:forEach>
      
      <!-- 댓글 입력 -->
      
      <c:if test="${userid ne null }">
      <tr>
      	<th colspan="5">댓글 부분</th>
      </tr>
      <tr>
          <td colspan="5">
            <form action="community_comment_write.do" method="post">
            <textarea name="contents" rows="2" cols="70" placeholder="댓글을 입력하세요."></textarea>
            <input type=hidden name =bId value="${content_view.bId}" />
            <input type=hidden name =userId value="${userid}" />
            <input type=submit value="확인"/>
            </form>
            </td>
     </tr>
	</c:if>

	</table>
          </section>
      </div>
  </div>

   <!--바닥부분 jquery 활용-->
   <footer id="footer" class="footer"></footer>
</div>

</body>
</html>



