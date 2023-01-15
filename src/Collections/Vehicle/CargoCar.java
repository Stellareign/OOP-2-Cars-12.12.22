package Collections.Vehicle;

import Collections.Competing;
import Collections.Drive;
import Collections.Drivers.Driver;
import Collections.Mechanics.Mechanic;
import Collections.Mechanics.ServiceTransport;

import java.util.ArrayList;
import java.util.List;

public class CargoCar<C> extends Transport implements Drive, Competing {
    private LoadCapacity loadCapacity;
    List<Mechanic> mechanics = new ArrayList<>();
    List<Driver> drivers = new ArrayList<>();

    public CargoCar(String brand, String model, double engineVolume, String transmission, LoadCapacity loadCapacity, ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume, transmission, mechanics);
        this.loadCapacity = loadCapacity;
    }

    // ===== ПЕРЕЧИСЛЕНИЯ (26.12.22): ====


    // =========== ИМПЛЕМЕНТАЦИЯ МЕТОДОВ ИЗ ИНТЕРФЕЙСА: ===============
    // ======= движение: ==========
    @Override
    public void startDrive() {
        if (transmission == "МКПП") {
            System.out.println(getBrand() + " " + getModel() + ": вставить ключ зажигания. \n Выжать сцепление, снять с ручника. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ \n Плавно отпустить сцепление. \n Погнали!");
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
            System.out.println("Начать тормозить, нажав на тормоз. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Ну всё, приехали.");
        }
    }

    // ====== методы из ТРАНСПОРТа СОРЕВНУЮЩИЕСЯ ======
    @Override
    public void pitStop() {
        System.out.print("В категории С грузовик " + getBrand() + " " + getModel() + ": ");
        super.pitStop();
    }

    @Override
    public void bestTimeOfLap() {
        System.out.print("В категории С грузовик " + getBrand() + " " + getModel() + " ");
        super.bestTimeOfLap();
    }

    @Override
    public void maxSpeed() {
        System.out.print("В категории С грузовик " + getBrand() + " " + getModel() + " ");
        super.maxSpeed();
    }

    // ==== переопределение ТРАНСПОРТ: =====
    @Override
    public void printType() {
        if (loadCapacity != null) {
            System.out.println("Грузовик " + getBrand() + " " + getModel() + ": " + loadCapacity);
        } else {
            System.out.println("Грузовик " + getBrand() + " " + getModel() + ": данных по транспортному средству недостаточно.");
        }
    }
    // === диагностика: =====

    @Override
    public void diagnostics() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " находится на диагностике");
    }
// ===== Гоночная команда: =====

    @Override
    public void creatingMechanicsTeam(Mechanic... mechanics) {
        ArrayList<Mechanic> mechanicsTeam = new ArrayList<>();
        for (Mechanic value : mechanics)  // value => это переменная листа: mechanic1 и т.д.
            if (value.getServiceTransport() == ServiceTransport.Trucks ||
                    value.getServiceTransport() == ServiceTransport.MultiSpec) { // вытаскиаем нужный параметр
                mechanicsTeam.add(value);
            }

                System.out.println("\n Грузовик " + getBrand() + " " + getModel() + ", " + getLoadCapacity() + " т обслуживает команда механиков: ");
                mechanicsTeam.forEach(System.out::println); // синтаксис листа. Данный метод выводит столбиком список листа.
//             else {
//                System.out.println("\n Грузовик " + getBrand() + " " + getModel() + ", " + getLoadCapacity() + " т обслуживает команда механиков: " +
//                        "команда не сформирована.");
//            }
        }



    @Override
    public void creatingDriver(Driver... drivers) {

            ArrayList<Driver> pilot = new ArrayList<>();
            for (Driver value : drivers) {
                if (value.getDrivingCategory().equals("C") || value.getDrivingCategory().equals("С")) {
                    pilot.add(value);
                    System.out.println("\n Грузовиком " + getBrand() + " " + getModel() + ", " + getLoadCapacity() + " управляет водитель: ");
                    pilot.forEach(System.out::println);
                } else {
                    System.out.println("\n Грузовиком " + getBrand() + " " + getModel() + ", " + getLoadCapacity() + " т управляет водитель: ");
                    System.out.println("Данных о водителе недостаточно или неверно указана информация");
                }
            }
        }


// ===== ГЕТТЕР И СЕТТЕР(?) ГРУЗОПОДЪЁМНОСТИ: =====

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public CargoCar<C> setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
        return this;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + ", тип кузова: " + "; объём движка " + getEngineVolume() + " л; КПП: " +
                getTransmission() + "; " + loadCapacity + ", команда механиков: " + getMechanics();
    }
}
