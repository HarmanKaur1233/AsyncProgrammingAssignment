package repository;

import model.AuditTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditableRepository extends JpaRepository<AuditTable, Integer> {
}
