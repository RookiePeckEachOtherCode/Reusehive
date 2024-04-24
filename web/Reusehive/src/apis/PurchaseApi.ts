import {$http} from "./index";

export const GetpurchaseList = () => {
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/user/list",
        url: "http://127.0.0.1:8888/purchase/user/list"
    })
}
export const GetpurchaseInfoByPid = (data: { id: string }) => {
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/" + data.id,
        url: "http://127.0.0.1:8888/purchase/" + data.id,
    })
}
export const CreatePurchase = (data: { item_id: string, item_uid: string, price: number }) => {
    return $http({
        method: "post",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/new",
        url: "http://127.0.0.1:8888/purchase/new",
        params: data
    })

}
export const EndPurchase = (data: { purchase_id: string }) => {
    return $http({
        method: "post",
        url: "http://127.0.0.1:8888/purchase/end",
        params: data
    })
}
export const CancelPurchase = (data: { purchase_id: string }) => {
    return $http({
        method: "post",
        url: "http://127.0.0.1:8888/purchase/cancel",
        params: data
    })
}