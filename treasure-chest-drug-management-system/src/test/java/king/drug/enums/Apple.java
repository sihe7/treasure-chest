package king.drug.enums;

import lombok.Getter;

public enum Apple {
    INSTANCE("yangkai");

    @Getter
    private final String method;

    Apple(String method) {
        this.method = method;
    }
}