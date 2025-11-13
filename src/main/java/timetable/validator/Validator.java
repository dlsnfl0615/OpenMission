package timetable.validator;

public class Validator {
    private Validator() {

    }

    public static boolean containsOnlyCommaHyphen(String inputLectures) {
        // 쉼표와 하이픈만 허용
        return inputLectures.matches("^[a-zA-z0-9,-]+$");
    }
}
