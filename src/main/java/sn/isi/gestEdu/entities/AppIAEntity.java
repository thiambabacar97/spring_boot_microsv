package sn.isi.gestEdu.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppIAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 100)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "app_user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUserEntity user;
}
