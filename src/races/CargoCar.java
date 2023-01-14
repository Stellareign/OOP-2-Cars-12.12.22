package races;

import java.util.Objects;

public class CargoCar<C> extends Transport implements Drive, Competing {
    private LoadCapacity loadCapacity;
    public CargoCar(String brand, String model, double engineVolume, String transmission, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, transmission);
        this.loadCapacity = loadCapacity;
    }
// ===== ПЕРЕЧИСЛЕНИЯ (26.12.22): ====


    // =========== ИМПЛЕМЕНТАЦИЯ МЕТОДОВ ИЗ ИНТЕРФЕЙСА: ===============
    // ======= движение: ==========
    @Override
    public void startDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": вставить ключ зажигания. \n Выжать сцепление, снять с ручника. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ \n Плавно отпустить сцепление. \n Погнали!");
        } else if (transmission.equals("АКПП")) {
            System.out.println("Вставить ключ зажигания. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                    "Нажать на газ. \n Погнали!");
        }

    }

    @Override
    public void finishDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n Нажать сцепление. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Отпустить сцепление, поставить на ручник. \n Ну всё, приехали.");
        } else if (transmission.equals("АКПП")) {
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
            System.out.println("Грузовик "  + getBrand() + " " + getModel() + ": " + loadCapacity);
        } else {
            System.out.println("Грузовик "  + getBrand() + " " + getModel() + ": данных по транспортному средству недостаточно.");
        }
    }
    // === диагностика: =====

    @Override
    public void diagnostics() {
        System.out.println("Грузовик "  + getBrand() + " " + getModel() + " находится на диагностике");
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
        return getBrand() + " " + getModel() + ", тип кузова: " +  "; объём движка " + getEngineVolume() + " л; КПП: " + getTransmission() + "; " + loadCapacity;
    }
}
