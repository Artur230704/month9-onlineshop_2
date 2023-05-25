let page = 0;
let totalPages;
let currentPage = document.querySelector('.current-page');
let nextButton = document.querySelector('.next');
let prevButton = document.querySelector('.prev');

let productsEndPoint = "/api/products";
let currentEndPoint;


displayProducts(productsEndPoint);
currentEndPoint = productsEndPoint;

function displayProducts(url){
    fetch(url)
        .then(response => response.json())
        .then(page => {
            document.querySelector('.content').innerHTML = '';
            page.content.forEach(product => {
                createProductCard(product);
            });
            totalPages = page.totalPages;
            if (totalPages === 0){
                totalPages = 1
            }
            currentPage.textContent = `Page ${page.number + 1} of ${totalPages}`;
        })
}



function createProductCard(product) {
    let newRow = document.createElement("div");
    newRow.classList.add("row");
    newRow.classList.add("mt-5");

    let newElem = document.createElement("div");
    newElem.classList.add("col-md-12");

    newElem.innerHTML = `
        <div class="card-block">
            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                  <div class="col-md-4">
                    <img src="${product.image}" class="img-fluid rounded-start" alt="...">
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
            <div class="card-btn ms-3 pt-5">
                <a href="#" class="btn btn-primary send-btn">add to cart</a>
            </div>
            <div class="card-btn ms-3 pt-5">
                <a href="/products/review/${product.name}" class="btn btn-primary send-btn">view reviews</a>
            </div>
        </div>
    `

    newRow.appendChild(newElem);

    let addToCartButton = newElem.querySelector(".send-btn");
    addToCartHandler(addToCartButton, product.id)

    let productsBlock = document.querySelector(".content");
    productsBlock.appendChild(newRow);
}

function addToCartHandler(btn, productId){
    btn.addEventListener("click", () => {
        let csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
        let csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

        fetch('/api/carts/items/add', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                [csrfHeader]: csrfToken
            },
            body: JSON.stringify({
                productId: productId
            })
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
            })
            .catch(error => {
                window.location.href = "/login";
            });
    });
}

nextButton.addEventListener('click', () => {
    if (page < totalPages - 1) {
        page++;
        let url;
        if (currentEndPoint === productsEndPoint){
            url = `${currentEndPoint}?page=${page}`;
        } else {
            url = `${currentEndPoint}&page=${page}`
        }
        displayProducts(url);
    }
});

prevButton.addEventListener('click', () => {
    if (page > 0) {
        page--;
        let url;
        if (currentEndPoint === productsEndPoint){
            url = `${currentEndPoint}?page=${page}`;
        } else {
            url = `${currentEndPoint}&page=${page}`
        }
        displayProducts(url);
    }
});



let searchForm = document.querySelector('.search-form');

searchForm.addEventListener('submit', function(event) {
    event.preventDefault();

    let min = document.querySelector('input[name="min"]').value;
    let max = document.querySelector('input[name="max"]').value;
    let name = document.querySelector('input[name="name"]').value;
    let description = document.querySelector('input[name="description"]').value;

    let categoryForm = document.querySelector('.form-select');
    let category = categoryForm.value;

    let searchParams = new URLSearchParams();

    if (category !== 'All') {
        searchParams.append('category', category);
    }
    if (min) {
        searchParams.append('min', min);
    }
    if (max) {
        searchParams.append('max', max);
    }
    if (name) {
        searchParams.append('name', name);
    }
    if (description) {
        searchParams.append('description', description);
    }

    let url = '/api/products/search?' + searchParams.toString();
    currentEndPoint = url;
    page = 0;

    displayProducts(url);
});