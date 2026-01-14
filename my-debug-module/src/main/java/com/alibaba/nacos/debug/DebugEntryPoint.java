/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.debug;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * Debug Entry Point - 源码阅读入口
 * 
 * 这是一个最简单的入门测试案例，用于理解 Nacos 的核心功能
 * 
 * @author Debug Module
 */
public class DebugEntryPoint {
    
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("Nacos 源码阅读入口 - Debug Entry Point");
        System.out.println("==========================================");
        
        // 1. 创建配置服务客户端
        createConfigService();
        
        // 2. 可以在这里添加更多调试代码
        // 例如：查看 Nacos 的核心类、理解配置管理流程等
        
        System.out.println("\n提示：可以在这里设置断点，深入阅读 Nacos 源码");
        System.out.println("建议阅读路径：");
        System.out.println("  1. NacosFactory.createConfigService()");
        System.out.println("  2. ConfigService 的实现类");
        System.out.println("  3. 配置的获取、发布、监听流程");
    }
    
    /**
     * 创建配置服务 - 这是理解 Nacos 配置管理的入口
     */
    private static void createConfigService() {
        try {
            // 配置服务器地址（如果本地启动了 Nacos Server，使用 localhost:8848）
            String serverAddr = "localhost:8848";
            
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            
            // 创建配置服务实例
            // 这里可以设置断点，深入查看 NacosFactory 的实现
            ConfigService configService = NacosFactory.createConfigService(properties);
            
            System.out.println("\n✓ ConfigService 创建成功");
            System.out.println("  ConfigService 类型: " + configService.getClass().getName());
            
            // 示例：获取配置（需要 Nacos Server 运行）
            // String dataId = "test";
            // String group = "DEFAULT_GROUP";
            // String content = configService.getConfig(dataId, group, 5000);
            // System.out.println("配置内容: " + content);
            
        } catch (NacosException e) {
            System.err.println("创建 ConfigService 失败: " + e.getMessage());
            System.err.println("提示：如果 Nacos Server 未启动，这是正常的");
            e.printStackTrace();
        }
    }
}
