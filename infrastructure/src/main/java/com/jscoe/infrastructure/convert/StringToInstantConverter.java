package com.jscoe.infrastructure.convert;

import com.jscoe.infrastructure.common.exception.MSException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class StringToInstantConverter implements Converter<String, Instant> {
    @Override
    public Instant convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }

        Instant result = null;
        try {
            boolean ifNumber = source.matches("[0-9]+");
            if (ifNumber) {
                result = Instant.ofEpochMilli(Long.parseLong(source));
            }
        } catch (Exception e) {
            throw new MSException("Convert String To Instant Fail", e);
        }

        return result;
    }
}