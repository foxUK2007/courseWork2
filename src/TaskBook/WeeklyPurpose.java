package TaskBook;

import java.time.LocalDateTime;

public class WeeklyPurpose extends Purpose implements Repeatable {

    public WeeklyPurpose(String title, String note, TypeOfPurpose type, LocalDateTime date) {
        super(title, note, type, date);
    }

    @Override
    public LocalDateTime getDateTime(LocalDateTime dateTime) {
        LocalDateTime date = dateTime;
        while (date.isBefore(dateTime)) {
            date = date.plusWeeks(1);
        }
        return date;
    }

    @Override
    public String getTypeRepeatable() {
        return "Еженедельная ";
    }

}
