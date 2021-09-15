import utils.AccessUtils;
import utils.ResultUtils;

/**
 * 主启动类
 * @author chenzhuohong
 */
public class TextCheck {

    public static void main(String[] args) {
        AccessUtils.write(
                //查重结果
                ResultUtils.textCheck(
                        //需要查重的两个文件路径
                        AccessUtils.read(args[0]), AccessUtils.read(args[1]))
                //答案写入文件的路径
                , args[2]);
    }
}
