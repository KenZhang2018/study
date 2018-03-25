package java_base.lesson01_BasicDataStructure;




import java.io.Serializable;
import java.nio.ByteOrder;

public class Salary implements Serializable,Cloneable {
    private String name;
    private int baseSalary;
    private int bonus;

    public Salary() {
        String a = null;
        ByteOrder aa = null;
    }

    public Salary(String name, int baseSalary, int bonus) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public Salary clone() {
        Salary salary = null;
        try {
            salary = (Salary) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return salary;
    }

    public Salary(String[] strings) {
        this.name = strings[0];
        this.baseSalary = Integer.valueOf(strings[1]);
        this.bonus = Integer.valueOf(strings[2]);
    }

    public String getPreName() {
        return name.substring(0, 2);
    }

    public int getYearlySalaryCount() {
        return baseSalary*13+bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

//    @Override
//    public String toString() {
//        return "Salary{" +
//                "name='" + name + '\'' +
//                ",  income="+(baseSalary*13+bonus) +
//                ", baseSalary=" + baseSalary +
//                ", bonus=" + bonus  + '}';
//    }


    @Override
    public String toString() {
        return  name +"," +  baseSalary + ","+  bonus;
    }
}
