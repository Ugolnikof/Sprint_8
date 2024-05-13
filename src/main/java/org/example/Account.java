package org.example;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name.length() > 2
                && name.length() < 20
                && name.charAt(0) != ' '
                && name.charAt((name.length() - 1)) != ' '
                && name.contains(" ");
    }
}
