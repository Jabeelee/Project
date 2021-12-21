<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" uri="/WEB-INF/views/tld/custom_tag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트 페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		/* 검색 후 검색 대상과 검색 단어 출력 */
		var word = "<c:out value = '${data.keyword}' />";
		var value = "";
		if(word != ""){
			$("#keyword").val("<c:out value = '${data.keyword}' />");
			$("#search").val("<c:out value = '${data.search}' />");
			
			if($("#search").val() != 'm_name')
				value = "#list tr td.mName";
			else if($("#search").val() == 'm_phone')
				value = "#list tr td.phone";
			
		/* 	$(value+":contains('"+ word +"')").each(function(){
				var regex = new RegExp(word,'gi');
				$(this).html($(this).text().replace(regex,"<span class='required'>" + word + "</span>"));
			}); */
		}
		
		
		/* 검색 대상이 변경될 때마다 처리 이벤트 */
		$("#search").change(function(){
			if($("#search").val() == "all"){
				$("#keyword").val("전체 데이터 조회합니다.");
			}else if($("#search").val() != "all"){
				$("#keyword").val("");
				$("#keyword").focus();
			}
				
		});
		/* 검색 버튼 클릭 시 처리 이벤트 */
		$("#searchData").click(function(){
			if($("#search").val() != "all"){
				if(!chkSubmit($('#keyword'), "검색어를"))return;
			}
			goPage(1);
		});
	
		/* 한 페이지에 보여줄 레코드 수 조회 후 선택한 값 그대로 유지하기 위한 설정 */
		if("<c:out value='${data.pageSize}' />" != ""){
			$("#pageSize").val("<c:out value='${data.pageSize}' />");
		}
		$("#pageSize").change(function(){
			goPage(1);
		});
		
	});
	/* 검색과 한 페이지에 보여줄 레코드 수 처리 및 페이징을 위한 실질적인 처리 함수 */
	function goPage(page){
		if($("#search").val() == "all"){
			$("#keyword").val("");
		}
		$("#page").val(page);
		$("#m_search").attr({
			"method":"get",
			"action":"/admin/member/memberList"
		});
		$("#m_search").submit();
	}
	function chkSubmit(item, msg){
		if(item.val().replace(/\s/g,"") == ""){
			alert(msg + "입력해 주세요.");
			item.val("");
			item.focus();
			return false();
		}else{
			return true;
		}
	}
</script>
</head>
<body>
<h2 align="center">회원 리스트</h2>
<%--검색기능 시작 --%>
<div id="memberSearch">
	<form id="m_search" name="m_search">
		<%-- <input type="hidden" id="page" name="page" value="${data.page}"/> --%>
		<table summary="검색" align="center">
			<colgroup>
				<col width="70%"></col>
				<col width="30%"></col>
			</colgroup>
			<tr>
				<td id="btd1">
					<select id="search" name="search">
						<option value="all">전체</option>
						<option value="m_name">이름</option>
						<option value="m_phone">전화번호</option>
					</select>
					<input type="text" name="keyword" id="keyword" value="검색어를 입력하세요" />
					<input type="button" value="검색" id="searchData" />
				</td>
			</tr>
		</table>
	</form>
</div>
<%--검색기능 끝 --%>
<div id="memberList" align="center">
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody id="list">
			<c:choose>
				<c:when test="${not empty memberList}">
					<c:forEach var="member" items="${memberList}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td class="mName">${member.m_id}</td>
							<td>${member.m_name}</td>
							<td class="phone">${member.m_phone}</td>
							<td><fmt:formatDate value="${member.m_date}" pattern="yyyy/MM/dd" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5" align="center">회원이 존재하지 않습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
<div id="memberPage" align="center">
	<tag:paging page="${param.page}" total="${total}" list_size="${data.pageSize}" />
</div>
</body>
</html>