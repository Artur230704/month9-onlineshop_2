<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/profile.css">
</head>
<body>
<div class="header">
    <nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark" data-bs-theme="dark">
        <div class="container">
            <a class="navbar-brand" href="#">Laptops</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-lg-0 fs-5">
                    <li class="nav-item">
                        <a href="/" class="nav-link active">${bundle["home_nav"]}</a>
                    </li>
                    <li class="nav-item">
                        <a href="/orders" class="nav-link active">${bundle["orders_nav"]}</a>
                    </li>
                    <li class="nav-item">
                        <a href="/cart" class="nav-link active">${bundle["cart_nav"]}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="main-block mt-5">
    <div class="container">
        <h1>${bundle["greeting"]}</h1>
        <button class="btn btn-secondary mt-5" id="changePasswordBtn">${bundle["change_password"]}</button>

        <#if errors?? >
            <p style="color:red">${bundle["input_error"]}</p>
            <#list errors as fieldError>
                <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
            </#list>
        </#if>
        <p id="passwordChangeResult" class="mt-5 fs-5"></p>
        <form id="changePasswordForm" class="d-none">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="mb-3">
                <label for="currentPassword" class="form-label">${bundle["current_password"]}</label>
                <input type="password" id="currentPassword" name="currentPassword" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="newPassword" class="form-label">${bundle["new_password"]}</label>
                <input type="password" id="newPassword" name="newPassword" class="form-control" required minlength="4" maxlength="15">
            </div>
            <button type="submit" class="btn btn-secondary">${bundle["change_password"]}</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="/js/profile.js"></script>
</body>
</html>