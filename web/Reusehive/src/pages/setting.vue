<template>
  <div class="setting-container">
    <t-navbar :fixed="false" left-arrow title="设置" @left-click="goBack"/>
    <t-cell title="服务器地址">
      <t-input v-model="host" ></t-input>
      <el-button type="primary" @click="savehost">保存</el-button>
    </t-cell>
    <div class="logout">
      <t-button block size="large" theme="danger" @click="logout">退出登录</t-button>
    </div>

  </div>

</template>

<script lang="ts" setup>
import router from "../router";
import {ref} from "vue";
import {LocalStorage} from "../storage/LocalStorage.ts";
import {Toast} from "tdesign-mobile-vue";

const goBack = () => {
  router.back();
}
const host=ref("")
const logout = () => {
  localStorage.removeItem("token")
  router.push({name: "login"})
}
const savehost=()=>{
  LocalStorage().setHost(host.value)
  if(LocalStorage().gethost()){
    Toast("设置成功")
  }
}
</script>

<style scoped>
.setting-container {
  display: flex;
  flex-direction: column;
}


.logout {
  position: fixed;
  bottom: 10px;
  left: 0;
  right: 0;
  margin-left: 20px;
  margin-right: 20px;
}
</style>