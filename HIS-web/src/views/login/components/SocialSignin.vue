<template>
  <div class="social-signup-container">
    <div class="sign-btn" @click="pelicanHandleClick('pelican')">
      <span class="wx-svg-container"><svg-icon icon-class="user" class="icon" /></span>
      Pelican
    </div>
    <!--<div class="sign-btn" @click="wechatHandleClick('wechat')">
      <span class="wx-svg-container"><svg-icon icon-class="wechat" class="icon" /></span>
      WeChat
    </div>
    <div class="sign-btn" @click="tencentHandleClick('tencent')">
      <span class="qq-svg-container"><svg-icon icon-class="qq" class="icon" /></span>
      QQ
    </div>-->
  </div>
</template>

<script>
import openWindow from '@/utils/open-window'

export default {
  name: 'SocialSignin',
  methods: {
    pelicanHandleClick(thirdpart) {
      this.$store.commit('SET_AUTH_TYPE', thirdpart)
      let url = this.getSigninUrl()
      // https://pelican.7otech.com/login/oauth/authorize?client_id=a07d0ddd8eaee128d94c&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A1024https%3A%2F%2Fhis.7otech.com%2Fcallback&scope=read&state=application_his
      // https://pelican.7otech.com/login/oauth/authorize?client_id=a07d0ddd8eaee128d94c&response_type=code&redirect_uri=https%3A%2F%2Fhis.7otech.com%2Fcallback&scope=read&state=application_his
      // https://pelican.7otech.com/login/oauth/authorize?client_id=a07d0ddd8eaee128d94c&response_type=code&redirect_uri=https%3A%2F%2Fhis.7otech.comhttps%3A%2F%2Fhis.7otech.com%2Fcallback&scope=read&state=application_his
      url = url.replace('http%3A%2F%2Flocalhost%3A1024', '')
      url = url.replace('https%3A%2F%2Fhis.7otech.comhttps', 'https')
      console.log(url)
      openWindow(url, thirdpart, 540, 540)
    },
    wechatHandleClick(thirdpart) {
      // this.$store.commit('SET_AUTH_TYPE', thirdpart)
      // const appid = 'xxxxx'
      // const redirect_uri = encodeURIComponent('xxx/redirect?redirect=' + window.location.origin + '/auth-redirect')
      // const url = 'https://open.weixin.qq.com/connect/qrconnect?appid=' + appid + '&redirect_uri=' + redirect_uri + '&response_type=code&scope=snsapi_login#wechat_redirect'
      // openWindow(url, thirdpart, 540, 540)
    },
    tencentHandleClick(thirdpart) {
      // this.$store.commit('SET_AUTH_TYPE', thirdpart)
      // const client_id = 'xxxxx'
      // const redirect_uri = encodeURIComponent('xxx/redirect?redirect=' + window.location.origin + '/auth-redirect')
      // const url = 'https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=' + client_id + '&redirect_uri=' + redirect_uri
      // openWindow(url, thirdpart, 540, 540)
    }
  }
}
</script>

<style lang="scss" scoped>
  .social-signup-container {
    margin: 20px 0;
    .sign-btn {
      display: inline-block;
      cursor: pointer;
    }
    .icon {
      color: #fff;
      font-size: 24px;
      margin-top: 8px;
    }
    .wx-svg-container,
    .qq-svg-container {
      display: inline-block;
      width: 40px;
      height: 40px;
      line-height: 40px;
      text-align: center;
      padding-top: 1px;
      border-radius: 4px;
      margin-bottom: 20px;
      margin-right: 5px;
    }
    .wx-svg-container {
      background-color: #24da70;
    }
    .qq-svg-container {
      background-color: #6BA2D6;
      margin-left: 50px;
    }
  }
</style>
