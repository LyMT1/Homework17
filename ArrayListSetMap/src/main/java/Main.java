import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<Person> people = new ArrayList<Person>(Arrays.asList(
                new Person("Vinh", "Vietnam", 28),
                new Person("Lan", "Vietnam", 24),
                new Person("John", "USA", 27),
                new Person("Lee", "China", 67),
                new Person("Kim", "Korea", 22),
                new Person("Long", "Vietnam", 18),
                new Person("Jungho", "Korea", 19),
                new Person("Tian", "China", 20),
                new Person("Clara", "USA", 40),
                new Person("Mikura", "Japan", 27),
                new Person("Sony", "Japan", 29),
                new Person("Xiang", "China", 78),
                new Person("Peter", "France", 18),
                new Person("Haloy", "Malaysia", 20),
                new Person("Magie", "Malaysia", 32)
        ));
        PersonRepository peoPle = new PersonRepository();
        System.out.println("1.1 Đếm số người theo từng quốc tịch in ra màn hình");
        peoPle.countPersonByNationality(people);

        System.out.println("\n1.2 Sắp xếp theo tên những người trên 25 tuổi rồi in ra màn hình");
        peoPle.sortPersonAgeBiggerThan25y(people);

        System.out.println("\n1.3 Tính trung bình tuổi của người theo từng quốc gia");
        peoPle.averageAgeByNationality(people);

        System.out.println("\n1.4 In ra màn hình đánh giá tuổi mỗi người");
        System.out.println("\n" +
                "* < 20 tuổi: nổi loạn\n" +
                "* 20 đến 30 tuổi: việc làm\n" +
                "* 31 đến 40 tuổi: sự nghiệp\n" +
                "* 41 trở lên: hưởng thụ\n");
        peoPle.ratingByAge(people);
    }
}