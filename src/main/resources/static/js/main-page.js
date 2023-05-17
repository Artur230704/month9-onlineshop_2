let page = 0;
// let defaultSearchSize = 2;
let totalPages;
let currentPage = document.querySelector('.current-page');

const form = document.querySelector('#product-search-form');
let searchInput = document.querySelector('#search-term');
let categorySelect = document.querySelector('#category');
let searchType = document.querySelector('#search-type');


let productsEndPoint = "/api/products";

let nextButton = document.querySelector('.next');
let prevButton = document.querySelector('.prev');

displayProducts(productsEndPoint);
let currentEndPoint = productsEndPoint;

function displayProducts(url){
    fetch(`${url}?page=${page}`)
        .then(response => response.json())
        .then(page => {
            document.querySelector('.products-block').innerHTML = '';
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
    newElem.classList.add("col-md-6");
    newElem.innerHTML = `
        <div class="card mb-4">
            <img src="${product.image}" class="card-img-center img-fluid" alt="...">
            <div class="card-body my-card-body">
                <h5 class="card-title">${product.name}</h5>
                <p class="card-text">Category: ${product.category}</p>
                <p class="card-text">Description: ${product.description}</p>
                <p class="card-text">Price: ${product.price} сом</p>
                <a href="#" class="btn btn-secondary">Add to cart</a>
            </div>
        </div>`;

    newRow.appendChild(newElem);

    let productsBlock = document.querySelector(".products-block");
    let lastRow = productsBlock.querySelector(".row:last-of-type");

    if (lastRow && lastRow.childElementCount < 2) {
        lastRow.appendChild(newElem);
    } else {
        productsBlock.appendChild(newRow);
    }
}

searchType.addEventListener('change', (event) => {
    const searchType = event.target.value;

    if (searchType === 'category') {
        searchInput.hidden = true;
        categorySelect.hidden = false;
    } else {
        searchInput.hidden = false;
        categorySelect.hidden = true;
    }
});

form.addEventListener('submit', event => {
    event.preventDefault();
    const searchType = document.getElementById('search-type').value;
    page = 0;

    if (searchType === 'category') {
        const category = document.getElementById('category').value;
        currentEndPoint = `/api/products/category/${category}`;
    } else if(searchType === 'all') {
        currentEndPoint = productsEndPoint;
    } else {
        const searchTerm = document.getElementById('search-term').value;
        currentEndPoint = `/api/products/${searchType}/${searchTerm}`;
    }
    displayProducts(currentEndPoint);
});


nextButton.addEventListener('click', () => {
    if (page < totalPages - 1) {
        page++;
        displayProducts(currentEndPoint);
    }
});

prevButton.addEventListener('click', () => {
    if (page > 0) {
        page--;
        displayProducts(currentEndPoint);
    }
});

