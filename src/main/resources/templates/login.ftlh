<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="/css/auth.css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <div>
            <#if error!false >
                <p style="color:red">Invalid username or password !</p>
            </#if>
        </div>

        <div>
            <#if password?? >
                <p style="color:white">Your new password: ${password}</p>
            </#if>
        </div>

        <form class="login-form" method="POST" action="/login">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" placeholder="email" name="username" value=""/>
            <input type="text" placeholder="password" name="password" value=""/>
            <button>login</button>
            <p class="message">Not registered? <a href="/signup">Create an account</a></p>
            <p class="message">Forgot your password? <a href="/password-recover">Recover password</a></p>
            <p class="message"><a href="/">Go back to the home page</a></p>
        </form>
    </div>
</div>
</body>
</html>