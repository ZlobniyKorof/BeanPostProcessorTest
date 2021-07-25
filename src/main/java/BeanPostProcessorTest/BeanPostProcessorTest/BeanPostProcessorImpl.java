package BeanPostProcessorTest.BeanPostProcessorTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * BeanPostProcessorImpl.
 *
 * @author Artem_Agafonov
 */
@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {

    List<String> beanNames = Arrays.asList("simpleBean", "anotherBean");

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanNames.contains(beanName)) {
            TestBeans testBean = (TestBeans) bean;
            System.out.println("postProcessBeforeInitialization method called for: "
                    + beanName.toUpperCase() + ". current setted message: " + testBean.getMessage());
            testBean.setMessage(beanName.toUpperCase() + ". Message setted from postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanNames.contains(beanName)) {
            TestBeans testBean = (TestBeans) bean;
            System.out.println("postProcessAfterInitialization method called for: "
                    + beanName.toUpperCase() + ". current setted message: " + testBean.getMessage());
            testBean.setMessage(beanName.toUpperCase() + ". Message setted from postProcessAfterInitialization");
            System.out.println();
        }
        return bean;
    }
}
