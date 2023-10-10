package com.example.test_modul4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String adress;
    @NotNull
    private String phone;
    @NotNull
    @Column(unique = true)
    private String email;
    @ManyToOne
    private Classboard classboard;


    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(Long id, String name, LocalDate dateOfBirth, String adress, String phone, String email, Classboard classboard) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.classboard = classboard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classboard getClassboard() {
        return classboard;
    }

    public void setClassboard(Classboard classboard) {
        this.classboard = classboard;
    }
}
