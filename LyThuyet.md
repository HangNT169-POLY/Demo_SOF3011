## Buổi 1: Overview Java 4 
### 1. Các phần trong Java 4 : 
Overview Java 4, Method Get, Post,
Mô hình MVC, Session, Cookies, 
Hibernate (ORM => Cách mapping, Phân biệt hibernate vs JDBC , CRUD Hibernate), Authen & Author (Filter)
### 2. Cấu trúc project Java 4
#### 2.1: Maven + gradle
- Buid bằng maven 
- Phân biệt maven + gradle 
- Pom.xml : chứa các khai báo thư viện(dependence) được sử dụng trong dự án.
Các thứ viện này được quản lý bởi maven.
Trong quá trình làm và phát triển thị các bạn có thể thêm bỏ thư viên nếu cầu cho dự án. 
Nhưng mỗi lần thay đổi File pomm thì phải build lại.
#### 2.2: Cấu trúc project 
controller, service, repo,entity, model,util => BE(java)
FE:webapp 
=> Đoạn này vẽ 
#### 2.3: Hướng dẫn cách chạy project 

## Buổi 2: Method Get Post + Mô hình MVC
### 1. Ôn lại
### 2. Giải thích về quy trình request được gửi đi
(slide 1- hình)
### 3. Giải thích về việc truyền dữ liệu từ servlet sang jsp
(slide 1- hình)
### 4. Giải thích mô hình MVC
### 1.1 Khái niệm
MVC là viết tắt của cụm từ “Model-View-Controller“.
Đây là mô hình thiết kế được sử dụng trong kỹ thuật phần mềm.
<br/>
MVC là một mẫu kiến trúc phần mềm để tạo lập giao diện người dùng trên máy tính.
<br/>
MVC chia thành ba phần được kết nối với nhau và mỗi thành phần đều có một nhiệm vụ riêng của nó và độc lập với các thành phần khác.
<br/>
MVC cũng được sử dụng rộng rãi trong phát triển web, sự khác biệt được tùy chỉnh liên quan đến sự có mặt của server - client.
<br/>
### 2. Cách thành phần trong MVC
#### Model
- Có nhiệm vụ thao tác với Database
- Nó chứa tất cả các hàm, các phương thức truy vấn trực tiếp với dữ liệu
    - Controller sẽ thông qua các hàm, phương thức đó để lấy dữ liệu rồi gửi qua View
#### View
- Là giao diện người dùng (User Interface)
- Chứa các thành phần tương tác với người dùng như menu, button, image, text,...
- Nơi nhận dữ liệu từ Controller và hiển thị
- Notes: Nói về view trong spring boot (nhăc lại).Với view spring thì nó hỗ trợ jsp
  hoặc là Thymeleaf (html). Mặc định là sử dụng thymeleaf.
#### Controller
- Là thành phần trung gian giữa Model và View
- Đảm nhận vai trò tiếp nhận yêu cầu từ người dùng, thông qua Model để lấy dữ liệu sau đó thông qua View để hiển thị cho người dùng
### 3. Cách chạy (hoạt động)
Đầu tiên user(client) gửi request tới server.
<br/>
Thì ở phía server (controller) sẽ tiếp nhận request vừa gửi và giao tiếp với model.
<br/>
Ở đây model có thể giao tiếp với database để lấy dữ liệu.
<br/>
Sau khi lấy xong dự liệu thì controller sẽ gửi dữ liệu vừa lấy được về view
<br/>
và từ view sẽ hiển thị (reponse)ra cho người dùng trên trình duyệt.
### 5. Hướng dẫn về các method : get, post + phân biệt chúng
GET và POST là hai phương thức của giao thức HTTP, 
đều là gửi dữ liệu về server xử lí sau khi người dùng nhập thông tin vào form 
à thực hiện submit. Trước khi gửi thông tin, nó sẽ được mã hóa bằng cách sử dụng 
một giản đồ gọi là url encoding. Giản đồ này là các cặp name/value được kết hợp 
với các kí hiệu = và các kí hiệu khác nhau được ngăn cách bởi dấu &.
name=value1&name1=value2&name2=value3

GET : Phương thức GET gửi thông tin người dùng đã được mã hóa thêm vào trên yêu cầu trang:

http://www.example.com/index.htm?name=value1&name1=value1

Chúng ta thấy rằng GET lộ thông tin trên đường dẫn URL. Băng thông của nó chỉ khoảng 1024 kí tự vì vây GET hạn chế về số kí tự được gửi đi. GET không thể gửi dữ liệu nhị phân , hình ảnh ... Có thể cached và được bookmark (đánh dấu trên trình duyệt). Lưu trong browser history.

POST : Phương thức POST truyền thông tin thông qua HTTP header, thông tin này được mã hóa như phương thức GET. Dữ liệu đươc gửi bởi phương thức POST rất bảo mật vì dữ liệu được gửi ngầm, không đưa lên URL, bằng việc sử dụng Secure HTTP, bạn có thể chắc chắn rằng thông tin của mình là an toàn. Parameters được truyền trong request body nên có thể truyền dữ liệu lớn, hạn chế tùy thuộc vào cấu hình của Server. Không cache và bookmark được cũng như không được lưu lại trong browser history. POST không có bất kì hạn chế nào về kích thước dữ liệu sẽ gửi, có thể gửi dữ liệu nhị phân, hình ảnh.

