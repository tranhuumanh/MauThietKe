import java.util.*;

public class GenealogyTree {

    public static List<Person> findUnmarriedPeople(Person person) {
        List<Person> unmarriedPeople = new ArrayList<>();
        if (person.spouse == null) {
            unmarriedPeople.add(person);
        }
        for (Person child : person.children) {
            unmarriedPeople.addAll(findUnmarriedPeople(child));
        }
        return unmarriedPeople;
    }

    public static List<Map.Entry<Person, Person>> findCouplesWithTwoChildren(Person person) {
        List<Map.Entry<Person, Person>> couples = new ArrayList<>();
        if (person.spouse != null && person.children.size() == 2) {
            couples.add(new AbstractMap.SimpleEntry<>(person, person.spouse));
        }
        for (Person child : person.children) {
            couples.addAll(findCouplesWithTwoChildren(child));
        }
        return couples;
    }

    public static Set<Person> findLatestGeneration(Person person) {
        Set<Person> latestGeneration = new HashSet<>();
        if (person.children.isEmpty()) {
            latestGeneration.add(person);
        } else {
            for (Person child : person.children) {
                latestGeneration.addAll(findLatestGeneration(child));
            }
        }
        return latestGeneration;
}
    public static Set<Person> findLatestGenerationRecursive(Person person) {
        Set<Person> latestGeneration = new HashSet<>();
        if (person.children.isEmpty()) {
            latestGeneration.add(person);
        } else {
            for (Person child : person.children) {
                latestGeneration.addAll(findLatestGenerationRecursive(child));
            }
        }
        return latestGeneration;
    }

    public static void main(String[] args) {
        Person james = new Person("James", "01/01/1970", "Male");
        Person hana = new Person("Hana", "05/05/1975", "Female");
        Person ryan = new Person("Ryan", "10/10/1995", "Male");
        Person kai = new Person("Kai", "15/03/1998", "Male");
        Person jennifer = new Person("Jennifer", "20/08/2000", "Female");
        james.addSpouse(hana);
        james.addChild(ryan);
        james.addChild(kai);
        kai.addSpouse(jennifer);

        List<Person> unmarriedPeople = findUnmarriedPeople(james);
        System.out.println("Các cá nhân không kết hôn:");
        for (Person person : unmarriedPeople) {
            System.out.println(person.name);
        }
        List<Map.Entry<Person, Person>> couplesWithTwoChildren = findCouplesWithTwoChildren(james);
        System.out.println("\nCác cặp vợ chồng có hai con:");
        for (Map.Entry<Person, Person> couple : couplesWithTwoChildren) {
            System.out.println(couple.getKey().name + " - " + couple.getValue().name);
        }
        Set<Person> latestGeneration = findLatestGeneration(james);
        System.out.println("\nThế hệ mới nhất:");
        for (Person person : latestGeneration) {
            System.out.println(person.name);
        }
    }
}
