/*Задание №3
1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно
использовать не все придуманные поля и методы. Создайте несколько
экземпляров этого класса, выведите их в консоль.
2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась
его кличка, цвет и возраст (или другие параметры на ваше усмотрение). */

/*Задание №4
1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>.
Поместите в него некоторое количество объектов.
2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество.
Убедитесь, что все они сохранились во множество.
3. Создайте метод public boolean equals(Object o)
Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод
должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
4. Создайте метод public int hashCode()
который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать
Objects.hash(...))
5. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились. */

package Seminari.Seminar06.Task0304;

import java.util.Objects;

    public class Cat {
        private String name;
        private int birthYear;
        private String color;
        private String owner;
    
        public Cat (String name, int birthYear, String color, String owner) {
            this.name = name;
            this.birthYear = birthYear;
            this.color = color;
            this.owner = owner;
        }
    
        public String getName(){
            return name;
        }
    
        public int getBirthYear(){
            return birthYear;
        }
    
        public String getColor(){
            return color;
        }
    
        public String getOwner(){
            return owner;
        }
    
        public void setName(String name){
            this.name = name;
        }
    
        public void setBirthYear(int birthYear){
            this.birthYear = birthYear;
        }
    
        public void setColor(String color){
            this.color = color;
        }
    
        public void setOwner(String owner){
            this.owner = owner;
        }
    
        @Override
        public String toString() {
            String result = "Name: " + name + System.lineSeparator()
             + "Birth year: " + birthYear + System.lineSeparator()
             + "Color: " + color + System.lineSeparator()
             + "Owner: " + owner;
     
            return result;
        }
    
        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;

            if(obj == null || getClass() != obj.getClass()) return false;

            Cat cat = (Cat) obj;

            return name.equals(cat.name) && birthYear == cat.birthYear 
            && color.equals(cat.color) && owner.equals(cat.owner);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, birthYear, color, owner);
        }
    }