function saveUser(user) {
    const userAsJSON = JSON.stringify(user)
    localStorage.setItem('user', userAsJSON);
}


const registerForm = document.querySelector('.register-form')
const errorContainer = document.querySelector('#errors')

registerForm.addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(registerForm)
    const user = Object.fromEntries(formData);
    saveUser(user)

    fetch('/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(function(response) {
        if (response.ok) {
            window.location.href = '/';
        } else {
            response.json().then(errors => {
                errorContainer.innerHTML = '';
                errorContainer.innerHTML = '<ul><li>' + errors.join('</li><li>') + '</li></ul>';
            });
        }
    }).catch(error => {
        console.error(error);
    });
});
