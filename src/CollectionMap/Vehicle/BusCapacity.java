package CollectionMap.Vehicle;

public enum BusCapacity {
    SUPERSMALL("особо малая", null, 10),
    SMALL("малая", null, 25),
    MEDIUM("средняя", 40, 50),
    LARGE("большая", 60, 80),
    SUPERLARGE("особо большая", 100, 120);

    private String busCapacity;
    private Integer minCapacity;
    private Integer maxCapacity;

    BusCapacity(String busCapacity, Integer minCapacity, Integer maxCapacity) {
        this.busCapacity = busCapacity;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    // ===== ГЕТТЕРЫ: ====
    public String getBusCapacity() {
        if (busCapacity != null) {
            return busCapacity;
        } else {
            return "вместимость не указана";
        }
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    // ===== ТУСТРИНГ =====
    @Override
    public String toString() {
        if (minCapacity == null) {
            return "вместимость " + busCapacity + ": до " + maxCapacity + " чел.";
        } else if (maxCapacity == null) {
            return "вместимость " + busCapacity + ": от " + minCapacity + " чел.";
        } else
            return "вместимость " + busCapacity + ": от " + minCapacity + " до " + maxCapacity + " чел.";
    }
}
