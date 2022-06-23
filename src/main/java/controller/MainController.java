package controller;

import lombok.extern.slf4j.Slf4j;
import model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping(value = "/java")
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public CompletableFuture<ResponseEntity<String>> saveData(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "dept") String dept,
            @RequestParam(value = "designation") String designation){
        log.info("Inside /save with parameters : " + id + " " + name + " " + dept + " " + designation);
        return userService.saveData(id, name, dept, designation).thenApply(ResponseEntity::ok);
    }

    @PostMapping("/getData")
    public CompletableFuture<ResponseEntity<Response>> getData(
            @RequestParam(value = "id") int id){
        log.info("Inside /getData with parameters : " + id);
        return userService.getData(id).thenApply(ResponseEntity::ok);
    }
}
