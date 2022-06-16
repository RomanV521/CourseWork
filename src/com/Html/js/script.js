const $list1 = document.querySelector('.list1');
const $list = document.querySelector('.list');
const $field = document.querySelector('.conText');

// let users = null;

function templateGenerator(listElem, list){
    let template = '';
    if(list.length){
        for(let i=0; i<list.length; i++){
            template += '<ul class="api-information">' + '<li>'+ (i+1) +')</li>' +
                                '<li> Surname: ' + list[i].surname + '</li>' + 
                                '<li> Name: ' + list[i].name + '</li>' + 
                                '<li> Patronymic: ' + list[i].patronymic + '</li>' + 
                                '<li> Flight Number: ' + list[i].baggage.flightNumber + '</li>' + 
                                '<li> Baggage Check Number: ' + list[i].baggage.baggageCheckNumber + '</li>' + 
                                '<li> Amount Of Luggage: ' + list[i].baggage.amountOfLuggage + '</li>' + 
                                '<li> Baggage Weight: ' + list[i].baggage.baggageWeight + '</li>' + 
                                '<li> Luggage Placement Time: ' + list[i].baggage.luggagePlacementTime + '</li>' + 
                                '<li> Period Of Placement: ' + list[i].baggage.periodOfPlacement + '</li>' + '</ul>';
        }
    } else{
        template +='<li>Not Found!</li>';
    }
    listElem.innerHTML = template;
}

var button = document.querySelector(".button");   
button.addEventListener("click", function(){

let xhr = new XMLHttpRequest();


// 2. Настраиваем его: GET-запрос по URL
xhr.open('GET', 'http://localhost:8001/back/users');
// xhr.setRequestHeader("Access-Control-Allow-Origin","null");

// 3. Отсылаем запрос
xhr.send();

// 4. Этот код сработает после того, как мы получим ответ сервера
xhr.onload = function() {

    var usersObj = JSON.parse(this.response);
    console.log(usersObj);
    templateGenerator($list, usersObj.users);
};


});