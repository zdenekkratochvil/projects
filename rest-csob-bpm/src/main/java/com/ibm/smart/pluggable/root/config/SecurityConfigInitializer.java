package com.ibm.smart.pluggable.root.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(Ordered.LOWEST_PRECEDENCE)
public class SecurityConfigInitializer extends AbstractSecurityWebApplicationInitializer {

}
