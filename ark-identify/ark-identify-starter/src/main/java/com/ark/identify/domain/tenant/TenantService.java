package com.ark.identify.domain.tenant;

import com.ark.identify.domain.organiztion.Organization;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 租户领域服务.
 */
@Service
@AllArgsConstructor
public class TenantService {

  private TenantRepository tenantRepository;
}
