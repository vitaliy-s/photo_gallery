package ua.sosna.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private int id;
    private String username;
    private String lastName;
    private String birthday;
    private String email;
    private String infoUser;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;

    private Set<Gallery> galleries;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "last_name")
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

    @Column(name = "information_user")
    public String getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(String infoUser) {
        this.infoUser = infoUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "user")
    public Set<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(Set<Gallery> galleries) {
        this.galleries = galleries;
    }
}
