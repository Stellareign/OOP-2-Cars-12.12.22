package CollectionMap.Mechanics;

public enum ServiceTransport  {
    //====== 1. создаём перечисления: ======
    PassCars("легковые автомобили"),
    Trucks("грузовики"),
    Buses("автобусы"),
    MultiSpec ("все виды ТС");

//    private static Transport PassengCar;
//    private static Transport CargoCar;
//    private static Transport Bus;
    // ======= 2. значение: ========
    private String transpotrMode;


//  ===== 3. конструктор: =======
    ServiceTransport(String transpotrMode) { //Transport transport
        if (transpotrMode != null && !transpotrMode.isBlank() && !transpotrMode.isEmpty()) {
            this.transpotrMode = transpotrMode;
        } else {
            transpotrMode = "данных нет";
        }
//        this.transport = transport;
//        if (transpotrMode.equals("Легковые автомобили")) {
//           this.transport = List<Transport> transport;
//        } else if (transpotrMode.equals("Грузовики")) {
//            this.transport = CargoCar;
//        } else if (transpotrMode.equals("Автобусы")) {
//            this.transport = Bus;
//        }

    }


    // ===== геттеры и сеттеры: ======

    public String getTranspotrMode() {
        return transpotrMode;
    }

    public ServiceTransport setTranspotrMode(String transpotrMode) {
        this.transpotrMode = transpotrMode;
        return this;
    }

    // ====== тустринг: ====

    @Override
    public String toString() {
        return transpotrMode;
    }
}
