getProfileInfo();

function getProfileInfo() {

    const loginURL = "http://localhost:8080/profile?email=" + window.localStorage.getItem('email');
    fetch(loginURL)
        .then(response => response.json())
        .then(data => {
            console.log(data) // Prints result from `response.json()` in getRequest
            if (data.name != null) {
                document.getElementById("name").innerHTML = data.name;
            }
            if (data.email) {
                document.getElementById("email").innerHTML = data.email;
            }
            if (data.position) {
                document.getElementById("position").innerHTML = data.position;
            }
            if (data.location) {
                document.getElementById("location").innerHTML = data.location;
            }
            if (data.aboutMe) {
                document.getElementById("aboutMe").innerHTML = data.aboutMe;
            }
            if (data.experience) {
                document.getElementById("experience").innerHTML = data.experience;
            }
            if (data.education) {
                document.getElementById("education").innerHTML = data.education;
            }
            if (data.skill) {
                document.getElementById("skill").innerHTML = data.skill;
            }
        })
        .catch(error => console.error(error))
}

function logOut() {
    window.localStorage.clear();
}
