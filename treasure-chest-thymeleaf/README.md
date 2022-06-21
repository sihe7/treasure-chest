虽然现在流行前后端分离，但是后端模版在一些关键地方还是非常有用的，例如邮件模版、代码模版等。当然也不排除一些古老的项目后端依然使用动态模版。
Thymeleaf 简洁漂亮、容易理解，并且完美支持 HTML5，可以直接打开静态页面，同时不新增标签，只需增强属性，这样也降低了学习成本。
##1. Thymeleaf 简介
Thymeleaf 是新一代 Java 模板引擎，它类似于 Velocity、FreeMarker 等传统 Java 模板引擎，但是与传统 Java 模板引擎不同的是，Thymeleaf 支持 HTML 原型。
它既可以让前端工程师在浏览器中直接打开查看样式，也可以让后端工程师结合真实数据查看显示效果，同时，SpringBoot 提供了 Thymeleaf 自动化配置解决方案，因此在 SpringBoot 中使用 Thymeleaf 非常方便。
事实上， Thymeleaf 除了展示基本的 HTML ，进行页面渲染之外，也可以作为一个 HTML 片段进行渲染，例如我们在做邮件发送时，可以使用 Thymeleaf 作为邮件发送模板。
另外，由于 Thymeleaf 模板后缀为 .html，可以直接被浏览器打开，因此，预览时非常方便。



##链接:
**https://juejin.cn/post/6907405693154754573**