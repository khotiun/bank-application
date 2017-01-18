package ua.spalah.bank.models;

/**
 * Created by MyPc on 28.12.2016.
 */
public enum Gender {
    MALE("Mr."),
    FEMALE("Mrs.");

    private final String salutation;

    Gender(String salutation) {
        this.salutation = salutation;
    }

    public String getSalutation() {
        return salutation;
    }
}
