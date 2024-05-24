


const usernameField = document.getElementById("username")
const userPasswordField = document.getElementById("password")
const loginButton = document.getElementById("login-btn")

console.log(userPasswordField,usernameField,loginButton)


const loginHandler = ()=>{
    const requestData = {
        username:usernameField.value,
        password:userPasswordField.value
    }

    const requestBody = {
        method:"POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Header":"*"
          },
        body:JSON.stringify(requestData)
    }
    const loginApi = "http://localhost:8080/user/login"

    const promiseObject = fetch(loginApi,requestBody)

    promiseObject.then(res=>res.json()).then(data=>{
        if(data.isAccepted === "true"){
            localStorage.setItem("isLoggedIn",true)
            localStorage.setItem("email",data.email)
            window.location.replace("dashboard.html")
        }
    })

    console.log(requestData)
}



loginButton.addEventListener("click",loginHandler)