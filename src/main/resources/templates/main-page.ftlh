<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main-page.css">
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
    <div class="row">
        <div class="col-2 sidebar">
            <form class="search-form ps-5 pt-5">
                <h2 class="mb-5">Search</h2>
                <h5>Brands</h5>
                <select class="form-select" aria-label="Default select example">
                    <option value="All" selected>All</option>
                    <option value="Acer">Acer</option>
                    <option value="Lenovo">Lenovo</option>
                    <option value="Asus">Asus</option>
                    <option value="HP">HP</option>
                    <option value="HUAWEI">HUAWEI</option>
                </select>
                <div class="price mb-5 mt-5">
                    <div class="input-group">
                        <span class="input-group-text">Price: </span>
                        <input type="text" aria-label="First name" class="form-control" placeholder="from" name="min">
                        <input type="text" aria-label="Last name" class="form-control" placeholder="to" name="max">
                    </div>
                </div>

                <div class="input-group flex-nowrap mb-5 ">
                    <span class="input-group-text" id="addon-wrapping">Name</span>
                    <input type="text" class="form-control" placeholder="Product name" aria-label="Username" aria-describedby="addon-wrapping" name="name">
                </div>

                <div class="input-group flex-nowrap mb-5 ">
                    <span class="input-group-text" id="addon-wrapping">Description</span>
                    <input type="text" class="form-control" placeholder="Description" aria-label="Username" aria-describedby="addon-wrapping" name="description">
                </div>

                <button type="submit" class="btn btn-primary">Search</button>
            </form>

            <div class="auth-block">
                <form action="/logout" method="post" class="auth-btn p-4">
                    <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!'--no-token--'}" />
                    <button type="submit" class="btn btn-primary">Logout</button>
                </form>
            </div>
        </div>


        <div class="col-10" class="content-block">
            <div class="container main-block-content">
                <div class="content">

                </div>

                <div class="pagination mb-5">
                    <ul>
                        <li><a href="#" class="prev btn-warning">Prev</a></li>
                        <li><a href="#" class="current-page active">0</a></li>
                        <li><a href="#" class="next btn-warning">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>



<script src="/js/main-page.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
