const $list = document.querySelector('.list1');
const $field = document.querySelector('.conText');

let users = null;

function templateGenerator(list){
    let template = '';
    if(list.length){
        for(let i=0; i<list.length; i++){
            template += '<li>' + list[i].name + '</li>';
        }
    } else{
        template +='<li>Not Found!</li>';
    }
    $list.innerHTML = template;
}

fetch('http://localhost:8001/back/users/')
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            users = data.results;
            templateGenerator(users);
        })
        



$field.addEventListener('input', function(){
    let conText = this.value.toLowerCase();
    let filterdUsers = users.filter(function(el){
        return ~el.name.toLowerCase().indexOf(conText);
    });
    templateGenerator(filterdUsers);
})


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