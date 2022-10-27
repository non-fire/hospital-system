<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">分诊导医智能调度系统</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText" text-align:right>
                <ul class="navbar-nav" v-if="$store.state.user.is_login">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false" text-malign:right>
                            {{ $store.state.user.username }}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="navbar-nav" v-else>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'user_account_login' }" role="button">
                            登录
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'user_account_register'}" role="button">
                            注册
                        </router-link>
                    </li>
                </ul>
            </div>
        </div>
    </nav>




</template>
    
<script>
import { useRoute } from 'vue-router'
import { computed } from 'vue'
import { useStore } from 'vuex';

export default {
    setup() {
        const store = useStore();
        const route = useRoute();
        let route_name = computed(() => route.name)

        const logout = () => {
            store.dispatch("logout");
        }

        return {
            route_name,
            logout
        }
    }

}
</script>
    
<style scoped>
div.container {
    width: 80vw;
    height: 10vw;
    margin: 40px auto;
}

img {
    width: 80vw;
    height: 15vw;
}
</style>