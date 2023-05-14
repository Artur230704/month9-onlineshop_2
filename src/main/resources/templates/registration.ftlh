<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="/css/auth.css">
</head>
<body>
<div class="registration-page">
    <div id="errors"></div>

    <div class="form">
        <form class="register-form" method="POST" enctype="multipart/form-data">
            <div class="error-message"></div>
            <input type="text" placeholder="name" name="username" required/>
            <div class="error-message"></div>
            <input type="text" placeholder="email address" name="email" required/>
            <div class="error-message"></div>
            <input type="password" placeholder="password" name="password" required/>
            <button>Register</button>
            <p class="message">Already registered? <a href="/login">Sign In</a></p>
        </form>
    </div>

</div>

<script src="/js/registration.js"></script>
</body>
</html>