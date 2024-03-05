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
<title>직원 관리 - 전체 직원 목록</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-12">
			<h1 class="fs-3 my-3">직원관리 - 전체 직원 목록</h1>
			<form action="list" method="get" id="form-employee" class="mb-3">
				<input type="hidden" name="page">
				<div class="mt-3 d-flex justify-content-between">
					<select class="form-control w-25" name="rows" onchange="changeRows()">
						<!-- param은 EL내장객체 -->
						<option value="5" ${param.rows eq 5 ? 'selected' : ''}>5개씩 보기</option>
						<option value="10" ${empty param.rows or param.rows eq 10 ? 'selected' : ''}>10개씩 보기</option>
						<option value="20" ${param.rows eq 20 ? 'selected' : ''}>20개씩 보기</option>
						<option value="50" ${param.rows eq 50 ? 'selected' : ''}>50개씩 보기</option>
					</select>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="sort"
							value="hireDate"
							${param.sort eq 'hireDate' ? 'checked' : '' }
							onchange="changeSort()" />
						<label class="form-check-label">입사일순</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="sort"
							value="name"
							${param.sort eq 'name' ? 'checked' : '' }
							onchange="changeSort()" />
						<label class="form-check-label">이름</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="sort"
							value="lowSalary"
							${param.sort eq 'lowSalary' ? 'checked' : '' }
							onchange="changeSort()" />
						<label class="form-check-label">낮은 임금순</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="sort"
							value="highSalary"
							${param.sort eq 'highSalary' ? 'checked' : '' }
							onchange="changeSort()" />
						<label class="form-check-label">높은 임금순</label>
					</div>
				</div>
				<table class="table">
					<colgroup>
						<col width="20%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="15%" />
						<col width="20%" />
					</colgroup>
					<thead>
						<tr>
							<th>직원명</th>
							<th>부서명</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>월급</th>
							<th>입사일</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty empList }">
								<tr>
									<td class="text-center">조회 결과가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="emp" items="${empList }">
									<tr>
										<td><a href="detail?no=${emp.no }" style="text-decoration:none">${emp.name }</a></td>
										<td>${emp.dept.name }</td>
										<td>${emp.tel }</td>
										<td>${emp.email }</td>
										<td><fmt:formatNumber value="${emp.salary }" pattern="##,###,###"/> 원</td>
										<td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd"/> </td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<div class="row">
					<div class="col-12">
						<c:if test="${paging.totalRows ne 0 }">
							<nav>
								<ul class="pagination">
									<li class="page-item">
										<a href="list?page=${paging.currentPage - 1}" class="page-link ${paging.first ? 'disabled' : ''}"
											onclick="changePage(${paging.currentPage - 1}, event)">이전</a>
									</li>
									
									<c:forEach var="num" begin="${paging.beginPage }" end="${paging.endPage }">
										<li class="page-item ${paging.currentPage eq num ? 'active' : '' }">
											<a href="list?page=${num }"
												class="page-link"
												onclick="changePage(${num}, event)">${num }</a>
										</li>
									</c:forEach>
									
									<li class="page-item">
										<a href="list?page=${paging.currentPage + 1}" class="page-link ${paging.last ? 'disabled' : ''}"
											onclick="changePage(${paging.currentPage + 1}, event)">다음</a>
									</li>
								</ul>
							</nav>
						</c:if>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<div class="text-end">
				<a href="create" class="btn btn-primary">신규 직원</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function changeRows() {
	document.getElementById("form-employee").submit();
}

function changeSort() {
	document.getElementById("form-employee").submit();
}

function changePage(page, event) {
	event.preventDefault();
	document.querySelector("input[name=page]").value = page;
	document.getElementById("form-employee").submit();
}
</script>
</body>
</html>