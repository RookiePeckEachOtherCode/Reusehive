package com.reusehive.entity;

public enum PurchaseType {
    LOCK(0), //交易锁定
    FREE(1);

    PurchaseType(int i) {
    }

    public static PurchaseType valueOf(int i) {
        return switch (i) {
            case 0 -> LOCK;
            case 1 -> FREE;
            default -> null;
        };
    }

    public static int codeOf(PurchaseType type) {
        return switch (type) {
            case LOCK -> 0;
            case FREE -> 1;
        };
    }

}

