package Collections.Vehicle;

public enum LoadCapacity {

    N1(null, 3.5f),
    N2(3.5f, 12.0f),
    N3(12f, null);

    private Float minLoadCapacity;
    private Float maxLoadCapacity;

    LoadCapacity(Float minLoadCapacity, Float maxLoadCapacity) {

        this.minLoadCapacity = minLoadCapacity;
        this.maxLoadCapacity = maxLoadCapacity;

    }

    public float getMinLoadCapacity() {
        return minLoadCapacity;
    }

    public float getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String toString() {

        if (minLoadCapacity == null) {
            return "грузоподъёмность  до " + maxLoadCapacity + " т.";
        } else if (maxLoadCapacity == null) {
            return "грузоподъёмность  от " + minLoadCapacity + " т.";
        } else {
            return "грузоподъёмность от " + minLoadCapacity + " до " + maxLoadCapacity + " т.";
        }
    }
}

