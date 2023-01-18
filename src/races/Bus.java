package races;

public class Bus<D> extends Transport implements Competing, Drive {
private BusCapacity busCapacity;
String capacity;
    public Bus(String brand, String model, double engineVolume, String transmission, BusCapacity busCapacity) {
        super(brand, model, engineVolume, transmission);
        this.busCapacity = busCapacity;
    }

    // ====== ИМПЕЛЕНТАЦИЯ: ======
    @Override
    public void startDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": вставить ключ зажигания. \n Выжать сцепление, снять с ручника. \n Повернуть ключ. \n " +
                    "Переключить передачу на КПП. \n  + Нажать на газ \n Плавно отпустить сцепление. \n Погнали!");
        } else if (transmission.equals("АКПП")) {
            System.out.println("Вставить ключ зажигания. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ. \n Погнали!");
        }

    }

    @Override
    public void finishDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n Нажать сцепление. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Отпустить сцепление, поставить на ручник. \n Ну всё, приехали.");}
        else if (transmission.equals("АКПП")) {
            System.out.println("Начать тормозить, нажав на тормоз. \n " +
                    "Плавно затормозить. \n + Переключить передачу на КПП. \n + Ну всё, приехали.");}
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
        super.maxSpeed() ;
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
    public void diagnostics()  {
        throw new UnsupportedOperationException("для данного вида ТС " + getBrand() + " " + getModel() + " не выполняется диагностика \n");
    }

    // ===== ГЕТТЕР И СЕТТЕР(?)  ВМЕСТИМОСТИ :

    public BusCapacity getBusCapacity() {
        return busCapacity;
    }

    public Bus<D> setCapacity(String capacity) {
        this.capacity = capacity;
        return this;
    }

    public Bus<D> setBusCapacity(BusCapacity busCapacity) {
        this.busCapacity = busCapacity;
        return this;
    }

    @Override
    public String toString() {
        return getBrand()  + " " + getModel() + "; объём движка: " + getEngineVolume() + "; КПП: " + getTransmission() + "; " + busCapacity + "\n";
    }

}
