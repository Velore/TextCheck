import org.junit.Test;

public class HandlerTest {

    private final String prefix = "D:\\Project1\\GitHub\\TextCheck\\src\\main\\resources\\";

    private final String originPath = "orig.txt";

    private final String comparePath = "orig_0.8_add.txt";

    private final String comparePath2 = "orig_0.8_del.txt";

    private final String comparePath3 = "orig_0.8_dis_1.txt";

    private final String comparePath4 = "orig_0.8_dis_10.txt";

    private final String comparePath5 = "orig_0.8_dis_15.txt";

    private final String answerPath = "ans.txt";

    @Test
    public void textCheckTest1(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath,prefix + answerPath);
    }

    @Test
    public void textCheckTest2(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath2,prefix + answerPath);
    }

    @Test
    public void textCheckTest3(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath3,prefix + answerPath);
    }

    @Test
    public void textCheckTest4(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath4,prefix + answerPath);
    }

    @Test
    public void textCheckTest5(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath5,prefix + answerPath);
    }
}
