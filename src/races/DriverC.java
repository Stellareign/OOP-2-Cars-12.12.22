package races;

import java.util.Objects;

public class DriverC <C extends CargoCar> extends Driver{// implements Drive
private C cargoCar;
    public DriverC(String fio, String drivingCategory, int yearOfPrimaryDriveLicense,C cargoCar) {
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);
        this.drivingCategory = checkCategory();
        this.cargoCar = cargoCar;
    }
    //======= НЕДОПУСТИМАЯ КАТЕГОРИЯ ========
    public String checkCategory() {
        if (drivingCategory == "С" || drivingCategory == "C") { // почему не работает смена языка????
            this.drivingCategory = drivingCategory;
        } else {
            drivingCategory = "недопустимая категория";}
        return drivingCategory;
    }

    @Override
    public void startDrive() {

        System.out.println("Завести грузовик " + cargoCar.brand + " " + cargoCar.model + ", начать движение.");

    }
    @Override

    public void finishDrive() {

        System.out.println("Остановиться, заглушить двигатель грузовика "+ cargoCar.brand + " " + cargoCar.model + ".");
    }

    @Override
        public void refuelTheCar() {
            System.out.println("Открыть бак грузовика " + cargoCar.brand + " " + cargoCar.model + ". \n Вставить заправочный пистолет. \n Нажать курок. \n " +
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
        return super.toString() + ", управляет грузовиком " + cargoCar.brand + " " + cargoCar.model + " и будет участвовать в заезде";

    }
}
