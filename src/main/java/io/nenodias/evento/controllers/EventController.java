package io.nenodias.evento.controllers;

import io.nenodias.evento.models.dto.EventDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/events")
@Controller
public class EventController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @ResponseBody
    @PostMapping
    public String insert(@RequestBody EventDTO event){
        rabbitTemplate.convertAndSend(this.queue.getName(), event);
        return "Event received";
    }

}
