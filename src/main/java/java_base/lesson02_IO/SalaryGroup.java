package java_base.lesson02_IO;

public class SalaryGroup {
    private String groupName;
    private int peopleCount;
    private long salaryTotalCount;

    public void increasePeopleCount() {
        peopleCount++;
    }

    public void plusSalaryTotalCount(int yearlySalaryCount) {
        salaryTotalCount = salaryTotalCount + yearlySalaryCount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public long getSalaryTotalCount() {
        return salaryTotalCount;
    }

    public void setSalaryTotalCount(long salaryTotalCount) {
        this.salaryTotalCount = salaryTotalCount;
    }

    @Override
    public String toString() {
        return groupName +", "+salaryTotalCount +", "+ peopleCount+"人";
    }
}
