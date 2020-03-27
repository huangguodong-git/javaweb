# 								Struts2

## Struts2执行流程

第一步：执行核心控制器

​				a.执行init方法

​				b.调用dofilter方法的时候，会经过拦截器

第二步：调用Action（动作类）方法

​				a.执行通过action的方法

​				b.获得执行类和执行类的方法

​				c.跳转到执行的页面

## Struts2配置文件的加载

struts2的初始化过程中（在核心过滤器调用init方法）：

a）.default.properties:常量文件

b）.struts-default.xml:struts2的核心配置（拦截器等）

c）.Struts-plugin.xml:struts2的插件配置（这个文件包含插件包）

d）.struts.xml(开发者自己编写):struts2的action配置

e）.struts.properties

f）.web.xml