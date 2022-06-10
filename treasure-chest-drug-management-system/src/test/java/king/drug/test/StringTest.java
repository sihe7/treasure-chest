package king.drug.test;


import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * @author: hemenghao
 * @date: 2022/5/10 18:34
 */
@SpringBootTest
public class StringTest {
    @Test
    public void replaceTest() {
        String m = "hello ?,nice+(book) ?-? good";
        String[] n = {"", "he", "she"};
            System.out.println(relapce(m, n));
    }
    public String relapce(String old, String[] params) {
        int count = 0;
        while (old.indexOf("?") != -1 && count < params.length) {
            old = old.substring(0, old.indexOf("?")) + params[count] + old.substring(old.indexOf("?") + 1);
            count++;
        }
        return old;
    }

    /**
     * 给数字补空格
     */
    @Test
    public void stringTest02(){
        String no = "32112";
        String s = StringUtils.rightPad(no, 10, " ");
        System.out.println(s+"00");

    }
    @Test
    public void stringTest03(){
        String a = "220.02";
        String b = "21.10";
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        BigDecimal multiply = add.multiply(new BigDecimal("100"));
        System.out.println("BigDecimal:" + add);
        long l = multiply.longValue();
        System.out.println("Long:" + l);
        System.out.println("multiply:" + multiply);

    }
    @Test
    public void stringTest04(){
        String a = "0";
        String b = "0";
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        BigDecimal multiply = add.multiply(new BigDecimal("100"));
        System.out.println("BigDecimal:" + add);
        long l = multiply.longValue();
        System.out.println("Long:" + l);
        System.out.println("multiply:" + multiply);

    }
    @Test
    public void stringTest05(){
        String s = "/app/bankftp-test/B05150007/{1}";
        String time = "202208";
        StringBuilder insert = new StringBuilder(time).insert(4, "/");
        System.out.println("查询后的字符串:" + insert);
        String replace = s.replace("{1}", insert);
        System.out.println("替换后:" + replace);
    }
    @Test
    public void stringTest06(){
        String str = " 1ede  2as       da3     4 20";
        StringTokenizer tokens = new StringTokenizer(str, " ");
        String[] intArray = new String[tokens.countTokens()];
        int index = 0;
        while(tokens.hasMoreTokens()){
            intArray[index] = tokens.nextToken();
            ++index;
        }
        for (int i = 0; i< intArray.length ;i++){
            System.out.println(i+ " : " + intArray[i]);
        }
    }
    @Test
    public void stringTest07(){
        String a = "   i am an          engineer";
        /*用缺省分隔符空格把a这个字符串分开来， 之后把结果放在StringTokenizer类型的st_Mark_to_win中，即使空很多个格也没问题，这为我们io那章，自己发明自己的j+语言，奠定了坚实的基础*/
        StringTokenizer st_Mark_to_win = new StringTokenizer(a);
        //返回一共有几个字， 这里是4 个
        int count = st_Mark_to_win.countTokens();
        for (int i = 0; i < count; i++) {
            //nextToken是把下一个字取回来
            System.out.println(st_Mark_to_win.nextToken());
        }
        System.out.println("-------------------------------");
        a = "++++===*name=lisi;age=26;title=software engineer";
        /*用=或者;把a这个字符串分开来， 之后把结果放在StringTokenizer类型的st_Mark_to_win中*/
        st_Mark_to_win = new StringTokenizer(a, "=;");
        count = st_Mark_to_win.countTokens();
        for (int i = 0; i < count; i++) {
            System.out.println(st_Mark_to_win.nextToken());
        }
    }
    @Test
    public void stringTest8(){
        String a= "sadas";
        String substring = a.substring(0, 2);
        System.out.println(substring);
    }
    @Test
    public void stringTest9(){
        int[] arr = {2, 8, 3, 16, 6};
        String str = "2378      23 7777            和梦浩   ";
        String[] aa = new String[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            //原值切割
            //aa[i] = str.substring(k, k+arr[i]);
            //去除两端空格
            aa[i] = str.substring(k, k+arr[i]).trim();
            k += arr[i];
        }
        for (int i = 0; i < aa.length; i++) {
            System.out.println("切割后的数组:" + aa[i]);
        }
    }
    @Test
    public void stringTest10(){
        String str = "20220617";
        String a = "/sads/asd/{1}/";
        StringBuilder insert = new StringBuilder(str.substring(0,6)).insert(4, "/");
        String replace = a.replace("{1}", insert);
        System.out.println(replace);
    }
    /*@Test
    public void stringTest11(){
        List<User> list = new ArrayList<>();
        System.out.println("111111");
        for (User s : list) {
            System.out.println("sss"+s.));
        }
        System.out.println("22222");
    }*/

}

