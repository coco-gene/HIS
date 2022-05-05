package com.neu.his.api.controller.sso;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neu.his.api.controller.dms.DmsRedisSaveController;
import com.neu.his.common.api.CommonPage;
import com.neu.his.common.api.CommonResult;
import com.neu.his.common.dto.sms.*;
import com.neu.his.common.util.JwtTokenUtil;
import com.neu.his.mbg.model.SmsStaff;
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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 统一登录
     * <p>author: Peter
     */
    @ApiOperation("统一登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult login(@RequestParam("code") String code, @RequestParam("state") String state) {
        String token = null;
        String casToken = "";
        CasdoorUser user = null;
        try {
            casToken = casdoorAuthService.getOAuthToken(code, state);
            user = casdoorAuthService.parseJwtToken(casToken);
            LOGGER.info("user：" + user.toString());
            // asdoorUser(owner=built-in, name=admin, createdTii
            /**
             * asdoorUser(owner=built-in, name=admin, createdTii
             * me=2022-04-27T08:17:21Z, updatedTime=, id=712ed058-a37f-4113-92b2-62549c12289c,
             * type=normal-user, password=, displayName=Admin,
             * avatar=https://www.7otech.com/pelican.svg, permanentAvatar=,
             * email=admin@example.com, phone=12345678910, location=, address=[],
             * affiliation=Example Inc., title=, homepage=, bio=, tag=staff, region=,
             * language=, score=2000, ranking=1, isOnline=false, isAdmin=false,
             * isGlobalAdmin=false, isForbidden=false, signupApplication=built-in-app,
             * hash=, preHash=, github=, google=, qq=, wechat=, facebook=, dingtalk=,
             * weibo=, gitee=, linkedin=, wecom=, lark=, gitlab=, ldap=, properties={})
             */
            String name = user.getName();
            String displayName = user.getDisplayName();
            String avatar = user.getAvatar();
            String email = user.getEmail();
            String phone = user.getPhone();
            SmsStaff smsStaff = smsStaffService.selectByUserName(name);
            if(smsStaff == null) {// create user

            } else {// update user

            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(name);//返回的是一个userDetails的实现类AdminUserDetails
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);  //在securityContext中添加该验证信息
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (CasdoorAuthException e) {
            e.printStackTrace();
        }

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
