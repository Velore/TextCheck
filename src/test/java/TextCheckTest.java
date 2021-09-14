import org.junit.Test;
import utils.AccessUtils;
import utils.ResultUtils;

public class TextCheckTest {

    private static final String prefix = "D:\\r\\";
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
        TextCheck.main(argsList);
    }

    @Test
    public void textCheckTest2(){
        //读取空字符串，相当于两个完全不同的字符串比较重复率，结果为0
        AccessUtils.write(ResultUtils.textCheck(
                "",
                AccessUtils.read(prefix+comparePath)
        ), prefix + answerPath);
    }

    @Test
    public void textCheckTest3(){
        //读取文件路径为空，读取文件失败，抛出异常
        AccessUtils.write(ResultUtils.textCheck(
                AccessUtils.read(null),
                AccessUtils.read(prefix+comparePath)
        ), prefix + answerPath);
    }

    @Test
    public void textCheckTest4(){
        //读取文件路径不正确，读取文件失败，抛出异常
        AccessUtils.write(ResultUtils.textCheck(
                AccessUtils.read(""),
                AccessUtils.read(prefix+comparePath)
        ), prefix + answerPath);
    }

    @Test
    public void textCheckTest5(){
        //写入文件的路径为空，写入文件失败
        AccessUtils.write(ResultUtils.textCheck(
                AccessUtils.read(prefix+originPath),
                AccessUtils.read(prefix+comparePath)
        ), null);
    }

}
