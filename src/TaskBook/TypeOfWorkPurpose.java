package TaskBook;

public enum TypeOfWorkPurpose {

    ONE_TIME ("Однократная"),
    DAILY ("Ежедневная"),
    WEEKLY("Еженедельная"),
    MONTHLY("Ежемесячная"),
    ANNUAL("Ежегодная");

    final String TypeOfWorkPurpose;

    TypeOfWorkPurpose(String TypeOfWorkPurpose) {
        this.TypeOfWorkPurpose = TypeOfWorkPurpose;
    }
}
