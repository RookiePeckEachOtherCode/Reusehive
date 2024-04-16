<template>

  <div class="app-container">
    <div class="app-header" v-if="showNavBar">
    </div>
    <el-scrollbar height="90vh">
      <div class="app-body">
        <RouterView></RouterView>
      </div>
    </el-scrollbar>
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

  .app-footer {
    position: fixed;
  }
}
</style>