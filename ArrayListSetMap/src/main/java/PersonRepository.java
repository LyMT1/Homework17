import java.util.*;

public class PersonRepository {
    public void countPersonByNationality(List<Person> persons) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < persons.size(); i++) {
            if (!map.containsKey(persons.get(i).nationality)) {
                map.put(persons.get(i).nationality, 1);
            } else {
                int count = map.get(persons.get(i).nationality);
                count++;
                map.put(persons.get(i).nationality, count);
            }
        }
        for (String name : map.keySet()) {
            String key = name.toString();
            String value = map.get(name).toString();
            System.out.println(key + " - " + value);
        }
    }

    public void sortPersonAgeBiggerThan25y(List<Person> persons) {
        List<Person> sortedList = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() > 25) {
                sortedList.add(person);
            }
        }
        sortedList.sort(Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge));
        for (Person person : sortedList) {
            System.out.println(person);
        }
    }

    public void averageAgeByNationality(List<Person> persons) {
        Map<String, List<Integer>> map = groupAgeByCountry(persons);
        Map<String, Double> maps = new HashMap<>();
        for (String key : map.keySet()) {
            List<Integer> values = map.get(key);
            int sum = 0;
            for (Integer age : values) {
                sum += age;
            }
            double averageAge = (double) sum / values.size();
            double value = Math.floor(averageAge * 10) / 10;
            maps.put(key, value);
        }
        for (String key : maps.keySet()) {
            System.out.println(key + " - " + maps.get(key));
        }
    }

    private Map<String, List<Integer>> groupAgeByCountry(List<Person> persons) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (Person person : persons) {
            String key = person.getNationality();
            List<Integer> values = new ArrayList<>();
            if (!map.containsKey(key)) {
                values.add(person.getAge());
                map.put(key, values);
            } else {
                values = map.get(key);
                values.add(person.getAge());
            }
        }
        return map;
    }

    public void ratingByAge(List<Person> persons) {
        Map<Person, String> map = new HashMap<>();
        for (Person person : persons) {
            int age = person.getAge();
            if (age < 20) {
                map.put(person, "nổi loạn");
            } else if (age >= 20 && age <= 30) {
                map.put(person, "việc làm");
            } else if (age >= 31 && age <= 40) {
                map.put(person, "sự nghiệp");
            } else {
                map.put(person, "hưởng thụ");
            }
        }
        map.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
