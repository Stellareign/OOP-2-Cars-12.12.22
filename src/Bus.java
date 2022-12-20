public class Bus extends Transport {
    final String typeOfBody;
    final String typeOfBus;
    String transmission;
    final int numberOfSeats;
    final int numberOfPassDoors;
    String regNumber;

    public Bus(String brand, String model, String color, int releaseYear, String country, String typeOfBody, String typeOfBus,
               String transmission, int numberOfSeats, int numberOfPassDoors, int maxSpeed, String regNumber) {
        super(brand, model, color, releaseYear, country, maxSpeed);

        if (typeOfBody != null && !typeOfBody.isBlank() && !typeOfBody.isEmpty()) {
            this.typeOfBody = typeOfBody;
        } else {
            this.typeOfBody = "default";
        }
        if (typeOfBus != null && !typeOfBus.isBlank() && !typeOfBus.isEmpty()) {
            this.typeOfBus = typeOfBus;
        } else {
            this.typeOfBus = "default";
        }
        if (numberOfSeats != 0) {
            this.numberOfSeats = numberOfSeats;
        } else {
            this.numberOfSeats = 9;
        }
        if (numberOfPassDoors != 0) {
            this.numberOfPassDoors = numberOfPassDoors;
        } else {
            this.numberOfPassDoors = 1;
        }
        if (this.transmission != null && !this.transmission.isEmpty() && !this.transmission.isBlank()) {
            this.transmission = this.transmission;
        } else {
            this.transmission = "МКПП";
        }
        this.regNumber = regNumber;
    }

    // ========= МЕТОДЫ =========
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

    // ========== ГЕТТЕРЫ / CЕТТЕРЫ =========
    public String getTypeOfBody() {
        return typeOfBody;
    }

    public String getTypeOfBus() {
        return typeOfBus;
    }


    public String getTransmission() {
        return transmission;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfPassDoors() {
        return numberOfPassDoors;
    }

    public Bus setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Bus setRegNumber(String regNumber) {
        this.regNumber = regNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Автобус " + brand  + " " + model + "; цвет кузова: " + color + "; год выпуска: " + releaseYear + "; страна производства: " + country +
                "; максимальная скорость: " + maxSpeed + " км/ч; тип кузова: " + typeOfBody + "; тип автобуса: " + typeOfBus +
                "; КПП: " + transmission + "; количество мест: " + numberOfSeats + "; число пассажирских дверей: " + numberOfPassDoors +
                "; гос.номер: " + checkRegNumber();
    }
}
