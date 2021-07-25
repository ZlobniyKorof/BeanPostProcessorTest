package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
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
public class SimpleBean implements TestBeans, InitializingBean, DisposableBean {

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
    public void preDestroy() {
        System.out.println("SimpleBean preDestroy(). message: " + message + getSimpleBeanText());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SimpleBean afterPropertiesSet(). message: " + message + getSimpleBeanText());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SimpleBean destroy(). message: " + message + getSimpleBeanText());

    }
}
