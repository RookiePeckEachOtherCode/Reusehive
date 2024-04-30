import {$http} from "./index";

export const GetAllItem = () => {
    return $http({
        method: "get",
        url: "/item/all"
    });
};
export const GetItemByType = (type: string) => {
    const url = "/item/type";
    return $http({
        method: "get",
        url: url,
        params: {type: type}
    })

}

export const getItemByItemIdApi = (data: { id: string }) => {
    const url = "/item/" + data.id;
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
    let formData = new FormData();
    for (let i = 0; i < data.images.length; i++) {
        formData.append("images", data.images[i].raw);
    }

    formData.append("name", data.name.toString());
    formData.append("description", data.description.toString());
    formData.append("prices", data.prices.toString());
    formData.append("itemType", data.itemType.toString());
    return $http({
        data: formData,
        method: "post",
        url: "/item/new",
    });
};
export const getCollections = () => {
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/query",
        url: "/item/collection/query",
        method: "get",
    })
}
export const isCollected = (data: { item_id: string }) => {
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/collected",
        url: "/item/collection/collected",
        method: "get",
        params: data
    })
}
export const addCollection = (data: { item_id: string }) => {
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/add",
        url: "/item/collection/add",
        method: "post",
        params: data
    })
}
export const deleteCollection = (data: { item_id: string }) => {
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/collection/delete",
        url: "/item/collection/delete",
        method: "post",
        params: data
    })
}

export const SerachItem = (data: { condition: string }) => {
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/search",
        url: "/item/search",
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
    return $http({
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/item/update",
        url: "/item/update",
        method: "post",
        params: data
    })
}