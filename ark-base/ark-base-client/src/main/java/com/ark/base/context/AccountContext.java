package com.ark.base.context;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountContext implements Serializable {
     private Long tenantId;
}

