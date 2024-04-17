<template>

</template>
<script setup lang="ts">
import { onMounted } from "vue";
import { useRoute } from "vue-router";
import { LocalStorage } from "../storage/LocalStorage.ts";
let url = "ws://127.0.0.1:8888/chat/"
const route = useRoute();
const localStorage = LocalStorage();
let tousername;
onMounted(() => {
  tousername = route.query.tousername;
  localStorage.setToken("ggbond", "lingluo")
  url = url + localStorage.getUserId() + "/114514"
  console.log(url)
  init();
})
const init = async () => {
  var socket = new WebSocket(url);
  socket.onopen = function () {
    console.log("websocket已打开");
  };
  socket.onmessage = function (msg) {
    var parse = JSON.parse(msg.data);
    console.log(parse);
  }
  socket.onclose = function () {
    console.log("websocket已关闭");
  };
  //发生了错误事件
  socket.onerror = function () {
    console.log("websocket发生了错误");
  }
}
</script>
<style scoped></style>