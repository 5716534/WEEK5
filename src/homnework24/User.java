package homnework24;

public class User {
    private String username;
    private String password;
    private String[] hobby;
    private String sex;

    public User() {
    }

    public User(String username, String password, String[] hobby, String sex) {
        this.username = username;
        this.password = password;
        this.hobby = hobby;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
