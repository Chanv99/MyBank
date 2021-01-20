package com.chango.myBank.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

class AuditorAwareImpl implements AuditorAware<String>{
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Mr. Auditor");
	}
}