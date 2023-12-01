const form = document.getElementById("form");
const button = document.getElementById("Submit");
const tbody=document.getElementById('tbody')

// for clear form inputs
let clearButton = document.getElementById("clear");
clearButton.addEventListener('click',clear);
function clear(){
    form.reset();
    
}
// for fetching data
const data = [];
window.addEventListener('load',(()=>{
    getData()
    }))
function getData(){
    fetch('http://localhost:8000/students')
    .then((res)=>{
        return res.json()
    })
    .then((res)=>{
        console.log(res)
        showData(res)
    })
}

// for Post Student
button.addEventListener("click", (e) => {
  e.preventDefault();

  const ob = {
    firstName: form.fname.value,
    lastName: form.lname.value,
    dateOfBirth: form.dob.value,
    gender: form.gender.value,
    phoneNumber: form.phone.value,
    address: form.address.value,
  };


var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify(ob);

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8000/student", requestOptions)
  .then(response => response.text())
  .then(result => getData())
  .catch(error => console.log('error', error));

  form.reset();
}
);

// show student in grid 
function showData(data){
console.log(data,'62')
    tbody.innerHTML=null;
    data.forEach((item)=>{
        
        let tr=document.createElement('tr')
        let td1=document.createElement('td')
        td1.innerText=item.rollNo
        let name = document.createElement('td')
        name.innerText=item.firstName
        let td2=document.createElement('td')
        td2.innerText=item.lastName
        let td3=document.createElement('td')
        td3.innerText=item.phoneNumber;
        let td4=document.createElement('td')
        td4.innerText=item.dateOfBirth
        let td5=document.createElement('td')
        td5.innerText= item.gender
        let td6=document.createElement('td')
        td6.innerText= item.address
        let button=document.createElement('button')
        button.innerText='delete'

        //for delete perticular student
        button.addEventListener('click',(()=>{
            fetch(`http://localhost:8000/students/${item.rollNo}`,{
                method:'DELETE'
            })
            .then((res)=>{
                getData()
            })
        }))

        // for update perticular student
        let button2=document.createElement('button')
        button2.innerText='update'

        button2.addEventListener('click',(()=>{
            fetch(`http://localhost:8000/students/${item.rollNo}`,{
                method:'PUT'
            })
            .then((res)=>{
                getData()
            })
        }))

        //for view details for perticular student
        let button3=document.createElement('button')
        button3.innerText="View"
        // var anchor = document.createElement("a");
        // anchor.href = "studentDetails.html";
        // anchor.appendChild(button3);
        button3.addEventListener('click',(()=>{

            window.location.href="studentDetails.html";
            fetch(`http://localhost:8000/students/${item.rollNo}`,{
                method:'GET'
            })
            .then((res)=>{
                getData()
            })
        }))
        tr.append(td1,name,td2,td3,td4,td5,td6,button,button2,button3);
        tbody.append(tr)
        
        
        
    })
}