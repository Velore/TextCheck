import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import utils.HashUtils;
import utils.AccessUtils;
import org.junit.Test;

import java.util.stream.Collectors;

public class HashUtilsTest {

    private final String prefix = "D:\\r\\";

    private final String originPath = "orig.txt";

    @Test
    public void getHashTest(){
        System.out.println(
                HashUtils.getHash(
                        AccessUtils.read(prefix + originPath)
                )
        );
        System.out.println(
                HashUtils.getHash(
                        AccessUtils.read("")
                )
        );
    }

    @Test
    public void getSimHashTest(){
        String comparePath = "orig_0.8_dis_1.txt";
        System.out.println(
                HashUtils.getSimHash(
                        AccessUtils.read(prefix + originPath)
                )
        );
        System.out.println(
                HashUtils.getSimHash(
                        AccessUtils.read(prefix + comparePath)
                )
        );
    }

    @Test
    public void strSplitTest(){
        //输出全部分词，包括标点符号
        System.out.println(
                StandardTokenizer.segment(
                        AccessUtils.read(prefix + originPath)
                ).toString()
        );
        //输出去除标点符号后的分词
        System.out.println(
                //读取文件，并分词为list，转化为stream方便操作
                StandardTokenizer.segment(AccessUtils.read(prefix + originPath)).stream()
                        //去除分词list中的标点符号
                        .filter(term -> !term.nature.equals(Nature.w))
                        //将stream再转化为list
                        .collect(Collectors.toList())
        );
    }

}
