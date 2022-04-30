package com.ark.common.exception.api;

import com.ark.common.exception.ArkAttributeInvaildException;
import com.ark.common.exception.ArkRuntimeException;
import com.ark.common.exception.ArkServiceException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class Assert {
    public static void equals(Object o1, Object o2) {
        if (ObjectUtils.notEqual(o1, o2)) {
            throw new ArkRuntimeException();
        }
    }

    public static void notNull(Object object, Map<String, String> data) {
        if (!Objects.nonNull(object)) {
            throw new ArkAttributeInvaildException(data);
        }
    }

    public static void isBlank(CharSequence charSequence, Map<String, String> data) {
        if (StringUtils.isBlank(charSequence)) {
            throw new ArkAttributeInvaildException(data);
        }
    }

    public static void matcherPattern(CharSequence charSequence, Pattern pattern, Map<String, String> data) {
        if (!pattern.matcher(charSequence).matches()) {
            throw new ArkAttributeInvaildException(data);
        }
    }

    public static void serviceInvaild(boolean valid, String supplementary) {
        if (valid) {
            throw new ArkServiceException(supplementary);
        }
    }
}
