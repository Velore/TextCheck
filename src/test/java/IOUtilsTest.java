import utils.IOUtils;
import org.junit.Test;

public class IOUtilsTest {

    private final String prefix = "D:\\Project1\\GitHub\\TextCheck\\src\\main\\resources\\";

    private final String originPath = "orig.txt";

    private final String answerPath = "ans.txt";

    @Test
    public void readTest(){
        System.out.println(IOUtils.read(prefix + originPath));
        System.out.println(IOUtils.read(""));
    }

    @Test
    public void writeTest(){
        boolean isCompete = IOUtils.write("writeTest", prefix + answerPath);
        System.out.println(isCompete + "\n" + IOUtils.read(prefix + answerPath));
        IOUtils.write("", "");
    }
}
