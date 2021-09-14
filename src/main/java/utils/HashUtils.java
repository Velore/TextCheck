package utils;

import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import java.security.MessageDigest;
import java.util.List;

/**
 * @author chenzhuohong
 */
public class HashUtils {

    /**
     * 二进制hash的长度
     */
    private static final int HASH_BIN_LENGTH = 128;

    /**
     * 将字节数组转换为二进制字符串
     * @param bytes 字节数组
     * @return 二进制字符串
     */
    public static String bytesToBinString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String bin = Integer.toBinaryString(0xFF & b);
            if (bin.length() == 1) {
                builder.append('0');
            }
            builder.append(bin);
        }
        return builder.toString();
    }

    /**
     * 输入一个词，获取词的hash值
     * @param str 要获取hash值的词
     * @return 字符串形式的hash值
     */
    public static String getHash(String str){
        StringBuilder strHash = null;
        try{
            //通过md5算法获取字符串的摘要信息
            MessageDigest md = MessageDigest.getInstance("MD5");
            //将字符串的摘要信息更新至MessageDigest
            md.update(str.getBytes());
            //获取字符串的二进制hash并转换为字符串
            strHash = new StringBuilder(bytesToBinString(md.digest()));
            //diffDigit为hash位数的差值
            int diffDigit = HASH_BIN_LENGTH - strHash.length();
            //diffDigit不为0,即hash长度不足128位,在末尾补0
            if(diffDigit > 0){
                for(int i = 0 ; i < diffDigit ; i++){
                    strHash.append("0");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        assert strHash != null : "";
        return strHash.toString();
    }

    /**
     * 获取字符串的SimHash值
     * @param str 要获取SimHash的字符串
     * @return 字符串形式的SimHash值
     */
    public static String getSimHash(String str){
        if(str == null | "".equals(str)){
            System.out.println("读取字符串为空");
            return null;
        }
        List<Term> wordList = StandardTokenizer.segment(str);
        //128位的加权向量表
        int[] weightedList = new int[HASH_BIN_LENGTH];
        for (Term term : wordList) {
            if(term.nature != Nature.w){
                //strHash每个分出的词都计算出128位哈希值
                String strHash = HashUtils.getHash(term.word);
                for (int index = 0; index < weightedList.length; index++) {
                    // 哈希值的每一位都与1比较，若等于1则乘以1，否则乘以-1，最后加在加权向量表上
                    // 分词出现的频率就是分词的权值,分词每出现一次，权值+1
                    // 因此无需额外处理分词权值
                    weightedList[index] += (strHash.charAt(index) == '1' ? 1 : -1);
                }
            }
        }
        StringBuilder simHashStrBuilder = new StringBuilder();
        for (int index : weightedList) {
            simHashStrBuilder.append((index > 0 ? 1 : 0));
        }
        return simHashStrBuilder.toString();
    }

}
