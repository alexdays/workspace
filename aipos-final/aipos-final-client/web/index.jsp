<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/switch-action.css" rel="stylesheet">
    <link href="css/footer.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
    <div class="container">
        <div class="page-header">
            <h1>Library</h1>
        </div>
        <div class="well" style="max-width: 340px; padding: 8px 0;">
            <ul class="nav nav-list">
                <li class="nav-header">Library</li>
                <li class="active">
                    <a href="#">Редактирование</a>
                </li>
                <li>
                    <a href="/locate">Все книги</a>
                </li>
            </ul>
        </div>
        <div class = "well">
            <form class="form-signin" action="/locate" method="POST">
                <h4 class="form-signin-heading">Информация о книге</h4>
                <input type="text" class="input-block-level" placeholder="Автор" name="author" value="<c:out value="${applicationScope.authorName}" />">
                <input type="text" class="input-block-level" placeholder="Название" name="title" value="<c:out value="${applicationScope.bookTitle}" />">
                <input type="text" class="input-block-level" placeholder="New" name="newValue" value="<c:out value="${applicationScope.newValue}" />">
                <select name="command">
                    <option value="add-book">Добавить книгу</option>
                    <option value="del-book">Удалить книгу</option>
                    <option value="srch-athr">Поиск автора</option>
                    <option value="srch-ttl">Поиск названия</option>
                    <option value="upd-athr">Обновить автора</option>
                    <option value="upd-ttl">Обновить название</option>
                </select>
                <button class="btn btn-success" type="submit">Выполнить</button>
            </form>
        </div>
    </div>
    <div id="push"></div>
</div>
<div id="footer">
    <div class="container">
        <p class="muted credit">&copy;  2013</p>
    </div>
</div>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>