import {$http} from "./index";

export const GetpurchaseList = () => {
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/user/list",
        url: "/purchase/user/list"
    })
}
export const GetpurchaseInfoByPid = (data: { id: string }) => {
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/" + data.id,
        url: "/purchase/" + data.id,
    })
}
export const CreatePurchase = (data: { item_id: string, item_uid: string, price: number }) => {
    return $http({
        method: "post",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/new",
        url: "/purchase/new",
        params: data
    })

}
export const EndPurchase = (data: { purchase_id: string }) => {
    return $http({
        method: "post",
        url: "/purchase/end",
        params: data
    })
}
export const CancelPurchase = (data: { purchase_id: string }) => {
    return $http({
        method: "post",
        url: "/purchase/cancel",
        params: data
    })
}