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
      <section id="loginUI" class="col-md-3">
      	<c:if test="${userid eq null}">
      		<div id="loginNot">
	          
         	</div>
         </c:if>
         <c:if test="${userid ne null}">
        <legend>${userid} 님!</legend>
         	<div id="loginOk">
	         	
            </div>
         </c:if>
      </section>
      
      
      <!--메인 컨텐츠-->
      <div id="main" class="col-md-9">
        <!--추천 논문-->
          <section id="newDocument">
              <h3>인기 물품</h3>
              <div class="row">
              <c:forEach items="${ranking}" var="ranking">
                <div class="col-sm-6 col-md-4">
                  <div class="thumbnail">
                    <a href="content_view.do?bId=${ranking.bId}"><img width=240 height=200 src="img/${ranking.img }" alt="..."></a>
                    <div class="caption">
                      <h3>${ranking.bTitle }</h3>
                      <p>
                        	가격 : ${ranking.price } 원
                        <br>
                         	조회수 : ${ranking.bHit }</p>
                          <p><a href="content_view.do?bId=${ranking.bId}" class="btn btn-primary" role="button">상세보기</a>
                          <c:if test="${userid ne null }">
                            <a href="interested.do?bId=${ranking.bId }" class="btn btn-outline-primary" role="button">담기</a></p>
                           </c:if>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>
          </section>

          <section id="board">
            <!--게시판<-->
              <h3>최신 물품</h3>
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead-dark">
                  <tr>
                    <th>#</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>날짜</th>
                    <th>Hit</th>
                  </tr>
                </thead>
                <tbody>           
                <!-- c:forEach items="${list}" var="dto" -->
                <c:forEach  items="${list}" begin="0" end="7" var="dto">
	                <c:if test="${dto.bIndent eq 0}">
							<c:if test="${dto.soldFlag eq 0}">
			                	<tr class="table-success">
									<td><<판매>></td>
									<td>${dto.bName}</td>
									<td>
										<c:forEach begin="1" end="${dto.bIndent}">[RE]</c:forEach>
										<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
									<td>${dto.bDate}</td>
									<td>${dto.bHit}</td>
								</tr>
			                </c:if>
			                <c:if test="${dto.soldFlag eq 1}">
			                	<tr class="table-danger">
									<td><<판매완료>></td>
									<td>${dto.bName}</td>
									<td>
										<c:forEach begin="1" end="${dto.bIndent}">[RE]</c:forEach>
										<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
									<td>${dto.bDate}</td>
									<td>${dto.bHit}</td>
								</tr>
			                </c:if>
						</c:if>
						<c:if test="${dto.bIndent ne 0}">
							<tr class="table-warning">
								<td><<문의>></td>
								<td>${dto.bName}</td>
								<td>
									<c:forEach begin="1" end="${dto.bIndent}">[RE]</c:forEach>
									<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
								<td>${dto.bDate}</td>
								<td>${dto.bHit}</td>
							</tr>
						</c:if>
			</c:forEach>
		<tr>
			<c:if test="${userid ne null }">
			<td colspan="4"> <a href="write_view.do">
								<button class="btn" type="button">글작성</button>
							</a> </td>
			</c:if>
			<c:if test="${userid eq null }"><td colspan="4"></td></c:if>
			<td><a id="page" href="./list.do?i=0" class="btn btn-outline-primary" role="button">More
							</a></td>
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
