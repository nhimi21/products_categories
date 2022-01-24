<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>New Category</title>
</head>
<body>
<div class="container">
    <h2>New Category</h2>
    <%--@elvariable id="category" type="java"--%>
    <form:form action="/category/new" method="post" modelAttribute="category">
        <table>
            <tr>
                <td>
                    <form:label path="name">Name:</form:label>
                </td>
                <td>
                    <form:input type="text" path="name" /><br>
                    <form:errors path="name" cssStyle="color: red"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Create" class="btn-primary"/>
                    <a href="/">Back</a>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>