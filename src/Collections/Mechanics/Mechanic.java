package Collections.Mechanics;

import Collections.Vehicle.Bus;
import Collections.Vehicle.CargoCar;
import Collections.Vehicle.PassengCar;
import Collections.Vehicle.Transport;

import java.util.Objects;

public class Mechanic {
    private String surname;
    private String name;
    private String company;
    private ServiceTransport serviceTransport;
//    private Transport transport;
//    private PassengCar passengCar;
//    private CargoCar cargoCar;
//    private Bus bus;

    // ==== делаем конструктор: ======
    public Mechanic(String surname, String name, String company, ServiceTransport serviceTransport) {
        this.surname = surname;
        this.name = name;
        this.company = company;
        this.serviceTransport = serviceTransport;
    }

    // ==== МЕТОДЫ: ====
    public void maintenanceCar() {
    }

    public void repairCar() {
    }
// ==== ГЕТТЕРЫ / СЕТТЕРЫ: =====
    public String getSurname() {
        return surname;
    }

    public Mechanic setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getName() {
        return name;
    }

    public Mechanic setName(String name) {
        this.name = name;
        return this;
    }

    public ServiceTransport getServiceTransport() {
        return serviceTransport;
    }

    public Mechanic setServiceTransport(ServiceTransport serviceTransport) {
        this.serviceTransport = serviceTransport;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Mechanic setCompany(String company) {
        this.company = company;
        return this;
    }


    // ===== ИКВАЛС И ХЭШ: =====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;
        Mechanic mechanic = (Mechanic) o;
        return getSurname().equals(mechanic.getSurname()) && getName().equals(mechanic.getName()) && getServiceTransport() == mechanic.getServiceTransport() && getCompany().equals(mechanic.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getServiceTransport(), getCompany());
    }

    @Override
    public String toString() {
        return "Механик " + surname + " " + name + " обслуживает вид транспорта: " + serviceTransport +
                ", сервисная компания *" + company +"*";

    }
}
