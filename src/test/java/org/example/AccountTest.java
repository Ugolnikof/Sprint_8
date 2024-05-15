package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Тимоти Шаламе", true},    // корректное имя на русском
                {"Timoty Shalame", true},   // корректное имя на английском
                {"Т м", true},  // длина строки 3 (ГЗ)
                {"Ти", false},  // длина строки 2 (ГЗ)
                {"Тимоти Шаламеиаламе", true},  // длина строки 19 (ГЗ)
                {"Тимотия Шаламеиаламе", false},    // длина строки 20 (ГЗ)
                {"Тимоти Shalame", false},  // имя и фамилия на разных языках
                {"Timoty Шаламе", false},   // имя и фамилия на разных языках
                {"ТимотиШаламе", false},    // имя без пробела
                {" ТимотиШаламе", false},    // пробел в начале строки
                {"ТимотиШаламе ", false},    // пробел в конце строки
                {"Тимоти Ша-ламе", false},    // имя со спец символами
                {"Тимоти_Шаламе", false},    // имя со спец символами
                {"Тимоти Ш@ламе", false},    // имя со спец символами
                {"", false},    // пустая строка
                {"12345 54321", false},    // строка c цифрами
                {"Тим оти Шаламе", false},   // имя с 2мя пробелами
        };
    }

    @Test
    public void checkValidName(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }

}