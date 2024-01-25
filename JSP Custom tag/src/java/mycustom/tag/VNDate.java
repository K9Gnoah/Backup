/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package mycustom.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author THINKPAD
 */
public class VNDate extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void doTag() throws JspException {
        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputDateFormat.parse(value);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("'ngày' dd 'tháng' MM 'năm' yyyy");
            String formattedDate = outputDateFormat.format(date);
            getJspContext().getOut().write(formattedDate);
        } catch (Exception e) {
            // Xử lý lỗi nếu cần
        }

        
    }
}
