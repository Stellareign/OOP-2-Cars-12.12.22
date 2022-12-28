package races;

public class CargoCar<C> extends Transport implements Drive, Competing {
    public LoadCapacity loadCapacity;
    public CargoCar(String brand, String model, double engineVolume, String transmission, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, transmission);
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


    // ========== ПРОВЕРКА КПП: ==============
    private String checkTransmission() {
        if (transmission != "АКПП" && transmission != "МКПП") {
            return "МКПП";
        }
        return transmission;
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
            System.out.println("Грузовик "  + brand + " " + model + ": " + loadCapacity);
        } else {
            System.out.println("Грузовик "  + brand + " " + model + ": данных по транспортному средству недостаточно.");
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
        return brand + " " + model + ", тип кузова: " +  "; объём движка " + engineVolume + " л; КПП: " + checkTransmission() + "; " + loadCapacity + "\n";
    }
}
