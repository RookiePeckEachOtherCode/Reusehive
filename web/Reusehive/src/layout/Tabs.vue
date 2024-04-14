<template>
  <div class="demo-tab-bar" style="">
    <t-tabs default-value="first">
      <t-tab-panel value="first">
        <template #label>
          <div class="label-content" @click="goto(1)">
            <icon-font name="app" size="large" />
            <span>物品列表</span>
          </div>
        </template>
      </t-tab-panel>
      <t-tab-panel value="second">
        <template #label>
          <div class="label-content" @click="goto(2)">
            <icon-font name="app" size="large" />
            <span>交易记录</span>
          </div>
        </template>
      </t-tab-panel>
      <t-tab-panel value="third">
        <template #label>
          <div class="label-content" @click="goto(3)">
            <icon-font name="app" size="large" />
            <span>聊天</span>
          </div>
        </template>
      </t-tab-panel>
      <t-tab-panel value="fourth" >
        <template #label>
          <div class="label-content" @click="goto(4)">
            <icon-font name="app" size="large" />
            <span>个人</span>
          </div>
        </template>
      </t-tab-panel>

    </t-tabs>
  </div>
</template>

<script lang="ts" setup>
import { IconFont } from 'tdesign-icons-vue-next';
import router from "../router";
const goto=(id)=>{
  if(id===1)router.push({name:'item'})
  if(id===2)router.push({name:'purchase'})
  if(id===3)router.push({name:'item'})
  if(id===4)router.push({name:'home'})
}
</script>

<style lang="less" scoped>
.t-tabs {
  margin-bottom: 16px;
}

.label-content {
  display: flex;
  align-items: center;
  justify-content: center;

  span {
    margin-left: 3px;
  }
}
</style>