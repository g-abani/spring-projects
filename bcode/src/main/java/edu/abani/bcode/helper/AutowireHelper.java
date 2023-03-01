package edu.abani.bcode.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AutowireHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private AutowireHelper() {
    }
    public static void autowire(Object classToAutowire) {
        AutowireHelper.applicationContext.getAutowireCapableBeanFactory()
                .autowireBean(classToAutowire);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AutowireHelper.applicationContext = applicationContext;
    }
}
