import org.junit.Test;
import utils.IOUtils;

public class HandlerTest {

    private static final String prefix = "D:\\Project1\\GitHub\\TextCheck\\src\\main\\resources\\";

    private static final String originPath = "orig.txt";

    private static final String comparePath = "orig_0.8_add.txt";

    private static final String answerPath = "ans.txt";


    @Test
    public void textCheckTest1(){
        //路径完整且正确，写入文件成功
        String[] argsList = new String[3];
        argsList[0] = prefix + originPath;
        argsList[1] = prefix + comparePath;
        argsList[2] = prefix + answerPath;
        TextCheckHandler.main(argsList);
    }

    @Test
    public void textCheckTest2(){
        //相当于两个完全不同的字符串比较重复率，结果为0
        IOUtils.write(TextCheckHandler.textCheck(
                "",
                IOUtils.read(prefix+comparePath)
        ), prefix + answerPath);
    }

    @Test
    public void textCheckTest3(){
        //读取文件失败，抛出异常
        IOUtils.write(TextCheckHandler.textCheck(
                IOUtils.read(null),
                IOUtils.read(prefix+comparePath)
        ), prefix + answerPath);
    }

    @Test
    public void textCheckTest4(){
        //读取文件失败，抛出异常
        IOUtils.write(TextCheckHandler.textCheck(
                IOUtils.read(""),
                IOUtils.read(prefix+comparePath)
        ), prefix + answerPath);
    }

    @Test
    public void textCheckTest5(){
        //写入文件失败
        IOUtils.write(TextCheckHandler.textCheck(
                IOUtils.read(prefix+originPath),
                IOUtils.read(prefix+comparePath)
        ), null);
    }

    @Test
    public void textCheckTest6(){
        //测试标点符号和词语前后顺序对重复率的影响，结果为不影响
        System.out.println(
                TextCheckHandler.textCheck(
                        "你好，，；。‘这是。。，。第一条，；，。’消息。。",
                        "消息，；’。第一条，‘，。这是。。。你好。。；。。"
                )
        );
    }
}
