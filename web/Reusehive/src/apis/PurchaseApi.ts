import {$http} from "./index";
import {LocalStorage} from "../storage/LocalStorage.ts";
export const GetpurchaseList = () => {
    const host=LocalStorage().gethost()
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/user/list",
        url: host+ "/purchase/user/list"
    })
}
export const GetpurchaseInfoByPid = (data: { id: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        method: "get",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/" + data.id,
        url: host+"/purchase/" + data.id,
    })
}
export const CreatePurchase = (data: { item_id: string, item_uid: string, price: number }) => {
    const host=LocalStorage().gethost()
    return $http({

        method: "post",
        // url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/new",
        url: host+"/purchase/new",
        params: data
    })

}
export const EndPurchase = (data: { purchase_id: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        method: "post",
        url: host+"/purchase/end",
        params: data
    })
}
export const CancelPurchase = (data: { purchase_id: string }) => {
    const host=LocalStorage().gethost()
    return $http({
        method: "post",
        url: host+"/purchase/cancel",
        params: data
    })
}