package com.safewomen.SafeWomen.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId",length = 45)
    private long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "phoneno", length = 12)
    private String phoneno;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(long id, String name, String email, String password, String phoneno) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
    }

    public User() {
    }

    public User(String name, String email, String password, String phoneno) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneno() {
        return phoneno;
    }



    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }






    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneno=" + phoneno +
                '}';
    }
}
