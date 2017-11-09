package com.eric.bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: nanxing
 * Date: 08/11/2017
 */
public class BitCalculateTest {
    @Test
    public void basicBitCalc() {
        // << 左移位
        Assert.assertEquals(2, 1 << 1);
        Assert.assertEquals(4, 1 << 2);
        Assert.assertEquals(8, 1 << 3);
        Assert.assertEquals(16, 1 << 4);

        Assert.assertEquals(12, 3 << 2);

        // >>> 算术右移位
        // >> 逻辑右移位
        // ~
        System.out.println(~2);
        // ^ 异或 半加法
        // &
        // |
    }

    @Test
    public void cast() {
        // 补码 = 源码 每一位取反 + 1
        int a = 133;
//        Assert.assertEquals(-1, (byte)a);
        // https://www.cnblogs.com/it-life-nathan/p/6416378.html?utm_source=itdadao&utm_medium=referral
        // 要了解补码
        System.out.println((byte)a);
    }
}
