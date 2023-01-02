package sn.isi.gestEdu.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.isi.gestEdu.dto.AppRoles;
import sn.isi.gestEdu.service.AppRolesService;
import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class AppRolesController {
    private AppRolesService appRolesService;

    @GetMapping
    public List<AppRoles> getAppRoles() {
        return appRolesService.getAppRoles();
    }

    @GetMapping("/{id}")
    public AppRoles getAppRoles(@PathVariable("id") int id) {
        return appRolesService.getAppRole(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRoles createAppRoles(@Validated @RequestBody AppRoles appRoles) {
        return appRolesService.createAppRoles(appRoles);
    }

    @PutMapping("/{id}")
    public AppRoles updateAppRoles(@PathVariable("id") int id, @Validated @RequestBody AppRoles appRoles) {
        return appRolesService.updateAppRoles(id, appRoles);
    }

    @DeleteMapping("/{id}")
    public void deleteAppRoles(@PathVariable("id") int id) {
        appRolesService.deleteAppRoles(id);
    }
}
