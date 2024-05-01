<template>
  <div>
    <t-tab-bar v-model="i" :split="false" theme="tag" @change="handleChange">
      <t-tab-bar-item v-for="(item,index) in list" :key="index" :value="item.value">
        <img :src="item.svg" alt="">
      </t-tab-bar-item>
    </t-tab-bar>
  </div>
</template>
<script lang="ts" setup>
import {onMounted, ref} from "vue";
import homeSvg from '../assets/tabs/home.svg'
import messageSvg from '../assets/tabs/message.svg'
import orderSvg from '../assets/tabs/order.svg'
import userSvg from '../assets/tabs/user.svg'
import likeSvg from '../assets/tabs/like.svg'
import router from "../router";

onMounted(() => {
  const path = router.currentRoute.value.path
  if (path === '/item-list') {
    i.value = "1"
  } else if (path === '/message') {
    i.value = "2"
  } else if (path === '/purchase') {
    i.value = "3"
  } else if (path === '/collections') {
    i.value = "4"
  } else if (path === '/home') {
    i.value = "5"
  }
})


const list = ref([{value: "1", svg: homeSvg},
  {value: "2", svg: messageSvg},
  {value: "3", svg: orderSvg},
  {value: "4", svg: likeSvg},
  {value: "5", svg: userSvg}
])

const i = ref("1")

function handleChange(val: string) {
  i.value = val
  if (val === "1") {
    router.push('item-list')
  } else if (val === "2") {
    router.push('message')
  } else if (val === "3") {
    router.push('purchase')
  } else if (val === "4") {
    router.push('collections')
  } else if (val === "5") {
    router.push('home')
  }
}

</script>