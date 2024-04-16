<template>
    <div class="item-detail-container">
        <div class="navbar">
            <t-navbar :fixed="false" left-arrow @left-click="goBack" />
        </div>
        <div class="user-info">
            <div class="avatar-container" @click="">
                <t-avatar class="avatar" v-bind:image="user.avatar_img"></t-avatar>
            </div>
            <div class="info-container">
                <span class="username">啊米诺斯</span>
                <span class="academy">计算机工程学院</span>
            </div>
        </div>
        <div class="item-title">
            <p>{{ item.name }}</p>
        </div>
        <div class="item-images">
            <t-swiper :navigation="{ type: 'dots' }" :autoplay="true" @click="" @change="">
                <t-swiper-item v-for="(item, index) in swiperList" :key="index" style="height: 192px">
                    <img :src="item" class="img" />
                </t-swiper-item>
            </t-swiper>
        </div>
        <div class="item-info">
            <div class="price">
                <span class="symbol">¥</span>
                <span class="data">
                    {{ item.prices }}
                </span>
            </div>
            <div class="desc">
                <p>{{ item.description }}</p>
            </div>
            <div class="botbar">
                <t-button class="chat-icon" theme="primary" :icon="chatIcon">
                    聊一聊
                </t-button>
                <t-button class="star-icon" theme="primary" :icon="starIcon"></t-button>
                <t-button class="beer-icon" theme="primary" :icon="beerIcon"></t-button>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { h, ref } from 'vue';
import router from '../router';
import Item from '../model/item';
import User from '../model/user';
import { ChatIcon, StarIcon, BeerIcon } from 'tdesign-icons-vue-next';
const chatIcon = () => h(ChatIcon, { size: '24px' })
const starIcon = () => h(StarIcon, { size: '24px' })
const beerIcon = () => h(BeerIcon, { size: '24px' })

const imageCdn = 'https://tdesign.gtimg.com/mobile/demos';
const swiperList = [
    `${imageCdn}/swiper1.png`,
    `${imageCdn}/swiper2.png`,
    `${imageCdn}/swiper1.png`,
    `${imageCdn}/swiper2.png`,
    `${imageCdn}/swiper1.png`,
];

const user = ref(new User(
    '114514',
    '啊米诺斯',
    '男',
    '2022级',
    '计算机工程学院',
    '1145141919810',
    '这个人很懒，什么都没有留下',
    'https://tdesign.gtimg.com/mobile/demos/avatar1.png',
    'https://tdesign.gtimg.com/mobile/demos/avatar1.png',
));

const item = new Item(
    '114514',
    '114514',
    '讯景rx5700显卡',
    '讯景rx5700显卡，性能正常，外观看图片，鲁大师跑分33w左右，砍价勿扰谢谢',
    1145,
    0
);

const goBack = () => {
    router.back();
}


</script>

<style scoped lang="less">
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
    margin-left: 10px;

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
