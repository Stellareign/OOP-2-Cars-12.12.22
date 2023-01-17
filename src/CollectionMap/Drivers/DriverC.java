package CollectionMap.Drivers;

import CollectionMap.Vehicle.CargoCar;

import java.util.Objects;

public class DriverC<C extends CargoCar> extends Driver {// implements Drive
    private C cargoCar;

    public DriverC(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, C cargoCar) {
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);
        if (drivingCategory.equals("C") || drivingCategory.equals("С")) { // C в разных раскладках, rus & eng
            this.drivingCategory = drivingCategory;
        } else {
            this.drivingCategory = "недопустимая категория";
            System.out.println("Для водителя " + getFio() + " укажите корректную категорию прав!");
        }
        this.cargoCar = cargoCar;
    }
    //======= НЕДОПУСТИМАЯ КАТЕГОРИЯ ========
//    public String checkCategory() {
//        if (drivingCategory == "С" || drivingCategory == "C") { // почему не работает смена языка????
//            this.drivingCategory = drivingCategory;
//        } else {
//            drivingCategory = "недопустимая категория";}
//        return drivingCategory;
//    }

    @Override
    public void startDrive() {

        System.out.println("Завести грузовик " + cargoCar.getBrand() + " " + cargoCar.getModel() + ", начать движение.");

    }

    @Override

    public void finishDrive() {

        System.out.println("Остановиться, заглушить двигатель грузовика " + cargoCar.getBrand() + " " + cargoCar.getModel() + ".");
    }

    @Override
    public void refuelTheCar() {
        System.out.println("Открыть бак грузовика " + cargoCar.getBrand() + " " + cargoCar.getModel() + ". \n Вставить заправочный пистолет. \n Нажать курок. \n " +
                "Залить нужное количество топлива. \n Извлечь заправочный пистолет и поместить на место. \n Закрыть бак. \n Расплатиться. ");
    }

    // ========ГЕТТЕРЫ / СЕТТЕРЫ: ========
    public C getCargoCar() {
        return cargoCar;
    }

    public DriverC<C> setCargoCar(C cargoCar) {
        this.cargoCar = cargoCar;
        return this;
    }

    // =========== иквалс и хэшкод =======
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DriverC<?> driverC = (DriverC<?>) o;
        return cargoCar.equals(driverC.cargoCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCar);
    }
    // ====== ТУСТРИНГ: =========

    @Override
    public String toString() {
        return super.toString() + ", управляет грузовиком " + cargoCar.getBrand() + " " + cargoCar.getModel() + " и будет участвовать в заезде";

    }
}