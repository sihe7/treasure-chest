package com.hmh.etc;

/**
 * @description: 控制台打印进度条
 * @author: Mr.hemenghao
 **/
public class Console {
    public static void main(String[] args) {
        final long size = 1000L;
        for (int i = 0; i < 101; i++) {
            String tu = "▧";
            for (int j = 0; j < i / 10; j++) {
                tu += "▧";
            }
            System.out.print("\r当前进度：" + (i) + "%\t" + tu + "\t" + (i * 10) + "/" + size);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
