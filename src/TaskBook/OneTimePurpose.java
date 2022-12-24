package TaskBook;

import java.time.LocalDateTime;

public class OneTimePurpose extends Purpose implements Repeatable {

    public OneTimePurpose(String title, String note, TypeOfPurpose type, LocalDateTime date) {
        super(title, note, type, date);
    }

    @Override
    public LocalDateTime getDateTime(LocalDateTime dateTime) {
        return dateTime;
    }

    @Override
    public String getTypeRepeatable() {
        return "Однократная ";
    }

}
