<script>
export default {
  name: 'AuthRedirect',
  created() {
    const hash = window.location.search.slice(1)
    console.log(hash)
    console.log(window.location.search)
    if (window.localStorage) {
      window.localStorage.setItem('x-admin-oauth-code', hash)
      // window.close()
    }
  },
  render: function(h) {
    return h() // avoid warning message
  }
}
</script>
