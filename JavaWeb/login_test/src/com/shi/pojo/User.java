package com.shi.pojo;

/**
 * @author 千文sea
 * @create 2020-09-10 11:19
 */
public class User {
    private String username;
    private Integer age;
    private String password;
    private Integer id;

    public User() {
    }

    public User(String username, Integer age, String password, Integer id) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
