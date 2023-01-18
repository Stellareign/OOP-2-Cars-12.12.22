package Collections;

import Collections.Drivers.Driver;
import Collections.Drivers.DriverB;
import Collections.Drivers.DriverC;
import Collections.Drivers.DriverD;
import Collections.Mechanics.Mechanic;
import Collections.Mechanics.ServiceTransport;
import Collections.Mechanics.TechServiceStation;
import Collections.Vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    ArrayList<Mechanic> mechanicsBTeamList = new ArrayList<>();
    ArrayList<Mechanic> mechanicsCTeamList = new ArrayList<>();
    ArrayList<Mechanic> mechanicsDTeamList = new ArrayList<>();


        System.out.println("****** ЛЕГКОВЫЕ АВТО: *********************************");
        PassengCar kia = new PassengCar("KIA", "RIO", 1.6, "МКПП", BodyType.HATCHBACK, mechanicsBTeamList);
        PassengCar ford = new PassengCar("Ford", "Mustang VI", 2.3, "АКПП", BodyType.COUPE, mechanicsBTeamList);
        PassengCar lada = new PassengCar("ВАЗ", "LADA Vesta Sport", 1.8, "МКПП", BodyType.SEDAN, mechanicsBTeamList);
        PassengCar reno1 = new PassengCar("RENOULT", "Arcana", 1.6, "МКПП", BodyType.HATCHBACK, mechanicsBTeamList);

        System.out.println(kia);
        System.out.println(ford);
        System.out.println(lada);
        System.out.println(reno1);

        System.out.println("\n ======= ГРУЗОВИКИ: ============================");
        CargoCar camaz1 = new CargoCar("КАМАЗ", "6520", 12.0, "", LoadCapacity.N3, mechanicsCTeamList);
        CargoCar camaz2 = new CargoCar("КАМАЗ", "43509", 13, "АКПП", LoadCapacity.N1, mechanicsCTeamList);
        CargoCar iveco = new CargoCar("Iveco", "PowerStar", 13, "АКПП", LoadCapacity.N3, mechanicsCTeamList);
        CargoCar reno2 = new CargoCar("Renault", "K520", 13, "АКПП", LoadCapacity.N2,mechanicsCTeamList);
        System.out.println(camaz1);
        System.out.println(camaz2);
        System.out.println(iveco);
        System.out.println(reno2);

// ====== ВЫВОД ИНФОРМАЦИИ О ВОДИТЕЛЯХ: =====

        System.out.println("\n ======== АВТОБУСЫ: ================================");
        Bus liaz = new Bus("ЛИАЗ", "CRUISE", 9.29, "МКПП", BusCapacity.MEDIUM, mechanicsDTeamList);
        Bus paz = new Bus("ПАЗ", "3237", 4.5, "АКПП", BusCapacity.LARGE, mechanicsDTeamList);
        Bus gazel = new Bus("ГАЗ", "ГАЗель NEXT", 2.9, "63", BusCapacity.SMALL, mechanicsDTeamList); // проверка КПП
        Bus camazBus = new Bus("КАМАЗ", "НЕФАЗ-5299-17-52", 6.7, "АКПП", null, mechanicsDTeamList);
        System.out.println(liaz);
        System.out.println(paz);
        System.out.println(gazel);
        System.out.println(camazBus);

        // === вывод типа ТС: ====
        paz.printType();
        camazBus.printType();
        kia.printType();
        Transport.performDiagnostics(kia, camaz1, camazBus, ford, camaz2, gazel); // проверка метода дагностики
//
//        // ===== ВОДИТЕЛИ =========
//        // Категория В:
        Driver driverB1 = new DriverB<PassengCar>("Ковров Е.Б.", "C", 2020, kia);
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


//        // ===== ПРОБУЕМ МЕТОДЫ=====
//        driverB1.startDrive();
//        driverB2.finishDrive();
//        driverB3.refuelTheCar();
//        driverC1.finishDrive();
//        driverD4.refuelTheCar();
//        kia.pitStop();
//        liaz.pitStop();
//        camazBus.maxSpeed();
//        camaz1.startDrive();
//        camaz2.bestTimeOfLap();
//        ford.bestTimeOfLap();
//        liaz.finishDrive();
//
//// ===== ВЫВОД В КОНСОЛЬ ИНФО О ВОДИТЕЛЯХ: ======
        System.out.println("\n ======= Водители категории B: ========================");
        System.out.println(driverB1);
        System.out.println(driverB2);
        System.out.println(driverB3);
        System.out.println(driverB4);
        System.out.println("\n ====== Водители категории С: =========================");
        System.out.println(driverC1);
        System.out.println(driverC2);
        System.out.println(driverC3);
        System.out.println(driverC4);
        System.out.println("\n ====== Водители категории D: ==========================");
        System.out.println(driverD1);
        System.out.println(driverD2);
        System.out.println(driverD3);
        System.out.println(driverD4);
