var fs=require("fs");
var data="hello,wangziyu afdfdf\n sfdsfsdfsdfsdf";
var writeStream=fs.createWriteStream("../nodefile/file2");
writeStream.write(data,"UTF-8");
writeStream.end();
writeStream.on("finish",function(){
    console.log("写入完成!");
});

writeStream.on("error",function(error){
    console.log("error"+error.stack);
});

console.log("写入程序执行完毕");