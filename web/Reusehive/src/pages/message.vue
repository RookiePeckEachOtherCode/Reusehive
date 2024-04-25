<template>
  <t-navbar title="消息记录" :fixed="false"></t-navbar>
  <t-image style="
  position: absolute;
  height: 30vh;
  width: 60vw;
  margin-top: 25vh;
  margin-left: 13vw;
" src="https://zh.minecraft.wiki/images/Bee_Artwork.png?dfcc9"></t-image>
  <div style="max-height: 84vh;overflow: auto">
  <t-pull-down-refresh v-model="refreshing" @refresh="loadData" style="min-height: 86vh;background-color: white" >
    <t-list :async-loading="loading" >
      <t-cell v-for="item in List" :key="item.id"
              class="list-item"
              style="display: flex"
              :title="item.name"
              @click="gochat(item.name,item.id)"
              :right-icon="chevronRightIcon"
              :description="item.social_info"
      >
        <template #leftIcon>
          <t-avatar shape="circle" :image="item.avatar_img" />
        </template>
      </t-cell>
    </t-list>
  </t-pull-down-refresh>
  </div>
</template>

<script setup lang="js">
import {userChatInfoApi} from "../apis/UserApi.ts";
import {onMounted, ref,h} from "vue";
import router from "../router";
import { ChevronRightIcon } from 'tdesign-icons-vue-next';
import {Toast} from "tdesign-mobile-vue";
const chevronRightIcon = () => h(ChevronRightIcon);
const loading = ref('');
const refreshing = ref(false);
const List=ref([])
onMounted(async ()=>{
  await loadData();
})
const loadData=async ()=>{
  const res=await userChatInfoApi();
  if(res.code!==1)Toast(res.msg)
  List.value=res.data;
  return true;
}
const gochat=(name,id)=>{
  router.replace({name:"chat",query:{tousername:name,touserid:id}});

}

</script>
<style scoped>
.list-item:nth-child(even) {
  background-color: rgba(192, 187, 181, 0.13); /* 灰色背景 */
}

/* 选择奇数行 */
.list-item:nth-child(odd) {
  background-color: rgba(255, 255, 255, 0.16); /* 白色背景 */
}
</style>