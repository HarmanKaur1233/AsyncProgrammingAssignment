package service;

import model.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface UserService {
    CompletableFuture<String> saveData(int empId, String empName, String empDept, String designation);
    CompletableFuture<Response> getData(int empId);

}
