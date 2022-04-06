
const errMessage = document.createElement("p");
errMessage.id = "err-msg";
window.addEventListener("load", function(){
    let form = document.querySelector("form");
    form.addEventListener("submit", function(evt){
        if(!validateForm()){
            evt.preventDefault();
        }
    }, false);
}, false);

function validateForm(){
    return validateUsername() && validatePassword();
}

function validateUsername(){
    let username = document.getElementById("username");
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(username.value)){
        if(document.getElementById("err-msg")){
            username.parentElement.removeChild(document.getElementById("err-msg"));
        }
        return true;
    }
    
    errMessage.textContent = "Invalid username. Must match the following format: example@email.com";
    
    username.parentElement.insertBefore(errMessage, username.nextElementSibling);
    
    return false;
}


function validatePassword(){
    let password = document.getElementById("password");
    
    if(password.value !== ""){
        if(document.getElementById("err-msg")){
            password.parentElement.removeChild(document.getElementById("err-msg"));
        }
        return true;
    }
    
    errMessage.textContent = "Invalid password. The password input can not be left empty";
    
    password.parentElement.insertBefore(errMessage, password.nextElementSibling);
    
    return false;
}