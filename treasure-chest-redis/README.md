什么是 NoSQL ？
NoSQL(NoSQL = Not Only SQL )，意即“不仅仅是SQL”，泛指非关系型的数据库。
为什么需要 NoSQL ？
随着互联网web2.0网站的兴起，传统的关系数据库在应付web2.0网站，特别是超大规模和高并发的SNS类型的web2.0纯动态网站已经显得力不从心，暴露了很多难以克服的问题，而非关系型的数据库则由于其本身的特点得到了非常迅速的发展。NoSQL数据库的产生就是为了解决大规模数据集合多重数据种类带来的挑战，尤其是大数据应用难题。  -- 百度百科
NoSQL 数据库的四大分类

键值（key-value）存储
列存储
文档数据库
图形数据库




分类
相关产品
典型应用
数据模型
优点
缺点




键值（key-value)
Tokyo、 Cabinet/Tyrant、Redis、Voldemort、Berkeley DB
内容缓存，主要用于处理大量数据的高访问负载
一系列键值对
快速查询
存储的数据缺少结构化


列存储数据库
Cassandra, HBase, Riak
分布式的文件系统
以列簇式存储，将同一列数据存在一起
查找速度快，可扩展性强，更容易进行分布式扩展
功能相对局限


文档数据库
CouchDB, MongoDB
Web应用（与Key-Value类似，value是结构化的）
一系列键值对
数据结构要求不严格
查询性能不高，而且缺乏统一的查询语法


图形（Graph）数据库
Neo4J, InfoGrid, Infinite Graph
社交网络，推荐系统等。专注于构建关系图谱
图结构
利用图结构相关算法
需要对整个图做计算才能得出结果，不容易做分布式集群方案



NoSQL 的特点

易扩展
灵活的数据模型
大数据量，高性能
高可用

二、Redis 概述
Redis的应用场景

缓存
任务队列
网站访问统计
应用排行榜
数据过期处理
分布式集群架构中的 session 分离

三.Redis 安装
网上有很多 Redis 的安装教程，这里就不多说了，只说下 Docker 的安装方法：
Docker 安装运行 Redis
docker run -d -p 6379:6379 redis:4.0.8
如果以后想启动 Redis 服务，打开命令行，输入以下命令即可。
redis-server
使用前先引入依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>



StringRedisTemplate 与 RedisTemplate 的区别


StringRedisTemplate 继承了 RedisTemplate。


RedisTemplate 是一个泛型类，而 StringRedisTemplate 则不是。


StringRedisTemplate 只能对 key=String，value=String 的键值对进行操作，RedisTemplate 可以对任何类型的 key-value 键值对操作。


他们各自序列化的方式不同，但最终都是得到了一个字节数组，殊途同归，StringRedisTemplate 使用的是 StringRedisSerializer 类；RedisTemplate 使用的是 JdkSerializationRedisSerializer 类。反序列化，则是一个得到 String，一个得到 Object


两者的数据是不共通的，StringRedisTemplate 只能管理 StringRedisTemplate 里面的数据，RedisTemplate 只能管理 RedisTemplate中 的数据。
