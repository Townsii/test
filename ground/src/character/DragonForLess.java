package character;

public class DragonForLess {

    private DragonForLess(){

    }

    private static DragonForLess dragon;

    public static DragonForLess getDragonName(){
        if(dragon==null)
          dragon = new DragonForLess();
    return dragon;
    }
}
