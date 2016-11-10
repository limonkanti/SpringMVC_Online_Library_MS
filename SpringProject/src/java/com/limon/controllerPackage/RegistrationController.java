package com.limon.controllerPackage;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired()
    UserRegDao dao = new UserRegDao();
//administration login
    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    public ModelAndView adminLogin() {
        return new ModelAndView("adminLogin", "command", new Model());
    }

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public ModelAndView adminLogin(@ModelAttribute("adminLogin") Model adminLogin) {
        String s = dao.adminLogin(adminLogin.getName(), adminLogin.getPassword()).toString();

        int i = s.length();
        if (i > 0) {
            //  return new ModelAndView("redirect:adminProfile");
            return new ModelAndView("adminProfile");
        } else {
            return new ModelAndView("error");
        }

    }//admin login
    
//store library books to the library....
    @RequestMapping(value = "/store_library_books", method = RequestMethod.GET)
    public ModelAndView getLibraryBooks() {
        return new ModelAndView("store_library_books", "command", new Model());
    }

    @RequestMapping(value = "/store_library_books", method = RequestMethod.POST)
    public ModelAndView getLibraryBooks(@ModelAttribute("store_library_books") Model store_library_books) {
        int i = dao.store_library_books(store_library_books);
        if (i > 0) {
            return new ModelAndView("success1");
        } else {
            return new ModelAndView("error");
        }

    }//store books 
    
    
//retrieve library books
     @RequestMapping("/view_library_books")  
    public ModelAndView viewLibraryBooks(){  
        List<Model> list=dao.retrieveLibraryBooks();
        return new ModelAndView("view_library_books","list",list);  
    }//retrieve library books
    
    
//issue book from the library
   @RequestMapping(value = "/issue_book", method = RequestMethod.GET)
    public ModelAndView issueBook() {
        return new ModelAndView("issue_book", "command", new Model());
    }

    @RequestMapping(value = "/issue_book", method = RequestMethod.POST)
    public ModelAndView issueBook(@ModelAttribute("issue_book") Model issue_book) {
        int i = dao.issue_book(issue_book);
        if (i > 0) {
            return new ModelAndView("success1");
        } else {
            return new ModelAndView("error");
        }

    }  //issue book
    
    
    //retrieve stock available
     @RequestMapping("/store_books")  
    public ModelAndView viewStockAvailableBook(){  
        List<Model> list=dao.retrieveStockAvailable();
        return new ModelAndView("store_books","list",list);  
    }//retrieve stock svailable
    
    
    
  //return book
    
   
    @RequestMapping(value = "/return_book", method = RequestMethod.GET)
    public ModelAndView returnBook() 
    {
        
         return new ModelAndView("return_book", "command", new Model());
    } 
    
    @RequestMapping(value = "/return_book", method = RequestMethod.POST)
    public ModelAndView returnBook(HttpServletRequest request) 
    {
        String student_id=request.getParameter("student_id");
        String book_name=request.getParameter("book_name");
        dao.return_book(student_id, book_name);
        return new ModelAndView("success1");
        
        
    }

  /* @RequestMapping(value = "/return_book", method = RequestMethod.POST)
    public ModelAndView returnBook(@ModelAttribute("return_book") Model return_book)        
    {
         //tring s = dao.return_book(return_book.getStudent_id(), return_book.getBook_name());
      //  ModelAndView mv=dao.return_book(return_book.getStudent_id(),return_book.getBook_name());
       // return dao.return_book(return_book.getStudent_id(),return_book.getBook_name());
        if (i > 0) {
            return new ModelAndView("success1");
        } else {
            return new ModelAndView("error");
        }

    }*/
  //user Registration
    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public ModelAndView userRegistration() {
        return new ModelAndView("userRegistration", "command", new Model());
    }

    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
    public ModelAndView userRegistration(@ModelAttribute("userReg") Model userReg) {
        int i = dao.userRegistration(userReg);
        if (i > 0) {
            return new ModelAndView("redirect:loginform");
        } else {
            return new ModelAndView("error");
        }

    }// user reg

    //user Login
    @RequestMapping(value = "/userLogin", method = RequestMethod.GET)
    public ModelAndView userLogin() {
        return new ModelAndView("userLogin", "command", new Model());
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(@ModelAttribute("userLogin") Model userLogin) {
        String s = dao.userLogin(userLogin.getUname(), userLogin.getUid()).toString();
        int i = s.length();
        if (i > 0) {
           // return new ModelAndView("redirect:userProfile");
            return new ModelAndView("userProfile");
        } else {
            return new ModelAndView("error");
        }

    }//user login
   
    
  

}
