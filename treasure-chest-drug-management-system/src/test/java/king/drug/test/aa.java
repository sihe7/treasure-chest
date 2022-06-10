package king.drug.test;

/**
 * @author: hemenghao
 * @date: 2022/4/24 14:54
 */
public class aa {
    private String name = "和梦浩";
    public void eat(){
    }
    public void aa(){
        name = "bb";
    }
    public String dd(int c){
        System.out.println(name);
        if(c == 2){
            aa();
            return name;
        }
        else return name;
    }
}
