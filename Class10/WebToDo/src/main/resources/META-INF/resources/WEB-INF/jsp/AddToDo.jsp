<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <title>Add Todo Page</title>
    <style>
        /* Add your custom CSS here */
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            color: #fff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
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
        <h1 class="mb-4">Enter Todo Details</h1>
        <div class="card">
            <div class="card-body">
                <form:form method="post" modelAttribute="todo">
                    <fieldset class="mb-3">
                        <form:label path="description">Description <i class="fas fa-info-circle"></i></form:label>
                        <form:input type="text" path="description" class="form-control" required="required"/>
                        <form:errors path="description" cssClass="text-warning"/>
                    </fieldset>
                    <fieldset class="mb-3">
                        <form:label path="targetDate">Target Date <i class="fas fa-calendar-alt"></i></form:label>
                        <form:input type="date" path="targetDate" class="form-control" required="required"/>
                        <form:errors path="targetDate" cssClass="text-warning"/>
                    </fieldset>
                    <form:input type="hidden" path="id"/>
                    <form:input type="text" path="done"/>
                    <button type="submit" class="btn btn-primary"><i class="fas fa-check"></i> Submit</button>
                </form:form>
            </div>
        </div>
    </div>

    <script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd',
        });
    </script>
</body>
</html>