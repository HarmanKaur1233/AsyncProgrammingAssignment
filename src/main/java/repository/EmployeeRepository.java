package repository;

import model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Transactional
    @Query(nativeQuery = true, value = "select * from employee where user_id = ?1")
    Employee findOnById(int id);
}
