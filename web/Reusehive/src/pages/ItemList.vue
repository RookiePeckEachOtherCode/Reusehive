<template>
  <div class="h-screen flex flex-col ">
    <div class="search flex py-5 justify-between mx-5 ">
      <div class="bg-gray-100 flex py-3 w-4/5 sm:w-1/3 rounded-3xl">
        <img alt="" class="mx-2" src="../assets/search.svg">
        <input class="focus:outline-none w-4/5 bg-gray-100" type="text">
      </div>
      <div class="shop-bag ">
        <img alt="" class="mt-2  size-8" src="../assets/shop_bag.svg">
      </div>
    </div>
    <div class="tags flex flex-wrap">
      <div
          v-for="tag in tags"
          :key="tag.type"
          class="item-type"
          @click="handleSwitchItem(tag.type)"
      >
        <div :class="{'tag-active':itemTypeTag==tag.type}" class="p-1.5">
          <img :src="tag.icon" alt="">
          <div class="text-center">{{ tag.type }}</div>
        </div>
      </div>
    </div>

    <div class="pb-14">
      <el-scrollbar height="100vh">
        <div class="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 max-h-20 ">
          <div v-for="itemDetail in itemDetails" :key="itemDetail.item.id.toString()" class="mx-auto">
            <itemCard :images="itemDetail.images" :item="itemDetail.item"></itemCard>
          </div>
        </div>
      </el-scrollbar>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue'
import itemCard from '../component/itemCard.vue'
import deviceSvg from '../assets/item-types/device.svg'
import bookSvg from '../assets/item-types/book.svg'
import clothesSvg from '../assets/item-types/clothes.svg'
import lifeSvg from '../assets/item-types/life.svg'
import findSvg from '../assets/item-types/find.svg'
import rewardSvg from '../assets/item-types/reward.svg'
import blockSvg from '../assets/item-types/block.svg'
import otherSvg from '../assets/item-types/other.svg'
import {GetAllItem, GetItemByType} from "../apis/ItemApi.ts";
import ItemDetail from "../model/itemDetail.ts";

const tags = ref([
  {type: '电子数码', icon: deviceSvg},
  {type: '书籍资料', icon: bookSvg},
  {type: '服装饰品', icon: clothesSvg},
  {type: '生活用品', icon: lifeSvg},
  {type: '失物招领', icon: findSvg},
  {type: '失物悬赏', icon: rewardSvg},
  {type: '网络虚拟', icon: blockSvg},
  {type: '其他物品', icon: otherSvg}
]);

const itemDetails = ref(new Array<ItemDetail>());
const itemTypeTag = ref<string>("")

onMounted(async () => {
  await getItemAll()
})

async function getItemByType(type: string) {
  await GetItemByType(type).then(res => {
    if (res.code == 1) {
      itemDetails.value = res.data;
    }
  })
}

async function getItemAll() {
  await GetAllItem().then(res => {
    if (res.code == 1) {
      itemDetails.value = res.data;
    }
  })
}


function handleSwitchItem(type: string) {
  if (type === itemTypeTag.value) {
    itemTypeTag.value = ""
    getItemAll()
  } else {
    itemTypeTag.value = type
    getItemByType(type)
  }
}

</script>

<style scoped>
.item-type {
  margin-left: 0.5rem;
  margin-right: auto;
  margin-bottom: 1rem;
  padding: 0.5rem 0.5rem;
  border-radius: 1rem;
}


.tag-active {
  background-color: #cbd5e1;
  border-radius: 1rem;
}
</style>
