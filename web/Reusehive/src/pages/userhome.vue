<template>
  <div class="profile-container" >
    <div class="profile-header">
      <div class="profile-info">
        <el-avatar size="large" src="https://ts1.cn.mm.bing.net/th/id/R-C.18b0ef152141b4f00d4dccd7ad2aace1?rik=yFn3nV90JZHcjw&riu=http%3a%2f%2fpic.uzzf.com%2fup%2f2018-5%2f201805091154525122038.png&ehk=n3MGluxxusEXz9tvXxHiTnSX92Cz7Xgmix9LaEI9%2bDc%3d&risl=&pid=ImgRaw&r=0"></el-avatar>
        <span class="profile-info-nickname" style="background-color: rgb(0,0,0,0.4)">野兽前辈</span>
        <span class="profile-info-ad  dress" style="background-color: rgb(0,0,0,0.4)">
                    <Icon name="location-o" /> 东京 涩谷
                </span>
      </div>
    </div>
    <t-grid :column="3" class="grid" style="max-height: 80px;--td-grid-item-image-width:25px" >
      <t-grid-item text="订单"  >
        <template #image>
          <div class="icon-wrapper" style="background-color: transparent">
            <svg t="1713140051274" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="9360" width="32" height="32"><path d="M711.9872 219.0848c0.2048 2.7136 0.4096 5.4784 0.4096 8.2432v2.9184c0 53.8624-42.496 97.4848-94.9248 97.4848H474.6752c-52.4288 0-94.9248-43.6224-94.9248-97.4848v-2.9184c0-2.7648 0.2048-5.5296 0.4096-8.2432-96.512 9.216-172.0832 92.5696-172.0832 194.0992v347.4432c0 107.6736 84.992 194.9696 189.8496 194.9696h296.2432c104.8576 0 189.8496-87.296 189.8496-194.9696V413.184c0-101.5296-75.52-184.8832-172.032-194.0992z" fill="#FFF7E6" p-id="9361"></path><path d="M884.0192 495.6672c-14.1312 0-25.6-11.4688-25.6-25.6v-22.3744c0-14.1312 11.4688-25.6 25.6-25.6s25.6 11.4688 25.6 25.6v22.3744c0 14.1824-11.4176 25.6-25.6 25.6zM668.6208 508.4672H342.272c-14.1312 0-25.6-11.4688-25.6-25.6s11.4688-25.6 25.6-25.6h326.3488c14.1312 0 25.6 11.4688 25.6 25.6s-11.4688 25.6-25.6 25.6zM668.6208 707.7376H342.272c-14.1312 0-25.6-11.4688-25.6-25.6s11.4688-25.6 25.6-25.6h326.3488c14.1312 0 25.6 11.4688 25.6 25.6s-11.4688 25.6-25.6 25.6z" fill="#44454A" p-id="9362"></path><path d="M589.6192 271.7184H422.3488c-56.576 0-102.4-45.824-102.4-102.4v-10.7008c0-56.576 45.824-102.4 102.4-102.4h167.2704c56.576 0 102.4 45.824 102.4 102.4v10.7008c0 56.576-45.8752 102.4-102.4 102.4z" fill="#FD973F" p-id="9363"></path><path d="M884.0192 526.0288c-14.1312 0-25.6 11.4688-25.6 25.6v191.5904c0 102.9632-83.7632 186.7776-186.7776 186.7776H340.2752c-102.9632 0-186.7776-83.7632-186.7776-186.7776V364.8c0-87.552 59.1872-161.1264 141.6192-181.2992 7.0656 63.8976 61.3888 113.8176 127.1808 113.8176h167.3216c65.792 0 120.1152-49.8688 127.1808-113.8176 82.432 20.1728 141.6192 93.7472 141.6192 181.2992 0 14.1312 11.4688 25.6 25.6 25.6s25.6-11.4688 25.6-25.6c0-116.6336-82.5344-213.8112-195.1232-234.0352-12.7488-57.2416-63.8976-100.1472-124.928-100.1472H422.3488c-61.0304 0-112.1792 42.9056-124.928 100.1472-112.5888 20.224-195.1232 117.4528-195.1232 234.0352v378.4192c0 131.2256 106.752 237.9776 237.9776 237.9776h331.4176c131.2256 0 237.9776-106.752 237.9776-237.9776v-191.5904a25.6512 25.6512 0 0 0-25.6512-25.6zM422.3488 81.8176h167.2704c39.9872 0 72.9088 30.72 76.4416 69.8368-0.1024 1.28-0.1024 2.56 0 3.8912 0.2048 2.304 0.3584 4.7104 0.3584 6.8608v3.1744c0 44.4416-36.1472 80.5888-80.5888 80.5888h-159.744c-44.4416 0-80.5888-36.1472-80.5888-80.5888v-3.1744c0-2.2016 0.1536-4.608 0.3584-6.8096 0.1024-1.3312 0.1024-2.6624 0-3.9424 3.584-39.1168 36.5056-69.8368 76.4928-69.8368z" fill="#44454A" p-id="9364"></path></svg>
          </div>
        </template>
      </t-grid-item>
      <t-grid-item text="收藏">
        <template #image>
          <div class="icon-wrapper">
            <svg t="1713143637009" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14487" width="32" height="32"><path d="M743.424 964.608c-14.336 0-26.624-4.096-38.912-10.24l-188.416-104.448-188.416 104.448c-26.624 14.336-59.392 12.288-86.016-4.096-26.624-18.432-38.912-51.2-34.816-83.968l36.864-221.184v-2.048l-153.6-155.648c-22.528-22.528-30.72-55.296-20.48-86.016s34.816-51.2 65.536-55.296L348.16 311.296l94.208-200.704c14.336-28.672 43.008-47.104 73.728-47.104 32.768 0 59.392 18.432 73.728 47.104l94.208 200.704 210.944 32.768c30.72 4.096 55.296 26.624 65.536 55.296 10.24 30.72 2.048 63.488-20.48 86.016l-153.6 155.648v2.048l36.864 221.184c6.144 32.768-8.192 63.488-34.816 83.968-12.288 10.24-28.672 16.384-45.056 16.384z m-227.328-819.2l-94.208 200.704c-12.288 24.576-34.816 43.008-61.44 47.104L147.456 423.936v4.096l153.6 155.648c18.432 18.432 26.624 47.104 22.528 73.728L286.72 878.592v2.048l188.416-104.448c24.576-14.336 53.248-14.336 77.824 0l188.416 104.448v-2.048l-36.864-221.184c-4.096-26.624 4.096-53.248 22.528-73.728l153.6-155.648v-2.048-2.048l-210.944-32.768c-26.624-4.096-49.152-20.48-61.44-47.104l-92.16-198.656z" fill="#333333" p-id="14488"></path><path d="M516.096 698.368c-67.584 0-122.88-55.296-122.88-122.88 0-22.528 18.432-40.96 40.96-40.96s40.96 18.432 40.96 40.96 18.432 40.96 40.96 40.96 40.96-18.432 40.96-40.96 18.432-40.96 40.96-40.96 40.96 18.432 40.96 40.96c0 67.584-55.296 122.88-122.88 122.88z" fill="#E5BD41" p-id="14489"></path></svg>
          </div>
        </template>
      </t-grid-item>
      <t-grid-item text="待收取">
        <template #image>
          <div class="icon-wrapper">
            <svg t="1713143762402" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="15510" width="32" height="32"><path d="M1024 223.328 1024 96.672C1024 43.36 980.928 0 928 0L96 0C43.072 0 0 43.36 0 96.672l0 126.624C0 276.64 43.072 320 96 320l0.512 0 0 513.984c0 36.224 30.048 65.696 67.008 65.696l335.808 0C551.328 974.688 637.984 1024 736 1024c158.816 0 288-129.184 288-288 0-84.768-37.024-160.864-95.488-213.6L928.512 319.936C981.184 319.68 1024 276.448 1024 223.328zM64 223.328 64 96.672C64 78.624 78.336 64 96 64l832 0c17.664 0 32 14.624 32 32.672l0 126.624C960 241.376 945.664 256 928 256L96 256C78.336 256 64 241.376 64 223.328zM960 736c0 123.712-100.288 224-224 224s-224-100.288-224-224 100.288-224 224-224c51.744 0 99.232 17.696 137.152 47.168 1.76 1.92 3.936 3.264 6.144 4.704C928.576 604.96 960 666.784 960 736zM736 448c-158.816 0-288 129.184-288 288 0 35.072 6.624 68.544 18.144 99.648L163.488 835.648c-1.952 0-3.008-1.184-3.008-1.696L160.48 323.712l704 0.864 0 154.08C825.76 459.2 782.208 448 736 448z" p-id="15511"></path><path d="M768.256 576c0-17.696-14.304-32-32-32s-32 14.304-32 32l0 160c0 17.696 14.304 32 32 32l160 0c17.696 0 32-14.304 32-32s-14.304-32-32-32l-128 0L768.256 576z" p-id="15512"></path></svg>
          </div>
        </template>
      </t-grid-item>
    </t-grid>
    <t-cell-group bordered>
      <t-cell title="我的出售" arrow hover />
      <t-cell title="个人信息" @click="goinfo" arrow hover />
      <t-cell title="设置" arrow hover>
      </t-cell>
      <t-cell title="显示ip" hover>
        <template #note>
          <t-switch :default-value="true" />
        </template>
      </t-cell>
      <t-cell title="其他" note="关于软件" arrow hover />
      <t-cell title="单行标题" :left-icon="lockIcon" arrow hover />

    </t-cell-group>

  </div>
