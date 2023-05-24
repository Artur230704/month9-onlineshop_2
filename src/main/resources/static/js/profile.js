let csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
let csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
let changePasswordBtn = document.getElementById('changePasswordBtn');
let changePasswordForm = document.getElementById('changePasswordForm');
document.addEventListener('DOMContentLoaded', function() {
    changePasswordBtn.addEventListener('click', function() {
        changePasswordForm.classList.toggle('d-none');
    });
});


changePasswordForm.addEventListener('submit', function(event) {
    event.preventDefault();
    changePasswordForm.classList.add("d-none")

    let currentPassword = document.getElementById('currentPassword').value;
    let newPassword = document.getElementById('newPassword').value;
    let data = {
        currentPassword: currentPassword,
        newPassword: newPassword
    };

    let jsonData = JSON.stringify(data);

    fetch('/api/customers/password-management/change', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            [csrfHeader]: csrfToken
        },
        body: jsonData
    }).then(function(response) {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Request failed.');
        }
    }).then(function(result) {
        let passwordChangeResult = document.getElementById('passwordChangeResult');
        passwordChangeResult.textContent = result;
    }).catch(function(error) {
        console.error('An error occurred:', error);
    });
});