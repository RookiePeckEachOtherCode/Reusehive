import {$http} from "./index";

export const loginApi = (data: { password: string; name: string }) => {

    return $http({
        method: "post",
        // url: "http://127.0.0.1:4523/m1/4280410-3922518-default/user/login",
        url: "http://127.0.0.1:8888/user/login",
        params: data,
        headers: {},
    });
};

export const registerApi = (data: {
    name: string,
    password: string,
    grade: string,
    academy: string,
    phone_number: string,
    social_info: string,
    avatar_img: any,
    back_img: any,
    gender: string,
}) => {
    const formData = new FormData();
    formData.append("name", data.name);
    formData.append("password", data.password);
    formData.append("grade", data.grade);
    formData.append("academy", data.academy);
    formData.append("phone_number", data.phone_number);
    formData.append("social_info", data.social_info);
    formData.append("gender", data.gender);


    return $http({
        method: "post",
        url: "http://127.0.0.1:8888/user/register",
        data: formData
    })
}

export const userChatInfoApi = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:4523/m1/4280410-0-default/user/chatsinfo",
    });
};

export const getUserInfoByUidApi = (data: { id: string }) => {
    const url = "http://127.0.0.1:8888/user/" + data.id;
    return $http({
        method: "get",
        url: url,
    });
};
export const getUserInfoByName = (data: { name: string }) => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:8888/user/name/" + data.name,
    })

}
export const getCurrentUserInfo = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:8888/me"
    })
}
export const UploadUserInfo = (data: {
    name: string,
    grade: string,
    academy: string,
    phone_number: string,
    social_info: string,
    avatar_img: any,
    back_img: any,
    gender: string,
}) => {
    const formData = new FormData();
    formData.append("name", data.name);
    formData.append("grade", data.grade);
    formData.append("academy", data.academy);
    formData.append("phone_number", data.phone_number);
    formData.append("social_info", data.social_info);
    formData.append("gender", data.gender);


    if (data.avatar_img != null) {
        formData.append("avatar_img", data.avatar_img.raw);
    }
    if (data.back_img != null) {
        formData.append("back_img", data.back_img.raw);
    }

    return $http({
        method: "post",
        url: "http://127.0.0.1:8888/user/update",
        data: formData
    })
}
export const getAllUserInfoApi = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:8888/user/all",
    })
}
export const verifylogin = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:8888/user/verify",
        //url:"http://127.0.0.1:4523/m1/4280410-0-default/user/verify"
    })
}

export const getUserItemList=(data:{id:string})=>{
    return $http({
        method:"get",
        //url:"http://127.0.0.1:8888/item/user/"+data.id
        url:"http://127.0.0.1:4523/m1/4280410-0-default/item/user/"+data.id
        })
}