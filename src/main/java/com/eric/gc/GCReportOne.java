package com.eric.gc;


/**
 * -Xms8m -Xmx8m -Xmn5m -Xss256k -XX:MaxPermSize=128M -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=java.hprof
 *
 * gc log
 * -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime -XX:+PrintPromotionFailure
 */
public class GCReportOne {

    public static void main(String[] args) {
        for (;;) {
            byte[] oneMB = new byte[3 * 1024 * 1024];
            System.gc();
        }
    }
}