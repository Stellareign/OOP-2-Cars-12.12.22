public class Car {
    String brand;
    String model;
    double engineVolume;
    String color;
    int year;
    String country;
// невозможно нормально работать
    public Car(String brand, String model, double engineVolume, String color, int year, String country) {
        if(brand == null || brand.isEmpty()|| brand.isBlank()){
            this.brand =" default, ";
        }
        else{
        this.brand = brand;}
        if (model == null || model.isBlank() || model.isEmpty()){
            this.model = " default ";
        } else{
        this.model = model;}
        if(engineVolume >= 0){
        this.engineVolume = engineVolume;}
        else {this.engineVolume = 1.5;}
        if(color == null || color.isEmpty() || color.isBlank()){
            this.color = " белый ";
        }
        else{
        this.color = color;}
        if(year <= 0){
            this.year = 2000;
        }
        else{
        this.year = year;}
        if(country == null || country.isBlank() || country.isEmpty()){
            this.country = " default ";}
        else{
        this.country = country;}
    }

    @Override
    public String toString() {
        return "Автомобтль " + brand + " " + model + ", объём движка " + engineVolume + " л, цвет " +
                 color + ", год выпуска " + year +" г., cтрана производства " + country +".";
    }
}
