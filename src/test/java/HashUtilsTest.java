import utils.HashUtils;
import utils.IOUtils;
import org.junit.Test;

public class HashUtilsTest {

    private final String prefix = "D:\\Project1\\GitHub\\TextCheck\\src\\main\\resources\\";

    private final String originPath = "orig.txt";

    private final String comparePath = "orig_0.8_add.txt";

    @Test
    public void getHashTest(){
        System.out.println(HashUtils.getHash(IOUtils.read(prefix + originPath)));
        System.out.println(HashUtils.getHash(IOUtils.read("")));
        System.out.println(HashUtils.getHash(IOUtils.read(null)));
    }

    @Test
    public void getSimHashTest(){
        System.out.println(HashUtils.getSimHash(IOUtils.read(prefix + originPath)));
        System.out.println(HashUtils.getSimHash(IOUtils.read(prefix + comparePath)));
    }
}
