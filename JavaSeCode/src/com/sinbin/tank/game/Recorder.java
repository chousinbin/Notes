package com.sinbin.tank.game;

import java.io.*;
import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/9 17:05
 * @Description:
 */
public class Recorder {
    private static int enemyTankHitCount = 0;
    private static BufferedWriter bw1;
    private static ObjectOutputStream oos;

    private static String scorePath = "resource\\score.txt";
    private static String enemyTanksPath = "resource\\enemyTanks.bak";

    private static Vector<EnemyTank> enemyTanks = null;

    public static void add() {
        enemyTankHitCount ++;
    }

    public static void saveScore() {
        try {
            bw1 = new BufferedWriter(new FileWriter(scorePath));
            bw1.write(enemyTankHitCount + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw1 != null) {
                try {
                    bw1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static int readScore() {
        BufferedReader br = null;
        int score = 0;
        try {
            br = new BufferedReader(new FileReader(scorePath));
            score = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return score;
    }
    // 序列化保存敌人坦克位置
    public static void saveEnemyTanks() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(enemyTanksPath));
            oos.writeObject(enemyTanks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 反序列化
    public static Vector<EnemyTank> readEnemyTanks() {
        ObjectInputStream ooi = null;
        Vector<EnemyTank> res = null;
        try {
            ooi = new ObjectInputStream(new FileInputStream(enemyTanksPath));
            res = (Vector<EnemyTank>) ooi.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ooi != null) {
                try {
                    ooi.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

    public static int getEnemyTankHitCount() {
        return enemyTankHitCount;
    }

    public static void setEnemyTankHitCount(int enemyTankHitCount) {
        Recorder.enemyTankHitCount = enemyTankHitCount;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static String getScorePath() {
        return scorePath;
    }

    public static String getEnemyTanksPath() {
        return enemyTanksPath;
    }
}
