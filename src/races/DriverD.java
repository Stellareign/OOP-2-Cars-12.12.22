package races;

public class DriverD<D extends Bus> extends Driver {
    private D bus;
       public DriverD(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, D bus) {
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);
        this.drivingCategory = checkCategory();
        this.bus = bus;
    }

//======= НЕДОПУСТИМАЯ КАТЕГОРИЯ ========
    public String checkCategory() {
               if (drivingCategory == "D") {
            this.drivingCategory = drivingCategory;
        } else {
                   drivingCategory = "недопустимая категория";}
            return drivingCategory;
        }


    @Override
    public void startDrive() {
        System.out.println("Завести двигатель автобуса " + bus.brand + " " + bus.model + ", начать движение.");
    }

    @Override
    public void finishDrive() {
        System.out.println("Остановиться, заглушить двигатель автобуса " + bus.brand + " " + bus.model + ".");
    }
    @Override
    public void refuelTheCar() {
        System.out.println("Открыть бак автобуса " +  bus.brand + " " + bus.model + ". \n Вставить заправочный пистолет. \n Нажать курок. \n " +
                "Залить нужное количество топлива. \n Извлечь заправочный пистолет и поместить на место. \n Закрыть бак. \n Расплатиться. ");
    }

    @Override
    public String toString() {
        return super.toString() + ", управляется автобусом " + bus.brand + " " + bus.model + " и будет участвовать в заезде";
    }
}
