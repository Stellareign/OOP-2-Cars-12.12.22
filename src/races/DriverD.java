package races;

import java.util.Objects;

public class DriverD<D extends Bus> extends Driver {
    private D bus;
       public DriverD(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, D bus) throws DrivingCategoryException{
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);
        try {
               if (drivingCategory == "D") {
                   this.drivingCategory = drivingCategory;
               } else {
                   this.drivingCategory = "недопустимая категория";
                   throw new DrivingCategoryException("Для водителя " + getFio() + "укажите корректную категорию прав");
               }
           }
        catch (DrivingCategoryException e) {
               System.out.println(e.getMessage());
           }
        this.bus = bus;
    }

////======= НЕДОПУСТИМАЯ КАТЕГОРИЯ ========
//    public String checkCategory() {
//               if (drivingCategory == "D") {
//            this.drivingCategory = drivingCategory;
//        } else {
//                   drivingCategory = "недопустимая категория";}
//            return drivingCategory;
//        }


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
// ====== ГЕТТЕРЫ / СЕТТЕРЫ, ИКВАЛС, ХЭШ ====
    public D getBus() {
        return bus;
    }

    public DriverD<D> setBus(D bus) {
        this.bus = bus;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DriverD<?> driverD = (DriverD<?>) o;
        return bus.equals(driverD.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bus);
    }
// ===== ТУСТРИНГ =====
    @Override
    public String toString() {
        return super.toString() + ", управляет автобусом " + bus.brand + " " + bus.model + " и будет участвовать в заезде";
    }


}
