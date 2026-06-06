
---
 ## 相关依赖
---
```text
 <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-starter-model-openai</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```
---
## 下面是application.yml的相关配置
```text
spring:
  ai:
    openai:
      base-url: https://api.siliconflow.cn
      api-key: sk-XXXXXXXX
      chat:
        options:
          model: Pro/zai-org/GLM-5.1
          temperature: 0.3
```

---
## 相关作用
---

| 配置 | 作用 |
|------|------|
| `spring` | Spring Boot 的总配置入口 |
| `ai` | Spring AI 相关配置 |
| `openai` | 使用 Spring AI 的 OpenAI 兼容客户端 |
| `base-url` | 模型平台地址，这里是硅基流动 |
| `api-key` | 你的 API 密钥，用来认证身份 |
| `chat` | 聊天模型相关配置 |
| `options` | 模型调用参数 |
| `model` | 指定使用哪个模型 |
| `temperature` | 控制回答随机性 |

---