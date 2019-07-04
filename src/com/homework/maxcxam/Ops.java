package com.homework.maxcxam;

public enum Ops {
    WITHDRAWAL ,
    REFILL,
    PAYMENT;
    public double execute(double sum, double balance) {
        switch (this) {
            case WITHDRAWAL:
                return balance - sum;
            case REFILL:
                return balance + sum;
            case PAYMENT:
                return balance + sum*-1;
            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
