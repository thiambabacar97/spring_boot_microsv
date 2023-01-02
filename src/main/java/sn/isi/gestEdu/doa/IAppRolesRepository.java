package sn.isi.gestEdu.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.gestEdu.entities.AppRolesEntity;

public interface IAppRolesRepository extends JpaRepository<AppRolesEntity, Integer> {
}
