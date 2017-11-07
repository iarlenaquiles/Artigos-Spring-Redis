<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form method="post" modelAttribute="artigo"
	action="${url_base}${acao}">
	<form:input path="id" type="hidden" />
	<spring:bind path="nome">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" type="text" cssClass="form-control" />
			<form:errors path="nome" />
		</div>
	</spring:bind>
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="descricao">Descrição</form:label>
		<form:input path="descricao" type="text" cssClass="form-control" />
		<form:errors path="descricao" />
	</div>

	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="arquivo">Arquivo</form:label>
		<form:input path="arquivo" type="text" cssClass="form-control" />
		<form:errors path="arquivo" />
	</div>

	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="tags">Tags</form:label>
		<form:input path="tags" type="text" cssClass="form-control"
			data-role="tagsinput" />
		<form:errors path="tags" />
	</div>

	<button type="submit" class="btn btn-primary">Salvar</button>
</form:form>