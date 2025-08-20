# Login Demo - Ứng Dụng Đăng Nhập với Cookie và Session

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-1.0-green.svg)
![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Jakarta EE](https://img.shields.io/badge/Jakarta_EE-9.1-red.svg)

## Giới thiệu

Đây là ứng dụng demo minh họa hai phương thức xác thực người dùng phổ biến trong ứng dụng web Java:
1. Xác thực sử dụng Cookie
2. Xác thực sử dụng Session

Ứng dụng được phát triển bằng Jakarta EE, sử dụng Servlet và JSP để xây dựng giao diện web đơn giản.

## Cấu trúc dự án

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── login/
│   │               ├── models/
│   │               │   └── User.java
│   │               └── servlets/
│   │                   ├── CookieLoginServlet.java
│   │                   ├── SessionLoginServlet.java
│   │                   └── LogoutServlet.java
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── cookie-login.jsp
│       │   ├── cookie-welcome.jsp
│       │   ├── session-login.jsp
│       │   ├── session-welcome.jsp
│       │   └── web.xml
│       ├── error.jsp
│       └── index.jsp
```

## Yêu cầu hệ thống

- Java 11 trở lên
- Apache Maven 3.6.0 trở lên
- Apache Tomcat 10.0.0 trở lên (hoặc container servlet tương thích Jakarta EE 9)

## Cài đặt và Triển khai

### 1. Biên dịch dự án

```bash
mvn clean package
```

### 2. Triển khai ứng dụng

#### Cách 1: Sử dụng Tomcat
Sao chép file `target/login-demo.war` vào thư mục `webapps` của Tomcat và khởi động server.

#### Cách 2: Sử dụng IDE
Hầu hết các IDE hiện đại (Eclipse, IntelliJ IDEA, NetBeans) đều có tích hợp Tomcat hoặc server container khác. Bạn có thể cấu hình IDE để chạy ứng dụng trực tiếp.

## Cách sử dụng

Sau khi triển khai thành công, truy cập ứng dụng tại:
```
http://localhost:8080/login-demo/
```

### Đăng nhập

Ứng dụng demo sử dụng thông tin đăng nhập cố định:
- **Tài khoản:** admin
- **Mật khẩu:** password

### Xác thực với Cookie

1. Truy cập vào đường dẫn "Đăng nhập với Cookie"
2. Nhập thông tin đăng nhập
3. Tích chọn "Ghi nhớ đăng nhập" để lưu cookie
4. Sau khi đăng nhập thành công, trình duyệt sẽ lưu cookie và duy trì phiên đăng nhập

### Xác thực với Session

1. Truy cập vào đường dẫn "Đăng nhập với Session"
2. Nhập thông tin đăng nhập
3. Sau khi đăng nhập thành công, server sẽ lưu thông tin phiên trong session
4. Phiên đăng nhập sẽ tự động hết hạn sau 30 phút không hoạt động

## So sánh hai phương thức xác thực

| Tiêu chí | Cookie | Session |
|----------|--------|---------|
| Lưu trữ dữ liệu | Phía client (trình duyệt) | Phía server |
| Bảo mật | Thấp hơn (dễ bị đánh cắp) | Cao hơn (dữ liệu không lộ ra client) |
| Tồn tại | Có thể kéo dài sau khi đóng trình duyệt | Thường mất sau khi đóng trình duyệt |
| Giới hạn dữ liệu | ~4KB | Không giới hạn cứng |
| Tốc độ | Nhanh (không cần truy vấn server) | Chậm hơn (cần truy vấn server) |

## Lưu ý bảo mật

Đây là dự án demo đơn giản cho mục đích học tập. Trong môi trường thực tế, cần thực hiện các biện pháp bảo mật bổ sung như:

1. Mã hóa mật khẩu
2. Sử dụng HTTPS
3. Bảo vệ chống tấn công CSRF (Cross-Site Request Forgery)
4. Xác thực hai yếu tố
5. Giới hạn số lần đăng nhập thất bại
6. Sử dụng cơ sở dữ liệu để lưu trữ thông tin người dùng
