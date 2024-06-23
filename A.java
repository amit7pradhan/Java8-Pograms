import java.util.*;
import java.util.stream.*;
/*

01. Filter emp whose has more than 15000 sal 
02. Map emp name in UpperCase and print it. 
03. WAP using flatMap () 
04. Print how many gender are there
05. sort the employee in descending order base on salary 
06. Print 3rd highest salary name of Employee using java 8 - limit(), skip()
07. Print nth highest salary name of Employee using java 8 
08. Print nth lowest salary name of Employee using java 8 
09. Convert the list to array and print it using Stream API 
10. Count no.of employee - count()
11. find max using reduce()
12. find min using reduce()
13. Concat name using reduce()
14. find max salary
15. find min salary
16. find Avg, sum, max & min using summarizing
17. Check if any employee has a salary greater than 15000 
18. Check if all employees are male 
19. Check if no employee has a salary less than 8000
20. find any emp from list 
21. find 1st emp from list
22. Create a HashMap using empid & name like HashMap<id, name> and print the map 
23. group by employee using gender
24. Filter and count genders with more than 4 employees

*/
public class A {
    public static void main(String[] args) {
        
         List<Employee> list = Arrays.asList(
            new Employee (104, "Abhishek", "Male", 14549.0),
            new Employee (106, "Satya", "Male", 12000.0),
            new Employee (108, "Jyoti", "Female", 8004.0),
            new Employee (103, "Pinkun", "Male", 11369.0),
            new Employee (105, "Titan", "Female", 9698.0),
            new Employee (102, "Animesh", "Male", 15998.0),
            new Employee (107, "Rohit", "Female", 13750.0),
            new Employee (101, "Amit", "Male", 18549.0)
                    );

// 01. Filter emp whose has more than 15000 sal 
         var filtered=list.stream().filter(e->e.getSal()>15000).collect(Collectors.toList());
         filtered.forEach(e->System.out.println(e));
         System.out.println("**********************");
// 02. Map emp name in UpperCase and print it. 
         var upperName=list.stream().map(e->e.getName().toUpperCase()).collect(Collectors.toList());
         upperName.forEach(e->System.out.println(e));
         System.out.println("**********************");
// 03. WAP using flatMap () 
         var l1 = Arrays.asList(
            new Employee (104, "Abhishek", "Male", 14549.0),
            new Employee (106, "Satya", "Male", 12000.0),
            new Employee (108, "Jyoti", "Female", 8004.0),
            new Employee (103, "Pinkun", "Male", 11369.0)
                    );         

         var l2 = Arrays.asList(
            new Employee (104, "Abhishek", "Male", 14549.0),
            new Employee (106, "Satya", "Male", 12000.0),
            new Employee (108, "Jyoti", "Female", 8004.0),
            new Employee (103, "Pinkun", "Male", 11369.0)
                    );

         var l3=Arrays.asList(l1,l2);
         var finalList=l3.stream().flatMap(e->e.stream()).collect(Collectors.toList());
         finalList.forEach(e->System.out.println(e));
         System.out.println("**********************");
// 04. Print how many gender are there
         var gender=list.stream().map(e->e.getGender()).distinct().collect(Collectors.toList());
         gender.forEach(e->System.out.println(e));
System.out.println("**********************");
// 05. sort the employee in descending order base on salary 
var sorted=list.stream().sorted(Comparator.comparingDouble(Employee::getSal).reversed()).collect(Collectors.toList());
sorted.forEach(e->System.out.println(e));
System.out.println("**********************");
// 06. Print 3rd highest salary name of Employee using java 8 - limit(), skip()
var rd3=list.stream().sorted(Comparator.comparingDouble(Employee::getSal).reversed()).limit(3).skip(2);
rd3.forEach(e->System.out.println(e));
System.out.println("**********************");
// 07. Print nth highest salary name of Employee using java 8 
int n=2;
var highest=list.stream().sorted(Comparator.comparingDouble(Employee::getSal).reversed()).skip(n-1).findFirst();
System.out.println(highest);
System.out.println("**********************");
// 08. Print nth lowest salary name of Employee using java 8 
var lowest=list.stream().sorted(Comparator.comparingDouble(Employee::getSal)).skip(n-1).findFirst();
System.out.println(lowest);
System.out.println("**********************");
// 09. Convert the list to array and print it using Stream API 
// Using Lambda Expression
Employee[] empArray=list.toArray(e->new Employee[e]);
Stream.of(empArray).forEach(e->System.out.println(e));
System.out.println("**********************");
// Using Method Reference
Employee[] empAray=list.toArray(Employee[]::new);
Stream.of(empAray).forEach(e->System.out.println(e));
System.out.println("**********************");
// 10. Count no.of employee - count()
long count=list.stream().count();
System.out.println("No.of Employee "+count);
System.out.println("**********************");
// 11. find max using reduce()
var maxReduce=list.stream().reduce((e1,e2)->e1.getSal()>e2.getSal()?e1:e2);
System.out.println(maxReduce);
System.out.println("**********************");
// 12. find min using reduce()
    var minReduce=list.stream().reduce((e1,e2)->e1.getSal()<e2.getSal()?e1:e2);
    System.out.println(minReduce);
System.out.println("**********************");
//13. Concat name using reduce()
var concate=list.stream().map(Employee::getName).reduce("",(name1,name2)->name1.isEmpty()?name2:name1+","+name2);
System.out.println(concate);
System.out.println("**********************");
//14. find max salary
var max=list.stream().max(Comparator.comparingDouble(Employee::getSal));
System.out.println(max);
System.out.println("**********************");
//15. find min salary
var min=list.stream().min(Comparator.comparingDouble(Employee::getSal));
System.out.println(min);
System.out.println("**********************");
//16. find Avg, sum, max & min using summarizing
 var summarizing=list.stream().collect(Collectors.summarizingDouble(Employee::getSal));
System.out.println(summarizing);
System.out.println("**********************");
//17. Check if any employee has a salary greater than 15000 
var anymatch=list.stream().anyMatch(e->e.getSal()>15000);
System.out.println(anymatch);
System.out.println("**********************");
//18. Check if all employees are male 
var allmatch=list.stream().allMatch(e->e.getGender().equals("Male"));
System.out.println(allmatch);
System.out.println("**********************");
// 19. Check if no employee has a salary less than 8000
var nonmatch=list.stream().noneMatch(e->e.getSal()<8000);
System.out.println(nonmatch);
System.out.println("**********************");
//20. find any emp from list 
var findany=list.stream().findAny();
System.out.println(findany);
System.out.println("**********************");
//21. find 1st emp from list
var find1st=list.stream().findFirst();
System.out.println(find1st);
System.out.println("**********************");
//22. Create a HashMap using empid & name like HashMap<id, name> and print the map 
var map=list.stream().distinct().collect(Collectors.toMap(Employee::getId,Employee::getName));
map.forEach((id,name)->System.out.println(id+","+name));
System.out.println("**********************");
//23. group by employee using gender
var groupBy=list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
System.out.println(groupBy);
System.out.println("**********************");
//24. Filter and count genders with more than 4 employees
var groupFilter = groupBy.entrySet().stream().filter(e -> e.getValue() > 4).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
groupFilter.forEach((g, c) -> System.out.println(g + "=" + c));
    }   
}
 class Employee{
     private int id;
     private String name;
     private String gender;
     private double sal;
     
    public Employee(int id, String name, String gender, double sal) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.sal = sal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    @Override
    public String toString() {
        return  id + "," + name + "," + gender + "," + sal;
    }
 }