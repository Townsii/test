package hero;

import inter.*;

public class ADAPhero extends Hero implements AD,AP{
    public void ADAttack(){
        System.out.println("物理攻击");
    }
    public void APAttack(){
        System.out.println("魔法攻击");
    }
}
