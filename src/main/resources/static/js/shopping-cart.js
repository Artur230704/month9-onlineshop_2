let cartEndPoint = '/api/carts'

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
            <div class="card mb-3" style="max-width: 540px;">
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
                      <p class="card-text"><small class="text-body-secondary">Quantity: ${item.quantity}</small></p>
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
}


function removeFromCartHandler(btn, productId){
    btn.addEventListener("click", () => {
        let csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
        let csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

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
                console.log(data);
                displayCart(cartEndPoint);
            })
            .catch(error => {
                console.error(error);
            });
    });
}

