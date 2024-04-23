<template>

  <div class="app-container">
    <div v-if="showNavBar" class="app-header">
    </div>
    <div class="app-body">
      <keep-alive>
        <RouterView :key="$route.fullPath"></RouterView>
      </keep-alive>
    </div>
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