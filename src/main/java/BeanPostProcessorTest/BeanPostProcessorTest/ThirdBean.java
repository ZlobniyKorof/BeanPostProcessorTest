package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ThirdBean.
 *
 * @author Artem_Agafonov
 */
@Component
public class ThirdBean implements TestBeans {

    @Autowired
    private SimpleBean simpleBean;

    public ThirdBean() {
        System.out.println("ThirdBean constructor. message: " + message + getSimpleBeanText());
    }

    private String message;

    public String getMessage() {
        return "Message: " + message + getSimpleBeanText();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String getSimpleBeanText() {
        return (simpleBean == null)
                ? ". ThirdBean. simpleBean not setted"
                : ". ThirdBean. simpleBean setted. SomeBean message: " + simpleBean.getMessage();
    }

    @PostConstruct
    public void init() {
        System.out.println("ThirdBean init(). message: " + message + getSimpleBeanText());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ThirdBean destroy(). message: " + message + getSimpleBeanText());
    }
}
