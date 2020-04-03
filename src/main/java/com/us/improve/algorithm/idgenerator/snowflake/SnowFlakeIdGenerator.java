package com.us.improve.algorithm.idgenerator.snowflake;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SnowFlakeIdGenerator
 * @Desciption 基于Twitter的SnowFlake算法，实现分布式系统中全局唯一id
 * @Author loren
 * @Date 2020/3/29 8:33 PM
 * @Version 1.0
 **/
public class SnowFlakeIdGenerator {

    /**
     * 初始时间戳
     *
     * 2017-01-01
     */
    private static final long INITIAL_TIME_STAMP = 1483200000000L;

    /**
     * 数据中心id所占的位数
     */
    private static final long DATACENTER_ID_BITS = 5L;

    /**
     * 机器节点id所占的位数
     */
    private static final long WORKER_ID_BITS = 5L;

    /**
     * 支持的最大数据中心id，结果是31
     *
     * （这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数）
     */
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);

    /**
     * 支持的最大机器节点id，结果是31
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 序列号所占的位数
     */
    private final long SEQUENCE_BITS = 12L;

    /**
     * 数据中心id的偏移量
     */
    private final long DATACENTERID_OFFSET = WORKER_ID_BITS + SEQUENCE_BITS;

    /**
     * 机器节点id的偏移量
     */
    private final long WORKERID_OFFSET = SEQUENCE_BITS;

    /**
     * 时间戳的偏移量
     */
    private final long TIMESTAMP_OFFSET = DATACENTER_ID_BITS + WORKER_ID_BITS + SEQUENCE_BITS;

    /**
     * 生成序列的掩码，这里为4095
     */
    private final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    /**
     * 数据中心id
     *
     * 0~31
     */
    private long datacenterId;

    /**
     * 工作节点id
     *
     * 0~31
     */
    private long workerId;

    /**
     * 序列号
     *
     * 0~4095
     */
    private long sequence = 0L;

    /**
     * 上次生成id的时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 构造函数
     *
     * @param datacenterId 数据中心id(0~31)
     * @param workerId 工作节点id(0~31)
     */
    public SnowFlakeIdGenerator(long datacenterId, long workerId) {
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenterID 不能大于 %d 或小于 0", MAX_DATACENTER_ID));
        }
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("workerID 不能大于 %d 或小于 0", MAX_WORKER_ID));
        }

        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过，这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("当前时间小于上一次记录的时间戳！");
        }

        // 如果是同一时间(毫秒)生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // sequence等于0说明毫秒内序列已经增长到最大值
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        // 移位并通过或运算拼到一起组成64位的ID
        // (timestamp - INITIAL_TIME_STAMP) << TIMESTAMP_OFFSET 表示将时间戳减去初始时间戳，再左移相应位数
        // datacenterId << DATACENTERID_OFFSET 表示将数据中心id左移相应的位数
        // workerId << WORKERID_OFFSET 表示将工作节点id左移相应的位数
        // | 是按位或运算符，例如：x | y，只有当x，y都为0的时候结果才为0，其它情况结果都为1
        // 因为部分只有相应位上的值有意义，其它位上都是0，所以将各部分的值进行 | 运算就能得到最终拼接好的id
        return ((timestamp - INITIAL_TIME_STAMP) << TIMESTAMP_OFFSET) |
                (datacenterId << DATACENTERID_OFFSET) |
                (workerId << WORKERID_OFFSET) |
                sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp  上次生成ID的时间截
     * @return 当前时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        final SnowFlakeIdGenerator idGenerator = new SnowFlakeIdGenerator(1, 1);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long id = idGenerator.nextId();
                    System.out.println(Long.toBinaryString(id));
                }
            });
        }
        executorService.shutdown();
    }

}
