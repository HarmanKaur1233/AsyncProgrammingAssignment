package repository;

import lombok.extern.slf4j.Slf4j;
import model.AuditTable;
import model.Employee;
import model.Response;
import model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Repository
@Slf4j
public class UserRepositoryImpl {
    @Autowired
    private UserRepositoryIn userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AuditableRepository auditableRepository;

    public CompletableFuture<String> saveEmployee(int id, String name, String dept, String designation) {
        try {
            UserData user = new UserData();
            Employee employee = new Employee();
            AuditTable auditTable = new AuditTable();
            user.setUserName(name);
            user.setUserId(id);
            employee.setEmpId(name);
            employee.setEmpName(name);
            employee.setEmpDept(dept);
            employee.setEmpDesignation(designation);
            auditTable.setCreatedBy(name);
            auditTable.setCreatedDate(Date.from(Instant.now()));
            auditTable.setLastModifiedBy(null);
            auditTable.setLastModifiedDate(null);
            userRepository.save(user);
            employeeRepository.save(employee);
            auditableRepository.save(auditTable);
            log.info("Employee saved with id: " + id);
            return CompletableFuture.completedFuture("Save Successful");
        } catch (Exception e) {
            log.error("Could not save employee with id: " + id);
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Save Unsuccessful");
    }

    public CompletableFuture<Response> getEmployee(int id) {
        try{
            UserData user = null;
            Employee employee = null;
            user = userRepository.findOneById(id);
            employee = employeeRepository.findOnById(id);
            Response response = new Response(user, employee);
            log.info("Fetched employee with id: " + id);
            return CompletableFuture.completedFuture(response);
        }catch (Exception e){
            log.error("Could not get employee with id: " + id);
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(null);
    }
}
