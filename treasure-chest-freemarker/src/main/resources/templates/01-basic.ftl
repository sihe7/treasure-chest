<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World!</title>
</head>
<body>
<b>普通文本 String 展示：</b><br><br>
Hello ${name} <br>

<hr>
<#--我是一个freemarker注释-->
<b>对象Student中的数据展示：</b><br/>
姓名：${stu.name}<br/>
年龄：${stu.age}
<hr>

<b>算数运算符</b>
<br/><br/>
100+5 运算：  ${100 + 5 }<br/>
100 - 5 * 5运算：${100 - 5 * 5}<br/>
5 / 2运算：${5 / 2}<br/>
12 % 10运算：${12 % 10}<br/>
<hr>
</body>
</html>