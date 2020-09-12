package Wanderlust.Domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table (name = "user_account",uniqueConstraints = {
        @UniqueConstraint(columnNames = "userEmail")})
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer user_ID;

    String userName;

    String userSurname;

    @NaturalId(mutable = false)
    @Column(name = "userEmail", unique = true)
    String userEmail;

    String userPassword;

    public User(String userName, String userSurname, String userEmail, String userPassword) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}



