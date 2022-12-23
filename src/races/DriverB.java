package races;

public class DriverB <B extends PassengCar> extends Driver  {
    private B car;
    DriverB(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, B car) {
        super(fio, drivingCategory, yearOfPrimaryDriveLicense);
        this.drivingCategory = checkCategory();
        this.car = car;
            }
    //======= НЕДОПУСТИМАЯ КАТЕГОРИЯ ========
    public String checkCategory() {
        if (drivingCategory == "В" || drivingCategory == "B") { // почему не работает смена языка????
            this.drivingCategory = drivingCategory;
        } else {
            drivingCategory = "недопустимая категория";}
        return drivingCategory;
    }

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
