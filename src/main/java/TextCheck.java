import utils.AccessUtils;
import utils.ResultUtils;

/**
 * 主启动类
 * @author chenzhuohong
 */
public class TextCheck {

    public static void main(String[] args) {
        AccessUtils.write(ResultUtils.textCheck(AccessUtils.read(args[0]), AccessUtils.read(args[1])), args[2]);
    }
}
