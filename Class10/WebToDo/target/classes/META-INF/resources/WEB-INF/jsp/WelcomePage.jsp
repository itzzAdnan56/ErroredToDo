<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Your To-Do List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom Styles */
        body {
            background-color: #f8f9fa; /* Light gray background */
        }
        .container {
            margin-top: 5rem;
            text-align: center;
        }
        .welcome-message {
            font-size: 1.5rem;
            margin-bottom: 2rem;
        }
        .todo-link {
            font-size: 1.2rem;
            color: #007bff; /* Blue color for link */
            text-decoration: none; /* Remove default underline */
        }
        .todo-link:hover {
            text-decoration: underline; /* Underline on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="welcome-message">Hello, Welcome! ${name}</h1>
        <div>
            <p>Start managing your tasks with ease.</p>
            <p>Click <a href="list-todos" class="todo-link">here</a> to manage your to-dos.</p>
        </div>
    </div>

    <!-- Bootstrap JS and jQuery (Optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
