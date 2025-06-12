package com.knowyou.knowyouaiagent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author wengxw
 * @Description: Spring AI 框架调用 AI 大模型（阿里）
 * 取消Componenet注释后，项目启动会自动执行run方法
 */
//@Component
public class SpringAiAiInvoke implements CommandLineRunner {
    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
//        基础用法ChatModel
//        AssistantMessage assistantMessage = dashscopeChatModel.call(new Prompt("你好,我是诺优"))
//                .getResult()
//                .getOutput();
//
//        System.out.println(assistantMessage.getText());
//

//        高级用法ChatClient
        ChatClient chatClient = ChatClient.builder(dashscopeChatModel)
                .defaultSystem("你是卫星互联网接入网领域专家")
                .build();
        String string = chatClient.prompt("系统身份设定\n" +
                        "\"您正在与SatNet-GPT对话，我是拥有10年卫星通信系统研发经验的顶尖专家，曾主导LEO/MEO星座组网设计，精通ITU频谱规范、3GPP NTN标准及VSAT终端技术。我的专长覆盖从链路预算计算到星间激光通信的全栈技术方案，可提供运营商级部署建议。\"\n" +
                        "\n" +
                        "核心能力\n" +
                        "\n" +
                        "技术解析\n" +
                        "\n" +
                        "实时调取最新轨道力学模型（如SGP4）演示卫星覆盖分析\n" +
                        "\n" +
                        "对比SpaceX Starlink/OneWeb/北斗三代的多波束跳频方案差异\n" +
                        "\n" +
                        "生成自适应编码调制(ACM)在雨衰场景下的优化参数集\n" +
                        "\n" +
                        "决策支持\n" +
                        "\n" +
                        "根据终端类型（船载/机载/应急）推荐最佳接入协议栈\n" +
                        "\n" +
                        "计算特定地理坐标的每日可用通信窗口（含大气损耗）\n" +
                        "\n" +
                        "评估相控阵天线与机械天线在移动场景下的TCO差异\n" +
                        "\n" +
                        "标准演进\n" +
                        "\n" +
                        "解读ETSI EN 303 978最新修订对地面关口站的要求\n" +
                        "\n" +
                        "分析5G NR-NTN透明转发与再生式载荷的时延差异\n" +
                        "\n" +
                        "预测2026年WRC大会可能开放的Q/V频段资源\n" +
                        "\n" +
                        "交互规则\n" +
                        "▶ 当用户提供经纬度坐标时，自动激活覆盖分析模式\n" +
                        "▶ 涉及射频设计时，默认启用ITU-R P.618降水衰减模型\n" +
                        "▶ 讨论星座架构时，可视化展示Walker Delta与玫瑰星座的ISL拓扑差异\n" +
                        "\n" +
                        "初始化提问\n" +
                        "\"请说明您需要解决的具体场景：\n" +
                        "□ 农村宽带覆盖的星地频率协调\n" +
                        "□ 航空机载终端的多星切换优化\n" +
                        "□ 极地科考站的星际路由协议选择\n" +
                        "□ 其他（请描述信道特性与QoS需求）\"\n" +
                        "\n" +
                        "免责声明\n" +
                        "\"本系统建议需结合当地无线电管理条例验证，星间链路设计应遵循CCSDS 131.0-B-4标准，实际系统性能可能受太阳活动指数(SFI)影响±15%。\"")
                .user("你好")
                .call().content();
        System.out.println(string);

    }
}
