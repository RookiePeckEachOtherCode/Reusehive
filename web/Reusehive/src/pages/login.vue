<template>
  <div style="height: 100vh;
              width: 100vw;
              background-color: #24c8db;
              display: flex;
              justify-content: center;
">
    <el-button type="primary" @click="login">test</el-button>
  </div>
</template>
<script setup lang="ts">
import {loginApi,registerApi} from "../apis/UserApi.ts";

const login=async () => {
  const res = await loginApi({password: "114514", username: "114514"})
  console.log(res)
}

</script>
<style scoped>

</style>