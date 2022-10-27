import $ from 'jquery'
import router from '../router/index'

export default {
    state: {
        id: "",
        username: "",
        token: "",
        is_login: false,
    },
    getters: {
    },
    mutations: { // 用commit 为同步操作
        updateUser(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.is_login = user.is_login;
        },
        updateToken(state, token) {
            state.token = token;
        },
        logout(state) {
            state.id = "";
            state.username = "";
            state.token = "";
            state.is_login = false;
        }
    },
    actions: { // 用dispatch 为异步操作 比如先从云端拉取信息，再执行下一步
        login(context, data) {
            $.ajax({
                url: "http://127.0.0.1:1000/user/account/token/",
                type: "post",
                data: {
                    number: data.number,
                    password: data.password,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        localStorage.setItem("jwt_token", resp.token);
                        context.commit("updateToken", resp.token);
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                }
            });
        },
        getinfo(context, data) {
            $.ajax({
                url: "http://127.0.0.1:1000/user/account/info/",
                type: "get",
                headers: {
                    Authorization: "Bearer " + context.state.token,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        context.commit("updateUser", {
                            ...resp,
                            is_login: true,
                        });
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                }
            })
        },
        logout(context) {
            localStorage.removeItem("jwt_token");
            context.commit("logout");
            router.push({ name: 'user_account_login'});
        }
    },
    modules: {
    }
}
