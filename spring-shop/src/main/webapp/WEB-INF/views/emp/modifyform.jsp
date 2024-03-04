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
<title>직원관리 - 직원 정보 수정폼</title>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1 class="mt-3">직원관리 - 직원 정보 수정폼</h1>
			
			<form class="border bg-light p-3"
				method="post"
				action="modify">
				<input type="hidden" name="no" value="${emp.no }"/>
				<div class="form-group mb-3">
					<label class="form-label">직원 이름</label>
					<input type="text" class="form-control" name="name" value="${emp.name }"/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">부서</label>
					<select class="form-select" name="deptNo">
						<c:forEach var="dept" items="${deptList }">
							<option value="${dept.no }" ${dept.no eq emp.dept.no ? 'selected' : '' }>${dept.name } </option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">전화번호</label>
					<input type="text" class="form-control" name="tel" value="${emp.tel }" />
				</div>
				<div class="form-group mb-3">
					<label class="form-label">이메일</label>
					<input type="text" class="form-control" name="email" value="${emp.email }"/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">급여</label>
					<input type="text" class="form-control" name="salary" value="${emp.salary }"/>
				</div>
				<div class="form-group mb-3">
					<label class="form-label">입사일</label>
					<fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd" var="hireDate"/>
					<input type="date" class="form-control" name="hireDate" value="${hireDate }" />
				</div>
				<div class="text-end">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>