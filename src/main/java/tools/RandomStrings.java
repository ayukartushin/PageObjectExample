package tools;

import java.util.Random;

public class RandomStrings {
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTERS_AND_DIGITS = LETTERS + "0123456789";
    private static final Random random = new Random();

    /**
     * Генерирует случайную строку из букв (и цифр) заданной длины
     * @param length количество символов в строке
     * @return случайная строка
     */
    public static String getString(int length) {
        if (length <= 0) return "";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(LETTERS_AND_DIGITS.charAt(random.nextInt(LETTERS_AND_DIGITS.length())));
        }
        return sb.toString();
    }

    /**
     * Генерирует случайный email с указанной длиной "имени"
     * @param length количество символов в строке
     * @return случайный email
     */
    public static String getEmail(int length) {
        if (length <= 0) length = 5;
        String name = getString(length).toLowerCase();
        String domain = getString(5).toLowerCase();
        return name + "@" + domain + ".com";
    }
}
