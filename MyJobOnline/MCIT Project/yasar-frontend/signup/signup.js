function onSubmit() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (name != null && email != null && password != null) {
        signUp = {
            name: name,
            email: email,
            password: password
        }
        console.log('working till now')
        const registerURL = "http://localhost:8080/registration";
        const Http = new XMLHttpRequest();
        Http.open("POST", registerURL);
        // Http.responseType = 'json';
        Http.setRequestHeader("Content-type", "application/json");
        Http.send(JSON.stringify(signUp));

        Http.onreadystatechange = (e) => {
            // var s = []
             Http.response;
            // console.log("success");
            window.location = '/login/login.html';
        }
    }
}
