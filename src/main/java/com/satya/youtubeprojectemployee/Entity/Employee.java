package com.satya.youtubeprojectemployee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long ID;

private String name;
private String desigination;
private int experience;
private String department;

public long getID() {
    return ID;
}
public void setID(long id) {
    ID = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getDesigination() {
    return desigination;
}
public void setDesigination(String desigination) {
    this.desigination = desigination;
}
public int getExperience() {
    return experience;
}
public void setExperience(int experience) {
    this.experience = experience;
}
public String getDepartment() {
    return department;
}
public void setDepartment(String department) {
    this.department = department;
}

    
}
