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
      
      
      <!--메인 컨텐츠-->
      <div id="main" class="col-md-9">
      
          <section id="board">
            <!--게시판<-->
              <h3>중고물품</h3>
            
                <table class="table">
		<form action="modify.do" method="post">
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
			<c:if test="${content_view.bStep eq 0 }">
				<tr>
					<td colspan="2">
	      				<img width=240 height=200 src="img/${content_view.img }"  onclick="doImgPop('img/${content_view.img }')" alt="..."  />
	    				가격 : ${content_view.price } 원
	    			<c:if test="${userid ne null }">
						<button class="btn btn-secondary" onClick="discount()" type="button">에누리</button> 
						<a href="interested.do?bId=${content_view.bId }">
						<button class="btn btn-secondary" type="button">관심물품</button>
						</a>
					</c:if>
					<br/>
	    				${content_view.bContent}
	    			</td>
				</tr>
			</c:if>
			<c:if test="${content_view.bStep ne 0 }">
				<tr><td>
					${content_view.bContent}
				</td></tr>
			</c:if>
			<!--<c:if test="${userid eq contentview.bName }"></c:if>-->
			
			<c:choose>
			<c:when test="${userid eq content_view.bName }">
			<tr >
				<td colspan="2">
				<c:if test="${content_view.bStep eq 0}">
				<a href="sold.do?bId=${content_view.bId }"><button class="btn btn-secondary" type="button">판매완료</button></a>
				</c:if>
				<a href ="content_modify.do?bId=${content_view.bId}"> 
				<button class="btn btn-secondary" type="button">수정</button></a> &nbsp;&nbsp; 
				<a href="list.do?i=0">목록보기</a> &nbsp;&nbsp; 
				<a href="delete.do?bId=${content_view.bId}&bStep=${content_view.bStep}&bGroup=${content_view.bGroup } ">삭제</a> &nbsp;&nbsp; <a href="reply_view.do?bId=${content_view.bId}">답변</a></td>
			</tr>
			</c:when>
			<c:when test="${userid eq null }">
			<tr >
				<td colspan="2">
				
				<a href="list.do?i=0">목록보기</a> &nbsp;&nbsp; 
				</td>
			</tr>
			</c:when>
			<c:when test="${userid ne null }">
			<tr >
				<td colspan="2">
				
				<a href="list.do?i=0">목록보기</a> &nbsp;&nbsp; 
				<a href="reply_view.do?bId=${content_view.bId}">답변</a></td>
			</tr>
			</c:when>
			</c:choose>
			
			
		</form>
	</table>
	<!-- 가격 에누리 -->
	<table class="table">
        <c:forEach items="${discount}" var="dis">
        	<c:choose>
        	<c:when test="${userid eq dis.bName }">
        		<c:choose>
	        	<c:when test="${dis.flag eq 0 }">
	        		<tr class="table-active">
				<form action="discount_delete.do" method="post">
					<input type=hidden name =bId value="${content_view.bId}" />
					<input type=hidden name =bId value="${content_view.bName}" />
			         <input type=hidden name="cId" value="${dis.cId }" />
				        <th><<대기>></th>
				        <td>ID : ${dis.userId }</td>
				        <th> 내용 </th>
				        <td> ${dis.contents}</td>
				        <td>
				        	<c:choose>
				        	<c:when test="${userid eq content_view.bName }">
					        		<a href="discount_accept.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">승인</a>
					         		<a href="discount_reject.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">거절</a>
					         		<input type=submit value="delete" /> 
					        	</c:when>
				        	<c:when test="${userid eq dis.userId }">
					        		<input type=submit value="delete" /> 
					        	</c:when>
					        	
					        	</c:choose>
				         </td>
						   </form>
					</tr>
	        	</c:when>
	        	
	        	<c:when test="${dis.flag eq 1 }">
	        		<tr class="table-danger">
				<form action="discount_delete.do" method="post">
					<input type=hidden name =bId value="${content_view.bId}" />
					<input type=hidden name =bId value="${content_view.bName}" />
			         <input type=hidden name="cId" value="${dis.cId }" />
				        <th><<거절>></th>
				        <td>ID : ${dis.userId }</td>
				        <th> 내용 </th>
				        <td> ${dis.contents}</td>
				        <td>
				        	<c:choose>
				        	<c:when test="${userid eq content_view.bName }">
					        		<a href="discount_accept.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">승인</a>
					         		<a href="discount_reject.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">거절</a>
					         		<input type=submit value="delete" /> 
					        	</c:when>
				        	<c:when test="${userid eq dis.userId }">
					        		<input type=submit value="delete" /> 
					        	</c:when>
					        	
					        	</c:choose>
				         </td>
						   </form>
					</tr>
	        	</c:when>
	        	
	        	<c:when test="${dis.flag eq 2 }">
	        		<tr class="table-success">
				<form action="discount_delete.do" method="post">
					<input type=hidden name =bId value="${content_view.bId}" />
					<input type=hidden name =bId value="${content_view.bName}" />
			         <input type=hidden name="cId" value="${dis.cId }" />
				        <th><<승인>></th>
				        <td>ID : ${dis.userId }</td>
				        <th> 내용 </th>
				        <td> ${dis.contents}</td>
				        <td>
				        	<c:choose>
				        	<c:when test="${userid eq content_view.bName }">
					        		<a href="discount_accept.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">승인</a>
					         		<a href="discount_reject.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">거절</a>
					         		<input type=submit value="delete" /> 
					        	</c:when>
				        	<c:when test="${userid eq dis.userId }">
					        		<input type=submit value="delete" /> 
					        	</c:when>
					        	
					        	</c:choose>
				         </td>
						   </form>
					</tr>
	        	</c:when>
	        	
        	</c:choose>
        	</c:when>
        	<c:when test="${userid eq dis.userId }">
        			<c:choose>
	        	<c:when test="${dis.flag eq 0 }">
	        		<tr class="table-active">
				<form action="discount_delete.do" method="post">
					<input type=hidden name =bId value="${content_view.bId}" />
					<input type=hidden name =bId value="${content_view.bName}" />
			         <input type=hidden name="cId" value="${dis.cId }" />
				        <th><<대기>></th>
				        <td>ID : ${dis.userId }</td>
				        <th> 내용 </th>
				        <td> ${dis.contents}</td>
				        <td>
				        	<c:choose>
				        	<c:when test="${userid eq content_view.bName }">
					        		<a href="discount_accept.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">승인</a>
					         		<a href="discount_reject.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">거절</a>
					         		<input type=submit value="delete" /> 
					        	</c:when>
				        	<c:when test="${userid eq dis.userId }">
					        		<input type=submit value="delete" /> 
					        	</c:when>
					        	
					        	</c:choose>
				         </td>
						   </form>
					</tr>
	        	</c:when>
	        	
	        	<c:when test="${dis.flag eq 1 }">
	        		<tr class="table-danger">
				<form action="discount_delete.do" method="post">
					<input type=hidden name =bId value="${content_view.bId}" />
					<input type=hidden name =bId value="${content_view.bName}" />
			         <input type=hidden name="cId" value="${dis.cId }" />
				        <th><<거절>></th>
				        <td>ID : ${dis.userId }</td>
				        <th> 내용 </th>
				        <td> ${dis.contents}</td>
				        <td>
				        	<c:choose>
				        	<c:when test="${userid eq content_view.bName }">
					        		<a href="discount_accept.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">승인</a>
					         		<a href="discount_reject.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">거절</a>
					         		<input type=submit value="delete" /> 
					        	</c:when>
				        	<c:when test="${userid eq dis.userId }">
					        		<input type=submit value="delete" /> 
					        	</c:when>
					        	
					        	</c:choose>
				         </td>
						   </form>
					</tr>
	        	</c:when>
	        	
	        	<c:when test="${dis.flag eq 2 }">
	        		<tr class="table-success">
				<form action="discount_delete.do" method="post">
					<input type=hidden name =bId value="${content_view.bId}" />
					<input type=hidden name =bId value="${content_view.bName}" />
			         <input type=hidden name="cId" value="${dis.cId }" />
				        <th><<승인>></th>
				        <td>ID : ${dis.userId }</td>
				        <th> 내용 </th>
				        <td> ${dis.contents}</td>
				        <td>
				        	<c:choose>
				        	<c:when test="${userid eq content_view.bName }">
					        		<a href="discount_accept.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">승인</a>
					         		<a href="discount_reject.do?cId=${dis.cId }&bId=${content_view.bId}" class="btn">거절</a>
					         		<input type=submit value="delete" /> 
					        	</c:when>
				        	<c:when test="${userid eq dis.userId }">
					        		<input type=submit value="delete" /> 
					        	</c:when>
					        	
					        	</c:choose>
				         </td>
						   </form>
					</tr>
	        	</c:when>
	        	
        	</c:choose>
        	</c:when>
        	<c:when test="${userid ne dis.userId} ">
        		<tr>
        			<td>비밀입니다.</td>
        		</tr>
        	</c:when>
        	</c:choose>
      </c:forEach>
</table>
	
		<form action='discount_write.do' method='post'>
			 <input type='hidden' name = 'bId' value='${content_view.bId}'>
			 <input type='hidden' name = 'bName' value='${content_view.bName}'>
			 <div id="Show" style="display:none;">
				<div  class='form-group has-success'>
					<label class='form-control-label' for='inputSuccess1'>Discount Chance!</label>
					<textarea class='form-control is-valid' rows='2' cols='10' name='contents' ></textarea>
					<div class='form-control-feedback'>원하는 가격과 메세지를 함께 입력하세요!&nbsp;&nbsp;
						<input class='btn btn-outline-success' type='submit' value='보내기'>
					</div>
				</div>
				</div>
		</form>
	
          </section>
      </div>
  </div>

   <!--바닥부분 jquery 활용-->
   <footer id="footer" class="footer"></footer>
</div>

</body>
</html>



