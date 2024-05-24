






(
    ()=>{
        const mainCtn = document.getElementById("main-ctn")
        const getUserDataApi = "http://localhost:8080/user/get-user-by-email"
        const email = localStorage.getItem("email")
        const emailObject = {
            email:String(email)
        }
        console.log(emailObject,"emailobject")
        const requestBody = {
            method:"POST",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Header":"*"
              },
            body:JSON.stringify(emailObject)
        }

        const promiseObject = fetch(getUserDataApi,requestBody)
        promiseObject.then(res=>res.json()).then(data=>{
            const nameHeading = document.createElement("h2")
            nameHeading.innerText = data.name

            const emailHeading = document.createElement("h2")
            emailHeading.innerText = data.email

            mainCtn.appendChild(nameHeading)
            mainCtn.appendChild(emailHeading)
        })
    }
)()


const logoutBtn = document.getElementById("logout-btn")

function logoutHandler (){
    localStorage.setItem("isLoggedIn",false)
    localStorage.removeItem("email")
    window.location.replace("login.html")
}


logoutBtn.addEventListener("click",logoutHandler)

