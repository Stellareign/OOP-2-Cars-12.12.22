package carAndBus;

public class Main {
    public static void main(String[] args) {

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
                180,
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
                320,
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
                "",
                300,
                new Car.Key("да", "да"));

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
                260,
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
                220,
                new Car.Key("", ""));
        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hunday);
        System.out.println(

        );
        Bus paz = new Bus(
                "ПАЗ",
                "3237",
                " ",
                2017,
                "Россия",
                "вагонный",
                "город / пригород",
                "АКПП-6",
                41,
                1,
                100,
                ""
        );
        Bus gazel = new Bus(
                "ГАЗ",
                "ГАЗель NEXT",
                "чёрный",
                2016,
                "Россия",
                "капотный",
                "город / пригород",
                "МКПП-5",
                18,
                1,
                120,
                "123659236"
        );
        Bus liaz = new Bus(
                "ЛИАЗ",
                "Круиз",
                "",
                2019,
                "Россия",
                "вагонный",
                "туристический",
                "Scania GR875R - 8 ст.",
                48,
                2,
                0,
                "23cx2"
        );
        System.out.println(paz);
        System.out.println(gazel);
        System.out.println(liaz);
    }
}