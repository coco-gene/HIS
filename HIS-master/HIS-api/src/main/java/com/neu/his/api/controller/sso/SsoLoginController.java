package com.neu.his.api.controller.sso;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.api.controller.dms.DmsRedisSaveController;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.sms.*;
import com.neu.his.sms.SmsSkdService;
import com.neu.his.sms.SmsStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.casbin.casdoor.entity.CasdoorUser;
import org.casbin.casdoor.exception.CasdoorAuthException;
import org.casbin.casdoor.service.CasdoorAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "SsoLoginController", description = "统一登录")
@RequestMapping("/sso")
@CrossOrigin(allowCredentials = "true")
public class SsoLoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(SsoLoginController.class);

    @Autowired
    private SmsStaffService smsStaffService;

    @Resource
    private CasdoorAuthService casdoorAuthService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 统一登录
     * <p>author: Peter
     */
    @ApiOperation("统一登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult login(@RequestParam("code") String code, @RequestParam("state") String state) {
        String token = "";
        CasdoorUser user = null;
        try {
            token = casdoorAuthService.getOAuthToken(code, state);
            user = casdoorAuthService.parseJwtToken(token);
            LOGGER.info("user：" + user.toString());
            // create user
            // update user
        } catch (CasdoorAuthException e) {
            e.printStackTrace();
        }

        token = smsStaffService.login("演示用户", "test");
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //如果 token不等于 null
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

}
