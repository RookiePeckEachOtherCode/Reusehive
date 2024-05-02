import {defineStore} from "pinia";

export const LocalStorage = defineStore("main-store", () => {
    const setToken = (token: string, userId: string, username: string) => {
        localStorage.setItem("token", token);
        localStorage.setItem("user_id", userId);
        localStorage.setItem("username", username)
    };
    const setHost = (host: string) => {
        localStorage.setItem("host", host);
    }
    const CheckToken = () => {
        const token = localStorage.getItem("token");
        const userId = localStorage.getItem("user_id");
        const username = localStorage.getItem("username")
        if (token && userId && username) {
            setToken(token, userId, username);
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
    const getToken = () => {
        return localStorage.getItem("token")
    }
    const getusername = () => {
        return localStorage.getItem("username");
    }
    const gethost = () => {
        return localStorage.getItem("host");
    }
    return {
        setToken,
        CheckToken,
        removeToken,
        getUserId,
        getToken,
        getusername,
        setHost,
        gethost,
    };

});