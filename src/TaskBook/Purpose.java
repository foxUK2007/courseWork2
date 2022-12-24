package TaskBook;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Purpose {

    private String title;
    private String note;
    private final TypeOfPurpose type;
    private final int id;
    private static int counter = 0;
    protected LocalDateTime date;

    public Purpose(String title, String note, TypeOfPurpose type, LocalDateTime date) {
        this.title = setTitle(title);
        this.note = setNote(note);
        this.type = type;
        this.date = date;
        counter++;
        this.id = counter;
    }

    public String setTitle(String title) {
        if ((title != null && !title.trim().isEmpty())) {
            this.title = title;
        } else {
            System.out.println("Такого имени не существует");
        }
        return title;
    }

    public String setNote(String note) {
        if ((title != null && !title.trim().isEmpty())) {
            this.note = note;
        } else {
            System.out.println("Введите корректное описание!");
        }
        return note;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public TypeOfPurpose getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public abstract String getTypeRepeatable();


    @Override
    public String toString() {
        return "\n\"" + title + "\"" +
                ", необходимо " + note +
                ". " + type + ", дата выполнения: " + date + ", повторяемость: " + getTypeRepeatable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Purpose purpose = (Purpose) o;
        return id == purpose.id && Objects.equals(title, purpose.title) && Objects.equals(
                note, purpose.note) && type == purpose.type && Objects.equals(date,
                purpose.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, date);
    }
}




