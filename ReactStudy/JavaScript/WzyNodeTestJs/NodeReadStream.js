var fs=require("fs");
var readStream=fs.createReadStream("../nodefile/file1");
var data="";
readStream.setEncoding("UTF8");
readStream.on("data",function(chunk){
data+=chunk;
});

readStream.on("end",function(){
    console.log("end:");
    console.log(data);
});
readStream.on("error",function(err){
    console.log("error:"+err.stack);
});

console.log("读取文件完毕");