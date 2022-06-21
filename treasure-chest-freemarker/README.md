FreeMarker 是一款 模板引擎： 即一种基于模板和要改变的数据， 并用来生成输出文本(HTML网页，电子邮件，配置文件，源代码等)的通用工具。 是一个Java类库。

FreeMarker不是一个Web应用框架，而适合作为Web应用框架一个组件。

FreeMarker与容器无关，因为它并不知道HTTP或Servlet。FreeMarker同样可以应用于非Web应用程序环境。

FreeMarker更适合作为Model2框架（如Struts）的视图组件，你也可以在模板中使用JSP标记库。



https://blog.csdn.net/weixin_44454512/article/details/109877418

Freemaker 生成静态化的方式：

​	1.SpringMVC+Freemarker

​		SpringMVC将Freemarker作为视图解析器

​		生成的文件位置：在内存中

​		项目中使用的场景：课程预览

​	2.Freemarker的原生API

​		生成的文件位置：制定文件生成的位置

​		API生成的文件形式：

​			1.模板文件+数据模型

​			2.模板字符串+数据模型

​		项目中使用的场景：课程发布

