package reflction;

public class Town {

    int id;
    Human human;

    public Town(int id, Human human) {
        this.id = id;
        this.human = human;
    }

    private void st(int id, Human human){
        System.out.println(id+human.toString());
    }
}
