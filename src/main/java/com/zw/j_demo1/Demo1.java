package com.zw.j_demo1;

import java.util.Timer;
import java.util.TimerTask;

import com.zw.bean.Student;

public class Demo1 {
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello TimerTask " + System.currentTimeMillis());
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 1000/* 延迟一秒执行 */, 1000 * 2/* 每2秒循环执行一次 */);
        
        Student student = new Student();
        student.age = 11;
        student.name = "HelloWorld!";

        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("hello world!");
    }
}