##### 2. So sánh
   Lưu trữ (cache) Dữ liệu gửi bằng phương thức GET sẽ được lưu trữ lại trong query string và có thể được xem trong lịch sử trình duyệt. Ngược lại thì dữ liệu và địa chỉ URL của các request gửi bằng POST không được trình duyệt lưu lại. Tốc độ GET nhanh hơn rất nhiều so với POST về quá trình thực thi vì dữ liệu gửi đi luôn được webrowser cached lại, khi dùng phương thức POST thì server luôn thực thi và trả kết quả cho client, còn dùng GET thì webrowser cached sẽ kiểm tra có kết quả tương ứng đó trong cached chưa, nếu có thì trả về ngay mà không cần đưa tới server. Đánh dấu (bookmark) Đối với request gửi bằng phương thức GET người dùng có thể bookmark lại được trên trình duyệt. Ngược lại các request gửi bằng POST sẽ không thể bookmark được. Gửi lại form Với form gửi đi bằng phương thức GET bạn có thể gửi lại bằng cách bấm phím F5 hoặc Ctrl + R. Tuy nhiên với phương thức POST, nếu bạn muốn thực hiện việc gửi lại dữ liệu của form thì trình duyệt sẽ hiển thị một hộp thoại cảnh báo. Trở lại trang trước Trong trường hợp bạn đã gửi form dữ liệu đi rồi sau đó bấm phím Backspace để quay lại trang trước thì với phương thức GET bạn sẽ vẫn được cùng một nội dụng (chứa form). Ngược lại với POST thì bạn sẽ thấy một trang trống. Bảo mật Phương thức POST bảo mật hơn GET vì dữ liệu được gửi ngầm, không xuất hiện trên URL, dữ liệu cũng không được lưu lại trong khi đó với GET thì bạn có thể hiển thị lại được các dữ liệu này. Dữ liệu Phương thức POST không giới hạn dung lượng dữ liệu gửi đi cũng như loại nhữ liệu (văn bản thông thường hay file nhị phân như upload tập tin hay hình ảnh, video...). Ngược lại, với phương thức GET dữ liệu gửi đi bị giới hạn sử dụng các ký tự chữ có trong bộ ký tự ASCII. Đồng thời dữ liệu của GET được gửi trong URL thông qua query string nên sẽ bị giới hạn bởi số lượng ký tự tối đa cho phép trong URL.

##### 3. Sự lựa chọn
   Qua những phân tích trên, GET và POST nên được sử dụng như sau:

Khi lấy dữ liệu nên dùng GET để truy xuất và xử lí nhanh hơn.
Khi tạo dữ liệu nên dùng POST để bảo mật dữ liệu hơn. Một ví dụ cụ thể như trong trường hợp bạn cần tạo một form để người dùng upload avatar hay video thì chúng ta thường sẽ sử dụng phương thức POST. Tuy nhiên khi tải về avatar hoặc video thì bạn lại nên sử dụng phương thức GET. Ngoài ra khi cần xử lý các thông tin nhạy cảm ví dụ như email, password thì bạn cần sử dụng POST thay vì GET.
https://viblo.asia/p/phuong-thuc-get-va-post-aWj53VBYl6m
http://itplus-academy.edu.vn/POST-voi-GET-khac-nhau-nhu-the-nao.html
### 6. Demo

## Buổi 3: JSTL 
https://o7planning.org/10429/java-jsp-standard-tag-library

## Buổi 5: Session, Cookies 
https://viblo.asia/p/cookie-va-session-07LKXEvEZV4
https://wiki.matbao.net/huong-dan-cach-phan-biet-giua-cookie-va-session/

## Buổi 7-9: ORM + Hibernate 
- Vẽ cấu trúc trao đổi (java 3)
### 1.	SS Code JDBC vs Hibernate
      https://viblo.asia/p/nhung-ly-do-khien-ta-chon-hibernate-thay-vi-jdbc-Qbq5QroJKD8
      https://hocspringboot.net/2021/05/10/tai_sao_nen_dung_hibernate_thay_vi_jdbc/
      https://vi.sawakinome.com/articles/software/difference-between-jdbc-and-hibernate-3.html
      https://topdev.vn/blog/hibernate-la-gi-sao-phai-dung-no-thay-jdbc/
      https://vie.weblogographic.com/difference-between-jdbc-and-hibernate-768200

### 2.	Khái niệm ORM
      https://www.codelean.vn/2019/12/spring-framework-orm-la-gi.html#:~:text=Object%20Relational%20Mapping,c%C3%A1c%20b%E1%BA%A3n%20ghi%20trong%20b%E1%BA%A3ng.
      https://hocspringboot.net/2021/08/09/orm-la-gi-tong-quan-ve-orm-framework-2/
      https://viettuts.vn/hibernate/orm-la-gi

### 3.	Custom model
      https://initialcommit.com/blog/how-to-return-a-custom-class-from-hibernate-query
      https://stackoverflow.com/questions/37420401/mapping-hibernate-query-results-to-custom-class
      https://gpcoder.com/6440-hibernate-reverse-engineering-customize-code-generation-su-dung-custom-strategy-class/
      https://stackjava.com/hibernate/code-vi-du-hibernate-tu-sinh-id-dang-text-string.html
### 4.	Các dạng jon table
-	One to one
     https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-one-join-table.html

-	Many to one
     https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-bidirectional-join-table.html

-	One to many
     https://www.codejava.net/frameworks/hibernate/hibernate-one-to-many-association-on-join-table-annotations-example

## Buổi 13: Filter 
### 1. Giải thích authencation , authorzation 
https://viblo.asia/p/phan-biet-su-khac-nhau-giua-authentication-va-authorization-Eb85oad4Z2G
### 2. Filter là gì ?
https://hoclaptrinh.vn/tutorial/hoc-jsp/filter-trong-jsp
https://hivetech.vn/https-hivetech-vn-java-servlet-filter/
### 3. Demo luồng chạy của 1 filter
### 4. Demo filter 
