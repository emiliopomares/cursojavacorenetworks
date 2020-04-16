import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Stream;

class Employee {
	public String name;
	public String gender;
	public int age;
	public String dept;

	public Employee(String name, String gender, int age, String dept) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dept = dept;
	}
}

public class Average {
	public static void main(String[] args) throws IOException {

		System.out.println("Getting the average age of R&D employees, functional style... ");

		Path path = Paths.get("./Employees.txt");
		Stream<String> lines = Files.lines(path);
		double averageRDAge = lines
			.map((line) -> { 
				String[] fields = line.split(","); 
				return new Employee(fields[0], fields[1], Integer.parseInt(fields[2]), fields[3]);  
			})
			.filter( (emp) -> emp.dept.equals("R&D") )
			.mapToDouble(emp -> (double)emp.age)
			.average().orElse(0.0);
		System.out.println("Average is " + averageRDAge + ", calculated with a one-liner. Neat, uhu?");
	}
}
