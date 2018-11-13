package com.zgtong.web.common.error;


import com.zgtong.web.common.domain.ServiceResponse;

@FunctionalInterface
public interface TransferableError {

	public ServiceResponse<?> errorFrom();

	default Error getFrom() {
		ServiceResponse<?> serviceResponse = this.errorFrom();
		if (serviceResponse == null) {
			return null;
		}

		Integer code = serviceResponse.getCode();
		String desc = serviceResponse.getDesc();

		return new Error() {

			@Override
			public String getDescr() {
				return desc;
			}

			@Override
			public Integer getCode() {
				return code;
			}
		};
	}
}
