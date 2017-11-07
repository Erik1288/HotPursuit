package com.eric.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * User: nanxing
 * Date: 06/11/2017
 */
public class RateLimiterTest {
    public static void main(String[] args) {
        // 每秒0.2个，10秒2个
        RateLimiter rateLimiter = RateLimiter.create(1);
        System.out.println(rateLimiter.acquire(1) * 1000);
        // 突发流量
        System.out.println(rateLimiter.acquire(20) * 1000);
        System.out.println(rateLimiter.acquire(1) * 1000);
        System.out.println(rateLimiter.acquire(1) * 1000);
        System.out.println(rateLimiter.acquire(1) * 1000);

        while (true) {
            // 突发流量
            System.out.println(rateLimiter.acquire(1) * 1000);
        }

    }
}
