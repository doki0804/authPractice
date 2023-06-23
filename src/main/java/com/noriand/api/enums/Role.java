package com.noriand.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	USER("ROLE_USER"),
	MANAGER("ROLE_ADMIN");
	
	private final String value;
}
