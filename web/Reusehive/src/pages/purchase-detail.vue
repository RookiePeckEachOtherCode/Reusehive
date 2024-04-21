<template>
  <t-navbar title="交易详情页"  :fixed="false" left-arrow @left-click="exit" ></t-navbar>
  <t-divider v-if="Pinfo.lock===true" content="订单已完成" style="--td-divider-content-color:rgba(106,232,136,0.78)" />
  <t-divider v-if="Pinfo.lock!==true" content="订单等待支付" style="--td-divider-content-color:rgba(232,173,106,0.78)"></t-divider>
  <div style="display: flex;margin-left: 20px;margin-top: 10px">
    <svg t="1713423057292" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3489" width="32" height="32"><path d="M357.376 279.552c0 79.36 33.792 155.136 93.184 208.384 19.968 6.144 40.96 9.216 61.952 9.216 119.808 0 217.088-97.28 217.088-217.088s-97.28-217.6-217.088-217.6c-20.992 0-41.984 3.072-61.952 9.216-59.392 52.224-93.184 128-93.184 207.872z" fill="#92DBFF" p-id="3490"></path><path d="M512 61.952c119.808 0 217.088 97.28 217.088 217.088S631.808 496.64 512 496.64 294.4 399.36 294.4 279.552 392.192 61.952 512 61.952M512 0C357.888 0 232.448 124.928 232.448 279.552s124.928 279.04 279.552 279.04 279.552-124.928 279.552-279.04S666.112 0 512 0z" fill="#39B4FF" p-id="3491"></path><path d="M918.016 870.912c-4.608-15.872-10.24-31.232-16.896-46.592-3.584-8.192-7.68-16.384-11.776-24.576-29.696-58.368-72.704-109.056-125.44-147.968C691.2 597.504 602.624 568.32 511.488 568.32c-16.384 0-32.256 1.024-48.128 2.56-166.4 68.096-283.136 230.912-283.136 421.888h756.224c-0.512-40.96-6.656-82.432-18.432-121.856z" fill="#92DBFF" p-id="3492"></path><path d="M238.592 659.456c-16.896 0-31.232-13.824-31.232-31.232 0-9.728 4.608-18.944 12.288-24.576 11.264-8.704 23.04-16.384 35.328-24.064 14.336-9.216 33.792-4.608 42.496 9.728 9.216 14.336 4.608 33.792-9.728 42.496-10.752 6.656-20.992 13.824-30.72 20.992-5.12 4.608-11.776 6.656-18.432 6.656zM56.32 1024c-16.896 0-31.232-13.824-31.232-31.232 0-117.76 43.008-231.936 120.32-320.512 11.264-12.8 30.72-14.848 43.52-3.584s14.848 30.72 3.584 43.52l-0.512 0.512A424.81664 424.81664 0 0 0 87.04 992.256c0.512 17.92-13.312 31.744-30.72 31.744z m910.848 0c-16.896 0-31.232-13.824-31.232-31.232 0-57.856-11.776-115.2-34.816-168.448-3.584-8.192-7.68-16.384-11.776-24.576-29.696-58.368-72.704-109.056-125.44-147.968-117.248-86.528-270.848-107.52-407.04-54.272-15.872 6.656-33.792-0.512-40.448-16.384-6.656-15.872 0.512-33.792 16.384-40.448 0.512 0 1.024-0.512 1.536-0.512 155.648-60.928 331.776-37.376 466.432 62.464 60.416 44.544 109.568 102.912 143.872 169.472 4.608 9.216 9.216 18.432 13.312 28.16 26.624 60.928 39.936 126.976 39.936 193.024 0.512 16.896-13.312 30.72-30.72 30.72 0.512 0 0.512 0 0 0z" fill="#39B4FF" p-id="3493"></path></svg>
    <div style="display:grid;">
    <el-text style="margin-left: 20px">{{buyer.name+" "+"   "+buyer.academy }}</el-text>
    <el-text style="margin-left: 20px">{{buyer.phone_number}}</el-text>
  </div>
  </div>
  <t-divider></t-divider>
  <div style="display: flex;margin-right: 20px;margin-top: 10px;flex-direction: row-reverse">
    <svg t="1713423023305" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1639" width="32" height="32"><path d="M984.886557 130.85377c-2.601967-57.142557-48.34623-102.920393-105.555934-105.505574l-221.586885-10.139279c-31.122885-1.410098-61.339279 10.307148-83.330098 32.297967L57.142557 564.794754c-43.159082 43.243016-43.159082 113.294689 0 156.520918L288.902295 953.07541c43.22623 43.209443 113.311475 43.209443 156.520918 0L962.727869 435.787541c22.024393-21.99082 33.724852-52.240787 32.314754-83.313311L984.886557 130.85377zM451.181115 724.656262c-18.331279 18.348066-41.211803 31.693639-55.262426 35.739279l-22.645508-37.417967c14.772459-4.750689 34.748852-14.789246 50.226361-30.266754 16.736525-16.669377 18.667016-32.398689 8.141639-42.907279-10.004984-10.004984-23.367344-8.108066-49.571672 4.31423-35.974295 17.408-68.137967 20.009967-91.505311-3.357377-27.412984-27.412984-25.516066-71.243541 12.371934-109.114754 18.146623-18.129836 35.286033-27.664787 49.118426-32.902295l21.168262 37.417967c-9.501377 3.34059-25.482492 10.256787-41.211803 25.969311-15.729311 15.746098-16.182557 30.50177-7.822689 38.878426 10.189639 10.206426 23.787016 5.673967 52.391869-7.184787 38.878426-17.861246 66.979672-16.417574 89.608393 6.211148C493.148328 636.978361 495.263475 680.573902 451.181115 724.656262zM622.088393 548.931148l-53.583738-28.789508-45.979279 45.979279 29.746361 52.677246-37.61941 37.652984-111.481705-209.735344 47.624393-47.657967 210.390033 110.81023L622.088393 548.931148zM670.820721 500.282754l-160.633705-160.633705 36.444328-36.444328 130.148721 130.131934 63.857311-63.890885 30.518557 30.518557L670.820721 500.282754zM780.707672 390.345443l-160.566557-160.600131 99.10977-99.143344 29.763148 29.779934-62.665443 62.68223 33.372328 33.355541 59.089836-59.089836 29.528131 29.561705-59.073049 59.073049 38.10623 38.139803 65.989246-65.989246 29.830295 29.763148L780.707672 390.345443z" fill="#AA4141" p-id="1640"></path><path d="M500.568131 533.705443l35.521049-35.504262-44.082361-24.072393c-12.371934-6.664393-27.144393-15.695738-39.079869-22.863738l-0.48682 0.48682c7.184787 11.901902 16.92118 26.456131 23.602361 38.37482L500.568131 533.705443z" fill="#AA4141" p-id="1641"></path></svg>
    <div style="display:grid;">
      <el-text style="margin-right: 20px">{{solder.name+" "+"   "+solder.academy }}</el-text>
      <el-text style="margin-right: 20px">{{solder.phone_number}}</el-text>
    </div>
  </div>
  <t-divider></t-divider>
  <t-cell :title="Iinfo.name" :description="Iinfo.itemType" :image="Iinfo.image"
  style="--td-cell-image-height:72px;
  --td-cell-image-width:72px
