import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PatternDemo
 * @Description
 * @Author zhangzx
 * @Date 2019/3/28 9:47
 * Version 1.0
 **/
public class PatternDemo {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\w+");
        System.out.println(p.pattern());

        Pattern p1 = Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        System.out.println(str[1]);

        System.out.println(Pattern.matches("\\d+","2223"));//返回true
        System.out.println(Pattern.matches("\\d+","2223aa"));//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
        System.out.println(Pattern.matches("\\d+","22bb23"));//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到

        Pattern p2 = Pattern.compile("\\d+");
        Matcher m = p2.matcher("22bb23");
        System.out.println(m.pattern());//返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的

        //当匹配到时返回true,没匹配到则返回false
        Pattern p3=Pattern.compile("\\d+");
        Matcher m3=p3.matcher("22bb23");
        System.out.println(m.matches());//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        Matcher m4=p3.matcher("2223");
        System.out.println(m4.matches());//返回true,因为\d+匹配到了整个字符串

        //lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        Pattern p5=Pattern.compile("\\d+");
        Matcher m5=p5.matcher("22bb23");
        System.out.println(m4.lookingAt());//返回true,因为\d+匹配到了前面的22
        Matcher m6=p5.matcher("aa2223");
        System.out.println(m6.lookingAt());//返回false,因为\d+不能匹配前面的aa

        Pattern p7=Pattern.compile("\\d+");
        Matcher m7=p7.matcher("22bb23");
        m.find();//返回true
        Matcher m8=p7.matcher("aa2223");
        m8.find();//返回true
        Matcher m9=p7.matcher("aa2223bb");
        m9.find();//返回true
        Matcher m10=p7.matcher("aabb");
        m10.find();//返回false

    }
}
