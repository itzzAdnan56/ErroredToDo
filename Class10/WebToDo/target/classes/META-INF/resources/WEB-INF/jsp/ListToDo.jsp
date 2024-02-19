<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <title>List Todos Page</title>
    <style>
        /* Add your custom CSS here */
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
        }
        .btn-warning {
            color: #fff;
        }
        .btn-success {
            color: #fff;
        }
    </style>
</head>
<body>
    <!-- Navigation bar code remains the same -->
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3 p-1">
    	<a class="navbar-brand m-1" href="https://itzzadnan56bbdeng.000webhostapp.com/#">AdPortfolio</a>
    	<div class="collapse navbar-collapse">
    		<ul class="navbar-nav">
    			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
    			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
    		</ul>
    	</div>
    	<ul class="navbar-nav">
    		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    	</ul>
    </nav>

    <div class="container">
        <h1 class="mb-4">Your Todos</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href = "delete-todo?id=${todo.id}" class ="btn btn-warning"><i class="fas fa-trash"></i> Delete</td>
                        <td><a href = "update-todo?id=${todo.id}" class ="btn btn-success"><i class="fas fa-edit"></i> Update</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class="btn btn-primary"><i class="fas fa-plus"></i> Add Todo</a>
    </div>

    <script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>