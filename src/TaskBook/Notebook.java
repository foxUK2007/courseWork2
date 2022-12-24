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

    public boolean addMapPurpose(Purpose purpose) {
        return purposeMap.put(purpose.getId(), purpose) == null;
    }

    public void removeMapPurpose(int id) {
        if ((getPurposeMap()).containsKey(id)) {
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
                            .equals(DailyPurpose.class)) {
                        for (int i = 0; i < 365; i++) {
                            if (integerPurposeEntry != null && integerPurposeEntry.getValue().getDate().toLocalDate()
                                    .isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusDays(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(WeeklyPurpose.class)) {
                        for (int i = 0; i < 1000; i++) {
                            if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusWeeks(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(MonthlyPurpose.class)) {
                        for (int i = 0; i < 1000; i++) {
                            if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusMonths(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(AnnualPurpose.class)) {
                        for (int i = 0; i < 2000; i++) {
                            if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate().plusYears(i))) {
                                purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                            }
                        }
                    } else if (integerPurposeEntry != null && integerPurposeEntry.getValue().getClass()
                            .equals(OneTimePurpose.class)) {
                        if (date.isEqual(integerPurposeEntry.getValue().getDate().toLocalDate())) {
                            purposeForDay.put(integerPurposeEntry.getKey(), integerPurposeEntry.getValue());
                        }
                    }
                }
                for (Map.Entry<Integer, Purpose> integerPurposeEntry : purposeForDay.entrySet()) {
                    System.out.println(integerPurposeEntry.getValue());
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение даты");
            }
        } catch (DateTimeException e) {
            System.out.println("Введите корректное значение даты");
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
        Notebook diary = (Notebook) o;
        return Objects.equals(purposeForDay, diary.purposeForDay) && Objects.equals(purposeMap,
                diary.purposeMap) && Objects.equals(purpose, diary.purpose);
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
