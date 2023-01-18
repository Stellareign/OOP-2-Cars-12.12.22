package Collections.Vehicle;

import Collections.Competing;
import Collections.Drive;
import Collections.Drivers.Driver;
import Collections.Mechanics.Mechanic;
import Collections.Mechanics.ServiceTransport;

import java.util.ArrayList;
import java.util.List;

public class Bus<D> extends Transport implements Competing, Drive {
    private BusCapacity busCapacity;
    List<Mechanic> mechanics = new ArrayList<>();
    List<Driver> drivers = new ArrayList<>();
    public Bus(String brand, String model, double engineVolume, String transmission, BusCapacity busCapacity, ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume, transmission, mechanics);
        this.busCapacity = busCapacity;

    }

    // ====== ИМПЕЛЕНТАЦИЯ: ======
    @Override
    public void startDrive() {
        if (transmission == "МКПП") {
            System.out.println(getBrand() + " " + getModel() + ": вставить ключ зажигания. \n Выжать сцепление, снять с ручника. \n Повернуть ключ. \n " +
                    "Переключить передачу на КПП. \n  + Нажать на газ \n Плавно отпустить сцепление. \n Погнали!");
        } else if (transmission == "АКПП") {
            System.out.println("Вставить ключ зажигания. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ. \n Погнали!");
        }

    }

    @Override
    public void finishDrive() {
        if (transmission == "МКПП") {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n Нажать сцепление. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Отпустить сцепление, поставить на ручник. \n Ну всё, приехали.");
        } else if (transmission == "АКПП") {
            System.out.println("Начать тормозить, нажав на тормоз. \n " +
                    "Плавно затормозить. \n + Переключить передачу на КПП. \n + Ну всё, приехали.");
        }
    }

    // ====== СОРЕВНУЮЩИЕСЯ: =====
    @Override
    public void pitStop() {
        System.out.print("В категории D автобус " + getModel() + " " + getBrand() + " ");
        super.pitStop();
    }

    @Override
    public void bestTimeOfLap() {
        System.out.print("В категории D автобус " + getModel() + " " + getBrand() + " ");
        super.bestTimeOfLap();
    }

    @Override
    public void maxSpeed() {
        System.out.print("В категории D автобус " + getModel() + " " + getBrand() + " ");
        super.maxSpeed();
    }
    // ==== переопределение ТРАНСПОРТ: ===

    @Override
    public void printType() {
        if (busCapacity != null) {
            System.out.println("Автобус " + getBrand() + " " + getModel() + ": " + busCapacity + "\n");
        } else {
            System.out.println("Автобус " + getBrand() + " " + getModel() + ": данных по транспортному средству недостаточно.\n");
        }
    }
// ===== ДИАГНОСТИКА: =======

    @Override
    public void diagnostics() {
        throw new UnsupportedOperationException("для данного вида ТС " + getBrand() + " " + getModel() + " не выполняется диагностика \n");
    }
    // ====== ПЕЧАТЬ КОМАНДЫ: ====

    @Override
    public void creatingMechanicsTeam(Mechanic... mechanics) {
        ArrayList<Mechanic> mechanicsTeam = new ArrayList<>();
        for (Mechanic value : mechanics) // value => это переменная листа: mechanic1 и т.д.
            if (value.getServiceTransport() == ServiceTransport.Buses ||
                    value.getServiceTransport() == ServiceTransport.MultiSpec) { // вытаскиаем нужный параметр
                mechanicsTeam.add(value);
            }
                System.out.println("\n Автобус " + getBrand() + " " + getModel() + ", " + getBusCapacity() + " чел. обслуживает команда механиков: ");
                mechanicsTeam.forEach(System.out::println); // синтаксис листа. Данный метод выводит столбиком список листа.
//            } else {
//                System.out.println("\n Автобус " + getBrand() + " " + getModel() + ", " + getBusCapacity() + " чел. обслуживает команда механиков: команда не сформирована");
            }//


    @Override
    public void creatingDriver(Driver... drivers) {
                   ArrayList<Driver> pilot = new ArrayList<>();
            for (Driver value : drivers) {
                if (value.getDrivingCategory().equals("D") && pilot.size() <2) {
                    pilot.add(value);
                    System.out.println("\n Автобусом " + getBrand() + " " + getModel() + " " + getBusCapacity() + " чел. управляет водитель: ");
                    pilot.forEach(System.out::println);
                } else {
                    System.out.println("\n Автобусом " + getBrand() + " " + getModel() + " " + getBusCapacity() + " чел. управляет водитель: ");
                    System.out.println("Данных о водителе недостаточно или неверно указана информация");
                }
            }
        }

    // ===== ГЕТТЕР И СЕТТЕР(?)  ВМЕСТИМОСТИ :

    public BusCapacity getBusCapacity() {
        return busCapacity;
    }


    @Override
    public String toString() {
        return "Автобус " +  getBrand() + " " + getModel() + "; объём движка: " + getEngineVolume() + "; КПП: " +
                getTransmission() + "; " + busCapacity + ", команда механиков: " + getMechanics();
    }

}
