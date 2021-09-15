package utils;

import java.text.DecimalFormat;

/**
 * @author chenzhuohong
 */
public class ResultUtils {

    /**
     * 获取两字符串的海明距离
     * @param simHash1 字符串1
     * @param simHash2 字符串2
     * @return 海明距离
     */
    public static double getHammingDistance(String simHash1, String simHash2){
        //只要有一个simHash为空，海明距离都为128
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
     * 主处理类
     * @param originStr 初始文本
     * @param compareStr 对比文本
     * @return  返回文本对比的重复率
     */
    public static String textCheck(String originStr, String compareStr){
        DecimalFormat format = new DecimalFormat("0.00");
        //计算初始文本的simHash
        String originSimHash = HashUtils.getSimHash(originStr);
        //计算对比文本的simHash
        String compareSimHash = HashUtils.getSimHash(compareStr);
        //计算并返回对比文本重复率，结果保留两位小数
        //查重结果有两种求法,结果有细微的偏差,本项目使用第二种求法：
        //1: 1-海明距离/simHash总长度
        //2: (simHash总长度-海明距离)/simHash总长度
        return format.format((128 - getHammingDistance(originSimHash, compareSimHash))/128);
    }

}
