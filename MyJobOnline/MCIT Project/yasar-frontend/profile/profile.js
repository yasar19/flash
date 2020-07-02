function onSubmit(submit) {
    
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var position = document.getElementById("position").value;
    var location = document.getElementById("location").value;
    var aboutMe = document.getElementById("aboutMe").value;
    var experience = document.getElementById("experience").value;
    var education = document.getElementById("education").value;
    var skill = document.getElementById("skill").value;

    profileDetails = {
        name: name,
        email: window.localStorage.getItem('email'),
        position: position,
        location: location,
        aboutMe: aboutMe,
        experience: experience,
        education: education,
        skill: skill
    }

    switch (submit) {
        case "name":
            var loginURL = "http://localhost:8080/name";
            break;
        case "email":
            var loginURL = "http://localhost:8080/email";
            break;
        case "position":
            var loginURL = "http://localhost:8080/position";
            break;
        case "location":
            var loginURL = "http://localhost:8080/location";
            break;
        case "aboutMe":
            var loginURL = "http://localhost:8080/aboutMe";
            break;
        case "experience":
            var loginURL = "http://localhost:8080/experience";
            break;
        case "education":
            var loginURL = "http://localhost:8080/education";
            break;
        case "skill":
            var loginURL = "http://localhost:8080/skill";
            break;
    }

    const Http = new XMLHttpRequest();
    Http.open("POST", loginURL);
    // Http.responseType = 'json';
    Http.setRequestHeader("Content-type", "application/json");
    Http.send(JSON.stringify(profileDetails));

    Http.onreadystatechange = (e) => {
    }
}

function logOut() {
    window.localStorage.clear();
}

