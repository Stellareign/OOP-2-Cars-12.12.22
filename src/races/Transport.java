package races;

import java.util.Objects;

public abstract class Transport implements Competing {
    private final String brand;
    private final String model;
    private double engineVolume;
    protected String transmission;
    protected String tsType;

    public Transport(String brand, String model, double engineVolume, String transmission) {
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
        this.transmission = checkTransmission();

    }

    // ========== ПРОВЕРКА КПП: ==============
    private String checkTransmission() {
        if (transmission.equals("АКПП") || transmission.equals("МКПП")) {
            return transmission;
        } else {
            return "МКПП";
        }
    }
    // ==== метод ДИАГНОСТИКА от 28.12.22 =======
    public abstract void diagnostics(); // с переопределением в соотв.классах
// метод для вызова диагностики для нескольких ТС:
    public static void performDiagnostics(Transport... transports) { // создали массив без определённого количества ячеек
        for (Transport transport : transports) {
            try {
                transport.diagnostics();
            } catch (UnsupportedOperationException e) { // при достижении неподдерживаемого объекта вывод сообщения об ошибке.
                System.out.println("Произошла ошибка");
                System.out.println(e.getMessage());
            }
        }
    }

    //    ==== ПЕЧАТЬ tsType: ====
    public void printType() {
        if (tsType == null || tsType.isBlank() || tsType.isEmpty()) {
            System.out.println("Данных по транспортному средству недостаточно");
        } else
            System.out.println(tsType);
    }
    // ======= ИМПЛЕМЕНТАЦИЯ СОРЕВНУЮЩИХСЯ:=====

    @Override
    public void pitStop() {
        System.out.println(" меняем покрышки в мега быстром режиме и гоним дальше!");
    }

    @Override
    public void bestTimeOfLap() {
        System.out.println(" показал лучшее время, мин.: ");
    }

    @Override
    public void maxSpeed() {
        System.out.println(" развил максимальную скорость, км/ч: ");
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

    public String transmission() {
        return transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && brand.equals(transport.brand)
                && model.equals(transport.model) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", tsType='" +  '\'' +
                '}';
    }
}
