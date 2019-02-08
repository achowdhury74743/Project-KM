function LoginForm() {
    const loginForm = $('#loginForm');
    loginForm.submit(event => {
        event.preventDefault();
    $.ajax({
        url: '/user/login',
        type: 'POST',
        data: loginForm.serialize(),
        success: response => {
        if (response.startsWith('Error:')) {
        alert(response);
    } else {
        Cookies.set("sessionToken", response);
        window.location.href = "/client/index.html";
    }
}
});
});
}

function NewUserForm() {
    const newUserForm = $('#newUserForm');
    newUserForm.submit(event => {
        event.preventDefault();
    $.ajax({
        url: '/user/new',
        type: 'POST',
        data: newUserForm.serialize(),
        success: response => {
        if (response.startsWith('Error:')) {
        alert(response);
    } else {
        Cookies.set("sessionToken", response);
        window.location.href = "/client/index.html";
    }
}
});
});
}

function pageLoad() {
    LoginForm();
    NewUserForm();
}