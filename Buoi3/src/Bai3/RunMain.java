package Bai3;

import java.util.Random;

public class RunMain {
    public static void main(String[] args) {
        Random rd = new Random();
        Guns dt1 = new Guns();
        Guns dt2 = new Guns();
        dt1.setWeaponName("DiepBeDe");
        dt1.setAmmoNumber(100);
        dt2.setWeaponName("DoanXinhGai");
        dt2.setAmmoNumber(100);

        while(dt1.getAmmoNumber() != 0 && dt2.getAmmoNumber() != 0){
            dt1.Shoot(rd.nextInt(11));
            dt2.Shoot(rd.nextInt(11));

            if (dt1.getAmmoNumber() == 0 && dt2.getAmmoNumber() == 0) {
                System.out.println("het dan");
                dt1.Load(rd.nextInt(11));
                dt2.Load(rd.nextInt(11));
            }
           else {
                if (dt1.getAmmoNumber() == 0) {
                    System.out.println(dt1.getWeaponName() + " thua");
                    break;
                }
                else {
                    System.out.println(dt2.getWeaponName() + " thua");
                    break;
                }
            }
        }
    }
}