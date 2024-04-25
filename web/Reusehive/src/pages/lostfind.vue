<template>
  <t-navbar :fixed="false" title="失物招领处" left-arrow @left-click="exit" />
  <t-drawer v-model:visible="visible" :items="baseSidebar" @item-click="itemClick"></t-drawer>
  <t-button style="margin-top: 15px" block variant="outline" size="large" theme="primary" @click="visible = true">{{theme}}</t-button>
  <t-image style="position: absolute;margin-top: 9vh" src="https://iconfont.alicdn.com/p/illus_3d/file/APvXVsw5Zuzi/f7795047-fe70-4f93-8516-e47884d9dc0c.png?image_process=resize,l_1000">

  </t-image>
  <t-list  style="max-height: 80vh;overflow: auto;background-color: white">
    <t-cell v-for="info in List" :key="info.item.id"
            class="list-item"
            style="display: flex"
            :title="info.item.name"
            @click="GoItemDetail(info.item.id.toString())"
            :image="info.images[0]"
            :description=info.item.description
    >
    </t-cell>

  </t-list>

</template>
<script setup lang="ts">
import router from "../router";
import {ref,onMounted} from "vue";
import {SerachItem} from "../apis/ItemApi.ts";
import {DrawerItem} from "tdesign-mobile-vue/es/drawer";
import {getUserInfoByName} from "../apis/UserApi.ts";
import {LocalStorage} from "../storage/LocalStorage.ts";
import {Toast} from "tdesign-mobile-vue";
import ItemDetail from "../model/itemDetail.ts";
const List=ref<Array<ItemDetail>>([])
const theme=ref("切换到失物悬赏列表")
const uid=ref("")
onMounted(async ()=>{
   await onSerach("失物招领")
   const res=await getUserInfoByName({name:LocalStorage().getusername()??""})
   uid.value=res.data.id.toString()

})
const onSerach= async (condition:string)=>{
  const res=await SerachItem({condition:condition})
  if(res?.code===1)List.value=res.data;
  else{
    Toast(res?.msg)
  }
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
.list-item:nth-child(even) {
  background-color: rgba(192, 187, 181, 0.33); /* 灰色背景 */
}

/* 选择奇数行 */
.list-item:nth-child(odd) {
  background-color: rgba(255, 255, 255, 0.36); /* 白色背景 */
}
</style>