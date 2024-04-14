import {defineStore} from "pinia";

export const LocalStorage=defineStore("main-store",()=>{
    const setToken = (token: string, userId: string) => {
        localStorage.setItem("token", token);
        localStorage.setItem("user_id", userId);
    };
    const CheckToken = () => {
        const token = localStorage.getItem("token");
        const userId = localStorage.getItem("user_id");
        if (token && userId) {
            setToken(token, userId);
            return true;
        }
        return false;
    };
    const removeToken = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("user_id");
    };
    const getUserId = () => {
        return localStorage.getItem("user_id");
    };
    const getToken=()=>{
        return localStorage.getItem("token")
    }
    return {
        setToken,
        CheckToken,
        removeToken,
        getUserId,
        getToken,
    };

});