package pl.javastart.task;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.ZoneOffset.UTC;

public class Main {

    private static final ZoneId LOS_ANGELES_ZONE = ZoneId.of("America/Los_Angeles");
    private static final ZoneId LONDON_ZONE = ZoneId.of("Europe/London");
    private static final ZoneId SYDNEY_ZONE = ZoneId.of("Australia/Sydney");

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {

        System.out.println("Podaj datę:");
        String dateInput = scanner.nextLine();

        String [] patterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "dd.MM.yyyy HH:mm:ss"};

        for (String pattern : patterns) {
            if (pattern.equals("yyyy-MM-dd")) {
                pattern = "yyyy-MM-dd 00:00:00";
            }
            DateTimeFormatter inputFormater = DateTimeFormatter.ofPattern(pattern);
            DateTimeFormatter outputFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            try {
                LocalDateTime dateTime = LocalDateTime.parse(dateInput, inputFormater);
                System.out.println("Czas lokalny: " + dateTime.format(outputFormater));
                System.out.println("UTC: " + dateTime.atZone(UTC).format(outputFormater));
                System.out.println("Londyn: " + dateTime.atZone(LONDON_ZONE).format(outputFormater));
                System.out.println("Los Angeles: " + dateTime.atZone(LOS_ANGELES_ZONE).format(outputFormater));
                System.out.println("Sydney: " + dateTime.atZone(SYDNEY_ZONE).format(outputFormater));
            } catch (Exception e) {
                //ignore
            }
        }
    }

}
