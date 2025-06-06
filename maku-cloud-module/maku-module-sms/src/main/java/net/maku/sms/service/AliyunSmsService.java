package net.maku.sms.service;

import net.maku.framework.common.cache.RedisCache;
import net.maku.framework.common.cache.RedisKeys;
import net.maku.framework.common.exception.ErrorCode;
import net.maku.framework.common.exception.ServerException;
import net.maku.sms.config.AliyunSmsConfig;
import net.maku.sms.utils.SmsUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AliyunSmsService extends SmsService {
    private final AliyunSmsConfig aliyunSmsConfig;
    private final RedisCache redisCache;

    @Override
    public boolean sendSms(String mobile) {
        if (!SmsUtils.checkPhone(mobile)) {
            throw new ServerException(ErrorCode.PARAMS_ERROR);
        }
        redisCache.set(RedisKeys.getCaptchaKey(mobile), "1234", 60);
        return true;
//        try{
//            Config config = new Config().setAccessKeyId(aliyunSmsConfig.getAccessKey())
//                    .setAccessKeySecret(aliyunSmsConfig.getAccessKeySecret());
//            Client client = new Client(config);
//            String code = RandomStringUtils.randomNumeric(4);
//            SendSmsRequest request = new SendSmsRequest()
//                    .setSignName(aliyunSmsConfig.getSignName())
//                    .setTemplateCode(aliyunSmsConfig.getTemplateCode())
//                    .setPhoneNumbers(mobile)
//                    .setTemplateParam("{\"code\":\"" + code + "\"}");
//            SendSmsResponse response = client.sendSmsWithOptions(request,new RuntimeOptions());
//            SendSmsResponseBody body = response.getBody();
//            if ("OK".equals(body.getCode())){
//                log.info(" ============= 短信发送成功 =============");
//                redisCache.set(RedisKeys.getCaptchaKey(mobile),code,60);
//                return true;
//            }else {
//                log.error("短信发送失败，错误码: {},错误信息: {}",body.getCode(),body.getMessage());
//                return false;
//            }
//        }catch (Exception e){
//            return false;
//        }
    }

    @Override
    public boolean verifyCode(String mobile, String code) {
        return super.verifyCode(mobile, code);
    }
}
