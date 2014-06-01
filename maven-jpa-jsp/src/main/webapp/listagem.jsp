<%-- 
    Document   : listagem
    Created on : 01/06/2014, 09:33:19
    Author     : Claudivan Moreira
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h2>Crud JPA - Listagem de Pessoas</h2>
            <br/><br/><br/>

            <c:if test="${errorMessage != null}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>
            <c:if test="${infoMessage != null}">
                <div class="alert alert-success">${infoMessage}</div>
            </c:if>

            <table class="table">
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>email</th>
                    <th>Opções</th>
                </tr>
                <c:forEach var="pessoa" items="${listaPessoas}">
                    <tr>
                        <td>${pessoa.id}</td>
                        <td>${pessoa.nome}</td>
                        <td>${pessoa.email}</td>
                        <td style="width: 170px;">
                            <a href="PessoaController?acao=selecinar&id=${pessoa.id}" class="btn btn-default">Editar</a>&nbsp;
                            <a href="PessoaController?acao=remover&id=${pessoa.id}" class="btn btn-danger">Remover</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <a href="cadastro.jsp" class="btn btn-success">Novo Cadastro</a>
        </div>
    </body>
</html>
