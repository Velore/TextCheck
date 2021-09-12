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
    private static String bytesToBinString(byte[] bytes) {
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
     * @param word 要获取hash值的词
     * @return 字符串形式的hash值
     */
    public static String getHash(String word){
        StringBuilder wordHash = null;
        try{
            //通过md5算法获取字符串的摘要信息
            MessageDigest md = MessageDigest.getInstance("MD5");
            //将字符串的摘要信息更新至MessageDigest
            md.update(word.getBytes());
            //获取字符串的二进制hash并转换为字符串
            wordHash = new StringBuilder(bytesToBinString(md.digest()));
            int a = HASH_BIN_LENGTH - wordHash.length();
            //hash长度不足128位，在末尾补0
            if(a > 0){
                for(int i = 0 ; i < a ; i++){
                    wordHash.append("0");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return wordHash.toString();
    }

    /**
     * 获取字符串的SimHash值
     * @param textStr 要获取SimHash的字符串
     * @return 字符串形式的SimHash值
     */
    public static String getSimHash(String textStr){
        List<Term> wordList = StandardTokenizer.segment(textStr);
        //128位的加权向量表
        int[] weightedList = new int[HASH_BIN_LENGTH];
        for (Term term : wordList) {
            if(term.nature != Nature.w){
                //wordHash每个分出的词都计算出128位哈希值
                String wordHash = HashUtils.getHash(term.word);
                for (int j = 0; j < HASH_BIN_LENGTH; j++) {
                    //哈希值的每一位都与1比较，若等于1则乘以1，否则乘以-1，最后加在加权向量表上
                    weightedList[j] += (wordHash.charAt(j) == '1' ? 1 : -1);
                }
            }
        }
        StringBuilder builder1 = new StringBuilder();
        for(int i = 0 ; i < HASH_BIN_LENGTH ; i++){
            builder1.append((weightedList[i] > 0 ? 1:0));
        }
        return builder1.toString();
    }

}
