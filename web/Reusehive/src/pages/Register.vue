<template>
  <div
      class="bg-gradient-to-r from-green-600 to-green-300 h-screen  items-center flex flex-col md:flex-row md:justify-center">
    <div class="logo text-green-200 mx-28 mb-4 my-40 md:my-0">
      <p class="text-3xl md:text-5xl flex justify-center">欢迎您的加入</p>
    </div>
    <div class="form bg-white shadow-md rounded-2xl drop-shadow-2xl px-8 pt-6 pb-8 mx-10 my-10 md:mx-0 md:my-0">
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2">
          用户名
        </label>
        <input
            id="name"
            v-model="registerForm.name"
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="用户名"
            type="text"
        />
      </div>
      <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2">
          电话号码
        </label>
        <input
            id="username"
            v-model="registerForm.phone_number"
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="电话号码" type="text"
        />
      </div>
      <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2">
          密码
        </label>
        <input
            id="password"
            v-model="registerForm.password"
            class="shadow appearance-none border  rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="密码"
            type="password"
        />
      </div>
      <div class="mb-6">
        <label class="block text-gray-700 text-sm font-bold mb-2">
          确认密码
        </label>
        <input
            id="password"
            v-model="registerForm.confirmPassword"
            class="shadow appearance-none border  rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
            placeholder="确认密码"
            type="password"
        />
      </div>
      <div class="flex items-center justify-center">
        <button
            class="bg-green-500 mr-10 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            @click="handleRegister"
        >
          注册
        </button>
        <button
            class="bg-green-500 mr-10 hover:bg-green-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            @click="router.push('login')"
        >
          返回登陆
        </button>
      </div>
    </div>
  </div>

</template>

<script lang="ts" setup>
import {reactive} from "vue";
import router from "../router";
import {UserRegister} from "../apis/UserApi.ts";

const registerForm = reactive({
  name: "",
  password: "",
  confirmPassword: "",
  phone_number: "",
})

function handleRegister() {
  if (registerForm.name === "" || registerForm.password === "" || registerForm.confirmPassword === "" || registerForm.phone_number === "") {
    alert("请填写完整信息")
    return
  }
  if (registerForm.password !== registerForm.confirmPassword) {
    alert("两次密码不一致，请重新输入")
    registerForm.password = ""
    registerForm.confirmPassword = ""
    return
  }
  // if (!checkCNPhoneNumber(registerForm.name)) {
  //   alert("请输入正确的手机号码")
  //   return
  // }
  UserRegister({
    name: registerForm.name,
    password: registerForm.password,
    phone_number: registerForm.phone_number
  }).then(res => {
    console.log(res)
    if (res.code === 1) {
      router.push({name: "login"})
    }
  })

}
</script>