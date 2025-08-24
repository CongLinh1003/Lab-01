<%--
  Created by IntelliJ IDEA.
  User: CONG LINH
  Date: 24/08/2025
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!doctype html><html lang="vi"><head><meta charset="utf-8">
<title>Bài 5 – Đăng ký</title>
<style>
    form { display:grid; gap:12px; max-width:540px }
    label { display:grid; gap:6px }
    fieldset{border:1px solid #ddd; padding:10px; border-radius:6px}
</style></head><body class="container">
<h2>Bài 5 – Form đăng ký</h2>

<p>Gửi bằng <b>GET</b> (dữ liệu hiện trên URL):</p>
<form action="<%=request.getContextPath()%>/bai5/inspect" method="get">
    <label>Họ tên <input name="fullName" required minlength="2" maxlength="60"></label>
    <label>Email <input type="email" name="email" required></label>
    <label>Password <input type="password" name="password" required minlength="6"></label>
    <label>Giới tính
        <select name="gender" required>
            <option value="">-- Chọn --</option>
            <option>Male</option><option>Female</option><option>Other</option>
        </select>
    </label>
    <fieldset>
        <legend>Sở thích</legend>
        <label><input type="checkbox" name="interests" value="Coding"> Coding</label>
        <label><input type="checkbox" name="interests" value="Music"> Music</label>
        <label><input type="checkbox" name="interests" value="Sports"> Sports</label>
    </fieldset>
    <label>Quốc gia
        <select name="country">
            <option>Vietnam</option><option>Australia</option><option>Japan</option>
        </select>
    </label>
    <label>Giới thiệu
        <textarea name="about" rows="4" maxlength="500"></textarea>
    </label>
    <button>Gửi (GET)</button>
</form>

<hr/>

<p>Gửi bằng <b>POST</b> (dữ liệu đi trong body):</p>
<form action="<%=request.getContextPath()%>/bai5/inspect" method="post">
    <!-- các trường giống form GET -->
    <label>Họ tên <input name="fullName" required minlength="2" maxlength="60"></label>
    <label>Email <input type="email" name="email" required></label>
    <label>Password <input type="password" name="password" required minlength="6"></label>
    <label>Giới tính
        <select name="gender" required>
            <option value="">-- Chọn --</option>
            <option>Male</option><option>Female</option><option>Other</option>
        </select>
    </label>
    <fieldset>
        <legend>Sở thích</legend>
        <label><input type="checkbox" name="interests" value="Coding"> Coding</label>
        <label><input type="checkbox" name="interests" value="Music"> Music</label>
        <label><input type="checkbox" name="interests" value="Sports"> Sports</label>
    </fieldset>
    <label>Quốc gia
        <select name="country">
            <option>Vietnam</option><option>Australia</option><option>Japan</option>
        </select>
    </label>
    <label>Giới thiệu
        <textarea name="about" rows="4" maxlength="500"></textarea>
    </label>
    <button>Gửi (POST)</button>
</form>

<p>Xem cấu trúc HTTP: <a href="<%=request.getContextPath()%>/bai5/inspect">/bai5/inspect</a></p>
</body></html>
