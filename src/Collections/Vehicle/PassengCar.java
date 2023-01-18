package Collections.Vehicle;

import Collections.Competing;
import Collections.Drive;
import Collections.Drivers.Driver;
import Collections.Mechanics.Mechanic;
import Collections.Mechanics.ServiceTransport;

import java.util.ArrayList;
import java.util.List;

public class PassengCar<B> extends Transport implements Drive, Competing {
    private BodyType bodyType; // ДОБАВИЛИ ТИП КУЗОВА, В Т.Ч. В КОНСТРУКТОР
    //    private ArrayList<Mechanic> mechanics;
    private ServiceTransport serviceTransport;
    List<Mechanic> mechanics = new ArrayList<>(); // добавляем листы водителей и механиков для использования
    List<Driver> drivers = new ArrayList<>();
    //private Driver driverB;

    public PassengCar(String brand, String model, double engineVolume, String transmission, BodyType bodyType, ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume, transmission, mechanics);
        this.bodyType = bodyType;
    }

    // ======= ИМПЛЕМЕНТАЦИЯ МЕТОДОВ из интерфейса: =========
    //  ==== движение ====
    @Override
    public void startDrive() {
        if (transmission == "МКПП") {
            System.out.println("Вставить ключ зажигания. \n Выжать сцепление. \n Повернуть ключ, снять с ручника. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ \n Плавно отпустить сцепление. \n Погнали!");
        } else if (transmission == "АКПП") {
            System.out.println("Вставить ключ зажигания. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ. \n Погнали!");
        }
    }

    @Override
    public void finishDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n Нажать сцепление. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Отпустить сцепление, поставить на ручник. \n Ну всё, приехали.");
        } else if (transmission == "АКПП") {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n  " +
                    "Плавно затормозить. \n Переключить передачу на КПП. \n Ну всё, приехали.");
        }
    }

    // ======= СОРЕВНУЮЩИЕСЯ методы: ========
    @Override
    public void pitStop() {
        System.out.print("В категории В автомобиль " + getBrand() + " " + getModel() + ": ");
        super.pitStop();
    }

    @Override
    public void bestTimeOfLap() {
        System.out.print("В категории В автомобиль " + getBrand() + " " + getModel() + " ");
        super.bestTimeOfLap();
    }

    @Override
    public void maxSpeed() {
        System.out.print("В категории В автомобиль " + getBrand() + " " + getModel() + " ");
        super.maxSpeed();
    }

    // ====== ПЕРЕОПРЕДЕЛЕНИЕ ТРАНСПОРТ: ====
    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println("Автомобиль " + getBrand() + " " + getModel() + ": " + bodyType);
        } else
            System.out.println("Автомобиль " + getBrand() + " " + getModel() + ": данных по транспортному средству недостаточно.");
    }
    // == ДИАГНОСТИКА: ===

    @Override
    public void diagnostics() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " находится на диагностике");
    }
    // ==== СОЗДАНИЕ КОМАНДЫ МЕХАНИКОВ, добавление водителя и печать: ====

    @Override
    public void creatingMechanicsTeam(Mechanic... mechanics) {
        ArrayList<Mechanic> mechanicsTeam = new ArrayList<>();
        for (Mechanic value : mechanics)  // value => это переменная листа: mechanic1 и т.д.
            if (value.getServiceTransport() == ServiceTransport.PassCars ||
                    value.getServiceTransport() == ServiceTransport.MultiSpec) { // вытаскиаем нужный параметр для "фильтра"
                mechanicsTeam.add(value);
            }
                System.out.println("\n Автомобиль " + getBrand() + " " + getModel() + " " + getEngineVolume() + " л обслуживает команда механиков: ");
                mechanicsTeam.forEach(System.out::println);
    }
//             else  {
//                System.out.println("\n Автомобиль " + getBrand() + " " + getModel() + " " + getEngineVolume() + " л обслуживает команда механиков: " +
//                        "команда не сформирована.");
//            }



    @Override
    public void creatingDriver(Driver... drivers) {
        ArrayList<Driver> pilot = new ArrayList<>();
        for (Driver value : drivers) {
            if (value.getDrivingCategory().equals("B") || value.getDrivingCategory().equals("В") && pilot.size() <2) {
                pilot.add(value);
                System.out.println("\n Автомобилем " + getBrand() + " " + getModel() + " управляет водитель: " );
                pilot.forEach(System.out::println);
            } else {
                System.out.println("\n Автомобилем " + getBrand() + " " + getModel() + " " + getEngineVolume() + " л управляет водитель: ");
                System.out.println("Данных о водителе недостаточно или неверно указана информация");
            }
        }
    }

// ===== ВЫВОД НА ПЕЧАТЬ ВОДИТЕЛЕЙ И МЕХАНИКОВ

//    @Override
//    public void printInfoTeam() {//List<Driver> driverList, List<Mechanic> mechanics
//        if (mechanics != null || drivers != null) {
//            for (Mechanic mechanic : mechanics) {
//                if (mechanic.getServiceTransport() == ServiceTransport.PassCars || mechanic.getServiceTransport() == ServiceTransport.MultiSpec &&
//                        mechanics.size() < 4) {
//                    System.out.println("Автомобиль " + getBrand() + " " + getModel() + " объём двигателя " + getEngineVolume() +
//                            "л обслуживается командой механиков: ");
//                    creatingMechanicsTeam();
//
//                } else {
//                    System.out.println("У автомобиля " + getBrand() + " " + getModel() + " объём двигателя " + getEngineVolume() +
//                            "л не сформирована команда механиков.");
//                }
////                for (Driver driver : drivers) {
//
//                System.out.println("Автомобиль " + getBrand() + " " + getModel() + " объём двигателя " + getEngineVolume() +
//                        " л управляется водителем " + ;
//            }
//
//        } else {
//            System.out.println("Отсутствует информация о команде ТС");
//        }
//    }

    //==== ГЕТТЕР КУЗОВА: =====

    public BodyType getBodyType() {
        return bodyType;
    }



    // ===== ИКВАЛС + ХЭШ =======

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengCar<?> that = (PassengCar<?>) o;
        return bodyType == that.bodyType;
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public String getTsType() {
        return super.getTsType();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

//==== ТУСТРИНГ  ======


    @Override
    public String toString() {
        return "Легковой автомобиль " + getBrand() + " " + getModel() + "; объём движка " + getEngineVolume() + " л; КПП: " + getTransmission()  +
                "; " + bodyType + "; команда механиков: " + getMechanics();
    }
}



