<template>
  <div class="h-screen flex flex-col ">
    <div class="search flex py-5 justify-between mx-12">
      <div class="bg-gray-100 flex py-3  w-4/5 sm:w-1/3 rounded-3xl">
        <img alt="" class="mx-2" src="../assets/search.svg" @click="search">
        <input v-model="searchCondition" class="focus:outline-none w-4/5 bg-gray-100" type="text">
      </div>
      <div class="shop-bag pt-0.5" @click="goNewItem">
        <img alt="" class="mt-2  size-8" src="../assets/item-new.svg">
      </div>
    </div>

    <div class="tags grid grid-cols-4 md:grid-cols-8">
      <div
          v-for="tag in tags"
          :key="tag.type"
          class="item-type mx-2"
          @click="handleSwitchItem(tag.type)"
      >
        <div :class="{'tag-active':itemTypeTag==tag.type}" class="p-2  ml-1">
          <img :src="tag.icon" alt="">
          <div class="text-left" style="font-size:0.8rem">{{ tag.type }}</div>
        </div>
      </div>
    </div>

    <div>
      <el-scrollbar height="90vh">
        <masonry-infinite-grid>
          <div
              v-for="itemDetail in itemDetails"
              :key="itemDetail.item.id.toString()"
              :data-grid-groupkey="itemDetail.item.id.toString()"
          >
            <div class="mx-2">
              <itemCard :images="itemDetail.images" :item="itemDetail.item"></itemCard>
            </div>
          </div>
        </masonry-infinite-grid>
      </el-scrollbar>
    </div>

  </div>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue'
import deviceSvg from '../assets/item-types/device.svg'
import bookSvg from '../assets/item-types/book.svg'
import clothesSvg from '../assets/item-types/clothes.svg'
import lifeSvg from '../assets/item-types/life.svg'
import findSvg from '../assets/item-types/find.svg'
import rewardSvg from '../assets/item-types/reward.svg'
import blockSvg from '../assets/item-types/block.svg'
import otherSvg from '../assets/item-types/other.svg'
import {GetAllItem, GetItemByType, SerachItem} from "../apis/ItemApi.ts";
import ItemDetail from "../model/itemDetail.ts";
import ItemCard from "../component/ItemCard.vue";
import {MasonryInfiniteGrid} from "@egjs/vue3-infinitegrid";
import router from '../router'

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
const searchCondition = ref("")

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

function goNewItem() {
  router.push("/item/new")
}


async function search() {
  await SerachItem({condition: searchCondition.value}).then(res => {
    console.log(res)
    if (res.code == 1) {
      itemDetails.value = res.data;
    }
  })
}
</script>

<style scoped>


.tag-active {
  background-color: #cbd5e1;
  border-radius: 1rem;
}
</style>
