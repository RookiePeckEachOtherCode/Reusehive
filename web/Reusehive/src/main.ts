import {createApp} from "vue";
import "./styles.css";
import App from "./App.vue";
import "tdesign-mobile-vue/es/style/index.css";

const createPinia = (await import("pinia")).createPinia;
const router = (await import("./router")).default;


createApp(App).use(createPinia()).use(router).mount("#app");
