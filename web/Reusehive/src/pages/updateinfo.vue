<template>
  <t-navbar :fixed="false" left-arrow title="注册" @left-click="back"/>
  <t-form
      ref="form"
      :data="formData"
      class="formLayout"
      label-align="left"
      reset-type="initial"
      show-error-message
      @reset="onReset"
      @submit="onSubmit"
  >

    <div class="UploadImg">
      <t-form-item label="头像" name="avatar" style="display:flex;">
        <t-upload :autoUpload="false" :beforeUpload="beforeUploadAvatar" :max="1" :onRemove="onRemoveAvatar">
          <template #addContent>
            <div class="add-content">
              <t-image
                  alt=""
                  v-bind:src="originAvatar"
              />
            </div>
          </template>
        </t-upload>
      </t-form-item>
      <t-form-item label="背景">
        <t-upload :autoUpload="false" :beforeUpload="beforeUploadBackImg" :max="1" :onRemove="onRemoveBackImg">
          <template #addContent>
            <div class="add-content">
              <t-image
                  alt=""
                  v-bind:src="originBackImg"
              />
            </div>
          </template>
        </t-upload>
      </t-form-item>
    </div>
    <t-form-item label="用户名" name="name">
      <t-input v-model="formData.name" :borderless=false placeholder="请输入内容"></t-input>
    </t-form-item>
    <t-form-item label="电话" name="social_info">
      <t-input v-model="formData.phone_number" :borderless=true placeholder="默认+86"></t-input>
    </t-form-item>
    <t-form-item label="性别" name="gender">
      <t-radio-group v-model="formData.gender" borderless class="box">
        <t-radio :block="false" label="男" value="1"/>
        <t-radio :block="false" label="女" value="0"/>
      </t-radio-group>
    </t-form-item>
    <t-form-item label="年级" name="social_info">
      <t-input v-model="formData.grade" :borderless=true placeholder="四位整数"></t-input>
    </t-form-item>
    <t-form-item arrow content-align="right" label="学院" name="academy">
      <t-input
          v-model="formData.academy" align="right"
          borderless
          placeholder="请输选择内容"
          @click="showCascader"
      ></t-input>
      <t-cascader
          v-model:visible="visibleCascader"
          :options="options"
          :value="academy"
          title="选择学院信息"
          @change="onChangeCascader"
      />
    </t-form-item>
    <t-form-item label="签名" name="social_info">
      <t-input v-model="formData.social_info" :borderless=true placeholder=""></t-input>
    </t-form-item>

  </t-form>
  <div class="button-group">
    <t-button id="left-button" size="large" theme="primary" type="submit" @click="onSubmit">更新</t-button>
    <t-button size="large" theme="default" type="reset" variant="base" @click="onReset">恢复</t-button>
  </div>
</template>
<script lang="ts" setup>
import {onMounted, reactive, ref} from "vue";
import router from "../router";
import {getCurrentUserInfo, UploadUserInfo} from "../apis/UserApi.ts";
import {areaList} from "../const/area-list.ts";
import {notify_err} from "../utils/notify.ts";
import user from "../model/user.ts";

onMounted(() => {
  getCurrentUserInfo().then(res => {
    if (res.data == null) {
      notify_err("请先登录")
      return
    }

    if (res.code == 1) {
      originData.value = res.data
      originAvatar.value = res.data.avatar_img
      originBackImg.value = res.data.back_img
      onReset()
    } else {
      notify_err(res.msg)
    }
  }).catch(err => {
    notify_err(err)
  })
})

const originData = ref<user>()
const originAvatar = ref('')
const originBackImg = ref('')
const avatar = reactive(Array<any>());
const back_img = reactive(Array<any>());

const beforeUploadAvatar = (file: any) => {
  avatar.push(file)
  return true
}
const onRemoveAvatar = (index: number) => {
  avatar.splice(index, 1)
}

const beforeUploadBackImg = (file: any) => {
  back_img.push(file)
  return true
}
const onRemoveBackImg = (index: number) => {
  back_img.splice(index, 1)
}

const formData = reactive({
  name: "",
  gender: "",
  grade: "",
  academy: "",
  phone_number: "",
  social_info: "",
  avatar_img: "",
  back_img: "",
})

const form = ref(null);
const onReset = () => {
  formData.grade = originData.value!.grade.toString()
  formData.phone_number = originData.value!.phone_number.toString()
  formData.academy = originData.value!.academy.toString()
  formData.name = originData.value!.name.toString()
  formData.social_info = originData.value!.social_info.toString()
  formData.gender = originData.value!.gender.toString()
  console.log(formData)
}
const onSubmit = async () => {
  await UploadUserInfo(formData).then(res => {
    if (res.code == 1) {
      router.push({name: "home"});
    } else {
      notify_err(res.msg)
    }
  }).catch(err => {
    notify_err(err)
  })
}
const back = () => {
  router.push({name: "home"});
}
const options = areaList;
const visibleCascader = ref(false)
const academy = ref("软件工程")
const onChangeCascader = (value: string, options: any) => {
  formData.academy = options?.map((item: any) => item.label).join('/');
  visibleCascader.value = false;
  console.log(value)
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

    width: 20%;

    &:not(:last-child) {
      flex: 1;
      margin-right: 16px;
    }
  }
}

#left-button {
  background-color: #529b2e;
  --td-button-primary-border-color: #529b2e;
}
</style>
