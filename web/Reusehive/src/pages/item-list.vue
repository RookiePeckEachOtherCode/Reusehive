<template>
    <div class="item-list-container">
        <div class="item-list" v-for="detail in itemDetails">
            <itemCard :itemDetail="(detail)"></itemCard>
        </div>
    </div>
</template>

<script setup lang="ts">
import { getAllItemsApi, getItemImageApi } from '../apis/ItemApi'
import Item from '../model/item';
import { onMounted, ref } from 'vue';
import itemCard from '../component/itemCard.vue'
import ItemDetail from '../model/itemDetail';

let itemDetails = ref(new Array<ItemDetail>);


onMounted(async () => {
    await getAll();
})

let isLoading = ref(false);
const CACHE_DURATION = 5 * 60 * 1000; // 5分钟

const isCacheValid = () => {
    const cacheTimestamp = localStorage.getItem('cacheItemTimestamp');
    if (!cacheTimestamp) return false;
    const timestamp = parseInt(cacheTimestamp);
    return Date.now() - timestamp <= CACHE_DURATION;
};



const getAll = async () => {
    if (isLoading.value || isCacheValid()) {
        itemDetails.value = JSON.parse(localStorage.getItem('itemDetails') || '[]');
        return;
    }

    isLoading.value = true;

    let items = new Array<Item>();
    await getAllItemsApi().then(res => {
        items = res.data;
    });

    const imagePromises = items.map((item: Item) => getItemImageApi({ id: item.id }));

    const images = await Promise.all(imagePromises);

    itemDetails.value = items.map((item, index) => {
        return new ItemDetail(item, images[index].data);
    });

    localStorage.setItem('itemDetails', JSON.stringify(itemDetails.value));
    localStorage.setItem('cacheItemTimestamp', Date.now().toString());

    isLoading.value = false;
};


</script>

<style scoped>
.item-list-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    margin-top: 10px;
}
</style>