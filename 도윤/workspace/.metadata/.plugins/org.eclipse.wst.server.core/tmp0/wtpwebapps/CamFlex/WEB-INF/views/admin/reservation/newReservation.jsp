<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 예약 리스트</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

function confirm(){
	$("#confirmRsv").attr("action", "/admin/reservation/confirmRsv");
	$("#confirmRsv").submit();
	
}
</script>
</head>
<body>
<h2 align="center">신규 예약 리스트</h2>
<%-- <div align="center">
<form:form modelAttribute="pgrq" method="get" action="newRsvList${pgrq.toUriStringByPage(1)}">
	<form:select path="searchType" items="${searchTypeCodeValueList}" itemValue="value" itemLabel="label" />
	<form:input path="keyword"/>
	<button id="searchBtn">검색</button>
</form:form>
</div> --%>
<div align="center">
	<form id="confirmRsv" action="newRsvList" method="get">
	<%-- <input type="text" id="r_number" value="${r_number.r_number}"> --%>
	<table border="1">
		<thead>
			<tr>
				<th>예약번호</th>
				<th>상품명</th>
				<th>아이디</th>
				<th>금액</th>
				<th>예약 신청일</th>
				<th>예약 시작일</th>
				<th>예약 종료일</th>
				<th>예약 승인</th>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${empty newRsvList}">
					<tr>
						<td colspan="8" align="center">예약이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="rs" items="${newRsvList}">
						<tr>
							<td>${rs.r_number}</td>
							<td><c:if test="${rs.p_number eq '1'}">오토A</c:if>
								<c:if test="${rs.p_number eq '41'}">오토B</c:if>
								<c:if test="${rs.p_number eq '42'}">글램핑A</c:if>
								<c:if test="${rs.p_number eq '43'}">글램핑B</c:if>
								<c:if test="${rs.p_number eq '44'}">글램핑C</c:if>
								<c:if test="${rs.p_number eq '45'}">글램핑D</c:if>
								<c:if test="${rs.p_number eq '46'}">차박A</c:if>
								<c:if test="${rs.p_number eq '47'}">차박B</c:if>
							</td>
							<td>${rs.m_id}</td>
							<td>${rs.r_price}</td>
							<td><fmt:formatDate value="${rs.r_apllicationDate}" pattern="yyyy/MM/dd" /></td>
							<td>${rs.r_startDate}</td>
							<td>${rs.r_endDate},<input type="hidden" value="${rs.r_number}"></td>
							<td><button type="button" onclick="confirm()">예약승인</button></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	</form>
	<!-- 페이징 네비게이션 -->
	<%-- <div>
		<c:if test="${pagination.prev}">
			<a href="${pagination.startPage - 1}">&laquo;</a>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<a href="/admin/reservation/newReservation${pagination.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		<c:if test="${pagination.next && pagination.endPage > 0}">
			<a href="${pagination.endPage + 1}">&raquo;</a>
		</c:if>
	</div> --%>
</div>
</body>
</html>