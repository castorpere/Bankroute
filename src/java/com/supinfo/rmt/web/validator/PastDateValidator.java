package com.supinfo.rmt.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 5/2/12
 * Time: 2:41 PM
 */
@FacesValidator(value = "pastDateValidator")
public class PastDateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        Date date = (Date) o;
        if(!date.before(new Date())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date must be in the past.", null));
        }
    }

}
