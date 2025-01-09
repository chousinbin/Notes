package com.tank.game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/9 17:05
 * @Description:
 */
public class Recorder {
    private static int enemyTankHitCount = 0;
    private static BufferedWriter bw;

    private static String path = "resource\\recorder.txt";

    public static void add() {
        enemyTankHitCount ++;
    }

    public static void save() {
        System.out.println("save");
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(enemyTankHitCount + "");
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static int getEnemyTankHitCount() {
        return enemyTankHitCount;
    }

    public static void setEnemyTankHitCount(int enemyTankHitCount) {
        Recorder.enemyTankHitCount = enemyTankHitCount;
    }

    public static BufferedWriter getBw() {
        return bw;
    }

    public static void setBw(BufferedWriter bw) {
        Recorder.bw = bw;
    }
}
