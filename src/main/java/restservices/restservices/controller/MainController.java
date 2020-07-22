package restservices.restservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restservices.restservices.service.MainService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = { "http://localhost:8081" })
public class MainController {
    
    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @GetMapping()
    public String hi() {
        return "hi";
    }

    @GetMapping("/{value}")
    public String getMonthName(@PathVariable(name = "value") int value) {
        return service.getMonthName(value);
    }

    @PostMapping()
    public List<String> sortLines(@RequestBody List<String> data) {
        return service.sortLines(data);
    }
}