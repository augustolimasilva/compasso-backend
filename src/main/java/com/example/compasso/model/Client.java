package com.example.compasso.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "sex", length = 20, nullable = false)
    private String sex;

    @Column(name = "birthday", length = 20, nullable = false)
    private String birthday;

    @Column(name = "age", nullable = false)
    private int age;

    @OneToOne(fetch = FetchType.EAGER)
    private City city;
}
