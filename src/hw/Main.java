package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    //Задача1
    //Есть класс Person с полями
    //String name
    //int age
    //String address
    //
    //Используя стримы, написать метод, принимающий список персонов и возвращающий мапу,
    // где возраст является ключом, а список персонов этого возраста значением

    /*Задача2
Используя тот же класс Person, написать метод, принимающий список персонов
 и возвращающий общий возраст тех, кто старше 17 лет.*/
    /*Задача 3
Написать метод, принимающий список персонов и возвращающий имена тех, кто является совершеннолетним
 в Германии (старше 18 лет). Должна быть возвращена примерно следующая строка: in Germany Jack and John
  are of legal age (имена по вашему выбору, это пример)*/


    public static void main(String[] args) {
Person person=new Person("Mike",34,"Berlin");
        Person person1=new Person("Linn",34,"Berlin");
        Person person2=new Person("Neo",34,"Leipzig");
        Person person3=new Person("Jack",15,"Paris");
        List<Person> persons=new ArrayList<>();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        System.out.println(sorted(persons));
        //{15=[Jack 15 Paris], 34=[Mike 34 Berlin, Linn 34 Berlin, Neo 34 Leipzig]}

        System.out.println(sum(persons));
        //102

        System.out.println(legalAge(persons));
       // in Germany[Mike 34 Berlin, Linn 34 Berlin, Neo 34 Leipzig] are of legal age


    }

public static Map<Integer, List<Person>> sorted(List<Person>persons){
    return persons.stream()
            .collect(Collectors.groupingBy(Person::getAge));
}
public static int sum(List<Person>persons){
        return persons.stream()
                .filter(p -> p.getAge()>17)
                .collect(Collectors.summingInt(Person::getAge));
}
public static String legalAge(List<Person>persons){
   Map<Boolean,List<Person>> la= persons.stream()
           .collect(Collectors.partitioningBy(p->p.getAge()>18));
   String result="in Germany"+la.get(true)+" are of legal age ";

return result;

}
}
