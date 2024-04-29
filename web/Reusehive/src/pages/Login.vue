<template>
  <div
      class="flex flex-col md:flex-row   items-center bg-gradient-to-r from-green-600 to-green-300  h-screen md:justify-center   ">
    <div class="logo text-green-200 mx-28 mb-4 my-40 md:my-0 md:mb-0">
      <p class="text-3xl md:text-5xl flex justify-center">REUSEHIVE</p>
      <p class="text-1xl md:text-3xl flex justify-center">让每次循环更有意义</p>
    </div>

    <div class="form">
      <div class="bg-white shadow-md rounded-2xl drop-shadow-2xl mx-10 mt-20  md:mt-0 md:mx-0 px-8 pt-6 pb-8 md:mb-4">
        <div class="mb-4">
          <label class="block text-gray-700 text-sm font-bold mb-2">
            用户名
          </label>
          <input
              id="username"
              v-model="loginForm.name"
              class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
              placeholder="用户名"
              type="text"
          />
        </div>
        <div class="mb-6">
          <label class="block text-gray-700 text-sm font-bold mb-2">
            密码
          </label>
          <input
              id="password"
              v-model="loginForm.password"
              class="shadow appearance-none border  rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
              placeholder="密码"
              type="password"
          />
        </div>
        <div class="flex items-center">
          <button
              class="bg-green-500 mr-10 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
              @click="handleLogin">
            登录
          </button>
          <button
              class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
              @click="handleRegister">
            注册
          </button>
        </div>
      </div>
    </div>
  </div>

</template>

<script lang="ts" setup>
import {reactive} from "vue";
import {UserLogin} from "../apis/UserApi.ts";
import router from "../router";

const loginForm = reactive({
  name: "",
  password: "",
})

function handleLogin() {
  UserLogin({name: loginForm.name, password: loginForm.password}).then(res => {
    if (res.code === 1) {
      localStorage.setItem("token", res.data);
      router.push({name: "item-list"})
    }
  })
}

function handleRegister() {
  router.push({name: "register"})
}
</script>