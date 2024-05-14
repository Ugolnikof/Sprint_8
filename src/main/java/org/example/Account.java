package org.example;

import java.util.regex.Pattern;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name.length() > 2
                && name.length() < 20
                && (Pattern.matches("^[А-Яа-я]*\\s[А-Яа-я]*$", name) // для русских имён
                || Pattern.matches("^[A-Za-z]*\\s[A-Za-z]*$", name)); // для английских имён
    }
}
