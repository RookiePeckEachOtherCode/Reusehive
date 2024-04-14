<template>

  <div class="app-container" >
    <div class="app-header" v-if="showNavBar">
    </div>
      <RouterView></RouterView>
    </div>
  <div class="app-footer">
    <Tabs>

    </Tabs>
  </div>
</template>


<script setup lang="ts">
import Tabs from "./Tabs.vue";
//375 628
</script>
<style scoped>

html,
body {
  margin: 0;
  height: 100%;
  width: 375px;
}

.app-container {

  background-color: #6aeb62;

  .app-header {}
  height: 580px;
  .app-body {
    height: calc(100vh - var(--van-nav-bar-height) - var(--van-tabbar-height));
    overflow: auto;
  }

  .app-body-noNavBar {
    height: calc(100vh  - var(--van-tabbar-height));
    overflow: auto;
  }

  .app-body-noTabBar {
    height: calc(100vh - var(--van-nav-bar-height));
    overflow: auto;
  }

  .app-body-noNavBar-noTabBar {
    height: calc(100vh);
    overflow: auto;
  }

  .app-footer {}

}
</style>