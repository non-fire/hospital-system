<template>
  <NavBar>
  </NavBar>
  <router-view></router-view>
</template>

<script>
import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
//import $ from 'jquery'

export default {
  components:{
    NavBar
  },
  setup() {
    // // 测试LoginService
    // $.ajax({
    //   url: "http://127.0.0.1:1000/user/account/token/",
    //   type: "post",
    //   data: {
    //     number: '123456',
    //     password: '123',
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp); 
    //   }
    // });
    // // 测试InfoService
    // $.ajax({
    //   url: "http://127.0.0.1:1000/user/account/info/",
    //   type: "get",
    //   headers: {
    //     Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0YzgwMDQ1ZjZhZDg0MGUwOGE5ZTg2ZjhkNDA0NDg5ZCIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY2NjUxNjM2MSwiZXhwIjoxNjY3NzI1OTYxfQ.rYZb90AcV_-xcFu6LRAdP2jZ01BCP9ylHYakjN1BrJM",
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // });
    // 测试RegisterService
    // $.ajax({
    //   url: "http://127.0.0.1:1000/user/account/register/",
    //   type: "post",
    //   data: {
        // number: "320503200112034027",
        // name: "陈昱衡",
        // password: "123",
        // confirmedPassword: "123",
        // sex: "1",
        // age: "22",
        // address: "",
        // phone: ""
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // })
  }

}
</script>

<style>

</style>
