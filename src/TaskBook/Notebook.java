package TaskBook;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;

public class Notebook {

    Map<Integer, Purpose> purposeForDay = new HashMap<>();
    private final Map<Integer, Purpose> purposeMap;
    private Purpose purpose;

    public Notebook() {
        this.purposeMap = new HashMap<>();
    }

    public boolean addMapPurpose (Purpose purpose) {
        return purposeMap.put(purpose.getId(), purpose) == null;
    }

    public void removeMapPurpose(int id) {
        if (purposeMap.containsKey(id)) {
            purposeMap.remove(id);
        }
    }

    public void getPurposeForDay(LocalDate date) {
        try {
            try {
                for (Map.Entry<Integer, Purpose> integerPurposeEntry : purposeMap.entrySet()) {
                    if (integerPurposeEntry != null && integerPurposeEntry.getValue().getDate().toLocalDate()
                            .isAfter(date)) {
                        continue;
                    }
                    if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(TypeOfPurpose.DAILY)) {
                        for (int i = 0; i < 10000; i++) {
                            if (integerPurposeEntry != null && integerPurposeEntry.getValue().getDate().toLocalDate()
                                    .isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusDays(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(TypeOfPurpose.WEEKLY)) {
                        for (int i = 0; i < 3000; i++) {
                            if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusWeeks(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(TypeOfPurpose.MONTHLY)) {
                        for (int i = 0; i < 1000; i++) {
                            if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusMonths(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(TypeOfPurpose.ANNUAL)) {
                        for (int i = 0; i < 200; i++) {
                            if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusYears(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(TypeOfPurpose.ONE_TIME)) {
                        if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate())) {
                            purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                        }
                    }
                }
                for (Map.Entry<Integer, Purpose> integerPurposeEntry : purposeForDay.entrySet()) {
                    System.out.println(integerPurposeEntry.getValue());
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректное значение даты");
            }
        } catch (DateTimeException e) {
            System.out.println("Вы ввели некорректное значение даты");
        }
    }

    public Map<Integer, Purpose> getPurposeMap() {
        return purposeMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) o;
        return Objects.equals(purposeForDay, notebook.purposeForDay) && Objects.equals(purpose,
                notebook.purpose) && Objects.equals(purpose, notebook.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purposeForDay, purposeMap, purpose);
    }

    @Override
    public String toString() {
        return "" + purposeMap;
    }
}
