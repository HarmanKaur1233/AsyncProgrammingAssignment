package service;

import lombok.extern.slf4j.Slf4j;
import model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeServiceImplementation employeeServiceImplementation;

    @Override
    @Async
    public CompletableFuture<String> saveEmployee(int empId, String empName, String empDept, String designation) {
        log.info("Inside saveEmployee with : " + empId + " " + empName + " " + empDept + " " + designation);
        return employeeServiceImplementation.saveEmployee(empId, empName, empDept, designation);
    }

    @Override
    @Async
    public CompletableFuture<Response> getEmployee(int id) {
        log.info("Inside getEmployee with : " + id);
        return employeeServiceImplementation.getEmployee(id);
    }
}
