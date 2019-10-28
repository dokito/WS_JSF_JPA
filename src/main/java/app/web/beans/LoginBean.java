package app.web.beans;

import app.domain.models.binding.UserLoginBindingModel;
import app.domain.models.service.UserServiceModel;
import app.service.UserService;
import jdk.jfr.Name;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class LoginBean extends BaseBean {

    private UserLoginBindingModel userLoginBindingModel;
    private UserService userService;

    public LoginBean() {
    }

    @Inject
    public LoginBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        this.userLoginBindingModel = new UserLoginBindingModel();
    }

    public void login() {
        UserServiceModel user = this.userService
                .findUserByUandP(this.userLoginBindingModel.getUsername(), DigestUtils.sha256Hex(this.userLoginBindingModel.getPassword()));

        if (user == null){
            this.redirect("/login");
        }

        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap();
        sessionMap.put("username", user.getUsername());
        this.redirect("/home");
    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }
}
