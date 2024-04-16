<template>
  <t-navbar :title="touserinfo.name" :fixed="false" left-arrow @left-click="exit" style="
  --td-navbar-height:60px;
  --td-navbar-left-arrow-size:32px;
  --td-navbar-title-font-size:24px
" />
  <div style="max-height: 82vh;overflow: auto">
    <ul style="list-style-type: none">
    <li v-for="mes in List"  style="margin-top: 20px; list-style-type: none;margin-left: -30px">
      <div v-if="mes.tousername===userinfo.name" style="display: flex;">
        <el-avatar :src="touserinfo.avatar" :size="50" style="" ></el-avatar>
        <el-text  style="
        word-break: break-all;
        word-wrap: break-word;
        font-size: 16px;
        margin-left: 10px;
        background-color:rgba(64,219,97,0.64);
        border-radius: 5px;
        padding: 5px;
        max-width: 70vw;

" >{{mes.content}}</el-text>
      </div>
      <div v-if="mes.tousername===touserinfo.name" style="display: flex; flex-direction: row-reverse;margin-top: 20px" >
        <el-avatar :src="userinfo.avatar" :size="50" style="margin-right: 10px"></el-avatar>
        <el-text style="font-size: 16px;
        margin-right: 10px;
        background-color:rgba(234,226,69,0.67);
        border-radius: 5px;
        padding: 5px;
        max-width: 70vw;
">{{mes.content}}</el-text>
      </div>
    </li>
    </ul>
  </div>
  <t-divider style="position: absolute;bottom: 62px;width: 100%;--td-divider-color:#70a1d7" />
  <t-input placeholder="输入消息" style="  position: fixed;bottom: 0;width: 100%" v-model="text" >
    <template #suffix>
      <t-button  theme="primary" size="medium" shape="round" style="background-color: #70a1d7;display: flex; flex-direction: row-reverse;margin-right: 50px" @click="send">
        <svg style="margin-top: 10px" t="1713270149975" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3335" width="32" height="32"><path d="M925.6 559.2L152 145.6c-11.2-5.6-24.8 3.2-23.2 15.2l60 714.4c0.8 11.2 12 17.6 22.4 13.6L460.8 784l136.8 155.2c8.8 9.6 24 5.6 27.2-6.4l65.6-245.6 235.2-99.2c11.2-5.6 12-22.4 0-28.8z m-328 305.6l-72-128-368-568 488 504-48 192z" p-id="3336"></path></svg>
      </t-button>
    </template>
  </t-input>
</template>
<script setup lang="js">
import { ref, onUnmounted,onMounted,reactive } from "vue";
import {useRoute} from "vue-router";
import {LocalStorage} from "../storage/LocalStorage.ts";
import router from "../router";
import {getUserInfoByName} from "../apis/UserApi.ts";
import {ElMessage} from "element-plus";

let url="ws://127.0.0.1:8888/chat/"
const route=useRoute();
const userinfo=reactive({
  id:"lingluo",
  avatar:"",
  name:"lingluo",
})
const touserinfo=reactive({
  id:"114514",
  avatar:"",
  name:"114514",
})
const List=ref([]);
const text=ref(null);
let socket;
onMounted(async ()=>{
  LocalStorage().setToken("114514","lingluo","lingluo")

  touserinfo.name = route.query.tousername;
  touserinfo.id=route.query.touserid;
  const res=await getUserInfoByName({name:touserinfo.name});


  const info=await  getUserInfoByName({name:LocalStorage().getusername()})
  userinfo.id=info.data.id;
  userinfo.avatar=info.data.avatar_img;
  userinfo.name=info.data.name;

  url=url+userinfo.name+"/"+touserinfo.name;
  await init();
})
const init=async ()=>{
  socket = new WebSocket(url);
  socket.onopen = function () {
    console.log("websocket link has built");
  };
  socket.onmessage=function (msg) {
    const parse = JSON.parse(msg.data);
    List.value.push(parse)
    console.log(List.value)
  }
  socket.onclose = function () {
    console.log("websocket link has closed");
  };
  socket.onerror = function () {
    console.log("websocket error,please check back side");
  }
}
const send=()=>{
  if(text.value===null){
    ElMessage.error("不能发送空字符");
    return
  }
  socket.send(text.value);
  List.value.push({
    content:text.value,
    fromusername:userinfo.name,
    tousername:touserinfo.name,
  })
  text.value=null;
}
const exit=()=>{
  router.push({name:"message"})
}
</script>
<style scoped>

</style>