package net.maku.service.impl;

import net.maku.framework.security.mobile.MobileVerifyCodeService;
import lombok.AllArgsConstructor;
import net.maku.sms.service.AliyunSmsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final AliyunSmsService smsService;

    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsService.verifyCode(mobile, code);
    }
}