"/>
  <el-text style="color:#40db61;margin-left: 20px" v-if="sevenday()!==true">七天质保生效中</el-text>
  <div style="display: flex;flex-direction: row-reverse;margin-top: 10px">
    <div style="display:grid;margin-right: 10px">
      <el-text>应付款:<el-text style="color:#ea6348;">¥{{Pinfo.prices}}</el-text></el-text>
      <el-text v-if="Pinfo.lock===true">实付款:<el-text style="color:#ea6348;">¥{{Pinfo.prices}}</el-text></el-text>
    </div>
  </div>
  <div style="display: flex;flex-direction: row-reverse;margin-top: 20px">
    <el-button v-if="Pinfo.lock===true" style="color: #ea6348;width: 80px;height: 35px;margin-right: 10px">申请售后</el-button>
    <el-button v-if="Pinfo.lock!==true" style="width: 80px;height: 35px;margin-right: 10px;background-color: #6aeb62">去支付</el-button>
    <el-button style="width: 100px;height: 35px;margin-right: 20px" @click="gochat(solder.name,solder.id)"><svg style="height: 23px;width: 23px"  t="1713423978903" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4531" width="16" height="16"><path d="M566.15 759.858l28.124-4.974c88.974-15.736 168.055-56.935 224.522-115.51C874.514 581.577 905 510.333 905 435.5 905 257.462 731.186 109 512.5 109S120 257.462 120 435.5c0 74.676 30.357 145.778 85.859 203.516 56.238 58.504 135.023 99.744 223.725 115.664l28.018 5.029 54.316 97.736 54.233-97.587z m-147.165 53.879C213.946 776.937 60 621.574 60 435.5 60 222.042 262.591 49 512.5 49S965 222.042 965 435.5c0 186.465-154.593 342.09-360.277 378.467l-49.1 88.352a50 50 0 0 1-19.417 19.417c-24.137 13.414-54.579 4.72-67.993-19.417l-49.228-88.582z" fill="#2F54EB" p-id="4532"></path><path d="M457.5 435.5c0-30.376 24.624-55 55-55s55 24.624 55 55-24.624 55-55 55-55-24.624-55-55z m-183 0c0-30.376 24.624-55 55-55s55 24.624 55 55-24.624 55-55 55-55-24.624-55-55z m365 0c0-30.376 24.624-55 55-55s55 24.624 55 55-24.624 55-55 55-55-24.624-55-55z" fill="#85A5FF" p-id="4533"></path></svg>联系卖家</el-button>
    <el-button style="width: 100px;height: 35px;margin-right: 10px">分享到微信</el-button>
  </div>
  <t-divider></t-divider>
  <t-collapse>
    <t-collapse-panel value="0" header="查看更多订单信息">
      <div style="display:grid;">
        <el-text>订单编号:{{Pinfo.id}}</el-text>
        <el-text>商品编号:{{Iinfo.id}}</el-text>
        <el-text>创建时间:{{Pinfo.createTime}}</el-text>
        <el-text v-if="Pinfo.lock">完成时间{{Pinfo.lockTime}}</el-text>
      </div>
    </t-collapse-panel>
  </t-collapse>

