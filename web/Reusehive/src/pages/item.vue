<template>
  <div class="item-detail-container">
    <div class="navbar">
      <t-navbar :fixed="false" left-arrow title="商品详情页" @left-click="goBack"/>
    </div>

    <div class="item-images">
      <t-swiper :autoplay="true" :navigation="{ type: 'dots' }" @change="" @click="">
        <t-swiper-item v-for="(url, index) in item.images" :key="index" style="height: 192px">
          <img :src="url.toString()" class="img"/>
        </t-swiper-item>
      </t-swiper>
    </div>
    <div class="user-info">
      <div class="avatar-container" @click="goToInfo">
        <t-avatar class="avatar" v-bind:image="user.avatar_img" style="--td-avatar-medium-width:60px"></t-avatar>
      </div>
      <div class="info-container">
        <div style="display: grid">
          <span class="username" style="font-size: 18px">{{ user.name }}</span>
          <span class="academy" style="font-size: 12px">{{ user.academy }}</span>
        </div>
      </div>
      <el-button round type="primary" plain style="width:75px;height:35px;" @click="gochat">
        <svg t="1714375119160" class="icon" viewBox="0 0 1879 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5050" width="48" height="48"><path d="M1030.954913 474.265896c-26.043931 0-47.352601 21.160694-47.352601 47.352601s21.308671 47.352601 47.352601 47.352601 47.352601-21.308671 47.352601-47.352601-21.160694-47.352601-47.352601-47.352601zM1452.54104 109.946821c0-36.402312-29.595376-65.997688-65.997687-65.997688H675.514451c-36.402312 0-65.997688 29.595376-65.997688 65.997688V176.092486h57.267052V101.216185H1395.421965v466.571098h-74.8763v57.267052H1386.543353c36.402312 0 65.997688-29.595376 65.997687-65.997688V109.946821zM843.912139 474.265896c-26.043931 0-47.352601 21.160694-47.352601 47.352601s21.308671 47.352601 47.352601 47.352601 47.352601-21.308671 47.352601-47.352601-21.308671-47.352601-47.352601-47.352601z" fill="#212121" p-id="5051"></path><path d="M1265.498266 297.137572c0-36.402312-29.595376-65.997688-65.997688-65.997688H488.323699c-36.402312 0-65.997688 29.595376-65.997687 65.997688v449.109827c0 36.402312 29.595376 65.997688 65.997687 65.997688h83.606937V987.00578l174.760693-174.760693h452.661272c36.402312 0 65.997688-29.595376 65.997688-65.997688V297.137572h0.147977zM1204.531792 751.278613H721.387283l-88.490173 88.490173v-88.490173H483.144509V291.958382H1204.531792v459.320231z" fill="#212121" p-id="5052"></path><path d="M656.721387 474.265896c-26.043931 0-47.352601 21.160694-47.352601 47.352601s21.308671 47.352601 47.352601 47.352601 47.352601-21.308671 47.352601-47.352601-21.160694-47.352601-47.352601-47.352601z" fill="#212121" p-id="5053"></path></svg>
      </el-button>
    </div>
    <t-divider />

    <div class="item-title">
      <svg style="width: 64px;max-height: 34px" t="1714375903177" class="icon" viewBox="0 0 3449 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6139" width="64" height="64"><path d="M2937.263158 1024h-2425.263158A512.592842 512.592842 0 0 1 0 512 512.592842 512.592842 0 0 1 512 0h2425.263158A512.592842 512.592842 0 0 1 3449.263158 512a512.592842 512.592842 0 0 1-512 512z m-1971.146105-388.042105a276.911158 276.911158 0 0 1-187.553685 95.339789l56.589474 118.083369a22.743579 22.743579 0 0 0 19.402105 12.880842h0.269474a24.306526 24.306526 0 0 0 19.132632-11.210106l43.654736-72.757894 84.07579 12.934737h4.850526a20.318316 20.318316 0 0 0 21.018948-21.072843 21.557895 21.557895 0 0 0-4.850527-12.880842l-56.535579-121.263158zM592.842105 775.006316l43.654737 72.704a24.252632 24.252632 0 0 0 19.402105 11.371789h1.616842a22.635789 22.635789 0 0 0 19.402106-12.934737l56.589473-118.029473a257.509053 257.509053 0 0 1-187.553684-92.16l-58.206316 122.88a19.887158 19.887158 0 0 0 1.616843 21.018947 23.498105 23.498105 0 0 0 19.402105 8.084211l84.075789-12.934737z m2033.825684-397.312v149.773473a333.716211 333.716211 0 0 1-53.14021 193.320422l32.067368 29.318736a388.958316 388.958316 0 0 0 63.703579-209.327158h294.103579V377.694316H2818.155789c-7.653053-21.557895-15.198316-40.259368-22.42021-56.373895l-46.780632 7.329684a385.670737 385.670737 0 0 1 24.737685 49.044211zM1709.541053 506.448842v242.526316h42.576842V438.325895a606.046316 606.046316 0 0 0 40.313263-98.465684l-40.744421-19.240422a544.013474 544.013474 0 0 1-94.369684 186.044632l14.22821 46.726737c11.587368-13.150316 24.360421-28.833684 37.726316-46.618947z m148.426105 217.573053h155.755789v23.821473h42.145685V582.063158h-240.047158v165.834105h42.145684v-23.767579z m-497.502316-332.584421v171.331368a267.210105 267.210105 0 0 1-44.409263 156.672l31.151158 27.917474a314.206316 314.206316 0 0 0 55.457684-184.589474v-37.726316h37.079579c-0.269474 47.265684-1.239579 79.279158-2.748632 92.537263s-5.820632 20.264421-11.910736 21.557895h-28.887579l10.778947 35.247158h28.887579a37.402947 37.402947 0 0 0 33.468632-28.887579 706.021053 706.021053 0 0 0 9.593263-156.672H1402.88V431.157895h89.357474a947.738947 947.738947 0 0 0 14.659368 143.36c4.203789 21.935158 8.192 39.397053 11.910737 51.738947a247.053474 247.053474 0 0 1-85.692632 83.375158l26.138948 33.414737a255.029895 255.029895 0 0 0 75.129263-69.632 193.482105 193.482105 0 0 0 13.743158 28.833684c16.168421 27.378526 31.959579 41.229474 46.295579 41.229474 16.168421 0 28.725895-31.744 37.726316-94.369684l-35.247158-19.186527c-2.910316 43.708632-5.766737 63.218526-9.162106 63.218527-4.850526 0-11.479579-10.347789-19.671579-30.72a213.746526 213.746526 0 0 1-9.162105-26.947369 602.004211 602.004211 0 0 0 53.894737-151.605895l-35.301053-14.659368a563.523368 563.523368 0 0 1-32.067368 107.196632l-2.694737-15.575579a1063.127579 1063.127579 0 0 1-10.778947-129.670737h83.375158v-39.882106h-44.894316l27.917474-12.341894a332.476632 332.476632 0 0 0-26.947369-53.625263l-30.72 12.341894a331.129263 331.129263 0 0 1 26.947369 53.625263h-36.648422l-0.91621-65.967157h-40.313263c0 31.043368 0 52.008421 0.862316 65.967157zM2161.717895 340.614737v224.471579a264.084211 264.084211 0 0 1-42.630737 149.773473l33.468631 29.80379a277.396211 277.396211 0 0 0 50.822737-142.928842h107.789474v130.586947h43.978105v-130.586947h113.610106v68.230737c0 17.946947-7.545263 26.947368-22.420211 26.947368-13.473684 0-30.288842-0.808421-49.960421-2.317474l11.425684 42.630737h52.655158a46.295579 46.295579 0 0 0 52.655158-51.792842v-344.926316zM1264.262737 503.269053v159.851789a28.833684 28.833684 0 0 1-11.910737 22.905263l16.168421 38.049684a563.523368 563.523368 0 0 0 74.644211-66.883368l-10.778948-42.576842-1.293473 1.455158c-2.155789 2.263579-5.766737 6.036211-11.587369 11.802947s-10.078316 10.186105-12.826947 13.312V461.608421h-102.4v41.714526z m-506.610526-287.636211a237.945263 237.945263 0 0 0-237.67579 237.67579 235.142737 235.142737 0 0 0 237.67579 237.675789 234.334316 234.334316 0 0 0 236.005052-237.675789A234.334316 234.334316 0 0 0 757.598316 215.578947z m1068.139789 298.145684v39.397053h220.375579v-39.397053z m0-64.673684v38.965895h220.375579v-38.965895z m-558.888421-120.508631l-30.288842 28.887578a432.451368 432.451368 0 0 1 74.213052 69.146948l29.80379-30.234948a620.544 620.544 0 0 0-73.728-67.799578z m517.389474 51.738947v40.798316h301.002105v-40.798316h-123.957895a389.658947 389.658947 0 0 0-21.989052-56.805053l-41.660632 11.425684a376.616421 376.616421 0 0 1 20.641684 45.379369z m229.537684 302.834526h-155.75579v-60.901052h155.75579v60.847157z m-1189.672421-105.472a26.947368 26.947368 0 0 1-11.317895-1.670737l-56.589474-32.336842-56.535579 29.103158a12.557474 12.557474 0 0 1-7.760842 2.479158 48.505263 48.505263 0 0 1-14.497684-3.449263l-1.994105-0.646737a18.539789 18.539789 0 0 1-8.084211-21.018947l11.317895-63.056842-46.834526-45.271579a18.108632 18.108632 0 0 1-4.850527-21.072842 19.186526 19.186526 0 0 1 17.731369-14.551579l63.056842-8.030316 27.486316-56.589474a26.947368 26.947368 0 0 1 19.402105-12.934737 22.635789 22.635789 0 0 1 19.402105 12.934737l27.486316 58.206316 63.056842 8.08421a23.659789 23.659789 0 0 1 21.018948 14.551579c1.562947 7.760842 0 17.677474-6.467369 21.018948l-45.325474 45.271579 11.37179 63.056842a19.994947 19.994947 0 0 1-8.084211 21.072842 32.336842 32.336842 0 0 0-5.01221 2.263579 16.815158 16.815158 0 0 1-8.29979 2.640842z m1644.597895-16.168421h-113.610106v-70.063158h113.610106v70.063158z m-157.588211 0h-105.364211v-70.063158h105.364211v70.063158z m608.417684-63.218526h-249.694316V420.378947h249.694316v77.824z m-450.829473-46.780632h-113.610106V382.652632h113.610106v68.608z m-157.588211 0h-105.364211V382.652632h105.364211v68.608z" fill="#F1BE62" p-id="6140"></path></svg>
      <p>{{ item.item.name }}</p>
      <el-text>{{item.item.itemType}}</el-text>
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
      <t-divider />
      <div class="botbar">

        <t-button class="star-icon" theme="primary" @click="UseCollection() " >
          <div v-if="collected_computed">
            <img alt="" src="../assets/true_collected.svg"/>
          </div>
          <div v-else>
            <img alt="" src="../assets/false_collected.svg"/>
          </div>
        </t-button>
        <t-button class="beer-icon" style="" theme="primary" @click="buy">
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
  router.push({name: "chat", query: {tousername: user.value.name.toString(), touserid: user.value.id.toString()}});
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
  router.push({name: "user-info", query: {id: user.value.id.toString()}});
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
    min-width: 45vw ;
    max-width: 45vw ;
    display: flex;
    flex-direction: row;
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
  margin-top: -10px;
  margin-left: 20px;
  font-size: 25px;
  display: grid;
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
  min-height: 13vh;
  max-height: 13vh;
  overflow: scroll;

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
    width: 40%;
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
  min-height: 40vh;
}
</style>