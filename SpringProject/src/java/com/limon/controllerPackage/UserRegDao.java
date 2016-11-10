package com.limon.controllerPackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

public class UserRegDao {

    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    
//user registration//
    public int userRegistration(Model userReg) {
        String sql = "insert into registration1(uname,uemail,uid) values('" + userReg.getUname() + "','" + userReg.getUemail() + "','" + userReg.getUid() + "')";
        int i = template.update(sql);
        return i;
    }/////


    //user Login
    public Model userLogin(String uname, int uid) {
        Model ob = new Model();
        String sql = "select uname,uid from registration1 where uname=? and uid=?";
        template.queryForObject(sql, new Object[]{uname, uid}, new UserLoginMapper());
        return ob;
    }
 private static class UserLoginMapper implements RowMapper<Model> {

        @Override
        public Model mapRow(ResultSet rs, int i) throws SQLException {
            Model ob = new Model();
            ob.setUname(rs.getString("uname"));
            ob.setUid(rs.getInt("uid"));
            return ob;

        }

    }//user login
 
//admin login
    public Model adminLogin(String name, String password) {
        Model ob = new Model();
        String sql = "select username,password from library_admin where username=? and password=?";
        template.queryForObject(sql, new Object[]{name, password}, new AdminLoginMapper());
        return ob;
    }

    private static class AdminLoginMapper implements RowMapper<Model> {

        @Override
        public Model mapRow(ResultSet rs, int i) throws SQLException {
            Model ob = new Model();
            ob.setName(rs.getString("username"));
            ob.setPassword(rs.getString("password"));
            return ob;

        }

    }//admin login

 
//store books to the library....
public int store_library_books(Model library_books) 
{
        String sql = "insert into library_books(book_id,book_name,author,publisher,quantity) values('" + library_books.getBook_id() + "','" + library_books.getBook_name() + "','" + library_books.getAuthor()+ "','" + library_books.getPublisher()+ "','" + library_books.getQuantity()+ "')";
        int i = template.update(sql);
        return i;
} 

//retrieve books from the library
public List<Model> retrieveLibraryBooks() {
        return template.query("select * from library_books", new RowMapper<Model>() {
            public Model mapRow(ResultSet rs, int row) throws SQLException {
                Model model = new Model();
                
             
                model.setBook_id(rs.getInt("book_id"));
                model.setBook_name(rs.getString("book_name"));
                model.setAuthor(rs.getString("author"));
                model.setPublisher(rs.getString("publisher"));
                model.setQuantity(rs.getInt("quantity"));
                

                return model;
            }
        });
    }
 
//issue book from the library....
public int issue_book(Model issue_book) 
{
        String sql = "insert into issue_books(book_id,book_name,student_name,student_id,issue_date) values('" + issue_book.getBook_id() + "','" + issue_book.getBook_name() + "','" + issue_book.getStudent_name()+ "','" + issue_book.getStudent_id()+ "','" + issue_book.getIssue_date()+ "')";
        int i = template.update(sql);
        return i;
} 

//retrieve stock available
public List<Model> retrieveStockAvailable() {
        return template.query("select library_books.book_id,library_books.book_name,library_books.author,library_books.publisher,library_books.quantity,count(issue_books.book_id) as issued,library_books.quantity-count(issue_books.book_id) as store_book   from library_books,issue_books  where library_books.book_id= issue_books.book_id group by(issue_books.book_id)", new RowMapper<Model>() {
            public Model mapRow(ResultSet rs, int row) throws SQLException {
                Model model = new Model();
                model.setBook_id(rs.getInt("book_id"));
                model.setBook_name(rs.getString("book_name"));
                model.setAuthor(rs.getString("author"));
                model.setPublisher(rs.getString("publisher"));
                model.setQuantity(rs.getInt("quantity"));
                model.setIssued(rs.getString("issued"));
                model.setStore_book(rs.getString("store_book"));
                

                return model;
            }
        });
    }
//return book//
public int  return_book(String student_id,String book_name) 
{
    String sql="delete from issue_books where student_id=? and book_name =?";
      //String sql = "delete from issue_books where student_id='"+return_book.getStudent_id()+"' and book_name='"+return_book.getBook_name()+"')";
   // String sql="delete from issue_books where student_id='"+student_id+"' and book_name ='"+book_name+"'";
      int i= template.update(sql,student_id,book_name);
      return i;
        
} 

}
