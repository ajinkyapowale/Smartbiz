package com.smartbiz.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.smartbiz.security.SecurityUser;



public class AuditAwareImpl implements AuditorAware<Integer> {
   
	@Override
    public Optional<Integer> getCurrentAuditor() {
		Integer uid = ((SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid();
        return Optional.of(uid);
    }
}