</template>
<script setup >
import router from "../router";
import {reactive,onMounted} from "vue";
import {getUserInfoByName} from "../apis/UserApi.ts";
const userinfo=reactive({
  name:"",
  id:"",
  academy:"",
  avatar_img:"",
  back_img:"",
  grade:"",
})
onMounted(()=>{

})
const goinfo=async ()=>{
  await router.push({name: "updateinfo"})
}

</script>
<style lang="scss" scoped>
.profile-container {
  margin: 0;
  overflow: auto;
  height: 92vh;
  background-color: white;
  .action-group {
    margin-top: 10px;
  }

  .profile-header {
    &::before {
      content: '';
      //backdrop-filter: blur(15px);
      //-webkit-backdrop-filter: blur(15px);
      width: 100%;
      height: 200px;
      position: absolute;
      left: 0;
      top: 0;
      z-index: 0;
    }

    width: 100vw;
    height: 220px;
    background-image: url("https://ts1.cn.mm.bing.net/th/id/R-C.33d86fa9c27e626bec6e5f194b6a6cc4?rik=azDIozTOJ%2f7QxQ&riu=http%3a%2f%2fwww.deskcar.com%2fdesktop%2ffengjing%2f2014325205802%2f9.jpg&ehk=DVCHelgY3vSZMMlEns9iEYYwg0JPtHEt8DTYTY9nPXM%3d&risl=&pid=ImgRaw&r=0");
    background-size: cover;

    display:flex;
    justify-content: center;
    align-items: center;

    .profile-info {
      z-index: 1;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: space-around;
      color: #f0f0f0;

      &-avatar {
        border: 3px solid #f0f0f0;
        width: 80px;
        height: 80px;
      }

      &-nickname {
        font-size: 20px;
        margin: 7px;
      }

      &-address {
        font-size: 14px;
        margin: 5px 5px 0px 5px;
      }
    }


  }
}
</style>