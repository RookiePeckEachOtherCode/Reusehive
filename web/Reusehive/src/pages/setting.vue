<template>
  <div class="setting-container">
    <t-navbar :fixed="false" left-arrow title="设置" @left-click="goBack"/>
    <div class="logout">
      <t-button block size="large" theme="danger" @click="logout">退出登录</t-button>
    </div>

  </div>

</template>

<script lang="ts" setup>
import router from "../router";

const goBack = () => {
  router.back();
}

const logout = () => {
  localStorage.removeItem("token")
  router.push({name: "login"})
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