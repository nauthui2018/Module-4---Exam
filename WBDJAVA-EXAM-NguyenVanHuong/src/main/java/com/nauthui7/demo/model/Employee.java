package com.nauthui7.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int gender;
    private String mobile;
    private String dob;
    private String personalID;
    private String address;
    private String email;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Group group;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public Group getGroup() {
        return group;
    }

    public String getDob() {
        return dob;
    }

    public String getPersonalID() {
        return personalID;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String viewStatus(int gender) {
        String str;
        switch (gender) {
            case 0:
                str = "Male";
                break;
            case 1:
                str = "Female";
                break;
            case 2:
                str = "Other";
                break;
            default:
                str = "Not chose gender";
        }
        return str;
    }
}
