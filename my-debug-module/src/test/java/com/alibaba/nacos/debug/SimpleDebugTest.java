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
import org.junit.Test;

import java.util.Properties;

/**
 * 简单的调试测试类
 * 
 * 用于理解 Nacos 的核心功能和源码结构
 */
public class SimpleDebugTest {
    
    /**
     * 测试创建 ConfigService
     * 
     * 这是理解 Nacos 配置管理的第一个入口点
     */
    @Test
    public void testCreateConfigService() {
        System.out.println("开始测试：创建 ConfigService");
        
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", "localhost:8848");
            
            // 设置断点在这里，可以深入查看 NacosFactory 的实现
            ConfigService configService = NacosFactory.createConfigService(properties);
            
            System.out.println("✓ ConfigService 创建成功");
            System.out.println("  实现类: " + configService.getClass().getName());
            
            // 可以继续调用其他方法进行调试
            // configService.getConfig(...)
            // configService.publishConfig(...)
            
        } catch (NacosException e) {
            System.err.println("创建失败: " + e.getMessage());
            // 如果 Nacos Server 未启动，这是正常的
        }
    }
    
    /**
     * 测试查看 Nacos 核心类的结构
     */
    @Test
    public void testExploreNacosClasses() {
        System.out.println("\n探索 Nacos 核心类结构：");
        
        // 可以在这里添加代码来探索 Nacos 的核心类
        // 例如：查看类的继承关系、方法签名等
        
        System.out.println("提示：可以在这里添加断点，查看类的详细信息");
    }
}
