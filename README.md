# wangyong
- 架构：2.0版本，mybatis-plus，swagger2
- 关于swagger2：http://域名:端口/swagger-ui.html
- hystrixDashboard服务监控：http://域名:端口/hystrix

#----------分隔符-----------

yyong-framework-parent | pom | yyong父项目

--------------
yyong-framework-common |  工具

----------------------
eurekaServer集群
- yyong-server-eureka-8761:8761
- yyong-server-eureka-8762:8762

--------
hystrixDashboard服务监控
- 端口：9001
- http://域名:端口/hystrix
- 健康度：绿<黄<橙<红
------------
gateway网关
- yyong-microservice-gateway-80
- 基于 Filter 的限流>令牌桶算法
-------------------
vod集群(视频播放)
- yyong-microservice-vod-8401:8401
- yyong-microservice-vod-8402:8402
-------