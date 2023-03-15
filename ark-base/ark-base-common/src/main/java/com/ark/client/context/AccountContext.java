package com.ark.client.context;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountContext implements Serializable {
     private Long tenantId;
}

