import utils.AccessUtils;
import org.junit.Test;

public class AccessUtilsTest {

    private final String prefix = "D:\\r\\";

    @Test
    public void readTest(){
        String originPath = "orig.txt";
        System.out.println(AccessUtils.read(prefix + originPath));
        System.out.println(AccessUtils.read(""));
    }

    @Test
    public void writeTest(){
        String answerPath = "ans.txt";
        AccessUtils.write("writeTest", prefix + answerPath);
        System.out.println(AccessUtils.read(prefix + answerPath));
        AccessUtils.write("", "");
    }
}
