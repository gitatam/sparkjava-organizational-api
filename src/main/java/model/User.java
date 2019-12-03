package model;

public class User {
    private int id;
    private String name;
    private String designation;
    private String role;
    private int departmentId;

    public User(String name, String designation, String role, int departmentId) {
        this.name = name;
        this.designation = designation;
        this.role = role;
        this.departmentId = departmentId;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (departmentId != user.departmentId) return false;
        if (!name.equals(user.name)) return false;
        if (!designation.equals(user.designation)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + designation.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + departmentId;
        return result;
    }
}
