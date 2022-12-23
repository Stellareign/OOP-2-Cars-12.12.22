package races;

import java.time.LocalDate;

public abstract class Driver {
    private final String fio;
    protected String drivingCategory; // protected - чтобы изменить в дочерних классах
    private final int yearOfPrimaryDriveLicense;
    private int drivingExperience;

// ====== КОНСТРУКТОР ========

    public Driver(String fio, String drivingCategory, int yearOfPrimaryDriveLicense, int drivingExperience) {

        if (fio != null && !fio.isEmpty() && !fio.isBlank()) {
            this.fio = fio;
        } else {
            this.fio = "ФИО не указано";
        }
        if (drivingCategory == "B" || drivingCategory == "C" || drivingCategory == "D") {
            this.drivingCategory = drivingCategory;
        } else {
            this.drivingCategory = "не указана";
        }
        if (yearOfPrimaryDriveLicense > 1960 && yearOfPrimaryDriveLicense < (LocalDate.now().getYear() + 1)) {
            this.yearOfPrimaryDriveLicense = yearOfPrimaryDriveLicense;
        } else {
            this.yearOfPrimaryDriveLicense = LocalDate.now().getYear();
        }
        this.drivingExperience = calculateDrivingExperience();
    }

    // =========== УРЕЗАННЫЙ КОНСТРУКТОР БЕЗ СТАЖА: =========
    public Driver(String fio, String drivingCategory, int yearOfPrimaryDriveLicense) {
        if (fio != null && !fio.isEmpty() && !fio.isBlank()) {
            this.fio = fio;
        } else {
            this.fio = "ФИО не указано";
        }
        if (drivingCategory == "B" || drivingCategory == "C" || drivingCategory == "D") {
            this.drivingCategory = drivingCategory;
        } else {
            this.drivingCategory = "не указана";
        }
        if (yearOfPrimaryDriveLicense > 1960 && yearOfPrimaryDriveLicense < (LocalDate.now().getYear() + 1)) {
            this.yearOfPrimaryDriveLicense = yearOfPrimaryDriveLicense;
        } else {
            this.yearOfPrimaryDriveLicense = LocalDate.now().getYear();
        }
        this.drivingExperience = calculateDrivingExperience();
    }

    // ====== СТАЖ: ========
    private int calculateDrivingExperience() {
        int drivingExperience = LocalDate.now().getYear() - yearOfPrimaryDriveLicense;
        return drivingExperience;
    }
// ===== абстрактные методы: ====
public abstract  void startDrive();
    public abstract void finishDrive();
    public abstract void refuelTheCar();

// ======= ГЕТТЕРЫ / СЕТТЕРЫ: =======


    public String getFio() {
        return fio;
    }

    public String getDrivingCategory() {
        return drivingCategory;
    }

    public int getYearOfPrimaryDriveLicense() {
        return yearOfPrimaryDriveLicense;
    }

    public Driver setDrivingCategory(String drivingCategory) {
        this.drivingCategory = drivingCategory;
        return this;
    }

    // ===== ТУСТРИНГ: ======
    @Override
    public String toString() {
        return "Водитель: " + fio + "; категория * " + drivingCategory + " *, год выдачи прав: " + yearOfPrimaryDriveLicense +
                "; стаж вождения, лет: " + calculateDrivingExperience();
    }

}

