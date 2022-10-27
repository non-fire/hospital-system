<template>
    <div class="row justify-content-md-center">
        <div class="col-6">
            <div class="mb-3">

                <label for="weilcome" class="form-label" style="font-size: 50px; margin-top: 50px">欢迎您,{{ $store.state.user.username }}!</label>
            </div>
            <router-link to='/choose/item/'>
                <div class="d-grid gap">
                    <button class="btn btn-outline-primary" type="button" style="margin-top: 50px">选择检测项目</button>
                </div>
            </router-link>
            <router-link to='/choose/item/'>
                <div class="d-grid gap">
                    <button class="btn btn-outline-primary" type="button" style="margin-top: 20px">修改个人资料</button>
                </div>
            </router-link>
       
        </div>
    </div>
</template>

<script>


export default {


}
</script>

<style scoped>
button {
    text-align: center;
}
</style>

