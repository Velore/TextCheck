import Utils.IOUtils;
import org.junit.Test;

public class IOUtilsTest {
    private final String testPath = "D:\\Project1\\GitHub\\TextCheck\\src\\main\\resources\\test.txt";

    @Test
    public void readTest(){
        System.out.println(IOUtils.read(testPath));
    }

    @Test
    public void writeTest(){
        boolean isCompete = IOUtils.write("writeTest", testPath);
        System.out.println(isCompete + "\n" + IOUtils.read(testPath));
    }
}
