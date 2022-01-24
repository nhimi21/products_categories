<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <title>Category Page</title>
</head>
<body>
<h1 style="text-align: center"><c:out value="${cat.name}"/></h1>
<hr>
<div class="container " style="display: flex;justify-content: space-around">
    <div>
        <h4>Products:</h4>
        <ul>

                <c:forEach items="${cat.products}" var="prod">
                      <li>${prod.name}</li>
                </c:forEach>

        </ul>
    </div>
    <div>
        <h4>Add Product:</h4>
        <%--@elvariable id="category" type="java"--%>
        <form action="/categories/${id}" method="post">
            <label>
                <select name="prods">
                    <c:forEach items="${toCat}" var="prod">
                        <option value="${prod.id}">
                            <c:out value="${prod.name}" />
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