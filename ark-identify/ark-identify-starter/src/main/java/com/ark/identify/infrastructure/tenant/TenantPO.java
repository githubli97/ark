package com.ark.identify.infrastructure.tenant;

import com.ark.infrastructure.base.AbstractPersistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ark_identify_tenant")
public class TenantPO extends AbstractPersistent {
    @Column(name = "name")
    private String name;
}
