package java_base.lesson01_BasicDataStructure;

import java.util.Comparator;

public class IncomeCompartor implements Comparator<Salary> {
    @Override
    public int compare(Salary o1, Salary o2) {
        int income1 = o1.getBaseSalary() * 13 + o1.getBonus();
        int income2 = o2.getBaseSalary() * 13 + o2.getBonus();
        int value = 0;
        if ( income1 < income2 ) {
            value = 1;
        } else if ( income1 > income2 ) {
            value = -1;
        }
        return value;
    }
}
