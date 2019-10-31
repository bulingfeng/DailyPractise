package com.jdk.enumtest.thread.schedule;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-31
 *
 *scheduleAtFixedRate
 * 1：period >执行时间  会等满足period的间隔才会执行
 * 开始执行,时间为:2019-10-31 14:36:19
 * 任务执行完成,时间为:2019-10-31 14:36:22 +3秒
 * 开始执行,时间为:2019-10-31 14:36:24 14:36:24-14:36:19=5秒中
 * 任务执行完成,时间为:2019-10-31 14:36:27
 * 开始执行,时间为:2019-10-31 14:36:29
 * 任务执行完成,时间为:2019-10-31 14:36:32
 * 开始执行,时间为:2019-10-31 14:36:34
 *
 *
 * 2:period <=执行时间  立即开始执行
 * 开始执行,时间为:2019-10-31 14:39:41
 * 任务执行完成,时间为:2019-10-31 14:39:47
 * 开始执行,时间为:2019-10-31 14:39:47
 * 任务执行完成,时间为:2019-10-31 14:39:53
 * 开始执行,时间为:2019-10-31 14:39:53
 */
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        // scheduleAtFixedRate 间隔某段时间开始执行
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
//        executor.scheduleAtFixedRate(getTask(),5,5, TimeUnit.SECONDS);

        // scheduleWithFixedDelay 延迟某段时间开始执行
        executor.scheduleWithFixedDelay(getTask(),5,5, TimeUnit.SECONDS);
    }

    public static Runnable getTask(){
        return ()->{
            System.out.println("开始执行,时间为:"+new Date().toLocaleString());
            try {
                // 模拟任务处理时间
                Thread.sleep(3000);
//                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完成,时间为:"+new Date().toLocaleString());
        };

    }
}
