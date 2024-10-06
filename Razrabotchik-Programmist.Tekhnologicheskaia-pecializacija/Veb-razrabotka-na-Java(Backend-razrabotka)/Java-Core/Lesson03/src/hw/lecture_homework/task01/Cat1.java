/*
Написать класс кота (из лекции) так, чтобы каждому объекту кота
присваивался личный порядковый целочисленный номер.
 */
package hw.lecture_homework.task01;

import java.time.LocalDate;
import java.time.Period;

/**
 * Класс, представляющий модель кота.
 * Каждый объект класса Cat имеет уникальный идентификатор, имя, цвет и дату рождения.
 * Класс позволяет узнать возраст кота, а также выполнять базовые действия, такие как голос и прыжок.
 */
public class Cat1 {

    /**
     * Статическое поле, которое задаёт количество лап у всех котов.
     */
    static int pawsCount = 4;

    /**
     * Статическое поле для автоматического присвоения уникальных идентификаторов объектам класса.
     * Каждый новый объект Cat получает уникальный идентификатор на основе этого счётчика.
     */
    private static int counter = 0;

    /**
     * Уникальный идентификатор каждого кота.
     * Присваивается автоматически при создании нового объекта.
     */
    private int id;

    /**
     * Имя кота.
     * Не может быть null или пустым.
     */
    private String name;

    /**
     * Цвет шерсти кота.
     * Не может быть null или пустым.
     */
    private String color;

    /**
     * Дата рождения кота.
     * Может быть null, если дата рождения неизвестна.
     */
    private LocalDate birthDate;

    /**
     * Конструктор, создающий объект Cat с указанием имени, цвета и даты рождения.
     *
     * @param name      имя кота, не может быть null или пустым
     * @param color     цвет кота, не может быть null или пустым
     * @param birthDate дата рождения кота, может быть null
     * @throws IllegalArgumentException если имя или цвет пусты, или равны null
     */
    public Cat1(String name, String color, LocalDate birthDate) {
        this(name, color); // Вызов второго конструктора для инициализации имени и цвета
        this.birthDate = birthDate;
    }

    /**
     * Конструктор, создающий объект Cat с указанием только имени и цвета.
     * Поле даты рождения можно добавить позднее.
     *
     * @param name  имя кота, не может быть null или пустым
     * @param color цвет кота, не может быть null или пустым
     * @throws IllegalArgumentException если имя или цвет пусты, или равны null
     */
    public Cat1(String name, String color) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        this.name = name;
        this.color = color;
        this.id = counter++; // Присваиваем уникальный ID на основе счётчика
    }

    /**
     * Метод, который выводит в консоль звук, который издаёт кот.
     * Пример: "Barsik meows".
     */
    public void voice() {
        System.out.println(name + " meows");
    }

    /**
     * Метод, позволяющий коту прыгать, если ему меньше 5 лет.
     * Если кот старше 5 лет, выводится сообщение о том, что кот слишком стар для прыжков.
     */
    public void jump() {
        if (this.getAge() < 5) {
            System.out.println(name + " jumps");
        } else {
            System.out.println("This cat cannot jump due to his age");
        }
    }

    /**
     * Метод для вычисления возраста кота в годах на основе текущей даты и даты рождения.
     * Если дата рождения не указана или она неверна (будущая дата), возраст считается равным 0.
     *
     * @return возраст кота в годах или 0, если дата рождения неизвестна или некорректна
     */
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate.isAfter(birthDate))) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0; // Если дата рождения не установлена или неверная
        }
    }

    /**
     * Переопределённый метод toString(), который возвращает строковое представление объекта Cat.
     * В строку включены ID, имя, возраст и цвет кота.
     *
     * @return строковое представление кота в формате:
     *         "ID: <id>
     *         Name: <name>
     *         Age: <age>
     *         Color: <color>"
     */
    @Override
    public String toString() {
        return String.format("ID: %d\nName: %s\nAge: %d\nColor: %s", id, name, getAge(), color);
    }

    /**
     * Статический метод для получения количества лап у всех котов.
     *
     * @return количество лап, всегда равно 4
     */
    public static int getPawsCount() {
        return pawsCount;
    }

    /**
     * Переопределённый метод equals(), который сравнивает два объекта Cat.
     * Объекты считаются равными, если совпадают их идентификаторы, имена, цвета и даты рождения.
     *
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cat1 cat = (Cat1) obj;
        return id == cat.id &&
                name.equals(cat.name) &&
                color.equals(cat.color) &&
                (birthDate != null ? birthDate.equals(cat.birthDate) : cat.birthDate == null);
    }

    /**
     * Переопределённый метод hashCode(), который возвращает хэш-код объекта Cat.
     * Используется для эффективного размещения объектов в коллекциях, таких как HashMap или HashSet.
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }
}
