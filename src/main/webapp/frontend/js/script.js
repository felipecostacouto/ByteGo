var my_header = document.getElementsByTagName("h1")[0];
var my_button = document.getElementsByTagName("button")[0];
var my_text = document.getElementsByTagName("h6")[0];

my_button.addEventListener('click', httpGet);
my_header.addEventListener('click', my_function);

function my_function() {
    var time_interval = 1;
    var time = new Date();
    var x = time.getSeconds() + time.getMilliseconds() / 1000;
    var color = Math.cos(x * (Math.PI / time_interval)) * (255 / 2) + (255 / 2);
    my_header.style.backgroundColor = 'rgba(0, 0, ' + color + ', 1)';
    my_header.style.color = 'rgba(' + (255 - color) + ', 0, 0, 1)';
    document.getElementsByTagName("p")[0].textContent = "Text color: " + my_header.style.color;
    document.getElementsByTagName("p")[1].textContent = "Background color: " + my_header.style.backgroundColor;
    document.getElementsByTagName("p")[2].textContent = "Time: " + x.toFixed(2) + " seconds";
    //alert(document.body.getElementsByTagName("p")[0].textContent)
}
setInterval(my_function, 20);
function httpGet() {
    alert("Javascript funcionando!")
    // var url = 'http://127.0.0.1:8888/Person/getBMI?name=Karina%20Santos%20Almeida';
    // fetch(url, {
    //     method: "POST",
    //     body: "Oieee Servidor!"
    // }).then(function (response) {
    //     console.log(response.ok);
    //     return response.json();
    // }).then(function (data) {
    //     useBody(data);
    // })["catch"](function (error) {
    //     alert("ERROOO");
    //     console.log(error);
    // });
}
function useBody(data) {
    // alert(data.person.Name)
    console.log(JSON.stringify(data, null, 4));
    my_text.textContent = data.BMI;
}
