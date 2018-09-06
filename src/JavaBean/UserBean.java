package JavaBean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserBean {
    private String name;
    private int age;
    private String sex;
    private String tel;
    private String ps;

    public UserBean(){
        //System.out.println("============ 一个新的实例化对象产生 ===========") ;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public boolean isValid(){
        String pattern_name="[\\u4E00-\\u9FA5]{2,4}";
        String pattern_tel="^((13[0-9])|(15[^4,\\D])|(18[0,3-9]))\\d{8}$";
        Pattern pn = Pattern.compile(pattern_name);
        Pattern pt = Pattern.compile(pattern_tel);
        Matcher mn = pn.matcher(name);
        Matcher mt=pt.matcher(tel);
        if(mn.matches()){
            if(mt.matches()){
                System.out.println("格式正确");
                return true;
            }
            else{
                System.out.println("格式错误1");
                return false;
            }
        }
        else{
            System.out.println("格式错误2");
            return false;
        }
    }
    @Override
    public String toString(){
        //System.out.println("name:"+name+" ,sex:"+sex+" ,age:"+age+" ,tel:"+tel);
        return "name:"+name+" ,sex:"+sex+" ,age:"+age+" ,tel:"+tel;
    }
}