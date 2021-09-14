package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 文件读写工具类
 * @author chenzhuohong
 */
public class AccessUtils {

    /**
     * 从绝对路径中读入txt文本
     * @param readPath 文本路径
     * @return 文本字符串
     */
    public static String read(String readPath){
        if(readPath == null){
            throw new NullPointerException("文本路径为空");
        }
        StringBuilder builder = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(readPath), StandardCharsets.UTF_8));
            String strBuffer;
            while((strBuffer = reader.readLine())!=null){
                builder.append(strBuffer);
            }
            reader.close();
            return builder.toString();
        }catch (Exception e){
            throw new NullPointerException("文本路径错误");
        }
    }

    /**
     * 将查重结果写入路径文件
     * @param answer 字符串形式的查重结果
     * @param writePath 写入文件的绝对路径
     */
    public static void write(String answer, String writePath){
        try{
            FileWriter writer = new FileWriter(writePath, true);
            writer.write(answer+"\n");
            writer.flush();
            System.out.println("查重结果已写入文件");
        }catch (Exception e){
            System.out.println("查重结果写入文件失败");
        }
    }
}
