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
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(word.getBytes());
            wordHash = new StringBuilder(bytesToBinString(md.digest()));
            int a = 128 - wordHash.length();
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
        int[] weightedList = new int[128];
        for (Term term : wordList) {
            if(term.nature != Nature.w){
                //wordHash每个分出的词都计算出128位哈希值
                String wordHash = HashUtils.getHash(term.word);
                for (int j = 0; j < 128; j++) {
                    //哈希值的每一位都与1比较，若等于1则乘以1，否则乘以-1，最后加在加权向量表上
                    weightedList[j] += (wordHash.charAt(j) == '1' ? 1 : -1);
                }
            }
        }
        StringBuilder builder1 = new StringBuilder();
        for(int i = 0 ; i < 128 ; i++){
            builder1.append((weightedList[i] > 0 ? 1:0));
        }
        return builder1.toString();
    }

}
