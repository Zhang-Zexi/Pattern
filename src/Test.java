import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Test
 * @Description
 * @Author zhangzx
 * @Date 2019/3/28 10:31
 * Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        //通过控制板输入想要输入的地址，然后测试是否符合规则
        String url = "rtsp://admin:admin@192.168.30.98:554/media/video1";

        //校验地址中是否存在 “ip:端口号”  （例如rtsp://admin:admin@192.168.30.98:554/media/video1 ）
        Pattern p = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)");
        Matcher m = p.matcher(url);

        //将符合规则的提取出来

        while(m.find()) {

            System.out.println("ip:"+m.group(1));
            System.out.println("port:"+m.group(2));
        }
    }

}
