<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Todo App - Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f7f7f7;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-container {
      background-color: #fff;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      width: 100%;
    }

    h2 {
      text-align: center;
    }

    .input-group {
      margin-bottom: 20px;
    }

    .input-group label {
      display: block;
      margin-bottom: 5px;
    }

    .input-group input {
      width: 100%;
      padding: 10px;
      border-radius: 4px;
      border: 1px solid #ccc;
    }

    .input-group button {
      width: 100%;
      padding: 10px;
      border-radius: 4px;
      border: none;
      background-color: #007bff;
      color: #fff;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .input-group button:hover {
      background-color: #0056b3;
    }

    .input-group button:focus {
      outline: none;
    }

    .input-group button:active {
      transform: translateY(1px);
    }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>${name} Hey! Don't Forget to Login </h2>
    <form id="login-form" method="post">
    <pre>${errorMessage}</pre>
      <div class="input-group">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>
      </div>
      <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="input-group">
        <button type="submit">Login</button>
      </div>
    </form>
  </div>
</body>
</html>
