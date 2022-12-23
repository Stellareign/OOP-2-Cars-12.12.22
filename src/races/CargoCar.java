package races;

public class CargoCar<C> extends Transport implements Drive, Competing {
    public CargoCar(String brand, String model, double engineVolume, String transmission) {
        super(brand, model, engineVolume, transmission);
    }


    // =========== ИМПЛЕМЕНТАЦИЯ МЕТОДОВ ИЗ ИНТЕРФЕЙСА: ===============
    // ======= движение: ==========
    @Override
    public void startDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": вставить ключ зажигания. \n Выжать сцепление. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
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
                "Плавно затормозить. \n Отпустить сцепление. \n Ну всё, приехали.");}
        else if (transmission.equals("АКПП")) {
            System.out.println("Начать тормозить, нажав на тормоз. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Ну всё, приехали.");}
        }


    // ========== ПРОВЕРКА КПП: ==============
    private String checkTransmission() {
        if (!transmission.equals("АКПП") && !transmission.equals("МКПП")) {
            return "МКПП";
        }
        return transmission;
    }

    @Override
    public String toString() {
        return brand + " " + model + "; объём движка " + engineVolume + " л; КПП: " + checkTransmission() + "\n";
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
}
