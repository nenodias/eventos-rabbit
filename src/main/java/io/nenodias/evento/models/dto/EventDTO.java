package io.nenodias.evento.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class EventDTO implements Serializable {

    private Long id;
    private String name;
    private Date date;
    private Boolean enable;

}
