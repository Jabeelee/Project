<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<style type="text/css">
     .centered {
        left: 50%; 
      }
</style>

<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/admin/main" style="font-size: 50px">CamFlex</a>
	</div>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/admin/main">통계</a></li>
			<li><a href="/admin/member/memberList">회원 관리</a></li>
			<li><a href="/admin/main">예약 관리</a></li>
			<li><a href="/admin/notice/noticeList">게시판 관리</a></li>
			<li><a href="/admin/product/productList">상품 관리</a></li>
		</ul>
		<!-- <ul class="nav navbar-nav navbar-right">
			<li><a href="/">로그인</a></li>
			<li><a href="/">회원가입</a></li>
		</ul> -->
	</div>
</div>
