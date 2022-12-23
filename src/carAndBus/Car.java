package carAndBus;


import java.time.LocalDate;

public class  Car extends Transport {

    double engineVolume;
    String transmission;
    final String bodyType;
    final int numberOfSeats;
    String regNumber;
    String tire;
    private Key key;

    public Car(String brand, String model, double engineVolume, String color, int releaseYear, String country, String transmission, String bodyType,
               int numberOfSeats, String regNumber, String tire, int maxSpeed, Key key) {
        super( brand, model, country, releaseYear, color, maxSpeed);

        if (engineVolume >= 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }

        if (transmission != null && !transmission.isEmpty() && !transmission.isBlank()) {
            this.transmission = transmission;
        } else {
            this.transmission = "МКПП";
        }
        if (bodyType != null && !bodyType.isBlank() && !bodyType.isEmpty()) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = "седан";
        }
        if (numberOfSeats != 0) {
            this.numberOfSeats = numberOfSeats;
        } else {
            this.numberOfSeats = 4;
        }
        this.tire = changeTires();
        this.regNumber = checkRegNumber();
        this.key = key;
    }


    // метод смены резины
    private String changeTires() {
        int month = LocalDate.now().getMonthValue();
        if (month <= 4 || month > 9) {
            return "зима";
        } else {
            return "лето";
        }
    }

    // проверка номера
    //X000XX000
    private String checkRegNumber() {
        if (regNumber != null && !regNumber.isEmpty() && !regNumber.isBlank() && regNumber.length() != 9) {
            return " номер указан неверно ";
        }
        if (regNumber == null || regNumber.isBlank() || regNumber.isEmpty()) {
            return " X000XX_000";

        }
        char[] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return " номер указан неверно ";
        }
        if (!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) || !Character.isDigit(chars[3]) || !Character.isDigit(chars[6])
                || !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) {
            return " номер указан неверно ";
        }
        return regNumber;

    }


    public static class Key {

        private final String remoteEngineStart;
        private final String keylessAccess;

        public Key(String remoteEngineStart, String keylessAccess) {
            if (remoteEngineStart != null && !remoteEngineStart.isBlank() && !remoteEngineStart.isEmpty()) {
                this.remoteEngineStart = remoteEngineStart;
            } else {
                this.remoteEngineStart = "нет";
            }
            if (keylessAccess != null && !keylessAccess.isEmpty() && !keylessAccess.isBlank()) {
                this.keylessAccess = keylessAccess;
            } else {
                this.keylessAccess = "нет";
            }
        }

        @Override
        public String toString() {
            return "удалённый запуск двигателя: " + remoteEngineStart + ", доступ без ключа: " + keylessAccess;
        }
    }

    public Car setKey(Key key) {
        this.key = key;
        return this;
    }

    public Key getKey() {
        return key;
    }


    @Override
    public String toString() {
        return "Автомобиль " + brand + " " + model + "; объём движка " + engineVolume + " л; цвет " +
                color + "; год выпуска: " + releaseYear + " г.; cтрана производства: " + country + "; КПП: " + transmission + "; тип кузова: " + bodyType +
                "; количество мест: " + numberOfSeats + "; гос.номер: " + checkRegNumber() + "; тип покрышек: " + tire + "; максимальная скорость: " +
                maxSpeed + " км/ч; удалённый доступ: " + getKey();
    }


    //   ГЕТТЕРЫ/СЕТТЕРЫ:
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Car setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public String getTransmission() {
        return transmission;
    }

    public Car setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getRegNumber() {

        return regNumber;
    }

    public Car setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    public String getTire() {
        return tire;
    }

    public Car setTire(String tire) {
        this.tire = tire;
        return this;
    }
}
