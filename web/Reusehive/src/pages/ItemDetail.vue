<template>
  <div class="flex flex-col h-screen">
    <div class="navbar ">
      <t-navbar :fixed="false" left-arrow title="详情" @left-click="goBack">
        <template #right>
          <div @click="ToggleCollection">
            <img v-show="collected" alt="" src="../assets/like-full.svg">
            <img v-show="!collected" alt="" src="../assets/like-notfull.svg">
          </div>
        </template>
      </t-navbar>
    </div>

    <div>
      <div class="item-images mx-2 md:hidden">
        <t-image-viewer v-model:current="imagePreview.index" v-model:images="itemDetail.images"
                        v-model:index="imagePreview.index" v-model:visible="imagePreview.show"/>
        <t-swiper :autoplay="false" :navigation="{ type: 'dots',showControls: true }" class="sm:max-w-96"
                  @change="updateImagePreviewIndex" @click="handleImagePreview">
          <t-swiper-item v-for="(url, index) in itemDetail.images" :key="index" style="height:20rem">
            <img :src="url.toString()" alt="" class="w-full h-full object-cover"/>
          </t-swiper-item>
        </t-swiper>
      </div>
      <masonry-infinite-grid class="hidden md:flex">
        <div
            v-for="(url,index) in itemDetail.images"
            :key="index"
            :data-grid-groupkey="index"
        >
          <div class="mx-2">
            <img :src="url.toString()" alt="" class="object-cover max-w-80"/>
          </div>
        </div>
      </masonry-infinite-grid>
    </div>


    <t-divider/>
    <div class="userinfo flex flex-row ">
      <div class="mx-2">
        <t-avatar class="avatar" style="--td-avatar-medium-width:60px" v-bind:image="user.avatar_img"></t-avatar>
      </div>
      <div class="flex flex-col">
        <span style="font-size: 1.5rem">{{ user.name }}</span>
        <span>{{ user.academy }}</span>
      </div>
    </div>


    <div class="content mt-5 mx-2">
      <div class="name text-4xl font-bold">
        {{ itemDetail.item.name }}
      </div>
      <div class="prices">
        <span class="symbol text-xl font-semibold">¥</span>
        <span class="data text-2xl font-semibold">{{ itemDetail.item.prices }}</span>
      </div>
      <div class="desc text-2xl mt-5">
        {{ itemDetail.item.description }}
      </div>
    </div>

    <div class="mb-0 mt-auto sm:max-w-48">
      <div class="buttons flex flex-row mb-5 mx-5 my-2">
        <button
            class="flex justify-center items-center text-white bg-gray-500 font-bold mr-1 py-4 w-1/2 rounded-l-2xl focus:outline-none focus:shadow-outline"
            @click="buy">
          <img alt="" class="ml-2  " src="../assets/buy.svg">
        </button>
        <button class="flex justify-center items-center bg-green-500 hover:bg-green-500 text-white font-bold ml-1 py-4  w-1/2 px-auto rounded-r-2xl focus:outline-none focus:shadow-outline"
                @click="goChat">
          <img alt="" class="ml-2" src="../assets/communication.svg">
        </button>
      </div>
    </div>

  </div>

</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue';
import router from '../router';
import User from '../model/user';
import {addCollection, deleteCollection, getItemByItemIdApi, isCollected} from '../apis/ItemApi';
import {getUserInfoByUidApi} from '../apis/UserApi';
import ItemDetail from '../model/itemDetail.ts';
import {CreatePurchase} from "../apis/PurchaseApi.ts";
import {MasonryInfiniteGrid} from "@egjs/vue3-infinitegrid";

const itemDetail = ref<ItemDetail>(new ItemDetail());
const user = ref<User>(new User());
const collected = ref(false);


const imagePreview = ref({
  show: false,
  index: 0,
})

function updateImagePreviewIndex(index: number) {
  imagePreview.value.index = index;
}

function handleImagePreview() {
  imagePreview.value.show = true;
}

function goBack() {
  router.push("item-list")
}

function goChat() {
  router.push({name: "chat", query: {tousername: user.value.name.toString(), touserid: user.value.id.toString()}});
}

async function buy() {
  await CreatePurchase({
    item_id: itemDetail.value.item.id.toString(),
    item_uid: itemDetail.value.item.uid.toString(),
    price: itemDetail.value.item.prices,
  }).then(res => {
    if (res.code == 1) {
      router.push({
        name: "PurchaseDetail",
        query: {purchaseid: res.data.toString(), itemid: itemDetail.value.item.id.toString()}
      })
    }
  })
}

function CheckCollected() {
  isCollected({item_id: itemDetail.value.item.id.toString()}).then(res => {
    collected.value = res.data;
  })
}

async function ToggleCollection() {
  if (collected.value) {
    await deleteCollection({item_id: itemDetail.value.item.id.toString()}).then(_ => {
      collected.value = false
    })
  } else {
    await addCollection({item_id: itemDetail.value.item.id.toString()}).then(_ => {
      collected.value = true
    })
  }
}


onMounted(async () => {

  const tid = router.currentRoute.value.query.tid?.toString() ?? ' ';
  const uid = router.currentRoute.value.query.uid?.toString() ?? ' ';

  await getItemByItemIdApi({id: tid}).then(res => {
    if (res.code == 1) {
      itemDetail.value = res.data
    }
  })
  await getUserInfoByUidApi({id: uid}).then(res => {
        if (res.code == 1) {
          user.value = res.data
        }
      }
  )

  await CheckCollected()

})
</script>

<style scoped>
* {
  --td-swiper-border-radius: 10px;
}

.symbol {
  color: #F00;
}

.data {
  color: #F00;
}

</style>