package hero;

import inter.AD;

public class ADhero extends Hero implements AD {
    public void ADAttack(){
        System.out.println("物理攻击");
    }
}
