import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String[] data) throws IllegalArgumentException {
        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество данных");
        }

        this.lastName = data[0];
        this.firstName = data[1];
        this.middleName = data[2];

        try {
            this.birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        try {
            this.phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }

        if (data[5].length() != 1 || (!data[5].equalsIgnoreCase("f") &&
                !data[5].equalsIgnoreCase("m"))) {
            throw new IllegalArgumentException("Неверный формат пола");
        }
        this.gender = data[5].charAt(0);
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c", lastName, firstName, middleName,
                birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), phoneNumber, gender);
    }
}
