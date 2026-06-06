package lon;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAI {

    @Resource
    OpenAiChatModel openAiChatModel;


    //    基本的简单用法
    @Test
    public void t1() {
        String s = openAiChatModel.call("你好！介绍一下你自己。");
        System.out.println(s);
    }

//    进阶用法
    @Test
    public void t2(){
//        defaultSystem
//        设置默认提示词 会一起发给AI
//        告诉 AI 应该扮演什么角色
//        规定行为规则
//        限制回答范围
//        只要使用这个client，每次都会带这个提示词
        ChatClient  client = ChatClient.builder(openAiChatModel)
                .defaultSystem("你是医生，对于医学知识需要使用专业知识解答，对于非医学问题，拒绝回答")
                .build();
        String s1 = client.prompt()
                .user("你是谁")
                .call()
                .content();
        System.out.println(s1);
        System.out.println("==================");
        String s2 = client.prompt()
                .user("我头痛")
                .call().content();
        System.out.println(s2);
        System.out.println("==================");
        String s3 = client.prompt()
                .user("你是医生吗？")
                .call()
                .content();
        System.out.println(s3);
    }
    /*
    * System
    *给 AI 设定规则、身份和回答边界。
    * */
    @Test
    public void t3(){
        ChatClient client = ChatClient.builder(openAiChatModel).build();
        String s1 = client
                .prompt()
                .system("你是一名老师！")
                .user("你是老师吗?")
                .call()
                .content();
        System.out.println(s1);
        System.out.println("====================");
        String s2 = client
                .prompt()
                .user("你是老师吗？")
                .call()
                .content();
        System.out.println(s2);
    }
    /*
    * 两个系统提示词对比
    *                      system                                                   defaultSystem
    *持续时间           一次，只要没有使用就不会将这个系统提示词发过去                    一直，只要使用这个对象
    * 适用场景                  临时角色                                                    固定角色
    * 调用位置                  prompt后                                                      builder时
    * 优先级都是相同的--高
    * */

/*
* Spring AI 的参数占位符模板。
* 作用：把 question 的内容填入 prompt 里的 {q}，然后发送给 AI，让 AI 整理成任务列表。
* */

    @Test
    public void t4(){
        ChatClient client = ChatClient.builder(openAiChatModel).build();
        String question = "我明天八点起床，八点半洗漱，九点吃饭" +
                "，十点出门去图书馆学习";
        String prompt = """
                请你把下面的内容梳理成任务列表
                内容:{q}.
                格式:
                (1). 明天去看球
                (2). 后天去打球
                """;
        /*
        * 个人理解： userMessage表示用户消息构建器（使用lambda）；userMessage.text(prompt)表示设置文本，文本是prompt；.param("q",prompt))作用将q替换成为对应的内容
        * */
        String s1 = client
                .prompt()
                .user(userMessage->userMessage.text(prompt).param("q",question))
                .call()
                .content();
        System.out.println(s1);


    }



}
