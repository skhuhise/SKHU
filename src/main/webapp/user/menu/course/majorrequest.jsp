<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>SKHU 졸업관리</title>
</head>

<body>
	<jsp:include page="../header.jsp" flush="true"></jsp:include>
	<main>
	<div class="container">
		<div id="header" class="panel panel-default">
			<div class="panel-body">
				<table>
					<h4 class="title text-center">전공인정신청 방법</h4>
					<hr />
					<tr>
						<td class="col-md-5 text-center">공학계 타학과 개설 과목 이수</br> ↓</br> 전공​인정신청서와
							이수구분변경신청서를 제출</br> ↓</br> 승인된 경우, 전공 선택으로 인정
						</td>
					</tr>
					<tr>
						<td class="col-md-5 text-center">
							<hr /> ***</br> 단, 전공필수 과목은 반드시 소프트웨어공학과에서 이수하여야함</br> 같은 과목을 소프트웨어공학과와
							타과에서 이중 이수한 경우 타과 이수 과목은 전공으로 인정하지 않음
							<p />
						</td>
					</tr>
				</table>

				<hr />

				<h3 class="text-center mb-25">전공 인정 신청</h3>
				<form>
					<div class="form-group col-md-4 col-md-offset-4">
						과목명: <select name="subjectName"
							class="form-control">
							<option value="1">전공인정과목1</option>
							<option value="2">전공인정과목2</option>
							<option value="3">전공인정과목3</option>
						</select>
					</div>
					<div>
						<button type="submit"
							class="btn btn-info col-md-2 col-md-offset-5 mb-25">신청</button>
					</div>
				</form>

			</div>
		</div>
	</div>
	</main>
	<footer> </footer>
</body>
</html>

