package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * AnotherBean.
 *
 * @author Artem_Agafonov
 */
@Component
public class AnotherBean implements TestBeans {

    SimpleBean simpleBean;

    public AnotherBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
        System.out.println("AnotherBean constructor. with someBean" + getSimpleBeanText());
        simpleBean.setMessage("Message setted to SimpleBean from Another bean Constructor");
        setMessage("Message from AnotherBean constructor");
    }

    private String message;

    public String getMessage() {
        return "AnotherBean Message: " + message + getSimpleBeanText();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getSimpleBeanText() {
        return (simpleBean == null)
                ? ". AnotherBean. simpleBean not setted"
                : ". AnotherBean. simpleBean setted. simpleBean message: " + simpleBean.getMessage();
    }

    @PostConstruct
    public void init() {
        System.out.println("AnotherBean init(). message: " + message + getSimpleBeanText());
        setMessage("Message from AnotherBean init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AnotherBean destroy(). message: " + message + getSimpleBeanText());
        setMessage("Message from AnotherBean destroy()");
    }
}
