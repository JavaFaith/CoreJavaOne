package UnitFive.Enums;

import java.util.Scanner;

/**
 * This program demonstrates enumerated types
 * @version 1.0
 * @author Robin Wan
 * @date 2021-12-27
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGER)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job -- you paid attention to the _.");
        }
    }


    enum Size {
        EXTRA_LARGE("XL"), LAGER("L"), MEDIUM("M"), SMALL("S");
        private String abbreviation;

        private Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

    }
}