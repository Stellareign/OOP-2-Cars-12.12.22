package races;

public class Main {
    public static void main(String[] args) {


        System.out.println("ЛЕГКОВЫЕ АВТО: \n");
        PassengCar kia = new PassengCar("KIA", "RIO", 1.6, "МКПП");
        PassengCar ford = new PassengCar("Ford", "Mustang VI", 2.3, "АКПП");
        PassengCar lada = new PassengCar("ВАЗ", "LADA Vesta Sport", 1.8, "МКПП");
        PassengCar reno1 = new PassengCar("RENOULT", "Arcana", 1.6, "МКПП");
//        System.out.println(kia);
//        System.out.println(ford);
//        System.out.println(lada);
//        System.out.println(reno1);

        System.out.println("ГРУЗОВИКИ: \n");
        CargoCar camaz1 = new CargoCar("КАМАЗ", "435091", 12.5, "АКПП");
        CargoCar camaz2 = new CargoCar("КАМАЗ", "43509", 13, "АКПП");
        CargoCar iveco = new CargoCar("Iveco", "PowerStar", 13, "АКПП");
        CargoCar reno2 = new CargoCar("Renault", "K520", 13, "АКПП");
//        System.out.println(camaz1);
//        System.out.println(camaz2);
//        System.out.println(iveco);
//        System.out.println(reno2);

        System.out.println("АВТОБУСЫ: \n");
        Bus liaz = new Bus("ЛИАЗ", "CRUISE", 9.29, "МКПП");
        Bus paz = new Bus("ПАЗ", "3237", 4.5, "АКПП");
        Bus gazel = new Bus("ГАЗ", "ГАЗель NEXT", 2.9, "63"); // проверка метода КПП
        Bus camazBus = new Bus("КАМАЗ", "НЕФАЗ-5299-17-52", 6.7, "АКПП");
//        System.out.println(liaz);
//        System.out.println(paz);
//        System.out.println(gazel);
//        System.out.println(camazBus);

        // ===== ВОДИТЕЛИ =========
        // Категория В:
        Driver driverB1 = new DriverB<PassengCar>(" ", "B", 2020, kia);
        Driver driverB2 = new DriverB<PassengCar>("Овчинников А.Е.", "B", 1990, ford);
        Driver driverB3 = new DriverB<PassengCar>("Малков А.С.", "v", 1995, lada);
        Driver driverB4 = new DriverB<PassengCar>("Семёнова Е.Г", "B", 2023, reno1); // проверка года стажа
        // Категория С:
        Driver driverC1 = new DriverC<CargoCar>("Карпов К.Н.", "C", 2000, camaz1);
        Driver driverC2 = new DriverC<CargoCar>("Акимов С.С.", "D", 2010, camaz2);
        Driver driverC3 = new DriverC<CargoCar>("Скударь Ф.С.", "C", 2012, iveco);
        Driver driverC4 = new DriverC<CargoCar>("Большов М.В.", "C", 1999, reno2);
        // Категория D:
        Driver driverD1 = new DriverD<Bus>("Шапарь Р.В.", "C", 2003, liaz);
        Driver driverD2 = new DriverD<Bus>("Филиппов А.А.", "D", 2001, gazel);
        Driver driverD3 = new DriverD<Bus>("Конкин С.В.", "D", 1998, paz);
        Driver driverD4 = new DriverD<Bus>("Васильев А.Р.", "D", 2010, camazBus);

        // ===== ПРОБУЕМ МЕТОДЫ=====
        driverB1.startDrive();
        driverB2.finishDrive();
        driverB3.refuelTheCar();
        driverC1.finishDrive();
        driverD4.refuelTheCar();
        kia.pitStop();
        liaz.pitStop();
        camazBus.maxSpeed();
        camaz1.startDrive();
        camaz2.bestTimeOfLap();
        ford.bestTimeOfLap();
        liaz.finishDrive();


        System.out.println("\n Водители категории B:");
        System.out.println(driverB1);
        System.out.println(driverB2);
        System.out.println(driverB3);
        System.out.println(driverB4);
        System.out.println("\n Водители категории С:");
        System.out.println(driverC1);
        System.out.println(driverC2);
        System.out.println(driverC3);
        System.out.println(driverC4);
        System.out.println("\n Водители категории D:");
        System.out.println(driverD1);
        System.out.println(driverD2);
        System.out.println(driverD3);
        System.out.println(driverD4);
    }
}