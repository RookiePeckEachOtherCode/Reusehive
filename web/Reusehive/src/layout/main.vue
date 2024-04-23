<template>

  <div class="app-container">
    <div v-if="showNavBar" class="app-header">
    </div>
    <keep-alive>
      <div class="app-body">
        <RouterView :key="$route.fullPath"></RouterView>
      </div>
    </keep-alive>
  </div>
  <div class="app-footer">
    <Tabs>
    </Tabs>
  </div>
</template>


<script lang="ts" setup>
import {ref} from "vue";
import Tabs from "./Tabs.vue";

const showNavBar = ref(true);
</script>
<style scoped>
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 92vh;

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