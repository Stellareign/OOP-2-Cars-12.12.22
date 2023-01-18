package Collections.Vehicle;

import Collections.Competing;
import Collections.Drivers.Driver;
import Collections.Mechanics.Mechanic;
import Collections.Mechanics.ServiceTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Transport implements Competing {
    private final String brand;
    private final String model;
    private double engineVolume;
    protected final String transmission;
    protected String tsType;
    private ArrayList<Mechanic> mechanicTeam;
    List<Driver> drivers = new ArrayList<>();
   // private Driver driver;


    public Transport(String brand, String model, double engineVolume, String transmission, ArrayList<Mechanic> mechanicTeam) {
        if (brand != null && !brand.isEmpty() && !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }
        if (model == null || model.isBlank() || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume >= 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
        if (!transmission.equals("АКПП") && !transmission.equals("МКПП")) {
            this.transmission = "МКПП";
        } else {
            this.transmission = transmission;
        }
        this.mechanicTeam = mechanicTeam;
      //  this.driver = driver;
    }


    // ===== ДОБАВЛЕНИЕ КОМАНДЫ МЕХАНИКОВ  и водителя: (от 09.01.23) ===
    public abstract void creatingMechanicsTeam(Mechanic... mechanics);  // как привязать метод к виду транспорта?
    public abstract void creatingDriver(Driver... drivers);
//    }

    // ==== метод ДИАГНОСТИКА от 28.12.22 =======
    public abstract void diagnostics(); // с переопределением в соотв. классах.

    // метод для вызова диагностики для нескольких ТС:
    public static void performDiagnostics(Transport... transports) { // создали массив без определённого количества ячеек
        for (Transport transport : transports) {
            try {
                transport.diagnostics();
            } catch (
                    UnsupportedOperationException e) { // при достижении неподдерживаемого объекта вывод сообщения об ошибке.
                System.out.println("Произошла ошибка:");
                System.out.println(e.getMessage());
            }
        }
    }
// ===== ПЕЧАТЬ КОМАНДЫ ВОДИТЕЛЕЙ И МЕХАНИКОВ: =====
//public abstract void printInfoTeam(); //List<Driver> driverList, List<Mechanic> mechanics{
//    if (mechanics != null || drivers != null) {
//        for (Mechanic mechanic : mechanics) {
//            if (mechanic.getServiceTransport() == ServiceTransport.PassCars || mechanic.getServiceTransport() == ServiceTransport.MultiSpec &&
//                    mechanics.size() < 4) {
//                System.out.println("Автомобиль " + getBrand() + " " + getModel() + " объём двигателя " + getEngineVolume() +
//                        "л обслуживается командой механиков: " + getMechanics());
//            } else {
//                System.out.println("У автомобиля " + getBrand() + " " + getModel() + " объём двигателя " + getEngineVolume() +
//                        "л не сформирована команда механиков.");
//                for (Driver driver : drivers) {
//                    System.out.println("Автомобиль " + driver.getP + " " + getModel() + " объём двигателя " + getEngineVolume() +
//                            " л управляется водителем " + driver.getFio());
//                }
//            }
//        }
//    } else {
//        System.out.println("Отсутствует информация о команде ТС");
//    }
//}

    //    ==== ПЕЧАТЬ tsType: ====
    public void printType() {
        if (tsType == null || tsType.isBlank() || tsType.isEmpty()) {
            System.out.println("Данных по транспортному средству недостаточно \n");
        } else
            System.out.println(tsType);
    }
    // ======= ИМПЛЕМЕНТАЦИЯ СОРЕВНУЮЩИХСЯ:=====

    @Override
    public void pitStop() {
        System.out.println(" меняем покрышки в мега быстром режиме и гоним дальше! \n");
    }

    @Override
    public void bestTimeOfLap() {
        System.out.println(" показал лучшее время, мин.: \n");
    }

    @Override
    public void maxSpeed() {
        System.out.println(" развил максимальную скорость, км/ч: \n");
    }

    // ======ГЕТТЕРЫ: ============
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getTsType() {
        return tsType;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public ArrayList<Mechanic> getMechanics() {
        return mechanicTeam;
    }


        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && brand.equals(transport.brand) && model.equals(transport.model) && transmission.equals(transport.transmission) && tsType.equals(transport.tsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, transmission, tsType);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", transmission='" + transmission + '\'' +
                ", tsType='" + tsType + '\'' +
                ", mechanics=" + mechanicTeam +
                '}';
    }


}
