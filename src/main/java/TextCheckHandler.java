import utils.HashUtils;
import utils.IOUtils;

/**
 * @author chenzhuohong
 */
public class TextCheckHandler {

    /**
     * 获取两字符串的海明距离
     * @param simHash1 字符串1
     * @param simHash2 字符串2
     * @return 海明距离
     */
    public static double getHammingDistance(String simHash1, String simHash2){
        double hammingDistance = 0;
        for(int i = 0; i<128 ; i++){
            //对比simhash的每一位
            if(simHash1.charAt(i)!=simHash2.charAt(i)){
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    /**
     * 主启动类
     * @param originPath 初始文本路径
     * @param comparePath 对比文本路径
     * @param answerPath 写入结果的路径
     */
    public static void textCheck(String originPath, String comparePath, String answerPath){
        //计算初始文本的simhash
        String originSimHash = HashUtils.getSimHash(IOUtils.read(originPath));
        //计算对比文本的simhash
        String compareSimHash = HashUtils.getSimHash(IOUtils.read(comparePath));
        //计算两文本重复率
        double repetitiveRate =(128 - getHammingDistance(originSimHash, compareSimHash))/128;
        //将重复率写入结果路径
        IOUtils.write(Double.toString(repetitiveRate), answerPath);
    }

    public static void main(String[] args) {
        textCheck(args[0], args[1], args[2]);
    }
}
