// const $list = document.querySelector('.list1');
// const $field = document.querySelector('.conText');

// let users = null;

// function templateGenerator(list){
//     let template = '';
//     if(list.length){
//         for(let i=0; i<list.length; i++){
//             template += '<li>' + list[i].name + '</li>';
//         }
//     } else{
//         template +='<li>Not Found!</li>';
//     }
//     $list.innerHTML = template;
// }

// fetch('http://localhost:8001/back/users')
//         .then(function(response){
//             return response.json();
//         })
//         .then(function(data){
//             users = data.results;
//             templateGenerator(users);
//         })
var button = document.querySelector(".button");   
button.addEventListener("click", function(){

    // fetch('http://localhost:8001/back/users')
    // .then(function(response){
    //     return response.json();
    // })
    // .then(function(data){
    //     users = data.results;
    //     templateGenerator(users);
    // });
let xhr = new XMLHttpRequest();


// 2. Настраиваем его: GET-запрос по URL /article/.../load
xhr.open('GET', 'http://localhost:8001/back/users');
// xhr.setRequestHeader("Access-Control-Allow-Origin","null");

// 3. Отсылаем запрос
xhr.send();

// 4. Этот код сработает после того, как мы получим ответ сервера
xhr.onload = function() {
    console.log(this.response);

  
};


});



// $field.addEventListener('input', function(){
//     let conText = this.value.toLowerCase();
//     let filterdUsers = users.filter(function(el){
//         return ~el.name.toLowerCase().indexOf(conText);
//     });
//     templateGenerator(filterdUsers);
// })




// $(document).ready(function(){
//     $.getJSON('http://localhost:8001/back/users/', my_getJSON); // вызываем callback-функцию
// });
// //парсим массив data
// function my_getJSON(data){
//     "use strict";
//     // сюда будем пихать результат
//     let str = '';

//     for (let a = 0; a < data.length; a++){
//         // str += data[a].radiant_name + ' VS ' + data[a].dire_name + '<br>';
//         // str += '<li>' + data[a].name + '</li>';
//         str += data[a].name + ' VS ' + data[a].name + '<br>';
//     }
//     // выводим результат
//     $(".list1").html(str);
// }



// async function getData() {
//     try {
//       let res = await fetch("http://localhost:8001/back/users", {
//         mode: 'name'
//       });

//       if (!res.ok) {
//         console.log(res);
//         throw new Error( res.statusText || res.status );
//       }

//       let data = await res.json();
//       console.log(data);
//     } catch (err) {
//       console.error(err);
//       alert('Произошла ошибка...');
//     }
//   }




// new Vue({
//     mounted: function(){
//         fetch('https://pokeapi.co/api/v2/pokemon/')
//             .then(function(response){
//                 return response.json();
//             })
//             .then(function(data){
//                 console.log(data.results);
//             })
//     }
// });