<template>
  <div class="h-screen flex flex-col">
    <div class="content bg-white ">
      <keep-alive>
        <RouterView></RouterView>
      </keep-alive>
    </div>
    <div>
      <TabBar/>
    </div>
  </div>
</template>


<script lang="ts" setup>
import TabBar from "./TabBar.vue";
</script>