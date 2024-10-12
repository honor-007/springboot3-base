# springboot3-base
springboot3.x快速开发框架

#### 介绍
搭建一个基于spring3+版本和java21的快速开发框架

#### 软件架构

#### 主要组件
* Redis 用于缓存高频访问的数据，提升系统性能和响应速度。
* Minio 用于对象存储，提供可靠的非结构化数据存储服务。
* MapStruct：用于高效的 Java 对象映射转换
* saToken 轻量级的 Java 权限认证框架，主要解决登录认证、权限认证、Session 会话、单点登录、OAuth2.0、微服务网关鉴权等一系列权限相关问题
* Knife4j 是一个基于 Swagger 2 的在线 API 文档框架,为 Java MVC 框架集成 Swagger 生成 API 文档提供了增强解决方案

#### 工程结构
``` 
Springboot-base
├── auth -- 授权服务提供
├── common -- 常用工具封装包 通用配置文件
├── gateway -- Spring Cloud 网关
├── service -- 业务模块
├    ├── demo -- demo模块 
├    ├── system -- 系统模块 
├    ├── user -- 用户模块 
├    └── ... -- 扩展模块 
├── service-api -- 业务模块api封装
├    ├── demo-api -- 工作台api 
├    ├── system-api -- 系统api 
└──  ├── user-api -- 用户api 
├    └── ... -- 扩展api 
```

#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx
