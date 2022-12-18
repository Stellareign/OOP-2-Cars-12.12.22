import java.security.Key;

public class Main {
    public static void main(String[] args) {
        //      String transmission;
        //    final String bodyType = null;
        //    final int numberOfSeats = 0;
        //    String regNumber;
        //    String tire;

        Car lada = new Car(
                "Лада",
                "",
                -0.5,
                " ",
                -9,
                "Russia",
                " ",
                "лифтбек",
                8,
                "A896EY076",
                "зима",
                new Car.Key("да", "нет"));
        lada.setTire("лето"); // замена резины
        Car audi = new Car(
                "Audi",
                "A8 50 L TDI quattro",
                3.0,
                "чёрный",
                2020,
                "Германия",
                "АКПП",
                "хэтчбек",
                5,
                "",
                "лето",
                new Car.Key("да", ""));
        Car bmw = new Car(
                "BMW",
                "Z8",
                3.0,
                "чёрный",
                2021,
                "Германия",
                "АКПП",
                "хетчбек",
                5,
                "",
                "",new Car.Key("да","да"));

        Car kia = new Car(
                "Kia",
                "Sportage 4",
                2.4,
                "красный",
                2018,
                "Южная Корея",
                "МКПП",
                "хэтчбек",
                5,
                "",
                "",
                new Car.Key("да", "нет"));
        Car hunday = new Car(
                "Hyundai",
                "Avante",
                1.6,
                "оранжевый",
                2016,
                "Южная Корея",
                "АКПП",
                "седан",
                5,
                "",
                "",
                new Car.Key("", ""));
        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hunday);
    }
}
