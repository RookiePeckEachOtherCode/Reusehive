import {$http} from "./index";
import {LocalStorage} from "../storage/LocalStorage.ts";

export const getAllItemsApi = () => {
    const host=LocalStorage().gethost()
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/all",
        url:  host+"/item/all"
    });
};

export const getItemByItemIdApi = (data: { id: string }) => {
    const host=LocalStorage().gethost()
    const url = host+"/item/" + data.id;
    return $http({
        method: "get",
        url: url,
    });
};

export const newItemApi = (data: {
    name: String;
    description: String;
    prices: String;
    itemType: String;
    images: Array<any>;
}) => {
    var formData = new FormData();
    for (let i = 0; i < data.images.length; i++) {
        formData.append("images", data.images[i].raw);
    }

    formData.append("name", data.name.toString());
    formData.append("description", data.description.toString());
    formData.append("prices", data.prices.toString());
    formData.append("itemType", data.itemType.toString());
    const host=LocalStorage().gethost()
    return $http({
        data: formData,
        method: "post",
        url: host+"/item/new",
    });
};
export const getCollections = () => {
    const host=LocalStorage().gethost()
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/query",
        url: host+"/item/collection/query",
        method: "get",
    })
}
export const isCollected = (data: { item_id: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/collected",
        url: host+"/item/collection/collected",
        method: "get",
        params: data
    })
}
export const addCollection = (data: { item_id: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/add",
        url: host+"/item/collection/add",
        method: "post",
        params: data
    })
}
export const deleteCollection = (data: { item_id: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/delete",
        url: host+"/item/collection/delete",
        method: "post",
        params: data
    })
}

export const SerachItem = (data: { condition: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/search",
        url: host+"/item/search",
        method: "get",
        params: data
    })
}

export const UpdateItemInfo = (data: {
    id: string,
    name: string,
    description: string,
    prices: number,
    type: string
}) => {
    const host=LocalStorage().gethost()
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/update",
        url: host+"/item/update",
        method: "post",
        params: data
    })
}