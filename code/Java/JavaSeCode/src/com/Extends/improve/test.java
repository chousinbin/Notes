package com.Extends.improve;

import com.Extends.improve.Graduate;
import com.Extends.improve.Pupil;

public class test {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小钻风";
        pupil.age = 12;
        pupil.testing();
        pupil.setScore(360.4);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "总钻风";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(600.6);
        graduate.showInfo();
    }
}
