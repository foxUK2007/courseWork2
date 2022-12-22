package TaskBook;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Purpose {

    private String title;

    private String note;

    private final TypeOfPurpose typeOfPurpose;

    private final int id;

    private static int counter = 0;

    private LocalDateTime date;


    public Purpose(String title, String note, TypeOfPurpose typeOfPurpose, LocalDateTime date) {
        this.title = title;
        this.note = setNote(note);
        this.typeOfPurpose = typeOfPurpose;
        this.date = date;
        counter++;
        this.id = counter;
    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String title) {
        if ((title != null && !title.trim().isEmpty())) {
            this.title = title;
        } else {
            System.out.println("Введите корректно название цели!");
        }
        return title;
    }


    public String getNote() {
        return note;
    }

    public String setNote(String note) {
        if ((note != null && !note.trim().isEmpty())) {
            this.note = note;
        } else {
            System.out.println("Введите корректное описание цели!");
        }
        return note;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public abstract String getTypePurpose();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purpose purpose = (Purpose) o;
        return id == purpose.id && Objects.equals(title, purpose.title) && Objects.equals(note, purpose.note) && Objects.equals(typeOfPurpose, purpose.typeOfPurpose) && Objects.equals(date, purpose.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, note, typeOfPurpose, id, date);
    }

    @Override
    public String toString() {
        return "Цель: " +
                title +
                ", описание " + note +
                date;
    }
}




