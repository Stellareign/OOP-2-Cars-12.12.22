package races;

import java.util.Objects;

public class  PassengCar<B> extends Transport implements Drive, Competing {
private BodyType bodyType; // ДОБАВИЛИ ТИП КУЗОВА, В Т.Ч. В КОНСТРУКТОР

    public PassengCar(String brand, String model, double engineVolume, String transmission, BodyType bodyType) {
        super( brand, model, engineVolume, transmission); // записывать в том же порядке, что и у родителя.
        this.bodyType = bodyType; // ИНИЦИАЛИЗИРОВАЛИ КУЗОВ В КОНСТРУКТОРЕ


    }

    // ======= ИМПЛЕМЕНТАЦИЯ МЕТОДОВ из интерфейса: =========
    //  ==== движение ====
      @Override
        public void startDrive() {
          if (transmission.equals("МКПП")) {
              System.out.println("Вставить ключ зажигания. \n Выжать сцепление. \n Повернуть ключ, снять с ручника. \n Переключить передачу на КПП. \n " +
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
                    "Плавно затормозить. \n Отпустить сцепление, поставить на ручник. \n Ну всё, приехали.");}
        else if (transmission.equals("АКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n  " +
                    "Плавно затормозить. \n Переключить передачу на КПП. \n Ну всё, приехали.");}
    }

// ======= СОРЕВНУЮЩИЕСЯ методы: ========
    @Override
    public void pitStop() {
        System.out.print("В категории В автомобиль " + getBrand() +" " + getModel() + ": ");
        super.pitStop();
    }

    @Override
    public void bestTimeOfLap() {
        System.out.print("В категории В автомобиль " + getBrand() +" " + getModel() + " ");
        super.bestTimeOfLap();
    }

    @Override
    public void maxSpeed() {
        System.out.print("В категории В автомобиль " + getBrand() +" " + getModel() +" ");
        super.maxSpeed();
    }
// ====== переопределение ТРАНСПОРТ: ====
    @Override
    public void printType() {
        if(bodyType != null){
            System.out.println("Автомобиль " + getBrand() + " " + getModel() + ": " + bodyType);
        }else
            System.out.println("Автомобиль " + getBrand() + " " + getModel() + ": данных по транспортному средству недостаточно.");
    }
    // == диагностика: ===

    @Override
    public void diagnostics() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " находится на диагностике");
    }

    //==== ГЕТТЕР И СЕТТЕР(?) КУЗОВА: =====

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
        return getBrand() + " " + getModel() + "; объём движка " + getEngineVolume() + " л; КПП: " + getTransmission()  + "; " + bodyType;
    }
}
