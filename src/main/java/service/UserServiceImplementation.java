package service;

import lombok.extern.slf4j.Slf4j;
import model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Override
    @Async
    public CompletableFuture<String> saveData(int empId, String empName, String empDept, String designation) {
        log.debug("Inside UserServiceImp.saveData with : " + empId + " " + empName + " " + empDept + " " + designation);
        return userServiceImplementation.saveData(empId, empName, empDept, designation);
    }

    @Override
    @Async
    public CompletableFuture<Response> getData(int id) {
        log.debug("Inside UserServiceImp.getData with : " + id);
        return userServiceImplementation.getData(id);
    }
}
