package TaskBook;

import java.time.LocalDateTime;

public class DailyPurpose extends Purpose implements Repeatable{


    public DailyPurpose(String title, String note, TypeOfPurpose type, LocalDateTime date) {
        super(title, note, type, date);
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public LocalDateTime getDateTime(LocalDateTime dateTime) {
        LocalDateTime date = dateTime;
        while (date.isBefore(dateTime)) {
            date = date.plusDays(1);
        }
        return date;
    }

    @Override
    public String getTypeRepeatable() {
        return "Ежедневная ";
    }

}
