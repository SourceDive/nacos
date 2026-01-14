# My Debug Module - Nacos 源码阅读入口

这是一个用于阅读和理解 Nacos 源码的调试模块。

## 模块结构

```
my-debug-module/
├── pom.xml                                    # Maven 配置文件
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/alibaba/nacos/debug/
│   │           └── DebugEntryPoint.java      # 主入口类
│   └── test/
│       └── java/
│           └── com/alibaba/nacos/debug/
│               └── SimpleDebugTest.java      # 单元测试类
└── README.md                                  # 本文件
```

## 使用方法

### 1. 运行主入口类

在 IDE 中直接运行 `DebugEntryPoint.java` 的 `main` 方法：

```bash
# 或者使用命令行
cd my-debug-module
mvn exec:java -Dexec.mainClass="com.alibaba.nacos.debug.DebugEntryPoint"
```

### 2. 运行单元测试

在 IDE 中运行 `SimpleDebugTest.java` 中的测试方法，或者使用 Maven：

```bash
mvn test -pl my-debug-module
```

### 3. 调试源码

**推荐步骤：**

1. 在 `DebugEntryPoint.java` 的 `createConfigService()` 方法中设置断点
2. 以 Debug 模式运行 `main` 方法
3. 进入 `NacosFactory.createConfigService()` 方法，开始追踪源码

## 源码阅读建议路径

### 配置管理（Config）

1. **入口点**: `NacosFactory.createConfigService()`
2. **核心接口**: `com.alibaba.nacos.api.config.ConfigService`
3. **实现类**: `com.alibaba.nacos.client.config.NacosConfigService`
4. **关键方法**:
   - `getConfig()` - 获取配置
   - `publishConfig()` - 发布配置
   - `addListener()` - 添加配置监听器

### 服务发现（Naming）

1. **入口点**: `NacosFactory.createNamingService()`
2. **核心接口**: `com.alibaba.nacos.api.naming.NamingService`
3. **实现类**: `com.alibaba.nacos.client.naming.NacosNamingService`

### 核心模块

- **nacos-common**: 通用工具类和基础组件
- **nacos-core**: 核心功能实现
- **nacos-api**: API 接口定义
- **nacos-client**: 客户端实现
- **nacos-config**: 配置管理服务端实现
- **nacos-naming**: 服务发现服务端实现

## 注意事项

- 如果本地没有启动 Nacos Server，某些功能可能无法正常使用，这是正常的
- 可以在代码中添加更多调试代码来探索不同的功能模块
- 建议结合 IDE 的调试功能（断点、单步执行、变量查看等）来深入理解源码

## 扩展

你可以在这个模块中添加更多的测试类和调试代码，例如：

- 测试配置的增删改查
- 测试服务注册与发现
- 测试配置监听机制
- 探索 Nacos 的集群和一致性协议

Happy Debugging! 🚀
