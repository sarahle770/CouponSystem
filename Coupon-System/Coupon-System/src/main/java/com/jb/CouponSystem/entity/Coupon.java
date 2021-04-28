package com.jb.CouponSystem.entity;

import com.jb.CouponSystem.data.LocalDateConverter;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This file is a part of Coupon-System project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
@Entity
@Getter
@Setter
@ToString
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String title;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate startDate;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate endDate;
    private int category;
    private String description;
    private double price;
    private String imageURL;
    @ManyToMany
    @JoinTable(name = "customer_coupon",
            joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    public Coupon() {
        /*Empty*/
    }
}
