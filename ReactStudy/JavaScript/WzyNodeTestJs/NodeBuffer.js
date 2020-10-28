var buffer=new Buffer(26);
for(var i=0;i<26;i++){
    buffer[i]=i+97;
}

    console.log(buffer.toString("ascii"))

var buff1=new Buffer("www.wangziyu.com");
var buffjson=buff1.toJSON();
console.log(buffjson);