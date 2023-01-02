package sn.isi.gestEdu.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.gestEdu.entities.AppUserEntity;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    AppUserEntity findByEmail(String email);
}
