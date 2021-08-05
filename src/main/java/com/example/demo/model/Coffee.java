package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "coffee")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Coffee {

    @Id
    @Column(name="id",nullable = false)
    @SequenceGenerator(name ="coffee_seq",sequenceName = "coffee_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coffee_seq")
    private Long id;
    private String name;
    private int price;
}