// ===== СОЗДАЁМ СПИСКИ водителей и транспорта по видам и всем чохом: =====
        // ===== Список легковых: ====
        List<PassengCar> passengCars = new ArrayList<>();
        passengCars.add(kia);
        passengCars.add(ford);
        passengCars.add(lada);
        passengCars.add(reno1);

        // ====== Список грузовых: ====
        List<CargoCar> trucks = new ArrayList<>();
        trucks.add(camaz1);
        trucks.add(camaz2);
        trucks.add(iveco);
        trucks.add(reno2);

        // ====== Список автобусов: ====
        List<Bus> buses = new ArrayList<>();
        buses.add(liaz);
        buses.add(paz);
        buses.add(gazel);
        buses.add(camazBus);

        // ==== ВЕСЬ ТРАНСПОРТ: ====
        List<Transport> vehicle = new ArrayList<>();
        vehicle.add(kia);
        vehicle.add(ford);
        vehicle.add(lada);
        vehicle.add(reno1);
        vehicle.add(camaz1);
        vehicle.add(camaz2);
        vehicle.add(iveco);
        vehicle.add(reno2);
        vehicle.add(liaz);
        vehicle.add(paz);
        vehicle.add(gazel);
        vehicle.add(camazBus);

        // ====== ВСЕ ВОДИТЕЛИ: ====
        List<Driver> allDrivers = new ArrayList<>();
        allDrivers.add(driverB1);
        allDrivers.add(driverB2);
        allDrivers.add(driverB3);
        allDrivers.add(driverB4);
        allDrivers.add(driverC1);
        allDrivers.add(driverC2);
        allDrivers.add(driverC3);
        allDrivers.add(driverC4);
        allDrivers.add(driverD1);
        allDrivers.add(driverD2);
        allDrivers.add(driverD3);
        allDrivers.add(driverD4);

      //===== СОЗДАЁМ МЕХАНИКОВ: ======
        Mechanic mechanic1 = new Mechanic(
                "Иванов",
                "Пётр",
                "Быстрый сервис",
                ServiceTransport.PassCars);
        Mechanic mechanic2 = new Mechanic(
                "Петров",
                "Васисуалий",
                "Быстрый сервис",
                ServiceTransport.PassCars);
        Mechanic mechanic3 = new Mechanic(
                "Дробнов",
                "Матвей",
                "Top gear",
                ServiceTransport.Trucks);
        Mechanic mechanic4 = new Mechanic(
                "Карпенкова",
                "Надежда",
                "Формула",
                ServiceTransport.MultiSpec);
        Mechanic mechanic5 = new Mechanic(
                "Волынин",
                "Андрей",
                "Формула",
                ServiceTransport.MultiSpec);
        Mechanic mechanic6= new Mechanic(
                "Малов",
                "Николай",
                "Top gear",
                ServiceTransport.Trucks);
        Mechanic mechanic7= new Mechanic(
                "Купцов",
                "Артём",
                "TopBus",
                ServiceTransport.Buses);
        Mechanic mechanic8= new Mechanic(
                "Панов",
                "Алексей",
                "TopBus",
                ServiceTransport.Buses);
        System.out.println("\n ****** МЕХАНИКИ: ***********************");
        mechanicsBTeamList.add(mechanic1); // легков.
        mechanicsBTeamList.add(mechanic2); // легков.
        mechanicsBTeamList.add(mechanic4); // мульти.

        mechanicsCTeamList.add(mechanic3); // грузов.
        mechanicsCTeamList.add(mechanic6); // грузов.
        mechanicsCTeamList.add(mechanic4); // мульти.
        mechanicsCTeamList.add(mechanic5); // мульти.

        mechanicsDTeamList.add(mechanic7); // автобус
        mechanicsDTeamList.add(mechanic4); // мульти.
        mechanicsDTeamList.add(mechanic5); // мульти.
        mechanicsDTeamList.add(mechanic8); // автобус
//        System.out.println(mechanicsTeamList);

// ======== СОЗДАЁМ КОМАНДЫ МЕХАНИКОВ  и водителя ДЛЯ АВТО ========
        System.out.println("\n ****** КОМАНАДЫ МЕХАНИКОВ ******************");
        System.out.println("*********** Команда  для автомобиля " + kia.getBrand() +" " + kia.getModel() + ":");
        kia.creatingMechanicsTeam(mechanic1, mechanic2);
        kia.creatingDriver(driverB1);


        System.out.println("\n *********** Команда механиков для грузовика: " + camazBus.getBrand() +" " + camaz2.getModel() + ":");
        iveco.creatingMechanicsTeam(mechanic4, mechanic3);
        iveco.creatingDriver(driverC3);


        System.out.println("\n  *********** Команда механиков для автобуса:"  + camazBus.getBrand() + " " + camazBus.getModel() + ":");
        camazBus.creatingMechanicsTeam(mechanic7, mechanic5, mechanic4);
        camazBus.creatingDriver(driverD4);

// ========= создаём СТО, проводим ТО:
        System.out.println("/n ********* проводим ТО на СТО *************");
        TechServiceStation sto = new TechServiceStation();
        sto.addTransport(reno1);
        sto.addTransport(reno2);
        sto.addTransport(kia);
        sto.addTransport(camaz1);
        sto.addTransport(camaz2);
        sto.addTransport(camazBus);
        sto.maintenanceCar();

        }

    }

