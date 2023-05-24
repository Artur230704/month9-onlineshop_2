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
    <link rel="stylesheet" href="/css/shopping-cart.css">
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
                            <a href="/" class="nav-link active">home</a>
                        </li>
                        <li class="nav-item">
                            <a href="/orders" class="nav-link active">orders</a>
                        </li>
                        <li class="nav-item">
                            <a href="/profile" class="nav-link active">profile</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="main-block">
        <div class="row">
            <div class="col-7">
                <div class="container">
                    <div class="cart"></div>
                </div>
            </div>
            <div class="col-5">
                <form id="orderForm" method="post" action="/api/orders/add">
                    <h2 class="mt-5">Order form</h2>
                    <div class="mb-3">
                        <label for="addressInput" class="form-label">Address</label>
                        <input type="text" class="form-control" id="addressInput" name="address" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Place an order</button>
                    <p class="response mt-5"></p>
                </form>
            </div>
        </div>
    </div>

<script src="/js/shopping-cart.js"></script>
</body>
</html>