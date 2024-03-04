<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tags.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>부서 목록</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="fs-3 mt-3">부서관리 - 부서 목록 정보</h1>
			
			<table class="table mb-3">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서명</th>
						<th>전화번호</th>
						<th>팩스번호</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty deptList }">
							<tr>
								<td colspan="4" class="text-center">등록된 부서가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="dept" items="${deptList }">
								<tr>
									<td>${dept.no }</td>
									<td>${dept.name }</td>
									<td>${dept.tel }</td>
									<td>${dept.fax }</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<div class="text-end">
				<a href="create" class="btn btn-primary">신규 부서</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>