package controller;

import lombok.extern.slf4j.Slf4j;
import model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/save")
    public CompletableFuture<ResponseEntity<String>> saveEmployee(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "dept") String dept,
            @RequestParam(value = "designation") String designation){
        log.info("Inside saveEmployee with id: " + id + ", name: " + name + ", department: " + dept + ", designation: " + designation);
        return employeeService.saveEmployee(id, name, dept, designation).thenApply(ResponseEntity::ok);
    }

    @PostMapping("/getData")
    public CompletableFuture<ResponseEntity<Response>> getEmployee(
            @RequestParam(value = "id") int id){
        log.info("Inside getEmployee with id : " + id);
        return employeeService.getEmployee(id).thenApply(ResponseEntity::ok);
    }
}
