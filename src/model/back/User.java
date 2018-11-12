package model.back;


import java.sql.SQLException;

public class User {

    private int id;
    private String email;
    private String password;
    private String regCode;
    private int role;
    private int activ;
    private String roleName;
    private String firstName;
    private String lastName;
    private double hourlyRate;


    public User(int id, String email, String password, String regCode, int activ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.regCode = regCode;
        this.activ = activ;
    }

    public User(String regCode, int activ) {
        this.regCode = regCode;
        this.activ = activ;
    }

    public User(int id, String email, String password, int roleId) throws SQLException {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleName = RoleDao.getRoleName(roleId);
    }

    public User(String email, String password, String regCode) {
        this.email = email;
        this.password = password;
        this.regCode = regCode;
    }

    public User(int id, String email, int roleId, String lastName, String firstName, double hourlyRate) throws SQLException {
        this.id = id;
        this.email = email;
        this.roleName = RoleDao.getRoleName(roleId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
    }

    public User(String email, int role, String firstName, String lastName, double hourlyRate) {
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegCode() {
        return regCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public int getActiv() {
        return activ;
    }

    public void setActiv(int activ) {
        this.activ = activ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
