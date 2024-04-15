<template>
  <t-navbar title="修改信息" :fixed="false" left-arrow @left-click="back" />
  <t-form
    ref="form"
    :data="formData"
    reset-type="initial"
    show-error-message
    label-align="left"
    @reset="onReset"
    @submit="onSubmit"
    class="formLayout"
  >

    <t-form-item label="头像" name="avatar" style="display:flex;">
      <t-upload
          v-model="back_img"
          :multiple="false"
          :max="1"
          :size-limit="{ size: 3000000, unit: 'B' }"
          accept="image/png"
          action="//service-bv448zsw-1257786608.gz.apigw.tencentcs.com/api/upload-demo"
      >

      </t-upload>
      <p>背景</p>
      <t-upload
          v-model="avatar"
          :multiple="false"
          :max="1"
          :size-limit="{ size: 3000000, unit: 'B' }"
          accept="image/png"
          action="//service-bv448zsw-1257786608.gz.apigw.tencentcs.com/api/upload-demo"
      >

      </t-upload>
    </t-form-item>
  <t-form-item label="用户名" name="name" >
    <t-input v-model="formData.name" :borderless=false placeholder="请输入内容"></t-input>
  </t-form-item>
    <t-form-item label="密码" name="password">
      <t-input v-model="formData.password" :borderless=false type="password" :clearable="false" placeholder="请输入内容">
        <template #suffixIcon>
          <BrowseOffIcon />
        </template>
      </t-input>
    </t-form-item>
    <t-form-item label="电话" name="social_info">
      <t-input v-model="formData.phone_number" :borderless=true placeholder=""></t-input>
    </t-form-item>
    <t-form-item label="性别" name="gender">
      <el-radio-group v-model="formData.gender" size="large">
        <el-radio :value="1" size="large">男</el-radio>
        <el-radio :value="0" size="large">女</el-radio>
      </el-radio-group>
    </t-form-item>
    <t-form-item arrow label="学院" name="academy" content-align="right">
      <t-input
          v-model="formData.academy"
          borderless
          align="right"
          placeholder="请输入内容"
          @click="showCascader"
      ></t-input>
      <t-cascader
          v-model:visible="visibleCascader"
          :value="academy"
          title="选择学院信息"
          :options="options"
          @change="onChangeCascader"
      />
    </t-form-item>
    <t-form-item label="签名" name="social_info">
      <t-input v-model="formData.social_info" :borderless=true placeholder=""></t-input>
    </t-form-item>

  </t-form>
  <div class="button-group">
    <t-button theme="primary" type="submit" size="large">提交</t-button>
    <t-button theme="default" variant="base" type="reset" size="large">重置</t-button>
  </div>
</template>
<script setup lang="ts">
import {reactive,ref} from "vue";
import { BrowseOffIcon } from 'tdesign-icons-vue-next';
import router from "../router";

const avatar=ref([])
const back_img=ref([])

const formData=reactive({
  name:"",
  password:"",
  gender:1,
  academy:"",
  phone_number:"",
  social_info:"",
  avatar_img:"",
  back_img:"",

})
const form=ref(null);
const onReset=()=>{

}
const onSubmit=()=>{

}
const back=()=>{
  router.push({name:"home"});
}
const data = {
  areaList: [
    {
      label: '计算机学院',
      value: '计算机学院',
      children: [
        { value: '软件工程', label: '软件工程' },
        { value: '网络工程', label: '网络工程' },
        { value: '信息安全', label: '信息安全' },
        // 可以继续添加其他专业
      ],
    },
    {
      label: '工商管理学院',
      value: '工商管理学院',
      children: [
        { value: '市场营销', label: '市场营销' },
        { value: '人力资源管理', label: '人力资源管理' },
        { value: '财务管理', label: '财务管理' },
        // 可以继续添加其他专业
      ],
    },
    {
      label: '文学院',
      value: '文学院',
      children: [
        { value: '汉语言文学', label: '汉语言文学' },
        { value: '外国语言文学', label: '外国语言文学' },
        { value: '新闻传播学', label: '新闻传播学' },
        // 可以继续添加其他专业
      ],
    },
    {
      label: '法学院',
      value: '法学院',
      children: [
        { value: '法学', label: '法学' },
        { value: '知识产权', label: '知识产权' },
        { value: '行政管理', label: '行政管理' },
        // 可以继续添加其他专业
      ],
    },
    // 可以继续添加其他学院
  ],
};
const options=data.areaList;
const visibleCascader = ref(false)
const academy=ref("软件工程")
const onChangeCascader = (value: string, options: any) => {
  formData.academy = options?.map((item: any) => item.label).join('/');
  visibleCascader.value = false;
};
const showCascader = () => {
  visibleCascader.value = true;
};

</script>

<style scoped>
.button-group {
  background-color: white;
  box-sizing: border-box;
  padding: 16px;
  display: flex;
  justify-content: space-between;
  position: relative;
  border-bottom: 0.5px solid #e7e7e7;

  .t-button {
    height: 32px;
    flex: 1;

    &:not(:last-child) {
      flex: 1;
      margin-right: 16px;
    }
  }
}
</style>