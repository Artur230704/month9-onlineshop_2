let csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
let csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

function showReviewForm(event, product) {
    event.preventDefault();
    let reviewBlock = document.getElementById("reviewBlock");
    let reviewForm = document.getElementById("reviewForm");
    let reviewProduct = document.getElementById("reviewProduct");

    reviewProduct.value = product;
    reviewBlock.style.display = "block";
    reviewForm.style.display = "block";
}

document.getElementById("reviewForm").addEventListener("submit", function(event) {
    event.preventDefault();
    let form = event.target;
    let reviewProduct = document.getElementById("reviewProduct").value;
    let reviewText = form.querySelector('textarea[name="text"]').value;

    let reviewData = {
        product: reviewProduct,
        text: reviewText
    };

    let jsonData = JSON.stringify(reviewData);

    fetch('/api/products/reviews/add', {
        method: 'POST',
        body: jsonData,
        headers: {
            'Content-Type': 'application/json',
            [csrfHeader]: csrfToken
        }
    })
        .then(function(response) {
            if (response.ok) {
                let responseMessage = document.getElementById("responseMessage");
                responseMessage.style.display = "block";
                responseMessage.textContent = 'Product review added';
            }
        })
        .catch(() => {
            let responseMessage = document.getElementById("responseMessage");
            responseMessage.style.display = "block";
            responseMessage.textContent = 'adding a review to the product failed';
        })
    form.reset();
    form.style.display = "none";
});