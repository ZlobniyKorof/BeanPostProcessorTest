package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * SomeBean.
 *
 * @author Artem_Agafonov
 */
@Component
public class SimpleBean implements TestBeans {

    @Autowired
    private AnotherBean anotherBean;

    public SimpleBean() {
        System.out.println("SimpleBean constructor. message: " + message + getSimpleBeanText());
    }

    private String message;

    public String getMessage() {
        return "Message: " + message + ((anotherBean == null) ? " anotherBean - null" : " anotherBean filled");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getSimpleBeanText() {
        return (anotherBean == null)
                ? ". SimpleBean. anotherBean not setted"
                : ". SimpleBean. anotherBean setted. anotherBean message: " + anotherBean.getMessage();
    }

    @PostConstruct
    public void init() {
        System.out.println("SimpleBean init(). message: " + message + getSimpleBeanText());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SimpleBean destroy(). message: " + message + getSimpleBeanText());
    }
}
