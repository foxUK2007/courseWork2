package TaskBook;

public enum TypeOfPurpose {
    PERSONAL_TASK("\"личная\""),
    WORK_TASK("\"рабочая\"");

    private final String typeOfPurpose;

    TypeOfPurpose(String typeOfPurpose) {
        this.typeOfPurpose = typeOfPurpose;
    }

    public String getTypeOfPurpose() {
        return typeOfPurpose;
    }


    @Override
    public String toString() {
        return "Тип задачи: " + typeOfPurpose;
    }
}
