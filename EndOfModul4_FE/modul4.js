function showList() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/api/students",
        success: function (data) {
            let content = "<table class=\"table table-sm\">\n" +
                "    <tr>\n" +
                "      <th scope=\"col\" >Stt</th>\n" +
                "      <th scope=\"col\">Tên sinh viên </th>\n" +
                "      <th scope=\"col\">Địa chỉ </th>\n" +
                "      <th scope=\"col\" >Ngày sinh </th>\n" +
                "      <th scope=\"col\">Email</th>\n" +
                "      <th scope=\"col\">Số điện thoại </th>\n" +
                "      <th scope=\"col\">Tên lớp học </th>\n" +
                "      <th scope=\"col\" colspan='3'></th>\n" +
                "    </tr>";
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
                        <td scope="row">${i + 1}</td>
                        <td scope="row">${data[i].name}</td>
                        <td scope="row">${data[i].adress}</td>
                        <td scope="row">${data[i].dateOfBirth}</td>
                        <td scope="row">${data[i].email}</td>
                        <td scope="row">${data[i].phone}</td>
                        <td scope="row">${data[i].classboard.name}</td>
                        <td><button class="btn btn-warning" onclick="updateStudent(${data[i].id})"> update</button></td>
                        <td><button class="btn btn-danger" onclick="deleteStudent(${data[i].id})"> delete</button></td>
            
                    </tr>`
            }
            document.getElementById("display").innerHTML = content;
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}

function loadClass() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/classes",
        success: function (data) {
            console.log(data);
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option></option><br><option value=${data[i].id}>${data[i].name}</option>`
            }
            document.getElementById("class_id").innerHTML = content;
            document.getElementById("classUpdate_id").innerHTML = content;

        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}

function create() {
    window.location.href = "create.html";
}

function Goback() {
    window.location.href = "home.html";
}

function deleteStudent(id) {
        $.ajax({
            type: "DELETE",
            url: `http://localhost:8080/api/students/${id}`,
            success: function () {
                alert("Xóa thành công!");
                showList();
            }, error: function (err) {
                console.log(err)
                // lỗi
            }
        });
}

function createPost() {
    let name = document.getElementById("name").value;
    let adress = document.getElementById("address").value;
    let dateOfBirth = document.getElementById("dateOfBirth").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let class_id = document.getElementById("class_id").value;
    let student = {
        name: name,
        classboard: {
            id: class_id
        },
        dateOfBirth: dateOfBirth,
        adress: adress,
        phone: phone,
        email: email
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(student),
        url: "http://localhost:8080/api/students/create",
        success: function () {
            alert("Tạo mới thành phố thành công!");
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function gobackHome() {
    window.location.href = "home.html";
}

function updateStudent(id){
    $.ajax({
        type: "POST",
        //tên API
        url: `http://localhost:8080/api/students/${id}`,
        success: function (data) {
            let student_modul4_exam = JSON.stringify(data)
            localStorage.setItem("student_modul4_exam", student_modul4_exam);
            window.location.href = "update.html";
        }
    });
    event.preventDefault()
}

function updatePost(){
    let data = localStorage.getItem("student_modul4_exam");
    let studentUpdate = JSON.parse(data);
    let id = studentUpdate.id;
    let name = document.getElementById("name").value;
    let adress = document.getElementById("address").value;
    let dateOfBirth = document.getElementById("dateOfBirth").value;
    let phone = document.getElementById("phone").value;
    let email = document.getElementById("email").value;
    let C_id = document.getElementById("C_id").value;
    let student = {
        id:id,
        name: name,
        classboard: {
            id: C_id
        },
        dateOfBirth: dateOfBirth,
        adress: adress,
        phone: phone,
        email: email
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(student),
        url: `http://localhost:8080/api/students/update/${id}`,
        success: function () {
            alert("Cập nhật thành phố thành công!");
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function loadUpdate(){
    let data = localStorage.getItem("student_modul4_exam");
    let studentUpdate = JSON.parse(data);
    document.getElementById("name").value=studentUpdate.name;
    document.getElementById("address").value=studentUpdate.adress;
  document.getElementById("phone").value=studentUpdate.phone;
    document.getElementById("email").value=studentUpdate.email;
    document.getElementById("dateOfBirth").value=studentUpdate.dateOfBirth;
}

function search(){
    let search = document.getElementById("search").value;
    let student={
        name:search
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(student),
        url: `http://localhost:8080/api/students/searchByName`,
        success: function (data) {
            let content = "<table class=\"table table-sm\">\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">Stt</th>\n" +
                "      <th scope=\"col\">Tên sinh viên </th>\n" +
                "      <th scope=\"col\">Địa chỉ </th>\n" +
                "      <th scope=\"col\">Ngày sinh </th>\n" +
                "      <th scope=\"col\">Email</th>\n" +
                "      <th scope=\"col\">Số điện thoại </th>\n" +
                "      <th scope=\"col\">Tên lớp học </th>\n" +
                "      <th scope=\"col\" colspan='3'></th>\n" +
                "    </tr>";
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
                        <td scope="row">${i + 1}</td>
                        <td scope="row">${data[i].name}</td>
                        <td scope="row">${data[i].adress}</td>
                        <td scope="row">${data[i].dateOfBirth}</td>
                        <td scope="row">${data[i].email}</td>
                        <td scope="row">${data[i].phone}</td>
                        <td scope="row">${data[i].classboard.name}</td>
                        <td scope="row"><button class="btn btn-warning" onclick="updateStudent(${data[i].id})"> update</button></td>
                        <td scope="row"><button class="btn btn-danger" onclick="deleteStudent(${data[i].id})"> delete</button></td>
            
                    </tr>`
            }
            document.getElementById("display").innerHTML = content;
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    })
}