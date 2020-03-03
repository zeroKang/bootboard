package org.zerock.app1.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractDomain {

    @CreatedDate
    private LocalDateTime regdate;

    @LastModifiedDate
    private LocalDateTime updateDate;

}
