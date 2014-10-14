package action;

import ActionUtil.BaseAction;
import domain.ProjectManager;
import adminService.LoginService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * ProjectManager: Justin
 * Date: 14-4-2
 * test for pull
 */
@ParentPackage("struts-default")
@Namespace("/project")
@Results({@Result(name = "success", location = "/main.jsp"),
        @Result(name = "error", location = "/login.jsp")})
@Action(value = "loginAction")
@Controller
@ExceptionMappings({@ExceptionMapping(exception = "java.lange.RuntimeException", result = "error")})
public class LoginBaseAction extends BaseAction {
    @Resource
    private transient LoginService loginService;
    private ProjectManager projectManager = new ProjectManager();

    @Action(value = "login")
    /*
    provide two methods two visit action
    1.if this class have a @Action ,we can visit this action with /projectManager/loginAction!login.action (we have to set DynamicMethodInvocation to true)
    2.we can also visit this action with /use/login.action
     */
    public String login() throws Exception {
        if (loginService.validateLoginInfo(projectManager)) {
            debug("Login Success");
            return SUCCESS;
        } else {
            debug("Login Fail");
            return ERROR;
        }
    }

    /*
    only one way to visit this action /projectManager/loginAction!method.action  (we have to set DynamicMethodInvocation to true)
     */
    public String method() {
        return "ERROR";
    }

    /*
    1.use the dynamic method to visit this action
    2.use the /different/url.action to visit
     */
    @Action("/different/url")
    public String method2() {
        return "ERROR";
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}
