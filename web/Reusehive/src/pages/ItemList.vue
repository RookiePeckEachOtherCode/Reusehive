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

    <div class="tags flex flex-wrap mt-2 ml-2">
      <div class="item-type">
        <img alt="" src="../assets/item-types/device.svg">
        <div>电子数码</div>
      </div>
      <div class="item-type">
        <img alt="" src="../assets/item-types/book.svg">
        <div>书籍资料</div>
      </div>
      <div class="item-type"><img alt="" src="../assets/item-types/clothes.svg">
        <div>服装饰品</div>
      </div>
      <div class="item-type">
        <img alt="" src="../assets/item-types/life.svg">
        <div>生活用品</div>
      </div>
      <div class="item-type">
        <img alt="" src="../assets/item-types/find.svg">
        <div>失误招领</div>
      </div>
      <div class="item-type">
        <img alt="" src="../assets/item-types/reward.svg">
        <div>失物悬赏</div>
      </div>
      <div class="item-type">
        <img alt="" src="../assets/item-types/block.svg">
        <div>网络虚拟</div>
      </div>
      <div class="item-type">
        <img alt="" src="../assets/item-types/other.svg">
        <div> 其他物品</div>
      </div>
    </div>

    <div class="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 max-h-20">
      <div v-for="itemDetail in itemDetails" :key="itemDetail.item.id" class="mx-auto">
        <itemCard :images="itemDetail.images" :item="itemDetail.item"></itemCard>
      </div>
    </div>
  </div>

</template>

<script lang="ts" setup>
import {ref} from 'vue'
import itemCard from '../component/itemCard.vue'

// const itemDetails = ref(new Array<ItemDetail>());
const itemDetails = ref([
      {
        "item": {
          "id": 1,
          "itemStatus": 1,
          "prices": 89,
          "itemType": null,
          "description": "步住定身确主科该对他认声。",
          "name": "公",
          "uid": 140000197507046910
        }, "images": ["http://dummyimage.com/180x150"]
      },
      {
        "item": {
          "id": 2,
          "itemStatus": 1,
          "prices": 89,
          "itemType": null,
          "description": "步住定身确主科该对他认声。",
          "name": "公",
          "uid": 140000197507046910
        }, "images": ["http://dummyimage.com/180x150"]
      },
      {
        "item": {
          "id": 3,
          "itemStatus": 1,
          "prices": 89,
          "itemType": null,
          "description": "步住定身确主科该对他认声。",
          "name": "公",
          "uid": 140000197507046910
        }, "images": ["http://dummyimage.com/180x150"]
      },
      {
        "item": {
          "id": 4,
          "itemStatus": 1,
          "prices": 89,
          "itemType": null,
          "description": "步住定身确主科该对他认声。",
          "name": "公",
          "uid": 140000197507046910
        }, "images": ["http://dummyimage.com/180x150"]
      },
      {
        "item": {
          "id": 5,
          "itemStatus": 1,
          "prices": 89,
          "itemType": null,
          "description": "步住定身确主科该对他认声。",
          "name": "公",
          "uid": 140000197507046910
        }, "images": ["http://dummyimage.com/180x150"]
      },
    ]
)

// onMounted(async () => {
//   await GetAllItem().then(res => {
//     if (res.code == 1) {
//       itemDetails.value = res.data;
//     } else {
//       alert(res.msg)
//     }
//   })
// })
</script>

<style scoped>
.item-type {
  margin-left: 0.5rem;
  margin-right: auto;
  margin-bottom: 1rem;
  padding: 0.5rem 0.5rem;
  border-radius: 1rem;
}

</style>
