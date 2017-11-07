package com.eric.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * User: nanxing
 * Date: 06/11/2017
 */
public class RateLimiterTest {
    @Test
    public void testBrustry() {
        // 每秒0.2个，10秒2个
        RateLimiter rateLimiter = RateLimiter.create(1);
        System.out.println(rateLimiter.acquire(1) * 1000);
        // 突发流量
        System.out.println(rateLimiter.acquire(20) * 1000);
        System.out.println(rateLimiter.acquire(1) * 1000);
        System.out.println(rateLimiter.acquire(1) * 1000);
        System.out.println(rateLimiter.acquire(1) * 1000);
    }
}
