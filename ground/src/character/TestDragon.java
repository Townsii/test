package character;

public class TestDragon {
    public static void main(String[] args){
        DragonForLess dragon01 = DragonForLess.getDragonName();
        DragonForLess dragon02 = DragonForLess.getDragonName();
        System.out.println(dragon01==dragon02);

    }

}
