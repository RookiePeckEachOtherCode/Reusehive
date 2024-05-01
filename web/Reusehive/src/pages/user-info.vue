<template>
  <div class="user-info-container">
    <t-navbar :fixed="false" left-arrow @left-click="goBack"/>
    <div :style="{ 'background-image': 'url(' + user.back_img + ')'}" class="info-header">
      <div class="info">
        <el-avatar :src="user.avatar_img" size="large"></el-avatar>
        <span class="name">{{ user.name }}</span>
        <span class="ad">{{ user.academy }}</span>
        <span class="gd">{{ user.grade }} 级/{{ user.gender }}生</span>
      </div>
    </div>
    <div class="info-items">
      <div class="items">
        <div v-for="item in items">
          <itemCard :images="item.images" :item="item.item"></itemCard>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>

import {onMounted, ref} from "vue";
import {useRoute} from "vue-router";
import User from "../model/user.ts";
import {getUserItemInfo} from "../apis/UserApi.ts";
import ItemDetail from "../model/itemDetail.ts";
import itemCard from '../component/ItemCard.vue'
import router from "../router";

const user = ref<User>(new User())
let items = ref<Array<ItemDetail>>([])

const route = useRoute()


onMounted(() => {
  const id = <string>route.query.id
  getUserItemInfo({id: id}).then(res => {
    console.log(res)
    if (res.code == 1) {
      user.value = res.data.user;
      items.value = res.data.items;
      user.value.gender = res.data.user.gender == 1 ? "男" : "女"
    }
  })
})

const goBack = () => {
  router.back()
}


</script>

<style lang="scss" scoped>
.user-info-container {
  display: flex;
  flex-direction: column;
}

.info-items {
  margin-top: 10px;
}

.items {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

p {
  margin-left: 0px;
  margin-top: 5px;
  font-size: 18px;
}

span {
  margin-left: 5px;
  font-size: 16px;

}

.info-header {
  &::before {
    content: '';
    width: 100%;
    height: 200px;
    position: absolute;
    left: 0;
    top: 0;
    z-index: 0;
  }

  width: 100vw;
  height: 220px;
  background-size: cover;

  display: flex;
  justify-content: center;
  align-items: center;

  .info {
    z-index: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    color: #f0f0f0;

    &avatar {
      border: 3px solid #f0f0f0;
      width: 80px;
      height: 80px;
    }

    .name {
      font-size: 20px;
      margin: 7px;
    }

    .ad {
      font-size: 14px;
      margin: 5px 5px 0px 5px;
    }

    .gd {
      font-size: 14px;
      margin: 5px 5px 0px 5px;
    }
  }

}
</style>
