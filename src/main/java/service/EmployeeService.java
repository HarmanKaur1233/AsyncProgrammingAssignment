package service;

import model.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface EmployeeService {
    CompletableFuture<String> saveEmployee(int empId, String empName, String empDept, String designation);
    CompletableFuture<Response> getEmployee(int empId);

}
