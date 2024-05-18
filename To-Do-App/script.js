

var addBtn = document.getElementsByClassName("add-item-btn")[0]
var overlay = document.getElementsByClassName("overlay")[0]
var closeBtn = document.getElementById("close-icon")
var itemForm = document.getElementsByClassName("item-form")[0]




function openFormHandler(){
    overlay.classList.remove("hidden")
}

function closeFormHandler(){
    overlay.classList.add("hidden")
}

function formSubmitHandler(event){
    event.preventDefault()
    overlay.classList.add("hidden")
    const itemValues = {
        itemTitle: event.target[0].value,
        itemDescription: event.target[1].value,
        startDate: event.target[2].value,
        endDate: event.target[3].value
    }
    console.log(itemValues)
    itemForm.reset()
}




closeBtn.addEventListener("click",closeFormHandler)
addBtn.addEventListener("click",openFormHandler)
itemForm.addEventListener("submit",formSubmitHandler)