import TaskBook.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    private static final Notebook notebook = new Notebook();
    private static Purpose purpose;
    public static final DateTimeFormatter D_T_FORMAT = DateTimeFormatter.ofPattern(
            "yyyy.MM.dd','HH:mm");
    public static final DateTimeFormatter D_FORMAT = DateTimeFormatter.ofPattern(
            "yyyy.MM.dd");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            System.out.println("Выберите цель, которую хотите удалить:\n");
                            System.out.println("Доступные цели: \n" + notebook + "\n");
                            notebook.removeMapPurpose(scanner.nextInt());
                            System.out.println("Цель удалена!");
                            break;
                        case 3:
                            System.out.println("Введите дату и время цели (ГГГГ.ММ.ДД):");
                            notebook.getPurposeForDay(LocalDate.parse(scanner.next(), D_FORMAT));
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
        System.out.println(notebook);
    }

    private static void inputTask(Scanner scanner) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название цели: ");
        String title = sc.nextLine();
        System.out.println("Введите описание цели: ");
        String note = sc.nextLine();
        System.out.println("Введите тип цели \"Личная\" или \"Рабочая\"?");
        TypeOfPurpose typeOfPurpose;
        if (scanner.next().trim().equalsIgnoreCase("Личная")) {
            typeOfPurpose = TypeOfPurpose.PERSONAL_TASK;
        } else {
            typeOfPurpose = TypeOfPurpose.WORK_TASK;
        }
        LocalDateTime dateTime;
        System.out.println("Введите дату и время цели (ГГГГ.ММ.ДД,ЧЧ:00):");
        dateTime = LocalDateTime.parse(scanner.next(), D_T_FORMAT);
        boolean tr = false;
        while (tr) {
            try {
                dateTime = LocalDateTime.parse(scanner.next(), D_T_FORMAT);
                tr = true;
            } catch (DateTimeParseException e) {
                System.out.println("Введите дату корректно!");
            }
        }
        System.out.println(
                "Укажите повторяемость цели");
        switch (scanner.next()) {
            case "однократная":
                purpose = new OneTimePurpose(title, note, typeOfPurpose, dateTime);
                break;
            case "ежедневная":
                purpose = new DailyPurpose(title, note, typeOfPurpose, dateTime);
                break;
            case "еженедельная":
                purpose = new WeeklyPurpose(title, note, typeOfPurpose, dateTime);
                break;
            case "ежемесячная":
                purpose = new MonthlyPurpose(title, note, typeOfPurpose, dateTime);
                break;
            case "ежегодная":
                purpose = new AnnualPurpose(title, note, typeOfPurpose, dateTime);
                break;
        }
        try {
            if (notebook.addMapPurpose(purpose)) {
                System.out.println("Цель успешно добавлена!");
            }
        } catch (NullPointerException e) {
            System.out.println("Цель не добавлена! Повторяемость цели введена неверно!");
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить цель \n2. Удалить цель \n3. Получить цель на указанный день \n0. Выход ");
    }
}



