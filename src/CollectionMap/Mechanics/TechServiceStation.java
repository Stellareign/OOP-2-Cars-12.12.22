package CollectionMap.Mechanics;

import CollectionMap.Vehicle.Bus;
import CollectionMap.Vehicle.Transport;
import carAndBus.Car;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TechServiceStation {
    private final Queue<Transport> transportQueue = new ArrayDeque<>(); // создаём очередь
// Добавление ТС в очередь:
    public void addTransport(Transport transport) {
        if (transport instanceof Bus) { // исключаем автобусы
            System.out.println("Для автобусов обслуживание не проводится");
        } else {
            transportQueue.add(transport); // добавляем ТС в очередь
        }
    }
    public void doMaintenanceCar() { // метод с автоматической очередью ТС, ТО сразу для все добавленных авто
        while (transportQueue.peek() != null) {
            Transport nextTransport = transportQueue.poll(); // автоматическое движение по очереди для каждого метода
            if (nextTransport != null) {
                System.out.println("Проводим ТО для " + nextTransport.getBrand() + " " + nextTransport.getModel());
            }// метод ТО из класса Mechanic
        }
    }
//    public void maintenanceCar() { // метод ТО из класса Mechanic
//         Map<Transport, Mechanic> transportMechanicMap = new HashMap<>();
//        Transport transport = transportQueue.poll(); // "достаём" из очереди объект
//        for  (Transport t : transportQueue){//(Transport t : transportQueue)
//            if (transport != null) {
//                t.getTransportMechanicMap().get(0).maintenanceCar();
//            }
//            System.out.println("\n Следующие ТС находятся на ТО:");
//            transportQueue.stream().forEach(System.out::println);
//        }
//    }


    public Queue<Transport> getTransportQueue() {
        return transportQueue;
    }

    @Override
    public String toString() {
        return "В очереди на СТО следующие ТС: " + transportQueue.element().getBrand() + " " + transportQueue.element().getModel();
    }
}
