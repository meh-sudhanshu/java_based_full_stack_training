




const hamburger = document.getElementsByClassName("hamburger")[0]

let hamburgerTurn = true

function hamburgerHandler(){
    
    const navbarContentCtn = document.getElementsByClassName("navbar-content-ctn")[0]
    const hamburgur = document.getElementsByClassName("hamburger")[0]
    if(hamburgerTurn === true){
        navbarContentCtn.style.left = "0px"
        hamburgerTurn = false
        hamburger.src = "cross.png"
    }else{
        navbarContentCtn.style.left = "-30vw"
        hamburgerTurn = true
        hamburger.src = "hamburgur.png"
    }

    
}



hamburger.addEventListener("click",hamburgerHandler)