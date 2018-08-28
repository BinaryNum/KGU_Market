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
         <br><br><br>
          <div class="list-group">
            <a class="list-group-item  list-group-item-action" href="/KGU_Market/notice.do">
              공지사항
            </a>
            <a class="list-group-item list-group-item-action" href="/KGU_Market/list.do">중고거래
            </a>

          </div>
      </section>
      <div id="main" class="col-md-9">
          <section id="board">
            <!--게시판-->
              <h3>공지사항</h3>
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                  <tr>
                    <th>#</th>
                    <th>제목</th>
                    <th>날짜</th>
                    <th>Hit</th>
                  </tr>
                </thead>
                <tbody>
			    <%int i = 0;
                	if(request.getParameter("i")!=null){
			    	i=Integer.parseInt(request.getParameter("i"));
			    }	
			    	int j=8*i; %>            
			    
                <!--추가공지 추가해야되!! c:forEach items="${list}" var="dto" -->
                <c:forEach  items="${list}" begin="<%=j %>" end="<%=j+7 %>" var="dto">
						<tr class="table-info">
							<td><<공지>></td>
							<td>
								<a href="Ncontent_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
							<td>${dto.bDate}</td>
							<td>${dto.bHit}</td>
						</tr>
				</c:forEach>
		<tr>
			<c:if test="${userid eq 'admin' }">
			<td colspan="3"> <a href="Nwrite_view.do">
								<button class="btn" type="button">글작성</button>
							</a> </td>
			</c:if>
			<c:if test="${userid ne 'admin' }"><td colspan="3"></td></c:if>
			<td>
			<%if(i==0){ %>
				<!--페이지-->
	          <div id="page">
	            <ul class="pagination pagination-sm">
	              <li class="page-item">
	                <a class="page-link" href="/KGU_Market/notice.do?i=<%=i+1%>">&raquo;</a>
	              </li>
	            </ul>
	          </div>
          <%} else{ %>
          	<div id="page">
	            <ul class="pagination pagination-sm">
	              <li class="page-item">
	                <a class="page-link" href="/KGU_Market/notice.do?i=<%=i-1%>">&laquo;</a>
	              </li>
	              <li class="page-item">
	                <a class="page-link" href="/KGU_Market/notice.do?i=<%=i+1%>">&raquo;</a>
	              </li>
	            </ul>
	          </div>
	          <%} %>
          </td>
		</tr>
                </tbody>
                </table>
              

          </section>
      </div>
  </div>

  <!--바닥부분 jquery 활용-->
   <footer id="footer" class="footer"></footer>
</div>


</body>
</html>