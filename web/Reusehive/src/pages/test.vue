<template>
  <div>
    <t-button @click="login">登陆</t-button>
    <p></p>
    <t-button @click="getAllUserInfo">获取全部用户信息</t-button>
  </div>
</template>

<script lang="ts" setup>

import {getAllUserInfoApi, loginApi} from "../apis/UserApi.ts";

const login = async () => {
  await loginApi({password: "114514", username: "114514"}).then(res => {
    if (res.code == 1) {
      localStorage.setItem("token", res.data)
      console.log("登陆成功")
    }
  }).catch(err => {
    console.log("登陆失败: ", err)
  })
}

const getAllUserInfo = () => {
  getAllUserInfoApi().then(res => {
    console.log(res)
  }).catch(err => {
    console.log(err)
  })
}


</script>