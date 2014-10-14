package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * user: Justin
 * Date: 14-4-2
 */
@Entity
@Table(name = "projectManager")
@NamedQueries({@NamedQuery(name = "manager.getManagerByName", query = "select p from ProjectManager p where p.userName=:userName")})
public class ProjectManager implements Serializable {
    private Long id;
    private String userName;
    private String passWard;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWard() {
        return passWard;
    }

    public void setPassWard(String passWard) {
        this.passWard = passWard;
    }

}
