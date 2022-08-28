package net.absoft.data;

public enum User {
    DATA_USER("Kristina", "Vasuyra", "12345");

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    User(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
