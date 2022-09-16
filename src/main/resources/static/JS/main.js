"use strict";
////////////////////////////
// Selectors
///////////////////////////

//DIVs
let tableBody = document.querySelector("#tableBody");


// INPUTS 

let cMakeInput = document.querySelector("#cMakeInput");
let cModelInput = document.querySelector("#cModelInput");
let rYearInput = document.querySelector("#rYearInput");
let mRangeInput = document.querySelector("#mRangeInput");

//BUTTONS
let createBtn = document.querySelector ("#createBtn")
let updateBtn = document.querySelector ("#updateBtn")
let deleteBtn = document.querySelector ("#deleteBtn")



//FUNCTIONS

let printResults = (result) => {

    let tr = document.createElement("tr");
    let td1 = document.createElement("td"); 
    let td2 = document.createElement("td");
    let td3 = document.createElement("td");
    let td4 = document.createElement("td");
    let td5 = document.createElement("td");

    td1.textContent= result.id;
    td2.textContent= result.carMake;
    td3.textContent= result.carModel;
    td4.textContent= result.releaseYear;
    td5.textContent= result.mileRange;


    tr.append(td1,td2,td3,td4,td5);
    tableBody.appendChild(tr);

    // entryDiv.textContent = `${result.id} | ${result.carMake} | ${result.carModel} | ${result.releaseYear} | ${result.mileRange}`;
    

    // let delBtn = document.createElement("button");
    // delBtn.textContent = "Delete"
    // delBtn.type = "button";
    // delBtn.setAttribute("Class", "btn btn-danger btn-sm");
    // delBtn.setAttribute("onClick", `del(${result.id})`);

    entryParent.appendChild(entryDiv);
    entryParent.appendChild(delBtn);
    resultsDiv.appendChild(entryParent);
}

    // get all
    let getAll = () => {
        axios.get("http://localhost:8080/getAll")
        .then(res => {
            
            let results = res.data;

            for (let result of results){
                printResults(result);
        }
    }).catch(err => console.log(err));
    } 

    // create


    let create = () => {

         if (!validateInputs()) {
            alert("Please complete inputs on all fields apart from ID this will be auto-populated");
            return
         }

        let obj = {
            "carMake" : cMakeInput.value,
            "carModel" : cModelInput.value,
            "releaseYear" : rYearInput.value,
            "mileRange": mRangeInput.value
    }
        axios.post("http://localhost:8080/create", obj)
        .then(res => {
            getAll();
    }).catch(err => console.log(err));
    } 

    // update
    let update = () => {

        let obj = {
            "carMake" : cMakeInput.value,
            "carModel" : cModelInput.value,
            "releaseYear" : rYearInput.value,
            "mileRange": mRangeInput.value
        }

        axios.put("http://localhost:8080/update/${idInput.value}", obj)
        .then(res => {
            getAll();
    }).catch(err => console.error(err));
    } 


    // delete
    let del = (id) => {
        axios.delete("http://localhost:8080/delete/${id}")
        .then(res => {
            getAll();
    }).catch(err => console.log(err));
    
    let validateDelete = () => {
        if (idInput.value === "") {
            alert("ID is required for this operation");
            return false;
        } else {
            return true;
        }
    }
} 

let validateInputs = () => {
    if (cMakeInput.value === ""|| cModelInput.value === ""|| rYearInput.value === ""|| mRangeInput.value === "") {
        return false;
    } else { 
        return true ;
    }

    }

//EVENT LISTENERS

createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);

