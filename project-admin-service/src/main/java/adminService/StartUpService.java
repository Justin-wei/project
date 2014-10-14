package adminService;

import Log.Dumpable;
import domain.ProjectManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Justin on 2014/7/16.
 */
//if you want to use @Configuration annotation , you have to import cglib
@Configuration
public class StartUpService extends Dumpable {
    @Resource
    private transient HibernateTemplate hibernateTemplate;

    @PostConstruct
    public void initLoginInfo() {
        //TODO password will be encrypted in the future
        if (hibernateTemplate.findByNamedQueryAndNamedParam("manager.getManagerByName", "userName", "super").size() == 0) {
            ProjectManager projectManager = new ProjectManager();
            projectManager.setUserName("super");
            projectManager.setPassWard("super");
            hibernateTemplate.save(projectManager);
            info("super user is saved in database");
        }
    }
}
