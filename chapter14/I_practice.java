package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private double salary;
}
public class I_practice {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("IT", "아무재", 5000),
                new Employee("HR", "아무배", 6000),
                new Employee("IT", "아무개", 7000),
                new Employee("Finance", "아무새", 8000)
        );

        // 1. 급여가 6000 이상인 직원 필터링
        List<Employee> salaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() >= 6000)
                .collect(Collectors.toList());

        System.out.println("급여가 6000 이상인 직원은: ");
        salaryEmployees.forEach(System.out::println);
/*      Employee(department=HR, name=아무배, salary=6000.0)`
        Employee(department=IT, name=아무개, salary=7000.0)
        Employee(department=Finance, name=아무개, salary=8000.0)`
*/
        // 2. IT 부서 직원의 이름만 추출
        List<String > employeesDepartment = employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toList());

                System.out.println("부서가 'IT' 인 직원은: ");
        employeesDepartment.forEach(System.out::println);
//      아무재, 아무개

//      3. 특정 부서(Finance) 직원 중 이름에 '새'가 포함된 직원 필터링
        List<Employee> employeesName = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Finance"))
                .filter(employee -> employee.getName().contains("새"))
                .collect(Collectors.toList());

        System.out.println("Finance 직원 중 이름에 '새'가 포함된 직원은: ");
        employeesName.forEach(System.out::println);
//      Employee(department=Finance, name=아무새, salary=8000.0)

//      4. 부서별 직원 그룹화
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("부서별 직원 그룹화: ");
        System.out.println(employeesByDept);

//      5. 부서별 평균 급여 계산
        Map<String, Double> average = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(average);  // {Finance=8000.0, HR=6000.0, IT=6000.0}


    }


}
