<template>
    <div class="container" @click="goToItem()">
        <div class="item-image">
            <t-image shape="round" :src="itemDetail?.images[0]" fit=" cover"
                :style="{ width: '20vh', height: '25vh' }"></t-image>
        </div>
        <div class="item-desc">
            {{ itemDetail?.item.description }}
        </div>
        <div class="price">
            <span class="symbol">¥</span>
            <span class="data">
                {{ itemDetail?.item.prices }}
            </span>
        </div>
    </div>

</template>

<script setup lang="ts">
import { defineProps } from 'vue';
import ItemDetail from '../model/itemDetail';
import router from '../router';


const props = defineProps({
    itemDetail: ItemDetail
})

const goToItem = () => {
    const tid: string = props.itemDetail?.item?.id.toString() ?? '';
    const uid: string = props.itemDetail?.item?.uid.toString() ?? '';
    router.push({
        path: `/item`,
        query: {
            tid: tid,
            uid: uid
        }
    })
}

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    max-width: 20vh;
}

.item-image {
    border-radius: 10px;
}

.item-desc {
    margin-top: 5px;
    margin-left: 5px;
    font-weight: bold;
    max-height: 20vh;
    overflow-y: auto;
}

.price {
    margin-left: 5px;

    .symbol {
        font-size: 15px;
        font-weight: bold;
        color: #F00;
    }

    .data {
        font-size: 25px;
        font-weight: bold;
        color: #F00;
    }
}
</style>
