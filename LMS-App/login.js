

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
    const data = {
        name:fullName.value,
        email:email.value,
        username:username.value,
        password:password.value,
        dob:dob.value,
        address:address.value,
    }

    console.log(data,"data")

    const requestBody = {
        method:"POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Header":"*"
          },
        body:JSON.stringify(data)
    }
    console.log(requestBody,"request body")
    const registerApi = "http://localhost:8080/user/create-user"

    const promiseObject = fetch(registerApi,requestBody)

   promiseObject.then(res=>res.json()).then(data=>{
        if(data.message === "failed"){
            const nameField = document.getElementsByClassName("input_field")[0]
            nameField.classList.add("error")
        }
   })

}


function iconMousHoverHandler(){
    const messageHeading = document.getElementsByClassName("message")[0]
    messageHeading.classList.remove("hidden")
}



infoIcon.addEventListener("mouseenter",iconMousHoverHandler)
submitBtn.addEventListener("click",submitHandler)