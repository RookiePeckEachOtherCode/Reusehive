import {createRouter, createWebHistory} from "vue-router";

const router = createRouter({
    end: undefined,
    history: createWebHistory(),
    sensitive: undefined,
    strict: undefined,
    routes: [
        {
            path: "/*",
            redirect: "/login",
        },
        {
            path: "/test",
            name: "test",
            component: () => import("../pages/test.vue")
        },
        {
            path: "/login",
            name: "login",
            component: () => import("../pages/login.vue"),
        },
        {
            path: "/item",
            name: "item",
            component: () => import("../pages/item.vue"),
        },
        {
            path: "/item/new",
            name: "itme-new",
            component: () => import("../pages/item-new.vue"),
        },
        {
            path: "/updateinfo",
            name: "updateinfo",
            component: () => import("../pages/updateinfo.vue"),
        },
        {
            path: "/chat",
            name: "chat",
            component: () => import("../pages/Chat.vue"),
        },
        {
            path: "/main",
            name: "main",
            component: () => import("../layout/main.vue"),
            children: [
                {
                    path: "message",
                    name: "message",
                    component: () => import("../pages/message.vue"),
                },
                {
                    path: "item-list",
                    name: "item-list",
                    component: () => import("../pages/item-list.vue"),
                },

                {
                    path: "purchase",
                    name: "purchase",
                    component: () => import("../pages/purchase.vue"),
                },
                {
                    path: "home",
                    name: "home",
                    component: () => import("../pages/userhome.vue"),
                },
            ],
        },
    ],
});
export default router;
