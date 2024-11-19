package com.yasharora102.test.sar.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yasharora102.test.sar.auditrail.AppAuditorAware;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Created on 2/27/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ASimpleAuditTrail extends BaseMasterDATA<Long> {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5338452813229316294L;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Transient
    private AppAuditorAware auditorAware;

    public ASimpleAuditTrail() {
        auditorAware = new AppAuditorAware();
    }
}
