// import { forLogin } from "../profile/profile";

function login() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (name != null && email != null) {
        login = {
            email: email,
            password: password
        }
        const loginURL = "http://localhost:8080/login";
        const Http = new XMLHttpRequest();
        Http.open("POST", loginURL);
        // Http.responseType = 'json';
        Http.setRequestHeader("Content-type", "application/json");
        Http.send(JSON.stringify(login));

        Http.onreadystatechange = (e) => {
            var email = Http.response;
            // console.log(email);
            if (email) {
                window.localStorage.setItem('email', email);
                // forLogin();
                window.location = '/profile/profile.html';
            }
        }

    }
}