package edu.abani.bcode.listener;

import edu.abani.bcode.annot.BCode;
import edu.abani.bcode.entities.Base;
import edu.abani.bcode.entities.Tenant;
import edu.abani.bcode.helper.AutowireHelper;
import edu.abani.bcode.repo.TenantRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
public class TenantListener {

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;
    @PrePersist
    public void update(Base base){
        AutowireHelper.autowire(this);
        BCode bCodeMeta = base.getClass().getAnnotation(BCode.class);
        String query = String.format("select max(%s) from %s", bCodeMeta.column(), bCodeMeta.table());
        Object res = entityManager.createNativeQuery( query ).getSingleResult();
        String resStr = (res == null) ? "0" : res.toString();
        int resInt = Integer.parseInt(resStr) + 1;
        String code = String.format("%s%05d",bCodeMeta.prefix(),resInt);
        base.setCode(code);
    }
}
