package races;

public class DriverB <B extends PassengCar> extends Driver  {
    private B car;
    DriverB(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, B car) throws DrivingCategoryException {
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);
        try {
            if (drivingCategory == "В" || drivingCategory == "B") { // почему не работает смена языка????
                this.drivingCategory = drivingCategory;
            } else {
                this.drivingCategory = "недопустимая категория";
                throw new DrivingCategoryException("Для водителя " + getFio() + "укажите корректную категорию прав");
            }
        }
        catch (DrivingCategoryException e) {
            System.out.println(e.getMessage());
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

    @Override
    public void startDrive()  {
        System.out.println("Завести автомобиль " + car.brand + " " + car.model + ", начать движение.");

}

    @Override
    public void finishDrive() {
        System.out.println("Остановиться, заглушить двигатель автомобиля " +  car.brand + " " + car.model + ".");

    }
    @Override
    public  void refuelTheCar() {
        System.out.println("Открыть бак автомобиля "+ car.brand + ". \n Вставить заправочный пистолет. \n Нажать курок. \n " +
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
        return super.toString() + ", управляет автомобилем " + car.brand + " " + car.model + " и будет участвовать в заезде";
    }

}
