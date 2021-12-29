<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 취소 리스트</title>
</head>
<body>
<h2 align="center">예약 취소 리스트</h2>
<div id="reservationList" align="center">
	<table border="1">
		<thead>
			<tr>
				<th>예약번호</th>
				<th>상품명</th>
				<th>아이디</th>
				<th>금액</th>
				<th>예약 시작일</th>
				<th>예약 종료일</th>
				<th>예약 확정일</th>
				<th>취소 사유</th>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${empty cancelList}">
					<tr>
						<td colspan="8" align="center">예약이 존재하지 않습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="rs" items="${cancelList}">
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
							<td>${rs.r_startDate}</td>
							<td>${rs.r_endDate}</td>
							<td><fmt:formatDate value="${rs.r_updDate}" pattern="yyyy/MM/dd" /></td>
							<td>${rs.r_cancel}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
</body>
</html>