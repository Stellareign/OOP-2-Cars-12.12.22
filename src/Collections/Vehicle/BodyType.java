package Collections.Vehicle;

public enum BodyType {
    SEDAN("седан"),
    HATCHBACK("хэтчбек"),
    COUPE("купе"),
    WAGON("универсал"),
    SUV("внедорожник"),
    CROSS("кроссовер"),
    PICKUP("пикап"),
    VAN("фургон"),
    MINIVAN("минивэн");

    // === КОНСТРУКТОР ====
    private String bodyType;

    BodyType(String bodyType) {
        if (bodyType != null && !bodyType.isEmpty() && !bodyType.isBlank()) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = "нет информации";
        }
    }

    public static BodyType checkBodyTypes(String bodyType) {
        for (BodyType bodyType1 : values()) {
            if (bodyType1.getBodyType().equals(bodyType)) {
                return bodyType1; // здесь случайно получился пустой if
            }
        }
        return null;
    }

    // === ГЕТТЕР ====
    public String getBodyType() {
        return bodyType;
    }

    // ===== ТУСТРИНГ  =====
    @Override
    public String toString() {
        return "тип кузова: " + getBodyType();
    }
}

