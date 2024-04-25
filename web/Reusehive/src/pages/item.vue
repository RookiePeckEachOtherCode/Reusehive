<template>
  <div class="item-detail-container">
    <div class="navbar">
      <t-navbar :fixed="false" left-arrow @left-click="goBack"/>
    </div>
    <div class="user-info">
      <div class="avatar-container" @click="goToInfo">
        <t-avatar class="avatar" v-bind:image="user.avatar_img"></t-avatar>
      </div>
      <div class="info-container">
        <span class="username">{{ user.name }}</span>
        <span class="academy">{{ user.academy }}</span>
      </div>
    </div>
    <div class="item-title">
      <p>{{ item.item.name }}</p>
    </div>
    <div class="item-images">
      <t-swiper :autoplay="true" :navigation="{ type: 'dots' }" @change="" @click="">
        <t-swiper-item v-for="(url, index) in item.images" :key="index" style="height: 192px">
          <img :src="url.toString()" class="img"/>
        </t-swiper-item>
      </t-swiper>
    </div>
    <div class="item-info">
      <div class="price">
        <span class="symbol">¥</span>
        <span class="data">
                    {{ item.item.prices }}
                </span>
      </div>
      <div class="desc">
        <p>{{ item.item.description }}</p>
      </div>
      <div class="botbar">
        <t-button :icon="chatIcon" class="chat-icon" theme="primary" @click="gochat">
          聊一聊
        </t-button>
        <t-button class="star-icon" theme="primary" @click="UseCollection()">
          <div v-if="collected_computed">
            <img alt="" src="../assets/true_collected.svg"/>
          </div>
          <div v-else>
            <img alt="" src="../assets/false_collected.svg"/>
          </div>
        </t-button>
        <t-button class="beer-icon" style="height: 50px" theme="primary" @click="buy">
          <img alt="" src="../assets/buy.svg"/>
        </t-button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {computed, h, onMounted, ref} from 'vue';
import router from '../router';
import User from '../model/user';
import {ChatIcon} from 'tdesign-icons-vue-next';
import {addCollection, deleteCollection, getItemByItemIdApi, isCollected} from '../apis/ItemApi';
import {getUserInfoByUidApi} from '../apis/UserApi';
import ItemDetail from '../model/itemDetail.ts';
import {CreatePurchase} from "../apis/PurchaseApi.ts";
import { Toast } from 'tdesign-mobile-vue';

const chatIcon = () => h(ChatIcon, {size: '24px'})
// const starIcon = () => h(StarIcon, { size: '24px' })
// const beerIcon = () => h(BeerIcon, { size: '24px' })

onMounted(async () => {
  const tid = router.currentRoute.value.query.tid?.toString() ?? ' ';
  const uid = router.currentRoute.value.query.uid?.toString() ?? ' ';


  await getItemByItemIdApi({id: tid}).then(
      res => item.value = res.data
  )
  await getUserInfoByUidApi({id: uid}).then(
      res => user.value = res.data
  )
  await CheckCollected()

  // console.log(item.value)
  // console.log(user.value)
})

const item = ref<ItemDetail>(new ItemDetail());
const user = ref<User>(new User());
const goBack = () => {
  router.back();
}
const gochat = () => {
  router.replace({name: "chat", query: {tousername: user.value.name.toString(), touserid: user.value.id.toString()}});
}
const buy = async () => {
  const res = await CreatePurchase({
    item_id: item.value.item.id.toString(),
    item_uid: item.value.item.uid.toString(),
    price: item.value.item.prices,
  })
  if(res?.data)await router.push({
    name: "PurchaseDetail",
    query: {purchaseid: res.data.toString(), itemid: item.value.item.id.toString()}
  })
  else{
    Toast(res.msg)
  }
}

const collected = ref(false)

const collected_computed = computed(() => {
  return collected.value
})


const CheckCollected = async () => {
  await isCollected({item_id: item.value.item.id.toString()}).then(res => {
    collected.value = res.data;
  })
}
const UseCollection = async () => {
  
  if (collected.value) {
    await deleteCollection({item_id: item.value.item.id.toString()}).then(_ => {
      collected.value = false
    })
  } else {
    await addCollection({item_id: item.value.item.id.toString()}).then(_ => {
      collected.value = true
    })
  }
}

const goToInfo = () => {
  router.replace({name: "user-info", query: {id: user.value.id.toString()}});
}
</script>

<style lang="less" scoped>
.item-detail-container {
  display: flex;
  flex-direction: column;

}

.user-info {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-left: 16px;
  margin-top: 10px;

  .avatar-container {
    margin-right: 16px;
  }

  .info-container {
    display: flex;
    flex-direction: column;
  }

  .username {
    font-size: 16px;
    font-weight: bold;
  }
}

.item-images {
  margin-top: 16px;
  display: flex;
  flex-direction: column;
  margin-left: 10px;
  margin-right: 10px;

  img {
    border-radius: 10px;
    width: 100%;
    height: 100%;
  }
}

.item-title {
  margin-top: 10px;
  margin-left: 10px;
  font-size: 30px;

}

.price {
  margin-top: 12px;
  margin-left: 8px;

  .symbol {
    font-size: 18px;
    font-weight: bold;
    color: #F00;
  }

  .data {
    font-size: 28px;
    font-weight: bold;
    color: #F00;
  }
}

.desc {
  margin-top: 5px;
  margin-left: 10px;
  margin-right: 10px;
  color: rgb(41, 41, 41);

  p {
    font-size: 20px;
  }

}

.botbar {
  position: fixed;
  bottom: 5px;
  display: flex;
  width: 100%;
  justify-content: space-around;


  .chat-icon {
    background-color: #70a1d7;
    --td-button-primary-border-color: #70a1d7;
    width: 20%;
  }

  .star-icon {
    background-color: #a1de93;
    --td-button-primary-border-color: #a1de93;
    width: 20%;
  }

  .beer-icon {
    background-color: #f47c7c;
    --td-button-primary-border-color: #f47c7c;
    width: 50%;
    margin-right: 20px;
  }

}

.item-info {
  margin-top: 5px;
  margin-left: 10px;
  margin-right: 10px;
  border-radius: 10px;
}
</style>