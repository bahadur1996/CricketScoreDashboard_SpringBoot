<%--
  Created by IntelliJ IDEA.
  User: bahad
  Date: 5/2/2022
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.20.0/dist/bootstrap-table.min.css">
</head>
<body>
<table id="table"
       data-toggle="table"
       data-height="460"
       data-search="true"
       data-ajax="getItems"
       data-side-pagination="server"
       data-pagination="true">
    <thead>
    <tr>
        <th data-field="title">Title</th>
        <th data-field="link">Link</th>
        <th data-field="description">Description</th>
        <th data-field="guid">GUID</th>
    </tr>
    </thead>
</table>

<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-table@1.20.0/dist/bootstrap-table.min.js"></script>
<script src="js/dashboard.js"></script>
</body>
</html>
