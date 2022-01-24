<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Product Page</title>
</head>
<body>
<h1 style="text-align: center"><c:out value="${prod.name}"/></h1>
<hr>
<div class="container " style="display: flex;justify-content: space-around">
    <div>
        <h4>Categories:</h4>
        <ul>
            <li>
                <c:forEach items="${prod.categories}" var="cat">
                    <c:out value="${cat.name}" />
                </c:forEach>
            </li>

        </ul>
    </div>
    <div>
        <h4>Add Category:</h4>
        <%--@elvariable id="product" type="java"--%>
        <form action="/products/${product.id}" method="post">
            <label>
                <select name="cats">
                    <c:forEach items="${toProd}" var="cat">
                        <option value="${cat.id}">
                            <c:out value="${cat.name}" />
                        </option>
                    </c:forEach>
                </select>
            </label>
            <input type="submit" value="Add" class="btn-primary"/>
        </form>
    </div>
</div>
</body>
</html>