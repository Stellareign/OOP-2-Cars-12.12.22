package races;

public abstract class Transport implements Competing {
    final String brand;
    final String model;
    double engineVolume;
    static String transmission;

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
        private static  String checkTransmission () {
            if (transmission == "АКПП" || transmission== "МКПП") {
                return transmission;
            }
           else{ return "МКПП";}
        }

//    }
    // ======= ИМПЛЕМЕНТАЦИЯ СОРЕВНУЮЩИХСЯ:=====

    @Override
    public void pitStop() {
        System.out.println(" меняем покрышки в мега быстром режиме и гоним дальше!");
    }

    @Override
    public void bestTimeOfLap() {
        System.out.println(" показал лучшее время, мин.: " );
    }

    @Override
    public void maxSpeed() {
        System.out.println(" развил максимальную скорость, км/ч: " );
    }

    // ======ГЕТТЕРЫ: ============
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
