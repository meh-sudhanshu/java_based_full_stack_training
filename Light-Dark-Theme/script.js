
// // IIFE -> immediately invoked functions expression



// (
//     ()=>{
//         localStorage.setItem("theme","dark")
//     }
// )()

const toggleBtn = document.getElementsByClassName("toggle-btn")[0]

function themeToggler(){
    const currentTheme = localStorage.getItem("theme")
    if(currentTheme){
        document.documentElement.classList.toggle(currentTheme)
    }

    toggleBtn.addEventListener("click",()=>{
        document.documentElement.classList.toggle("light")

        if(document.documentElement.classList.contains("light")){
            localStorage.setItem("theme","dark")
        }else{
                localStorage.removeItem("theme")
        }
    })
}



document.addEventListener('DOMContentLoaded',themeToggler)




// const toggleBtn = document.getElementsByClassName("toggle-btn")[0]

// const toggleTheme = ()=>{
//     const mainCtn = document.getElementsByClassName("main-ctn")[0]
//     const toggleBtn = document.getElementsByClassName("toggle-btn")[0]
//     const currentTheme = localStorage.getItem("theme")
    
//     console.log(mainCtn)
//     console.log(toggleBtn)
//     console.log(currentTheme)

//     if(currentTheme === "dark-theme"){
//         console.log("inside if statement")
//         mainCtn.style.backgroundColor ="black"
//         mainCtn.style.color = "white"
//         // toggleBtn.setAttribute("style","background-color:white")
//         // toggleBtn.setAttribute("style","background-color:black")
//         localStorage.setItem("theme","light-theme")
//     }else{
//         mainCtn.style.backgroundColor ="white"
//         mainCtn.style.color = "black"
//         localStorage.setItem("theme","dark-theme")
//     }
// }


// toggleBtn.addEventListener("click",toggleTheme)
