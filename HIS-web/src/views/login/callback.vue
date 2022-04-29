<script>
export default {
  name: 'Callback',
  created() {
    const href = window.location.href // 获取当前url
    // const path = href.split('#')[0] // 获取#/之前的字符串
    const argumentStr = href.split('?')[1] // 获取?之后的参数字符串
    const argumentArr = argumentStr.split('&') // 参数字符串分割为数组
    let argument
    const data = {}
    for (var i = 0; i < argumentArr.length; i++) { // 遍历数组，拿到json对象
      argument = argumentArr[i].split('=')
      data[argument[0]] = argument[1]
    }
    console.log(data)
    if (window.localStorage) {
      window.localStorage.setItem('x-admin-oauth-code', data)
      // window.close()
    }
  },
  render: function(h) {
    return h() // avoid warning message
  }
}
</script>
