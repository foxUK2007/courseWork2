package TaskBook;

public enum TypeOfPurpose {

    ONE_TIME ("Однократная"),
    DAILY ("Ежедневная"),
    WEEKLY("Еженедельная"),
    MONTHLY("Ежемесячная"),
    ANNUAL("Ежегодная");



    final String TypeOfPurpose;

    TypeOfPurpose(String TypeOfPurpose) {
        this.TypeOfPurpose = TypeOfPurpose;
    }
}
