package com.jb.CouponSystem.data.repository;

import com.jb.CouponSystem.entity.Coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * This file is a part of Coupon-System project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    /*Company functions*/
    @Query("select c from Coupon c where c.company.id=:id")
    List<Coupon> findCompanyCoupons(@Param(value = "id") long id);

    @Query("select c from Coupon c where c.company.id=:id and c.category=:category")
    List<Coupon> findCompanyCouponsByCategory(@Param(value = "id") long id, @Param(value = "category") int category);

    @Query("select c from Coupon c where c.company.id=:id and c.price<=:price")
    List<Coupon> findCompanyCouponsLessThan(@Param(value = "id") long id, @Param(value = "price") double price);

    @Query("select c from Coupon c where c.company.id=:id and c.endDate<:endDate")
    List<Coupon> findCompanyCouponsBeforeDate(@Param(value = "id") long id, @Param(value = "endDate") LocalDate date);

    /*Customer functions*/

    @Query("select c from Customer as cr join cr.coupons as c where cr_id=:id")
    List<Coupon> findCustomerCoupons(@Param(value = "id") long id);


    @Query("select c from Customer as cr join cr.coupons as c where cr.id=:id and c.category=:category")
    List<Coupon> findCustomerCouponsByCategory(@Param(value = "id") long id, @Param(value = "category") int category);

    @Query("select c from Customer as cr join cr.coupons as c where cr.id=:customerId and c.price<:price")
    List<Coupon> findCustomerCouponsLessThan(@Param(value = "id") long id, @Param(value = "price") double price);

    @Query("select c from Coupon c inner join c.customers e where e.id =:id and c.endDate<:endDate")
    List<Coupon> findCustomerCouponsBeforeDate(@Param(value = "id") long id, @Param(value = "endDate") LocalDate date);

    @Query("select c from Coupon c where c.endDate<localDate")
    List<Coupon> findExpiredCoupons();
}
