import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStream {
    public static void main (String[] args) {
        //arraylistFilter();
        //streamFilter();
        //streamMap();
        //streamMerge();
        //streamMatch();
        streamCollect();
    }
    public static void arraylistFilter() {
        //Array type list use to store names and count names that start's with "A"
        ArrayList<String> userNames = new ArrayList<>();
        userNames.add("Udit");
        userNames.add("Rahul");
        userNames.add("Ankit");
        userNames.add("Ankur");
        int counter = 0;
        for (int i=0; i<userNames.size(); i++) {
            String userName = userNames.get(i);
            if (userName.startsWith("A")) {
                counter++;
            }
        }
        //OR
        //long counter = userNames.stream().filter(name->name.startsWith("A")).count();
        System.out.println("Total number of names that start with 'A' is " + counter);
    }
    public static void streamFilter () {
        //Java Stream use to store names and count names that start's with "A"
        long counter = Stream.of("Udit","Rahul","Ankit","Ankur").filter(name->name.startsWith("A")).count();
        System.out.println("Total number of names that start with 'A' is " + counter);

        //Java Stream use to filter all the names that are less than 5
        Stream.of("Udit","Rahul","Ankit","Ankur").filter(name->name.length()<5).forEach(name->System.out.println(name));
    }
    public static void streamMap () {
        //Java Stream use to filter all the names that ends with "t" and convert to uppercase
        Stream.of("Udit","Rahul","Ankit","Ankur").filter(name->name.endsWith("t")).map(name->name.toUpperCase()).forEach(name-> System.out.println(name));

        //Converting arrays to array list so that Stream methods can be used
        List<String> names = Arrays.asList("Udit","Rahul","Ankur","Ankit");

        //Java Stream use to filter names that start with "A" in uppercase and sorted
        names.stream().filter(name->name.startsWith("A")).sorted().map(name->name.toUpperCase()).forEach(name-> System.out.println(name));
    }
    public static void streamMerge () {
        //String type array list
        ArrayList<String> userNames = new ArrayList<String>();
        userNames.add("Udit");
        userNames.add("Rahul");
        userNames.add("Ankit");
        userNames.add("Ankur");
        //String type stream
        Stream<String> names = Stream.of("Kumar","Sharma","Gupta","Kapoor");

        //Merging or concatenating two strings or streams
        Stream<String> fullNames = Stream.concat(userNames.stream(), names);
        fullNames.sorted().forEach(name-> System.out.println(name));
    }
    public static void streamMatch () {
        ArrayList<String> userNames = new ArrayList<String>();
        userNames.add("Udit");
        userNames.add("Rahul");
        userNames.add("Ankit");
        userNames.add("Ankur");
        //Checking whether a stream or string is present in a list or stream
        boolean flag = userNames.stream().anyMatch(name->name.equalsIgnoreCase("Udit"));
        System.out.println(flag);
    }
    public static void streamCollect () {
        //Converting stream to list
        Stream<String> streamNames = Stream.of("Udit","Rahul","Ankur","Ankit","Sourav");
        List<String> listNames = streamNames.toList();

        //Print all the names in list
        System.out.println(listNames);

        //Print only the second name from list
        System.out.println(listNames.get(1));

        //Print only the first name from stream
        Stream<String> newStreamNames = Stream.of("Pragya","Monika","Ketty","Angel","Rimmy");
        newStreamNames.limit(1).forEach(name-> System.out.println(name));

        List<Integer> numbers = Arrays.asList(4,5,6,2,3,8,6,9,6,0,1,2);
        //Print unique numbers from list of integers
        numbers.stream().distinct().forEach(number-> System.out.println("Unique numbers from list of integers " + number));

        //Print unique and sorted numbers from list of integers
        numbers.stream().distinct().sorted().forEach(name-> System.out.println("Unique and sorted numbers from list of integers " + name));

        //Print unique, sorted and third index numbers from list of integers
        List<Integer> number = numbers.stream().distinct().sorted().toList();
        System.out.println("Unique, sorted and third index numbers from list of integers: " + number.get(2));
    }
}