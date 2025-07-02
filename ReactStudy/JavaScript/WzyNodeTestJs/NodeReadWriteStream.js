var fs=require("fs");
var readStream=fs.createReadStream("../nodefile/file3");
var writeStream=fs.createWriteStream("../nodefile/file3-copy");
readStream.pipe(writeStream);


var zlib=require("zlib");

fs.createReadStream("../nodefile/file3")
.pipe(zlib.createGzip())
.pipe(fs.createWriteStream("../nodefile/file3.gz"));

console.log("压缩完成")


fs.createReadStream("../nodefile/file3.gz")
.pipe(zlib.createGunzip())
.pipe(fs.createWriteStream("file3"));

console.log("解压完成")