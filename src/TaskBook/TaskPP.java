package TaskBook;

import java.time.LocalDateTime;

public class TaskPP extends Purpose implements Repeatable {

    public TaskPP(String title,
                  String note,
                  TypeOfPurpose typeOfPurpose,
                  LocalDateTime date) {
        super(title, note, typeOfPurpose, date);
    }

    @Override
    public String getTypePurpose() {
        return "Личная";
    }

    @Override
    public LocalDateTime getDateTime(LocalDateTime dateTime) {
        LocalDateTime date = dateTime;
        while (date.isBefore(dateTime)) {
            date = date.plusWeeks(1);
        }
        return date;
    }
}
