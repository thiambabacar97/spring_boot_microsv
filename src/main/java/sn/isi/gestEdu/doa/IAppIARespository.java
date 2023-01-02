package sn.isi.gestEdu.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.gestEdu.entities.AppIAEntity;

public interface IAppIARespository extends JpaRepository<AppIAEntity, Integer>  {
}
