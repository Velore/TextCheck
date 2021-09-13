import utils.HashUtils;
import utils.IOUtils;

import java.text.DecimalFormat;

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
        if(simHash1 == null | simHash2 == null){
            return 128;
        }
        double hammingDistance = 0;
        //计算海明距离
        for(int i = 0; i<simHash1.length() ; i++){
            hammingDistance += simHash1.charAt(i) ^ simHash2.charAt(i);
        }
        return hammingDistance;
    }

    /**
     * 主启动类
     * @param originStr 初始文本
     * @param compareStr 对比文本
     * @return  返回文本对比的重复率
     */
    public static String textCheck(String originStr, String compareStr){
        DecimalFormat format = new DecimalFormat("0.00");
        //计算初始文本的simhash
        String originSimHash = HashUtils.getSimHash(originStr);
        //计算对比文本的simhash
        String compareSimHash = HashUtils.getSimHash(compareStr);
        //计算并返回对比文本重复率，结果保留两位小数
        return format.format((128 - getHammingDistance(originSimHash, compareSimHash))/128);
    }

    public static void main(String[] args) {
        IOUtils.write(textCheck(IOUtils.read(args[0]), IOUtils.read(args[1])), args[2]);
    }
}
