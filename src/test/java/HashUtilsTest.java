import utils.HashUtils;
import utils.AccessUtils;
import org.junit.Test;

public class HashUtilsTest {

    private final String prefix = "D:\\r\\";

    private final String originPath = "orig.txt";

    @Test
    public void getHashTest(){
        System.out.println(HashUtils.getHash(AccessUtils.read(prefix + originPath)));
        System.out.println(HashUtils.getHash(AccessUtils.read("")));
//        System.out.println(HashUtils.getHash(AccessUtils.read(null)));
    }

    @Test
    public void getSimHashTest(){
        String comparePath = "orig_0.8_add.txt";
        System.out.println(HashUtils.getSimHash(AccessUtils.read(prefix + originPath)));
        System.out.println(HashUtils.getSimHash(AccessUtils.read(prefix + comparePath)));
    }
}
