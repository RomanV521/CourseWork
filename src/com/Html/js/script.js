const $list1 = document.querySelector('.list1');
const $list = document.querySelector('.list');
const $field = document.querySelector('.conText');

// let users = null;

function templateGenerator(listElem, list){
    let template = '';
    if(list.length){
        for(let i=0; i<list.length; i++){
            template += '<li>' + list[i].name + '</li>';
        }
    } else{
        template +='<li>Not Found!</li>';
    }
    listElem.innerHTML = template;
}

var button = document.querySelector(".button");   
button.addEventListener("click", function(){

let xhr = new XMLHttpRequest();


// 2. Настраиваем его: GET-запрос по URL /article/.../load
xhr.open('GET', 'http://localhost:8001/back/users');
// xhr.setRequestHeader("Access-Control-Allow-Origin","null");

// 3. Отсылаем запрос
xhr.send();

// 4. Этот код сработает после того, как мы получим ответ сервера
xhr.onload = function() {

    var usersObj = JSON.parse(this.response);
    console.log(users);
    templateGenerator($list, usersObj.users);
};


});
