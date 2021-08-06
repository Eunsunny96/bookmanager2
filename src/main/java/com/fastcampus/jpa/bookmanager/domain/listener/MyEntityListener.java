package com.fastcampus.jpa.bookmanager.domain.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {

        @PrePersist
        public void prePersist(Object o){ //엔티티를 받아서 처리를 해야 되기 때문에 오브젝트를 받아야됨
            if(o instanceof Auditable){
                ((Auditable) o).setCreatedAt(LocalDateTime.now());
                ((Auditable) o).setUpdatedAt(LocalDateTime.now());

            }
        }
        @PreUpdate
        public void preUpdate(Object o){
            if(o instanceof Auditable){
                ((Auditable) o).setUpdatedAt(LocalDateTime.now());
            }
        }
    }

