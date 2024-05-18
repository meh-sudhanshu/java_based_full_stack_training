

// // console.log is used to print data
// console.log("Hello World")

// // create a variable in js var,let, const

// // console.log(a)
// var a = 10
// //console.log(a)

// // varaible created using var keyword can be changed as well as can be re declared
// var a = 20 
// //console.log(a)

// a = a+10
// //console.log(a)


// // variables created using let can be changed but can not be redeclared
// let b = 10
// //console.log(b)
// b = 78
// //console.log(b)

// //let b = 100

// // variables created using const can neither be redeclared nor cn be changed
// const c = 100

// // hoisting, callback, promise, asynchronus js, fetch, loops, functions

// getElementsByTagName always return an array of HtmlCollections

// var allButtons = document.getElementsByTagName("button")
// console.log(allButtons)


// var utilityButtons = document.getElementsByClassName("btn")
// console.log(utilityButtons,"utility buttons")

// var number = document.getElementById("number")
// console.log(number)


var numberHeading = document.getElementById("number")
var allButtons = document.getElementsByClassName("btn")
var overlay = document.getElementsByClassName("overlay")[0]
var closeButton = document.getElementsByClassName("close-btn")[0]
var increaseButton = allButtons[0]
var decreaseButton = allButtons[1]

// console.log(numberHeading)
// console.log(increaseButton)
// console.log(decreaseButton)

function increaseHandler(){
    var currentValue = numberHeading.innerText
    currentValue = Number(currentValue)
    if(currentValue === 10){
        overlay.classList.remove("hidden")
    }else{
        currentValue+=1
        numberHeading.innerText = currentValue
        console.log(currentValue)
    }
   
}

function decreaseHandler(){
    var currentValue = numberHeading.innerText
    currentValue = Number(currentValue)
    if(currentValue === -10){
        overlay.classList.remove("hidden")
    }else{
        currentValue-=1
        numberHeading.innerText = currentValue
        console.log(currentValue)
    }
  
}

function closeHandler(){
    overlay.classList.add("hidden")
}



increaseButton.addEventListener('click',increaseHandler)
decreaseButton.addEventListener("click",decreaseHandler)
closeButton.addEventListener("click",closeHandler)










