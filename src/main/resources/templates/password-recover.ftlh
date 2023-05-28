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
        <form class="login-form" method="POST" action="/api/customers/password-management/recover">
            <div>
                <#if errors?? >
                    <p style="color:red">${bundle["input_error"]}</p>
                    <#list errors as fieldError>
                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                    </#list>
                </#if>
                <#if customerError??>
                    <p style="color:red">${customerError}</p>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="text" placeholder="email address" name="email"  value="${(dto.email)!''}" required/>
            <button type="submit">${bundle["recover"]}</button>
            <p class="message">${bundle["not_registered"]} <a href="/signup">${bundle["create_account_link"]}</a></p>
            <p class="message"><a href="/">${bundle["bacK_to_home_page_link"]}</a></p>
        </form>
    </div>
</div>
</body>
</html>