package com.jb.CouponSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "company",
            cascade = CascadeType.ALL)
    private List<Coupon> coupons;

    public Company() {
        coupons = new ArrayList<>();
    }
}
