import { createRouter, createWebHistory } from "vue-router";

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
      path: "/login",
      name: "login",
      component: () => import("../pages/login.vue"),
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
    {
      path: "/item-detail",
      name: "item-detail",
      component: () => import("../pages/item-detial.vue"),
    },
  ],
});
export default router;
