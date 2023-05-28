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

    <div class="form">
        <form class="register-form" method="POST" action="/signup" >
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div>
                <#if errorMessage?has_content>
                    <p class="error-message" style="color:red">${errorMessage}</p>
                </#if>
                <#if errors?? >
                    <p style="color:red">${bundle["input_error"]}</p>
                    <#list errors as fieldError>
                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                    </#list>
                </#if>
            </div>
            <div class="error-message"></div>
            <input type="text" placeholder="name" name="username"  value="${(dto.username)!''}" required/>
            <div class="error-message"></div>
            <input type="text" placeholder="email address" name="email"  value="${(dto.email)!''}" required/>
            <div class="error-message"></div>
            <input type="password" placeholder="password" name="password"  value="${(dto.password)!''}" required/>
            <button>${bundle["register"]}</button>
            <p class="message">${bundle["already_registered"]} <a href="/login">${bundle["login_link"]}</a></p>
            <p class="message"><a href="/">${bundle["bacK_to_home_page_link"]}</a></p>
        </form>
    </div>

</div>
</body>
</html>