package com.Extends;

public class extends1 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小钻风";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(360.5);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "总钻风";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(600.6);
        graduate.showInfo();
    }


}
