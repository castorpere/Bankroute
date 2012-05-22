package com.supinfo.rmt.web.validator;

import com.supinfo.rmt.entity.Employee;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 5/2/12
 * Time: 2:41 PM
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void validate(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        ResourceBundle bundle = getResourceBundle(context);
        String email = (String) o;
        if(!Pattern.matches(EMAIL_PATTERN, email)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString("validations.email.format.summary"), null));
        }
    }

    private ResourceBundle getResourceBundle(FacesContext context) {
        return context.getApplication().getResourceBundle(context, "msg");
    }

}
