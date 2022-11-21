package com.ark.base.interceptor;

import com.ark.base.context.ArkContext;
import lombok.AllArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

/**
 * 将请求中的tenantId保存到Context中
 */
@AllArgsConstructor
public class TenantIdResolverInterceptor extends ArkHandlerInterceptor {
    @Override
    public void preHandle(WebRequest request) throws Exception {
        Map<String,String> pathVariableMap = (Map<String, String>) RequestContextHolder.currentRequestAttributes()
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);

        if (pathVariableMap.containsKey("tenantId")) {
            ArkContext.ACCOUNT_CONTEXT.get().setTenantId(Long.parseLong(pathVariableMap.get("tenantId")));
        }
    }
}

