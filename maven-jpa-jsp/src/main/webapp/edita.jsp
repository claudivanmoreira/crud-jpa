<%-- 
    Document   : edita
    Created on : 01/06/2014, 12:32:13
    Author     : Claudivan Moreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="margin: 100px auto; width: 600px;">

            <h2>Crud JPA - Edição de Pessoa</h2>

            <br/><br/>
            <a href="index.jsp" class="btn btn-primary">Voltar</a>
            <br/><br/>

            <c:if test="${errorMessage != null}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>
            <c:if test="${infoMessage != null}">
                <div class="alert alert-success">${infoMessage}</div>
            </c:if>

            <form role="form" action="PessoaController" method="post">
                <input type="hidden" name="acao" value="editar"/>
                <div class="form-group">
                    <label for="inputNome">ID</label>
                    <input type="text" name="id" value="${pessoa.id}" class="form-control" id="inputNome" readonly="true">
                </div>
                <div class="form-group">
                    <label for="inputNome">Nome</label>
                    <input type="text" name="nome" value="${pessoa.nome}" class="form-control" id="inputNome" placeholder="Nome">
                </div>
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="email" name="email" value="${pessoa.email}" class="form-control" id="inputEmail" placeholder="email">
                </div>
                <button type="submit" class="btn btn-warning">Atualizar</button>
                <button type="reset" class="btn btn-default">Cancelar</button>
            </form>
        </div>
    </body>
</html>
