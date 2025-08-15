package com.sinbin.inner_class.innerclass02;

/**
 * @ClassName: Apply2
 * @Description:
 * @date: 2023-03-15 16:22
 */
public class Apply2 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Phone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}
