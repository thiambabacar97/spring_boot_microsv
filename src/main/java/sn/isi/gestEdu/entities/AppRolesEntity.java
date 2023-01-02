package sn.isi.gestEdu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 100)
    private String nom;
    @ManyToMany(mappedBy = "appRoleEntities")
    private List<AppUserEntity> appUserEntity;
}
