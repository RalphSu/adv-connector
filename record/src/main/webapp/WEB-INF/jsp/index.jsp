<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body style="background-image: none;">
<div class="body_wrap">
    <div class="container">
        <div class="alert alert-success text-center" role="alert">Sptring Boot教程</div>
        <table class="table table-striped table-bordered">
            <tr>
                <td>author</td>
                <td>class name</td>
                <td>address</td>
            </tr>
            <c:forEach var="learn" items="${learnList}">
                <tr class="text-info">
                    <td >${learn.author}</td>
                    <td >${learn.title}</td>
                    <td><a href="${learn.url}" class="btn btn-search btn-green"><span>click</span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
