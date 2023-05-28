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
                <p style="color:red">${bundle["invalid_credentials"]}</p>
            </#if>
        </div>

        <div>
            <#if password?? >
                <p style="color:black">${bundle["recovered_password"]}: ${password}</p>
            </#if>
        </div>

        <form class="login-form" method="POST" action="/login">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" placeholder="email" name="username" value=""/>
            <input type="text" placeholder="password" name="password" value=""/>
            <button>login</button>
            <p class="message">${bundle["not_registered"]} <a href="/signup">${bundle["create_account_link"]}</a></p>
            <p class="message">${bundle["forgot_password"]} <a href="/password-recover">${bundle["recover_password_link"]}</a></p>
            <p class="message"><a href="/">${bundle["bacK_to_home_page_link"]}</a></p>
        </form>
    </div>
</div>
</body>
</html>