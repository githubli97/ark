package com.ark.domain.helper;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class SnowflakeIdGeneratorHelper {

    private static final long START_TIMESTAMP = 1622505600000L; // 2021-06-01 00:00:00
    private static final long WORKER_ID_BITS = 10L;
    private static final long SEQUENCE_BITS = 12L;
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);

    private long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeIdGeneratorHelper() {
        // 根据IP地址和MAC地址生成机器ID
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            long macAddressAsLong = ((0x000000FF & (long) mac[0]) | (0x0000FF00 & (((long) mac[1])
                << 8))
                | (0x00FF0000 & (((long) mac[2]) << 16)) | (0xFF000000L & (((long) mac[3]) << 24)));
            this.workerId = macAddressAsLong % MAX_WORKER_ID;
        } catch (Exception e) {
            // 如果获取IP地址或MAC地址失败，则随机生成一个机器ID
            this.workerId = new Random().nextInt((int) MAX_WORKER_ID);
        }
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - START_TIMESTAMP) << (WORKER_ID_BITS + SEQUENCE_BITS)) |
            (workerId << SEQUENCE_BITS) |
            sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
