package com.sinbin.tank.game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AePlayWave extends Thread {
    private String filename;
    private boolean loop; // 控制是否循环播放

    public AePlayWave(String wavfile, boolean loop) {
        this.filename = wavfile;
        this.loop = loop; // 是否循环播放
    }

    public void run() {
        do {
            File soundFile = new File(filename);

            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)) {
                AudioFormat format = audioInputStream.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                SourceDataLine auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);

                auline.start();
                byte[] abData = new byte[512]; // 缓冲区
                int nBytesRead;

                while ((nBytesRead = audioInputStream.read(abData, 0, abData.length)) != -1) {
                    auline.write(abData, 0, nBytesRead);
                }

                auline.drain();
                auline.close();

            } catch (Exception e) {
                e.printStackTrace();
                break; // 如果发生错误，退出循环
            }
        } while (loop); // 如果 loop 为 true，则继续播放
    }
}
