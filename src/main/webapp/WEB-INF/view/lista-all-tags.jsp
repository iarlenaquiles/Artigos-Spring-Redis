<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url var="url_base" value="/" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tags</title>
<link href="${url_base}css/bootstrap.min.css" rel="stylesheet">
<script src="https://use.fontawesome.com/d91313ced9.js"></script>
<script src="${url_base}js/jquery.min.js"></script>

</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container">
				<h2>Todas as Tags</h2>
		<div id="list" class="row">
			<div class="table-responsive col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Ação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tags}" var="tag">
							<tr>
								<td>${tag}</td>
								<td class="actions"><a class="btn btn-warning btn-sm"
									href="/artigos/${tag}"><i
										class="fa fa-pencil"></i> Todas os artigos desta tag</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>