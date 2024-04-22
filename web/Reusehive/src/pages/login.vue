<template>
  <div class="login-container">
    <div class="login-header">
      <img alt="" src="../assets/bee.svg"/>
    </div>
    <div class="login-content">
      <div class="login-title">
        <h3>欢迎使用</h3>
      </div>
      <div class="login-form">
        <div class="login-form-item">
          <div id="input">
            <t-input v-model="form.username" label="用户名" placeholder="输入用户名">
              <template #prefixIcon>
                <UserCircleIcon/>
              </template>
            </t-input>
          </div>
        </div>
        <div class="login-form-item" style="margin-top: 10px">
          <div id="input"></div>
          <t-input v-model="form.password" :clearable="false" label="输入密码" placeholder="输入密码" type="password">
            <template #prefixIcon>
              <LockOnIcon/>
            </template>
          </t-input>
        </div>
      </div>
      <div class="buttons">
        <el-button block color="#529b2e" size="large" style="margin-left: 30px" type="primary" @click="login">登录
        </el-button>
        <el-button block color="#d1edc4" size="large" style="color: #0f0f0f;margin-left: 50px"
                   @click="goToRegister">注册
        </el-button>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import {loginApi} from "../apis/UserApi.ts";
import {reactive} from "vue";
import router from "../router";
import {LocalStorage} from "../storage/LocalStorage.ts";
import {LockOnIcon, UserCircleIcon} from "tdesign-icons-vue-next"
import {notify_err} from "../utils/notify.ts";


const form = reactive({
  username: "",
  password: "",
});

const login = async () => {
  await loginApi({password: form.password, name: form.username}).then(res => {
    if (res.code == 1) {
      localStorage.setItem("token", res.data)
      LocalStorage().setToken(res.data, '14514', form.username)
      router.push({name: "main"})
    } else {
      notify_err(res.msg)
    }
  }).catch(err => {
    notify_err(err)
  })
}

const goToRegister = () => {
  router.push({name: "register"})
}

</script>
<style scoped>
.login-container {
  .login-header {
    width: 100vw;
    height: 220px;
    background: #95d475;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: -20px;
    padding: 0;

  }

  .login-content {
    height: auto;
    overflow: hidden;
    border-radius: 20px 20px 0 0;
    background: #ffffff;
    padding: 30px;
    margin-top: -20px;
  }

  .login-title {
    letter-spacing: 3px;
  }

  .login-form {
    height: 100px;
    margin-top: 20px;
    margin-bottom: 20px;
  }

  .buttons {
    margin-top: 10vh;
    margin-left: 10%;
    margin-right: 10%;
  }
}

</style>