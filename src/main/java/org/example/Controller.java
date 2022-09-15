package org.example;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/home/{data}")
    protected ResponseEntity<Integer> getResource(@PathVariable String data) throws ParseException {
        ArrayList<Integer> list = Service.parseJson(data);
        return new ResponseEntity<>(Service.run(list), HttpStatus.OK);
    }
}
