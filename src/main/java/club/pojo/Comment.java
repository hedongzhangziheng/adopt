package club.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-20 14:23
 */
@Data
public class Comment {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentTime;
    private String content;

    private User user;
    private Admins admin;
    private Pet pet;
    private List<Answer> answer;

}
