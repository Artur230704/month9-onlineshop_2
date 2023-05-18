<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main-page.css">
</head>
<body>

<div class="header">
    <nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark" data-bs-theme="dark">
        <div class="container">
            <a class="navbar-brand" href="#">Computer shop</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-lg-0">
                    <li class="nav-item">
                        <a href="/profile" class="nav-link active">Profile</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>


<div class="sidebar" style="display: flex; flex-direction: column; height: 100vh; justify-content: space-between;">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <form class="mb-5" id="product-search-form">
        <select class="form-select pe-5 mb-2" name="search-type" id="search-type">
            <option value="all" selected>All</option>
            <option value="name">Name</option>
            <option value="category">Category</option>
            <option value="price">Price</option>
            <option value="description">Description</option>
        </select>
        <select id="category" class="form-select ps-4 pe-5 me-2" name="category" aria-label="Select a category" hidden>
            <option value="monitor">Monitors</option>
            <option value="processor">Processors</option>
            <option value="ram">RAM</option>
            <option value="ssd">SSD</option>
            <option value="hdd">HDD</option>
            <option value="graphics card">Graphics cards</option>
            <option value="power unit">Power units</option>
            <option value="motherboard">Motherboards</option>
        </select>
        <div class="input-group mt-2 ps-2">
            <input class="form-control search-input me-2 ms-2" type="search" placeholder="Search" aria-label="Search" name="search" id="search-term">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
    </form>
    <form action="/logout" method="post" class="pb-3 ps-3">
        <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!'--no-token--'}" />
        <button type="submit" class="btn btn-secondary">Logout</button>
    </form>
</div>




<div class="main-block">
    <button class="openbtn" onclick="openNav()">&#9776; Open Sidebar</button>
    <div class="container">
        <h1 class="text-center mb-4 mt-5 main-title">Products</h1>

        <div class="products-block row"></div>


        <div class="pagination">
            <ul>
                <li><a href="#" class="prev btn-primary">Prev</a></li>
                <li><a href="#" class="current-page active">0</a></li>
                <li><a href="#" class="next btn-primary">Next</a></li>
            </ul>
        </div>
    </div>
</div>





<script src="/js/main-page.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>