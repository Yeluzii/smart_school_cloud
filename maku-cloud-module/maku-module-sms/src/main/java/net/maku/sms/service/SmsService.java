package net.maku.sms.service;

import net.maku.framework.common.cache.RedisCache;
import net.maku.framework.common.cache.RedisKeys;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.common.exception.ErrorCode;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;

public abstract class SmsService {
    @Resource
    private RedisCache redisCache;

    abstract boolean  sendSms(String mobile);

    public boolean verifyCode(String mobile, String code){
        String captchaKey = RedisKeys.getCaptchaKey(mobile);
        String redisCode = (String) redisCache.get(captchaKey);
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        // 删除⽤过的验证码
        redisCache.delete(captchaKey);
        return true;
    }
}
