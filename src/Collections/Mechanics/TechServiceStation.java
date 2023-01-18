package Collections.Mechanics;

import Collections.Vehicle.Bus;
import Collections.Vehicle.Transport;

import java.util.ArrayDeque;
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

    public void maintenanceCar() { // метод ТО из класса Mechanic
        Transport transport = transportQueue.poll(); // "достаём" из очереди объект
        for (Transport transport1 : transportQueue){
        if (transport != null) {
            transport1.getMechanics().get(1).maintenanceCar();}
        System.out.println("\n Следующие ТС находятся на ТО:");}
               transportQueue.stream().forEach(System.out::println);
    }
}
