public class Transport {
    final String brand;
    final String model;
    String color;
    final int releaseYear;
    final String country;
    int maxSpeed;
// ============КОНТРУКТОР==================
    public Transport(String brand, String model, String color, int releaseYear, String country, int maxSpeed) {
        if (brand != null && !brand.isEmpty() && !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }
        if (model == null || model.isBlank() || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (color == null || color.isEmpty() || color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        if (releaseYear <= 0) {
            this.releaseYear = 2000;
        } else {
            this.releaseYear = releaseYear;
        }
        if (country == null || country.isBlank() || country.isEmpty()) {
            this.country = "default";
        } else {
            this.country = country;
        }
        if (maxSpeed != 0 && maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else{
            maxSpeed = 90;
        }

    }

    // ======ГЕТТЕРЫ: ============
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    // ======СЕТТЕРЫ:========

    public Transport setColor(String color) {
        this.color = color;
        return this;
    }

    public Transport setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }
}
