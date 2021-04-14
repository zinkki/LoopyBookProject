<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%> 

<style>
     .wrap {
     	display:flex;
     	justify-content:center;
     	align-items:center;
     	height: 50vh;
     	margin-left:500px;
     	position:absolute;
     }
</style>

<body class="text-center">

<main class="form-signin">
<div class="wrap">
  <form action="/user/login_success" method="post" >
    <h1 class="h3 mb-3 fw-normal">Login</h1>
    <label  style="vertical-align: 17px" >ID</label>
    <input type="text" id="user_id" name="user_id" class="form-control" style="vertical-align: 17px; text-align: right: ;" placeholder="아이디를 입력하세요" required autofocus><br>
    <label for="inputPw" class="visually-hidden">Password</label>
    <input type="password" id="user_pw" name="user_pw" class="form-control" placeholder="비밀번호를 입력하세요" required>
    <div class="checkbox mb-3">
    </div>
    <c:if test="${message != null }">
    	<p style="color: red">${message }</p>
    </c:if>
     <input type="hidden" name="referer" value="${referer }">
    <input class="btn btn-lg btn-primary " type="submit" value="LOGIN">
  </form>
</div>
</main>

</body>
  