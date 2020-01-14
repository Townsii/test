package treemap_test;

public class Salary implements Comparable<Salary>{
    private int id;
    private String name;
    private long salary;

    public Salary() {
    }

    public Salary(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Salary o) {
        if(this.salary>o.salary)
            return 1;
        else if(this.salary<o.salary)
            return -1;
        else{
            if(this.id>o.id)
                return 1;
            else if(this.id<o.id)
                return -1;
            else return 0;
            }
        }



}
