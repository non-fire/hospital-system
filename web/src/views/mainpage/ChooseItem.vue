<template>
    <div class="row justify-content-md-center">
        <div class="col-6">
            <div class="mb-3">
                <label for="weilcome" class="form-label" style="font-size: 30px; margin-top: 30px">请选择检测项目:</label>
            </div>

            <div class="card-body">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>项目名称</th>
                            <th>选择</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- for循环的写法 -->
                        <tr v-for="bot in bots" :key="bot.id">
                            <td>{{ bot.name }}</td>
                            <td>
                                <Checkbox v-model="bot.id"></Checkbox>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <router-link to='/choose/item/'>
            <div class="d-grid gap">
                <button class="btn btn-outline-primary" type="button" style="margin-top: 20px">确定</button>
            </div>
        </router-link>
        </div>
        
    </div>
</template>

<script>
import { ref } from 'vue'
import $ from 'jquery'
import { useStore } from 'vuex'
export default {
    setup() {
        const store = useStore();
        let bots = ref([]);

        const refresh_bots = () => {
            $.ajax({
                url: "http://127.0.0.1:1000/user/item/getlist/",
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) {
                    bots.value = resp;
                }
            })
        }

        refresh_bots();

        return {
            bots,

        }
    }

}
</script>

<style scoped>

</style>

