package basic;

import static java.lang.System.*;
import java.util.Scanner;

public class IfTest {

    int yeahOut;

    boolean condition1(){
            return (yeahOut%4==0 & yeahOut%100!=0) | yeahOut%400==0;
    }


    public void setYeahOut(int yeahOut) {
        this.yeahOut = yeahOut;
    }

    public int getYeahOut() {
        return yeahOut;
    }

    public static void main(String[] args){
        IfTest test = new IfTest();
        out.println("请输入年份");
        Scanner yeahIn = new Scanner(in);
        int yeahO = yeahIn.nextInt();
        test.setYeahOut(yeahO);
        if(test.condition1()==true){
            out.println(yeahO+"是闰年");
        }
        else {
            out.println(yeahO+"不是闰年");
        }
    }
}
