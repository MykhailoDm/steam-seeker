package com.steam.seeker.test_util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;

@UtilityClass
public class RandomUtil {

    public Long randomLongId() {
        return RandomUtils.nextLong(1, Long.MAX_VALUE);
    }

    public String randomStringUUID() {
        return UUID.randomUUID().toString();
    }
}
