package model;

public class Department {
    private int id;
    private String deptName;
    private String deptDescription;
    private int employeeCount;

    public Department(String deptName, String deptDescription, int employeeCount) {
        this.deptName = deptName;
        this.deptDescription = deptDescription;
        this.employeeCount = employeeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (employeeCount != that.employeeCount) return false;
        if (!deptName.equals(that.deptName)) return false;
        return deptDescription.equals(that.deptDescription);
    }

    @Override
    public int hashCode() {
        int result = deptName.hashCode();
        result = 31 * result + deptDescription.hashCode();
        result = 31 * result + employeeCount;
        return result;
    }
}
