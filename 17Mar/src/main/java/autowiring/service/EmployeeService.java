package autowiring.service;


import java.util.Map;

import autowiring.repository.Employee;

public interface EmployeeService {

    Employee getEmployeeById(int id);

    Map<Integer, Employee> getAllEmployees();

    void createEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void deleteEmployee(int id);
}