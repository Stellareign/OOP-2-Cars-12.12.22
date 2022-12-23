package races;

public class  PassengCar<B> extends Transport implements Drive, Competing {

    public PassengCar(String brand, String model, double engineVolume, String transmission) {
        super( brand, model, engineVolume, transmission); // записывать в том же порядке, что и у родителя.


    }



    // ======= ИМПЛЕМЕНТАЦИЯ МЕТОДОВ из интерфейса: =========
    //  ==== движение ====
      @Override
        public void startDrive() {
          if (transmission.equals("МКПП")) {
              System.out.println("Вставить ключ зажигания. \n Выжать сцепление. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                      "Нажать на газ \n Плавно отпустить сцепление. \n Погнали!");
          } else if (transmission.equals("АКПП")) {
              System.out.println("Вставить ключ зажигания. \n Повернуть ключ. \n Переключить передачу на КПП. \n " +
                      "Нажать на газ. \n Погнали!");
          }

      }


    @Override
    public void finishDrive() {
        if (transmission.equals("МКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n Нажать сцепление, если оно есть. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Отпустить сцепление, если оно есть. \n Ну всё, приехали.");}
        else if (transmission.equals("АКПП")) {
            System.out.println(getBrand() + " " + getModel() + ": начать тормозить, нажав на тормоз. \n Переключить передачу на КПП. \n " +
                    "Плавно затормозить. \n Ну всё, приехали.");}
    }


    // ========== ПРОВЕРКА КПП: ==============
    private String checkTransmission() {
        if (transmission != "АКПП" && transmission != "МКПП") {
            return "МКПП";
        }
        return transmission;
    }
// ======= СОРЕВНУЮЩИЕСЯ методы: ========
    @Override
    public void pitStop() {
        System.out.print("В категории В автомобиль " + getBrand() +" " + getModel() +": ");
        super.pitStop();
    }

    @Override
    public void bestTimeOfLap() {
        System.out.print("В категории В автомобиль " + getBrand() +" " + getModel() +" ");
        super.bestTimeOfLap();
    }

    @Override
    public void maxSpeed() {
        System.out.print("В категории В автомобиль " + getBrand() +" " + getModel() +" ");
        super.maxSpeed();
    }



    @Override
    public String toString() {
        return brand + " " + model + "; объём движка " + engineVolume + " л; КПП: " + transmission +"\n";
    }


}
