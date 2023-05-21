let cartEndPoint = '/api/carts'
let csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
let csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

displayCart(cartEndPoint)

function displayCart(url) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const cart = data;
            document.querySelector('.cart').innerHTML = '';
            cart.products.forEach(item => {
                createCartItem(item);
            });
        })
}

function createCartItem(item) {
    let row = document.createElement("div");
    row.classList.add("row");
    row.classList.add("mt-5");

    let elem = document.createElement("div");
    elem.classList.add("col-md-12");

    elem.innerHTML = `
        <div class="card-block">
            <div class="card mb-3" style="max-width: 650px;">
                <div class="row g-0">
                  <div class="col-md-4">
                    <img src="${item.product.image}" class="img-fluid rounded-start" alt="...">
                  </div>
                  <div class="col-md-8">
                    <div class="card-body">
                      <h5 class="card-title">${item.product.name}</h5>
                      <p class="card-text">Description: ${item.product.description}</p>
                      <p class="card-text"><small class="text-body-secondary">Category: ${item.product.category}</small></p>
                      <p class="card-text"><small class="text-body-secondary">Price: ${item.product.price} сом</small></p>
                      <div class="quantity">
                        <button class="quantity-btn minus-btn"><i class="bi bi-dash-square"></i></button>
                        <input type="text" class="quantity-input" value="${item.quantity}">
                        <input type="hidden" name="productId" value="${item.product.id}">
                        <button type="submit" class="quantity-btn plus-btn"><i class="bi bi-plus"></i></button>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
            <div class="card-btn pt-5">
                <a href="#" class="btn btn-primary remove-btn">remove from cart</a>
            </div>
        </div>
    `

    let removeFromCartButton = elem.querySelector(".remove-btn");
    removeFromCartHandler(removeFromCartButton, item.product.id)

    row.appendChild(elem);

    let cartBlock = document.querySelector(".cart");
    cartBlock.appendChild(row);

    setupQuantityChangeHandlers(elem.querySelector('.quantity'), item);

}


function removeFromCartHandler(btn, productId){
    btn.addEventListener("click", (event) => {
        event.preventDefault();
        fetch('/api/carts/items/remove', {
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
                displayCart(cartEndPoint);
            })
            .catch(error => {
                console.error(error);
            });
    });
}


function setupQuantityChangeHandlers(elem, item) {
    let minusBtn = elem.querySelector('.minus-btn');
    let plusBtn = elem.querySelector('.plus-btn');

    minusBtn.addEventListener('click', (event) => {
        event.preventDefault();
        changeProductQuantity('/api/carts/items/reduce', item.product.id);
    });

    plusBtn.addEventListener('click', (event) => {
        event.preventDefault();
        changeProductQuantity('/api/carts/items/increase', item.product.id);
    });
}

function changeProductQuantity(url, productId) {
    fetch(url, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            [csrfHeader]: csrfToken
        },
        body: JSON.stringify({
            productId: productId
        })
    })
        .then(() => displayCart(cartEndPoint))
        .catch(error => {
            console.error(error);
        });
}

