package adminService;

import Log.Dumpable;
import domain.ProjectManager;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Justin
 * Date: 14-4-2
 */
@Service
public class LoginService extends Dumpable {
    // I saw some codes extending hibernateDaoSupport to operate data base , I do not understand why not use hibernateTemplate class directly ？
    // HibernateTemplate hibernateTemplate = hibernateDaoSupport.getHibernateTemplate();
    @Resource
    private transient HibernateTemplate hibernateTemplate;

    public boolean validateLoginInfo(ProjectManager projectManager) {
        ProjectManager managerFromDateBase = getProjectManagerByUserName(projectManager.getUserName());
        return managerFromDateBase != null && managerFromDateBase.getPassWard().equals(projectManager.getPassWard());
    }

    private ProjectManager getProjectManagerByUserName(String userName) {
        @SuppressWarnings("unchecked")
        List<ProjectManager> managerList = (List<ProjectManager>) hibernateTemplate.findByNamedQueryAndNamedParam("manager.getManagerByName", "userName", userName);
        if (managerList == null || managerList.isEmpty()) {
            info("user is not found");
            return null;

        } else {
            info(this.getClass().toString() + "user found");
            return managerList.get(0);
        }
    }
}
