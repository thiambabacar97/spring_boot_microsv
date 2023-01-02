package sn.groupeisi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.gestEdu.dto.AppUser;
import sn.isi.gestEdu.service.AppUserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;

    @Test
    void getAppUsers() {
        List<AppUser> appUserList =
                appUserService.fechAll();

        Assertions.assertEquals(1, appUserList.size());
    }

    @Test
    void createUser() {
        AppUser appUser = new AppUser();
        appUser.setNom("Sarr");
        appUser.setPrenom("Sokhna Aicha");
        appUser.setEmail("s.sarr@gmail.com");
        appUser.setEtat(1);
        appUser.setPassword("Passer123");

        AppUser appUsersSave = appUserService.create(appUser);
        Assertions.assertNotNull(appUsersSave);
    }


    @Test
    void getAppRole() {
        AppUser appUser = appUserService.getAppUser(1);
        Assertions.assertNotNull(appUser);
    }

    @Test
    void updateAppRoles() {
        AppUser appUser = new AppUser();
        appUser.setNom("Thiam");
        appUser.setPrenom("Babacar");
        appUser.setEmail("b.thiam@gmail.com");
        appUser.setEtat(1);
        appUser.setPassword("Passer123");

        AppUser appUsersSave = appUserService.updateAppUser(1, appUser);

        Assertions.assertEquals("Users", appUsersSave.getNom());

    }

    @Test
    void deleteAppRoles() {
        appUserService.deleteAppUser(1);
        Assertions.assertTrue(true);
    }
}
