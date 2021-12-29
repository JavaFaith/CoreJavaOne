package UnitFive;
/**
 * @date 2021-12-21
 * @author Robin Wan
 * @description 字符串s和t散列码相同，因为是内容导出，
 * @description 因为在 StringBuilder 类中没有定义hashCode 方法，
 * @description 它的散列码是由 Object 类的默认 hashCode 方法导出的对象存储地址
 */
public class TestStringHashcode {
    public static void main(String[] args){
        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode()+ " " +sb.hashCode());
        String t = "Ok";
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode()+ " " +tb.hashCode());
    }
}
