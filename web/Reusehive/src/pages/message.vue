<template>
  <p>message</p>
</template>

<script setup lang="ts">
import { ref, onUnmounted,onMounted } from "vue";
const url="ws://127.0.0.1:8888/chat/lingluo/114514"
onMounted(()=>{
  init();
})
const init=async ()=>{
  var socket = new WebSocket(url);
  socket.onopen = function () {
    console.log("websocket已打开");
  };
  socket.onmessage=function (msg) {
      console.log(msg.data  )
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
<style scoped>

</style>