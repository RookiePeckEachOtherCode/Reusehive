import {$http} from "./index";

export const GetpurchaseList = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/user/list",
    })
}
export const GetpurchaseInfoByPid = (data: { id: string }) => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/" + data.id,
    })
}
export const CreatePurchase = (data: { item_id: string, pirce: number, id: string | null }) => {
    return $http({
        method: "post",
        url: "http://127.0.0.1:4523/m1/4280410-0-default/purchase/new",
        params: data
    })

}