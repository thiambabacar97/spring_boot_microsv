package sn.isi.gestEdu.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.isi.gestEdu.dto.AppIA;
import sn.isi.gestEdu.service.AppIAService;

import java.util.List;

@RestController
@RequestMapping("/ia")
@AllArgsConstructor
public class AppIAController {
    private AppIAService appIAService;

    @GetMapping
    public List<AppIA> fechAll() {
        return appIAService.fechAll();
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppIA create(@Validated @RequestBody AppIA appIA) {
        return appIAService.create(appIA);
    }
}
