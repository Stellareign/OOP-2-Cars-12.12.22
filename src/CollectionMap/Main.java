package CollectionMap;

import CollectionMap.Drivers.Driver;
import CollectionMap.Drivers.DriverB;
import CollectionMap.Drivers.DriverC;
import CollectionMap.Drivers.DriverD;
import CollectionMap.Mechanics.Mechanic;
import CollectionMap.Mechanics.ServiceTransport;
import CollectionMap.Mechanics.TechServiceStation;
import CollectionMap.Vehicle.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    ArrayList<Mechanic> mechanicsBTeamList = new ArrayList<>();
    ArrayList<Mechanic> mechanicsCTeamList = new ArrayList<>();
    ArrayList<Mechanic> mechanicsDTeamList = new ArrayList<>();
        // ======= создаём Мар механиков: ======
        Map<Transport, Mechanic> transportMechanicMapB = new HashMap<>(); // заполнение внизу, так как отсюда не видит объекты
        Map<Transport, Mechanic> transportMechanicMapC = new HashMap<>();
        Map<Transport, Mechanic> transportMechanicMapD = new HashMap<>();

        System.out.println("****** ЛЕГКОВЫЕ АВТО: *********************************");
        PassengCar kia = new PassengCar("KIA", "RIO", 1.6, "МКПП", BodyType.HATCHBACK, transportMechanicMapB);
        PassengCar ford = new PassengCar("Ford", "Mustang VI", 2.3, "АКПП", BodyType.COUPE, transportMechanicMapB);
        PassengCar lada = new PassengCar("ВАЗ", "LADA Vesta Sport", 1.8, "МКПП", BodyType.SEDAN, transportMechanicMapB);
        PassengCar reno1 = new PassengCar("RENOULT", "Arcana", 1.6, "МКПП", BodyType.HATCHBACK, transportMechanicMapB);

        System.out.println(kia);
        System.out.println(ford);
        System.out.println(lada);
        System.out.println(reno1);

        System.out.println("\n ======= ГРУЗОВИКИ: ============================");
        CargoCar camaz1 = new CargoCar("КАМАЗ", "6520", 12.0, "", LoadCapacity.N3, transportMechanicMapC);
        CargoCar camaz2 = new CargoCar("КАМАЗ", "43509", 13, "АКПП", LoadCapacity.N1, transportMechanicMapC);
        CargoCar iveco = new CargoCar("Iveco", "PowerStar", 13, "АКПП", LoadCapacity.N3, transportMechanicMapC);
        CargoCar reno2 = new CargoCar("Renault", "K520", 13, "АКПП", LoadCapacity.N2,transportMechanicMapC);
        System.out.println(camaz1);
        System.out.println(camaz2);
        System.out.println(iveco);
        System.out.println(reno2);

// ====== ВЫВОД ИНФОРМАЦИИ О ВОДИТЕЛЯХ: =====

        System.out.println("\n ======== АВТОБУСЫ: ================================");
        Bus liaz = new Bus("ЛИАЗ", "CRUISE", 9.29, "МКПП", BusCapacity.MEDIUM, transportMechanicMapD);
        Bus paz = new Bus("ПАЗ", "3237", 4.5, "АКПП", BusCapacity.LARGE, transportMechanicMapD);
        Bus gazel = new Bus("ГАЗ", "ГАЗель NEXT", 2.9, "63", BusCapacity.SMALL, transportMechanicMapD); // проверка КПП
        Bus camazBus = new Bus("КАМАЗ", "НЕФАЗ-5299-17-52", 6.7, "АКПП", BusCapacity.SUPERLARGE, transportMechanicMapD);
        System.out.println(liaz);
        System.out.println(paz);
        System.out.println(gazel);
        System.out.println(camazBus);

//        // === вывод типа ТС: ====
//        paz.printType();
//        camazBus.printType();
//        kia.printType();
//        Transport.performDiagnostics(kia, camaz1, camazBus, ford, camaz2, gazel); // проверка метода дагностики
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

//========= СОЗДАЁМ МАПЫ: ================
        System.out.println("\n *********** Печатаем мапы ****************");
        transportMechanicMapB.put(kia, mechanic1);
        transportMechanicMapB.put(kia, mechanic2);
        transportMechanicMapB.put(kia, mechanic2);
        transportMechanicMapB.put(reno1, mechanic1);
        transportMechanicMapB.put(reno1, mechanic5);
        System.out.println("\n" + transportMechanicMapB);

        transportMechanicMapC.put(camaz1, mechanic6);
        transportMechanicMapC.put(camaz1, mechanic3);
        transportMechanicMapC.put(camaz2, mechanic6);
        transportMechanicMapC.put(camaz2, mechanic3);
        transportMechanicMapC.put(reno2, mechanic5);
        transportMechanicMapC.put(reno2, mechanic6);
        System.out.println("\n" + transportMechanicMapC);

        transportMechanicMapD.put(camazBus, mechanic7);
        transportMechanicMapD.put(camazBus, mechanic5);
        transportMechanicMapD.put(camazBus, mechanic4);

        System.out.println("\n" +  transportMechanicMapD);
        // ========= создаём СТО, проводим ТО:
        System.out.println("/n ********* проводим ТО на СТО *************");
        TechServiceStation sto = new TechServiceStation();
        sto.addTransport(reno1);
        sto.addTransport(reno2);
        sto.addTransport(kia);
        sto.addTransport(camaz1);
        sto.addTransport(camaz2);
        sto.addTransport(camazBus);

        sto.doMaintenanceCar();
        System.out.println(sto.getTransportQueue());
        // ======= СОЗДАЁМ SET ВОДИТЕЛЕЙ: =============
        Set<Driver> allDriversSet = new HashSet<>(allDrivers); // создаём сет всех водителей - хэш-множество: можно добавить лист, можно по отдельности
        allDriversSet.add(driverB1); // добавляем дубли
        allDriversSet.add(driverB2);
//        allDriversSet.add(driverB3);
//        allDriversSet.add(driverB4);
//        allDriversSet.add(driverC3);
//        allDriversSet.add(driverC4);
//        allDriversSet.add(driverC2);
//        allDriversSet.add(driverB1); // дублируем водителя для проверки "неповтора"
//        allDriversSet.add(driverC1);
//        allDriversSet.add(driverD1);
//        allDriversSet.add(driverD2);
//        allDriversSet.add(driverD3);
//        allDriversSet.add(driverD4);

        System.out.println("Список всех водителей (через итератор): "); // не работает с несколькими полями, либо выводить со всем данными, либо только с чем-то одним, например ФИО

        Iterator<Driver> itr = allDriversSet.iterator(); // итерируемся по сету с помощью метода итератора, можно записать прямо так: Iterator itr = allDriversSet.iterator(), но яве так не особо "нравится"
       {
            int count = 0; // создаём / инициализируем переменную для счётчика !!!! (надо бы перенести наверх)
            while (itr.hasNext()) { // цикл "пока есть следующий"
                count++; // увеличиваем счётчик на 1
                System.out.println(count + ". " + itr.next().getFio());// + " категория: " + itr.next().getDrivingCategory()); // и выводим через итератор списком в консоль
            }
        }
        System.out.println("\n Список всех водителей (через фор-ич):");
        {int count = 0;
        for (Driver driver : allDriversSet) {

            count++;
            System.out.println(count + ". " + driver.getFio() + " " + driver.getDrivingCategory());
        }
        }
        }
    }

