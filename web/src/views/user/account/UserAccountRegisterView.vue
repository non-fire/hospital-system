<template>
    <div class="row justify-content-md-center">
        <div class="col-3">
            <form @submit.prevent="register">
                <div class="mb-3">
                    <label for="username" class="form-label">姓名</label>
                    <input v-model="username" type="text" class="form-control" id="username" placeholder="请输入用户名">
                </div>
                <div class="mb-3">
                    <label for="number" class="form-label">身份证号</label>
                    <input v-model="number" type="text" class="form-control" id="number" placeholder="请输入身份证号">
                </div>
                <div class="mb-3">
                    <label for="sex" class="form-label">性别</label>
                    <Select v-model="sex" style="width:280px; height: 35px" id="sex" size="large" placeholder="请选择性别">
                        <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </div>
                <div class="mb-3">
                    <label for="age" class="form-label">年龄</label>
                    <input v-model="age" type="text" class="form-control" id="age" placeholder="请输入年龄">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">地址（选填）</label>
                    <input v-model="address" type="text" class="form-control" id="address" placeholder="请输入地址">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">电话（选填）</label>
                    <input v-model="phone" type="text" class="form-control" id="phone" placeholder="请输入电话">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">密码</label>
                    <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
                </div>
                <div class="mb-3">
                    <label for="confirmedPassword" class="form-label">确认密码</label>
                    <input v-model="confirmedPassword" type="password" class="form-control" id="confirmedPassword"
                        placeholder="请再次输入密码">
                </div>
                <div class="error-message">{{ error_message }}</div>
                <button type="submit" class="btn btn-primary">提交</button>
            </form>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue'
import router from '../../../router/index'
import $ from 'jquery'


export default {
    setup() {
        let username = ref('');
        let number = ref('');
        let age = ref('');
        let sex = ref('');
        let address = ref('');
        let phone = ref('');
        let password = ref('');
        let confirmedPassword = ref('');
        let error_message = ref('');

        const register = () => {
            $.ajax({
                url: "http://127.0.0.1:1000/user/account/register/",
                type: "post",
                data: {
                    number: number.value,
                    name: username.value,
                    password: password.value,
                    confirmedPassword: confirmedPassword.value,
                    sex: sex.value,
                    age: age.value,
                    address: address.value,
                    phone: phone.value,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        router.push({ name: "user_account_login" });
                    } else {
                        error_message.value = resp.error_message;
                    }
                },
            });

        }
        return {
            cityList: [
                {
                    value: '0',
                    label: '男'
                },
                {
                    value: '1',
                    label: '女'
                }
            ],
            number,
            username,
            password,
            confirmedPassword,
            sex,
            age,
            address,
            phone,
            error_message,
            register,
        }
    }
}
</script>

<style scoped>
button {
    width: 100%;
}

div.error-message {
    color: red;
    justify-content: center;
}
</style>
