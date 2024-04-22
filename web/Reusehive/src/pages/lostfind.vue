<template>
  <t-navbar :fixed="false" title="失物招领处" left-arrow @left-click="exit" />
  <t-drawer v-model:visible="visible" :items="baseSidebar" @item-click="itemClick"></t-drawer>
  <t-button style="margin-top: 15px" block variant="outline" size="large" theme="primary" @click="visible = true">{{theme}}</t-button>
  <t-list style="max-height: 75vh;overflow: auto;background-color: white">
    <div v-for="info in List" style="margin-top: 15px; margin-bottom: 15px;display: flex" >
      <t-cell>

        <t-image style="width: 72px; height: 72px;" :src="info.images[0]" @click="GoItemDetail(info.item.id.toString())"></t-image>
        <div style="flex: 1; margin-left: 10px;margin-top: 15px" @click="GoItemDetail(info.item.id.toString())" >
          <el-text style="font-size: 18px;" >{{info.item.name}}</el-text>
          <div style="font-size: 12px;margin-top: 12px">
            {{info.item.itemType}}
          </div>

        </div>
      </t-cell>
      <t-divider />
    </div>

  </t-list>

</template>
<script setup lang="ts">
import router from "../router";
import {ref,onMounted} from "vue";
import {SerachItem} from "../apis/ItemApi.ts";
import {DrawerItem} from "tdesign-mobile-vue/es/drawer";
import {getUserInfoByName} from "../apis/UserApi.ts";
import {LocalStorage} from "../storage/LocalStorage.ts";
const List=ref([])
const theme=ref("切换到失物悬赏列表")
const uid=ref("")
onMounted(async ()=>{
   await onSerach("失物招领")
    const res=await getUserInfoByName({name:LocalStorage().getusername()})
  uid.value=res.data.id.toString()
})
const onSerach= async (condition:string)=>{
  const res=await SerachItem({condition:condition})
  List.value=res.data;
}
const baseSidebar = ref([
  {
    title: '失物招领',
  },
  {
    title: '失物悬赏',
  },
]);
const visible = ref(false);
const GoItemDetail=(tid:string)=>{
  router.push({name:"item",query:{uid:uid.value,tid:tid}})
}
const itemClick =async (index: number, item: DrawerItem, context: { e: MouseEvent }) => {
  console.log('itemclick: ', index, item, context);
  if(index===0){
    theme.value="切换到失物悬赏列表"
    await  onSerach("失物招领")
  }else{
    theme.value="切换到失物招领列表"
    await onSerach("失物悬赏")
  }
  visible.value=false
};
const exit=()=>{
  router.back();
}
</script>
<style scoped>

</style>