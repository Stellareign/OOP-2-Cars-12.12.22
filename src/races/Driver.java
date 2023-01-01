package races;

import java.time.LocalDate;
import java.util.Objects;


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
            this.fio = "* ФИО не указано *";
        }
        if (drivingCategory.equals("B") || drivingCategory.equals("C") || drivingCategory.equals("D")) {
            this.drivingCategory = drivingCategory;
        } else {
            this.drivingCategory = "недопустимая категория";

        }
        if (yearOfPrimaryDriveLicense > 1960 && yearOfPrimaryDriveLicense < (LocalDate.now().getYear() + 1)) {
            this.yearOfPrimaryDriveLicense = yearOfPrimaryDriveLicense;
        } else {
            this.yearOfPrimaryDriveLicense = LocalDate.now().getYear();
        }
        this.drivingExperience = calculateDrivingExperience();
    }

    // =========== УРЕЗАННЫЙ КОНСТРУКТОР БЕЗ СТАЖА: =========
    public Driver(String fio, String drivingCategory, int yearOfPrimaryDriveLicense) throws DrivingCategoryException {
        if (fio != null && !fio.isEmpty() && !fio.isBlank()) {
            this.fio = fio;
        } else {
            this.fio = "* ФИО не указано *";
        }
        //  === СОЗДАЁМ ИСКЛЮЧЕНИЕ===
        try {
            if (drivingCategory.equals("B") || drivingCategory.equals("C") || drivingCategory.equals("D")) {
                this.drivingCategory = drivingCategory;
            } else {
                this.drivingCategory = ("недопустимая категория");
                throw new DrivingCategoryException("Водитель " + fio + ": ошибка при вводе данных категории прав!");
            }
        } catch (DrivingCategoryException e) {
            System.out.println(e.getMessage());
        }


        if (yearOfPrimaryDriveLicense > (LocalDate.now().getYear() - 60) && yearOfPrimaryDriveLicense < (LocalDate.now().getYear() + 1)) {
            this.yearOfPrimaryDriveLicense = yearOfPrimaryDriveLicense;
        } else {
            this.yearOfPrimaryDriveLicense = LocalDate.now().getYear();
        }
        this.drivingExperience = calculateDrivingExperience();
    }

    // ====== рассчитываем СТАЖ: ========
    private int calculateDrivingExperience() {
        int drivingExperience = LocalDate.now().getYear() - yearOfPrimaryDriveLicense;
        return drivingExperience;
    }


    // ===== абстрактные методы: ====
    public abstract void startDrive();

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
        return "Водитель: " + fio + "; категория" + " * " + drivingCategory + " *" + ", год выдачи прав: " + yearOfPrimaryDriveLicense +
                "; стаж вождения, лет: " + calculateDrivingExperience();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (yearOfPrimaryDriveLicense != driver.yearOfPrimaryDriveLicense) return false;
        if (drivingExperience != driver.drivingExperience) return false;
        if (!Objects.equals(fio, driver.fio)) return false;
        return Objects.equals(drivingCategory, driver.drivingCategory);
    }

    @Override
    public int hashCode() {
        int result = fio != null ? fio.hashCode() : 0;
        result = 31 * result + (drivingCategory != null ? drivingCategory.hashCode() : 0);
        result = 31 * result + yearOfPrimaryDriveLicense;
        result = 31 * result + drivingExperience;
        return result;
    }
}


