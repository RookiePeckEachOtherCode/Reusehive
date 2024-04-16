<template>

  <div class="app-container">
    <div class="app-header" v-if="showNavBar">
    </div>
    <div class="app-body">
      <RouterView></RouterView>
    </div>
  </div>
  <div class="app-footer">
    <Tabs>
    </Tabs>
  </div>
</template>


<script setup lang="ts">
import { ref } from "vue";
import Tabs from "./Tabs.vue";
//375 628
const showNavBar = ref(true);
</script>
<style scoped>
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 92vh;
  background-color: #6aeb62;

  .app-body {
    flex: 1;

  }

  .app-footer {
    .app-footer {
      position: absolute;
      bottom: 0;
      width: 100%;
    }
  }
}
</style>