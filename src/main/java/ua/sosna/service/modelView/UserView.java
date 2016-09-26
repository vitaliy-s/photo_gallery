package ua.sosna.service.modelView;

public class UserView {

    private String username;
    private String lastName;
    private String birthday;
    private String email;

    public UserView() {
    }

    public UserView(String username, String lastName, String birthday, String email) {
        this.username = username;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
