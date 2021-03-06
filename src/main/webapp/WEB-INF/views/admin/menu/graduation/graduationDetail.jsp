<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../../res/css/common/main.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="../../../res/css/common/form.css?ver=1">
<script type="text/javascript"
	src="../../../res/script/common/mygraduation.js?ver=1"></script>
<title>SKHU 졸업관리</title>
</head>

<body>
	<jsp:include page="../header.jsp" flush="true"></jsp:include>
	<main>
	<div class="container">
		<div id="header" class="panel panel-default">
			<div class="panel-body">
				<table class="table text-center">
					<tr>
						<td class="title col-md-1">학번</td>
						<td class="col-md-1">${ student.studentNumber }</td>
						<td class="title col-md-1">이름</td>
						<td class="col-md-1">${ student.name }</td>
						<td class="title col-md-1">학과</td>
						<td class="col-md-2">${ student.department.name }</td>
					</tr>
				</table>
				<h3>${ student.graduation }</h3>
				<c:if test="${student.graduation ne '미설정'}">
					<div class="text-center">
						<h3>필요 학점</h3>
					</div>
					<div class="table-responsive">
						<table class="table text-center">
							<c:forEach var="map" items="${ graduationGradeMap }"
								varStatus="status">
								<c:choose>
									<c:when test="${ status.index == 0 }">
										<tr>
											<td class="col-md-3 active"><c:if
													test="${map.key.departmentId != 1}">${ map.key.department.name } </c:if>${ map.key.graduation.name }</td>
										</tr>
									</c:when>
									<c:when
										test="${ map.key.graduation.id != graduationGrades[status.index - 1].graduation.id }">
						</table>
					</div>
					<div class="table-responsive">
						<table class="table text-center">
							<tr>
								<td class="col-md-3 active"><c:if
										test="${map.key.departmentId != 1}">${ map.key.department.name } </c:if>${ map.key.graduation.name }</td>
							</tr>
							</c:when>
							</c:choose>
							<tr>
								<c:if test="${ map.key.name ne '상세졸업과정'}">
								<td
									class="col-md-3 <c:choose> 
									<c:when test="${ map.key.score <= map.value }">success</c:when>
									<c:otherwise>danger</c:otherwise>
								</c:choose>">
									${ map.key.name } ${ map.value }/${ map.key.score }<c:if
										test="${ map.key.note ne ''}">(${ map.key.note })</c:if>
									
								</td>
								</c:if>
							</tr>
							</c:forEach>
						</table>
					</div>


					<div class="text-center">
						<h3>필요 과목</h3>
					</div>


					<div class="table-responsive">
						<table class="table text-center">
							<c:forEach var="map" items="${ graduationSubjectMap }"
								varStatus="status">
								<c:choose>
									<c:when test="${ status.index == 0 }">
										<tr>
											<td class="col-md-3 active"><c:if
													test="${map.key.departmentId != 1}">${ map.key.department.name } </c:if>${ map.key.graduation.name }</td>
										</tr>
									</c:when>
									<c:when
										test="${ map.key.graduation.id != graduationSubjects[status.index - 1].graduation.id }">
						</table>
					</div>
					<div class="table-responsive">
						<table class="table text-center">
							<tr>
								<td class="col-md-3 active"><c:if
										test="${map.key.departmentId != 1}">${ map.key.department.name } </c:if>${ map.key.graduation.name }</td>
							</tr>
							</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${ status.index == 0 }">
									<c:if test="${ map.key.note ne '' }">
									<tr>
										<td class="col-md-3 active">${ map.key.note }</td>
									</tr>
									</c:if>
								</c:when>
								<c:when
									test="${ map.key.note ne graduationSubjects[status.index - 1].note }">
									<c:if test="${ map.key.note ne '' }">
									<tr>
										<td class="col-md-3 active">${ map.key.note }</td>
									</tr>
									</c:if>
								</c:when>
							</c:choose>
							<tr>
							<td
								class="col-md-3 <c:choose> 
									<c:when test="${ map.value == 0 }">danger</c:when>
									<c:when test="${ map.value == 1 }">success</c:when>
										<c:when test="${ map.value == 2 }">active</c:when>
									</c:choose>">
								${ map.key.subject.name }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	</main>
	<footer> </footer>
</body>
</html>