</template>
<script setup lang="js">
import{ref,onMounted,reactive} from "vue";
import {getUserInfoByUidApi} from "../apis/UserApi.ts";
import{GetpurchaseInfoByPid} from "../apis/PurchaseApi.ts";
import {getItemByItemIdApi} from "../apis/ItemApi.ts";
import {useRoute} from "vue-router";
import router from "../router/index.ts";
const route=useRoute();
const Pinfo=reactive({
  id:"",
  createTime:"",
  uid:"",
  prices:"",
  lock:"",
  lockTime:"",
})
const Iinfo=reactive({
  id:"",
  uid:"",
  name:"",
  prices:"",
  itemStatus:"",
  itemType:"",
  image:"",
})
const solder=reactive({
  id:"",
  name:"",
  avatar_img:"",
  phone_number:"",
  academy:"",
})

const buyer=reactive({
  id:"",
  name:"",
  phone_number:"",
  academy:"",
})


onMounted(async ()=>{
  await getPinfo();
  await getIinfo();
  await getSoler();
  await getBuyer();
  const data= new Date(Pinfo.lockTime)
})
const getPinfo= async ()=>{
  const pid=route.query.purchaseid;
  let res
  if(typeof pid === 'string')res= await GetpurchaseInfoByPid({id:pid})
  Pinfo.id=res.data.id.toString();
  Pinfo.lock=res.data.lock;
  Pinfo.lockTime=res.data.lockTime
  Pinfo.createTime=res.data.createTime;
  Pinfo.prices=res.data.prices;
  Pinfo.uid=res.data.uid;
}
const getIinfo=async ()=>{
  const itemid=route.query.itemid;
  let res
  if(typeof itemid==='string')res=await getItemByItemIdApi({id:itemid})
  Iinfo.id=res.data.item.id.toString();
  Iinfo.uid=res.data.item.uid.toString();
  Iinfo.name=res.data.item.name;
  Iinfo.prices=res.data.item.prices;
  Iinfo.itemType=res.data.item.itemType;
  Iinfo.itemStatus=res.data.item.itemStatus;
  Iinfo.image=res.data.images[0];
}
const getSoler=async ()=>{
  const res=await getUserInfoByUidApi({id:Iinfo.uid});
  solder.id=Iinfo.uid;
  solder.name=res.data.name;
  solder.avatar_img=res.data.avatar_img;
  solder.phone_number=res.data.phone_number;
  solder.academy=res.data.academy;
}

const getBuyer=async ()=>{
  const res=await getUserInfoByUidApi({id:Pinfo.uid})
  buyer.name = res.data.name;
  buyer.id=res.data.id.toString();
  buyer.phone_number=res.data.phone_number;
  buyer.academy=res.data.academy;
}
const exit=()=>{
  router.push({name:"purchase"})
}
const sevenday=()=>{
  if(Pinfo.lock!==true)return true
  const lockTime = new Date(Pinfo.lockTime);
  const now = new Date();
  const timeDiff = now.getTime() - lockTime.getTime();
  const daysDiff = timeDiff / (1000 * 3600 * 24); // 毫秒转换为天
  return daysDiff >= 7;
}
const gochat=(name,id)=>{
  router.push({name:"chat",query:{tousername:name,touserid:id}});

}
</script>
<style scoped>

</style>