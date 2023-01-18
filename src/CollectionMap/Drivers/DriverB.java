package CollectionMap.Drivers;

import CollectionMap.Vehicle.PassengCar;

public class DriverB<B extends PassengCar> extends Driver {
    private B car;

    public DriverB(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, B car) throws DrivingCategoryException {
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);

        if (drivingCategory.equals("B") || drivingCategory.equals("В")) { // буква "В" в разных раскладках: rus & eng, ну или в обратном порядке
            this.drivingCategory = drivingCategory;
        } else {
            this.drivingCategory = "недопустимая категория";
            System.out.println("Для водителя" + " " + getFio() + " укажите корректную категорию прав!"); // если я правильно поняла замечание, выводим соо в консоль без исключения.
        }

        this.car = car;
    }
    //======= НЕДОПУСТИМАЯ КАТЕГОРИЯ ========
//    public void checkCategory() throws DrivingCategoryException {
//
//        try {
//            if (drivingCategory == "В" || drivingCategory == "B") { // почему не работает смена языка????
//                this.drivingCategory = drivingCategory;
//            } else {
//                throw new DrivingCategoryException("Для водителя " + getFio() + "укажите корректную категорию прав");
//            }
//                    }catch (DrivingCategoryException e){
//            drivingCategory = e.getMessage();
//        }
//
//    }

//    @Override
//    public String checkDrivingCategory() throws DrivingCategoryException {
//        return super.checkDrivingCategory();
//    }
// =====ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДОВ: ====
    @Override
    public void startDrive() {
        System.out.println("Завести автомобиль " + car.getBrand() + " " + car.getModel() + ", начать движение.");

    }

    @Override
    public void finishDrive() {
        System.out.println("Остановиться, заглушить двигатель автомобиля " + car.getBrand() + " " + car.getModel() + ".");

    }

    @Override
    public void refuelTheCar() {
        System.out.println("Открыть бак автомобиля " + car.getBrand() + ". \n Вставить заправочный пистолет. \n Нажать курок. \n " +
                "Залить нужное количество топлива. \n Извлечь заправочный пистолет и поместить на место. \n Закрыть бак. \n Расплатиться. ");
    }

    // ========= ГЕТТЕРЫ / СЕТТЕРЫ: ===
    public B getCar() {
        return car;
    }

    public DriverB<B> setCar(B car) {
        this.car = car;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + ", управляет автомобилем " + car.getBrand() + " " + car.getModel() + " и будет участвовать в заезде";
    }

}
