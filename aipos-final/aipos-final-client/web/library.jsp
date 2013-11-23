<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/library.css" rel="stylesheet">
    <link href="css/footer.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<div id="wrap" itemscope itemtype="http://schema.org/Thing/Organization/LocalBusiness/Library">
    <div class="container">
        <div class="page-header">
            <h1 itemprope="name">Library - Каталог книг</h1>
        </div>
        <div class = "well">
            <table class="table" itemscope itemtype="http://schema.org/Thing/CreativeWork/WebPageElement/Table">
                <thead>
                <tr>
                    <th>#</th>
                    <th itemprope="authorName">Автор</th>
                    <th itemprope="bookTitle">Название книги</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${applicationScope.library}" var="book">
                    <tr>
                        <td itemprope="bookId"><c:out value="${library.indexOf(book) + 1}"></c:out></td>
                        <td itemprope="bookAuthor"><c:out value="${book.getAuthor()}"></c:out></td>
                        <td itemprope="bookTitle"><c:out value="${book.getTitle()}"></c:out></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div id="push"></div>
</div>
<div id="footer">
    <div class="container">
        <p class="muted credit">&copy; 2013</p>
    </div>
</div>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>