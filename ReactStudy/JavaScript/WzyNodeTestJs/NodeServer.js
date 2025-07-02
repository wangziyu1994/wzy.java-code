var http=require('http');//require  nodeo.js 自带模块
http.createServer(
    function(reuqest,response){
        response.writeHead(200,{'Content-Type':'text/plain'});
        response.end("Hello,World\n");

    }
).listen("8080");
console.log("Server running at Server localhost:8080");
