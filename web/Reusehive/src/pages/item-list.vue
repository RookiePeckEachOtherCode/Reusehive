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


const getAll = async () => {
    let items = new Array<Item>;
    await getAllItemsApi().then(res => {
        items = res.data;
    });

    const imagePromises = items.map((item: Item) => getItemImageApi({ id: item.id }));

    const images = await Promise.all(imagePromises);

    itemDetails.value = items.map((item, index) => {
        return new ItemDetail(item, images[index].data);
    });
}


</script>

<style scoped>
.item-list-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    margin-top: 10px;
}
</style>