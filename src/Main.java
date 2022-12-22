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
                            System.out.println("Какую цель Вы хотите удалить:\n");
                            System.out.println("Доступные цели: \n" + notebook + "\n");
                            notebook.removeMapPurpose(scanner.nextInt());
                            System.out.println("Цель удалена!");
                            break;
                        case 3:
                            System.out.println("Введите дату и время выполнения цели (ГГГГ.ММ.ДД):");
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
        String purposeTitle = sc.nextLine();
        System.out.println("Введите описание цели: ");
        String note = sc.nextLine();
        System.out.println("Выберите повторяемость целм: однократная, ежедневная, еженедельная, ежемесячная, ежегодная задача. ");
        TypeOfPurpose typeOfPurpose;
        if (scanner.next().trim().equalsIgnoreCase("однократная")) {
            typeOfPurpose = TypeOfPurpose.ONE_TIME;
        }if (scanner.next().trim().equalsIgnoreCase("ежедневная")){
            typeOfPurpose = TypeOfPurpose.DAILY;
        }if (scanner.next().trim().equalsIgnoreCase("еженедельная")){
            typeOfPurpose = TypeOfPurpose.WEEKLY;
        }if (scanner.next().trim().equalsIgnoreCase("ежемесячная")){
            typeOfPurpose = TypeOfPurpose.MONTHLY;
        } else{
            typeOfPurpose = TypeOfPurpose.ANNUAL;
        }
        LocalDateTime dateTime;
        System.out.println("Введите дату и время задачи (ГГГГ.ММ.ДД,ЧЧ:00):");
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
                "Выберите тип цели?");
        switch (scanner.next()) {
            case "рабочая":
                purpose = new TaskWP(purposeTitle, note, typeOfPurpose, dateTime);
                break;
            case "личная":
                purpose = new TaskPP(purposeTitle, note, typeOfPurpose, dateTime) {
                };
                break;

        }
        try {
            if (notebook.addMapPurpose(purpose)) {
                System.out.println("Задача успешно добавлена!");
            }
        } catch (NullPointerException e) {
            System.out.println("Задача не добавлена! Повторяемость задачи введена неверно!");
        }
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу \n2. Удалить задачу \n3. Получить задачу на указанный день \n0. Выход ");
    }
}



