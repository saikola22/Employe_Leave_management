import model.Employee;
import dao.EmployeeDAO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Join Date (YYYY-MM-DD): ");
        String joinDate = sc.nextLine();

        Employee emp = new Employee(name, email, dept, joinDate);
        dao.addEmployee(emp);

        System.out.println("Employee added successfully!");
    }
}
