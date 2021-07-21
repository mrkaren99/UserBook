package am.itspace.userBook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private int id;
    private String title;
    private String authorName;
    private double price;
    private Date createdDate;
    private String picUrl;
    private User user;

}
