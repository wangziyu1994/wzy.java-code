console.log("wangziyu run nodejs");
var fs=require("fs");
var zlib=require("zlib");
fs.createReadStream("../nodefile/file3.gz")
    .pipe(zlib.createGunzip())
    .pipe(fs.createWriteStream("file4"));