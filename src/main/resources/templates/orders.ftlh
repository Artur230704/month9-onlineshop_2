<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
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
                        <a href="/cart" class="nav-link active">shopping cart</a>
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
    <div class="container">
        <table class="table table-responsive">
            <thead>
            <tr>
                <th>Email</th>
                <th>Product</th>
                <th>Quantity</th>
                <th>Address</th>
                <th>Bill</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <#list orders as order>
                <tr>
                    <td>${order.email}</td>
                    <td>
                        <ul>
                            <#list order.products as product, quantity>
                                <li>${product} <a href="#" onclick="showReviewForm(event, '${product}')">add review</a></li>
                            </#list>
                        </ul>
                    </td>
                    <td>
                        <ul>
                            <#list order.products as product, quantity>
                                <li>${quantity}</li>
                            </#list>
                        </ul>
                    </td>
                    <td>${order.address}</td>
                    <td>${order.bill}</td>
                    <td>${order.date}</td>
                </tr>
            </#list>
            </tbody>
        </table>

        <div class="review-block" id="reviewBlock">
            <form id="reviewForm" style="display: none;">
                <h3 class="mb-3">Add Review</h3>
                <div class="form-group">
                    <input type="hidden" name="product" id="reviewProduct">
                </div>
                <div class="form-group">
                    <label for="reviewText">Review Text</label>
                    <textarea class="form-control" name="text" id="reviewText" rows="3" required></textarea>
                </div>
                <button type="submit" class="btn btn-secondary">Add</button>
            </form>
        </div>

        <div id="responseMessage" style="display: none;"></div>
    </div>
</div>
<script src="/js/orders.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>