package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    String empId;
    String empName;
    String empDept;
    String empDesignation;
}
