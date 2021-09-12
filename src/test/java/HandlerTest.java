import org.junit.Test;

public class HandlerTest {

    private final String prefix = "D:\\Project1\\GitHub\\TextCheck\\src\\main\\resources\\";

    private final String originPath = "orig.txt";

    private final String comparePath = "orig_0.8_add.txt";

    private final String answerPath = "ans.txt";

    @Test
    public void textCheckTest1(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath,prefix + answerPath);
    }

    @Test
    public void textCheckTest2(){
        TextCheckHandler.textCheck(null,prefix + comparePath,prefix + answerPath);
    }

    @Test
    public void textCheckTest3(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath,null);
    }

    @Test
    public void textCheckTest4(){
        TextCheckHandler.textCheck(prefix + originPath,"",prefix + answerPath);
    }

    @Test
    public void textCheckTest5(){
        TextCheckHandler.textCheck(prefix + originPath,prefix + comparePath,"");
    }
}
