public class Main {
    public static void main(String[] args) {

        Car лада = new Car(null, "", -0.5,
                " ", -9, "Russia");
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "чёрный",
                2020,"Германия");
        Car bmw = new Car("BMW", "Z8", 3.0, "чёрный",
                2021,"Германия");
        Car kia = new Car("Kia", "Sportage 4", 2.4, "красный",
                2018,"Южная Корея");
        Car hunday = new Car("Hyundai", "Avante", 1.6, "оранжевый",
                2016,"Южная Корея");
        System.out.println(лада);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hunday);
    }
}