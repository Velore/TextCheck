import org.junit.Test;
import utils.ResultUtils;

public class ResultUtilsText {

    @Test
    public void ResultUtilsTest1(){
        //测试标点符号对重复率的影响，测试结果为不影响，文本重复率为1
        System.out.println(
                ResultUtils.textCheck(
                        "，。你好，，；。‘这是。，。第一条，；，。’消息。。正在，’。、；检测，。；‘，。",
                        "，‘。；你好，；’。这是，‘，。第一条。“。消息。。；正在、’；。，检测。。"
                )
        );
    }

    @Test
    public void ResultUtilsTest2(){
        //测试词语前后顺序对重复率的影响，测试结果为不影响，文本重复率为1
        System.out.println(
                ResultUtils.textCheck(
                        "你好这是第一条消息正在检测",
                        "消息检测第一条正在这是你好"
                )
        );
    }
}
