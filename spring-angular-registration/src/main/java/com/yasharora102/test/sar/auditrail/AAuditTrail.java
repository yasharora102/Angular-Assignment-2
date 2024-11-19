package com.yasharora102.test.sar.auditrail;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yasharora102.test.sar.model.base.ABaseAuditTrail;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AAuditTrail extends ABaseAuditTrail {
	/**
	 *
	 * 
	 */
	private static final long serialVersionUID = -5401587542468260575L;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@Transient
	private AppAuditorAware auditorAware;

	public AAuditTrail() {
		auditorAware = new AppAuditorAware();
	}
}
