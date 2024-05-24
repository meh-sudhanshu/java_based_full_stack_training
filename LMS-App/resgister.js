

// (
//     ()=>{
//         console.log(localStorage.getItem("isLoggedIn"))
//         if(localStorage.getItem("isLoggedIn")){
//             window.location.replace("dashboard.html")
//             console.log("inside if block")
//         }else{
//             console.log("inside else block")
//         }
//     }
// )()

const allInputFields = document.getElementsByClassName("ip")
const infoIcon = document.getElementsByClassName("info_icon")[0]
console.log(allInputFields)

const fullName = allInputFields[0]
const email = allInputFields[1]
const username = allInputFields[2]
const password = allInputFields[3]
const dob = allInputFields[4]
const address = allInputFields[5]
const submitBtn = allInputFields[6]



function submitHandler(event){
    event.preventDefault()
    const userData = {
        name:fullName.value,
        email:email.value,
        username:username.value,
        password:password.value,
        dob:dob.value,
        address:address.value,
    }

    console.log(userData,"data")

    const requestBody = {
        method:"POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Header":"*"
          },
        body:JSON.stringify(userData)
    }
    console.log(requestBody,"request body")
    const registerApi = "http://localhost:8080/user/create-user"

    const promiseObject = fetch(registerApi,requestBody)

   promiseObject.then(res=>res.json()).then(data=>{
        if(data.message === "failed"){
            console.log(data)
            Object.keys(data).forEach(key=>{
                if(key !== "message"){
                    const currentHtmlEle = document.getElementsByClassName(key)[0]
                    currentHtmlEle.style.border = "2px solid red"
                    const iconClassName = key+"-icon"
                    const icon = document.getElementsByClassName(iconClassName)[0]
                    icon.classList.remove("hidden")
                }
            })
        }else if(data.message === "success"){
            localStorage.setItem("isLoggedIn",true)
            localStorage.setItem("email",userData.email)
            window.location.href="dashboard.html"
        }
   })

}


function iconMousHoverHandler(){
    const messageHeading = document.getElementsByClassName("message")[0]
    messageHeading.classList.remove("hidden")
}



infoIcon.addEventListener("mouseenter",iconMousHoverHandler)
submitBtn.addEventListener("click",submitHandler)









