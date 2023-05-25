<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/reviews-page.css">
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
                        <a href="/cart" class="nav-link active">cart</a>
                    </li>
                    <li class="nav-item">
                        <a href="/profile" class="nav-link active">profile</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>


<div class="container mt-5">
    <div class="card mb-3 mx-auto" style="max-width: 540px;">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="/${product.image?replace('/products/review/', '')}" class="img-fluid rounded-start" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">Description: ${product.description}</p>
                    <p class="card-text"><small class="text-body-secondary">Category: ${product.category}</small></p>
                    <p class="card-text"><small class="text-body-secondary">Price: ${product.price} сом</small></p>
                </div>
            </div>
        </div>
    </div>

    <h3 class="mt-5">reviews: </h3>
    <div class="comments-block">
        <ul class="list-group">
            <#list reviews as review>
                <li class="list-group-item">${review.username}
                    <br>
                    text: ${review.text}
                </li>
            </#list>
        </ul>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>