import java.util.ArrayList;
import java.util.List;

public class Person {
        String name;
        String birthDate;
        String gender;
        List<Person> children;
        Person spouse;

        public Person(String name, String birthDate, String gender) {
            this.name = name;
            this.birthDate = birthDate;
            this.gender = gender;
            this.children = new ArrayList<>();
            this.spouse = null;
        }

        public void addChild(Person child) {
            children.add(child);
        }

        public void addSpouse(Person spouse) {
            this.spouse = spouse;
        }
}
