package org.designpatterns.creational;

import java.util.UUID;

interface Coupon{
    String code();
    String message();
}

class FoodCoupon implements Coupon{
    @Override
    public String code(){
        return UUID.randomUUID().toString();
    }
    @Override
    public String message(){
        return "I am a Food Coupon.";
    }
}

class ElectronicsCoupon implements Coupon{
    @Override
    public String code(){
        return UUID.randomUUID().toString();
    }
    @Override
    public String message(){
        return "I am a Electronics Coupon.";
    }
}

class CouponFactory{
    public static Coupon getCoupon(Integer points){
        if (points < 50){
            return new FoodCoupon();
        }else {
            return new ElectronicsCoupon();
        }
    }
}


public class Factory {
    public static void main(String[] args){
        Coupon coupon1 = CouponFactory.getCoupon(30);
        System.out.printf("Coupon code: %s, message: %s%n", coupon1.code(), coupon1.message());

        Coupon coupon2 = CouponFactory.getCoupon(50);
        System.out.printf("Coupon code: %s, message: %s%n", coupon2.code(), coupon2.message());    }
}
