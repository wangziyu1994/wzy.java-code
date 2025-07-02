var http = require('http');

function sendRes(request, response) {
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.end("Hello wangziyu \n");

}

//http.createServer(sendRes).listen(9999);
//console.log("server running at  9999  Port");
function myfunction1(param1,param2){
    console.log(param1);
    console.log(param2);
}
//myfunction1("dsfd","aaaaaaaa");


function myfunction2(param1,param2,param3){
    param1();

}

myfunction2(myfunction1,"111111111","2222222222222");


