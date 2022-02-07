package com.example.link;


import javax.persistence.Entity;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link extends AbstractPersistable<Long>{
    
    private String title;
    private String link;
    private String description;
    private String keyword;
}
