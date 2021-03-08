package io.nenodias.evento.consumers;

import io.nenodias.evento.models.Event;
import io.nenodias.evento.models.dto.EventDTO;
import io.nenodias.evento.repository.EventRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @Autowired
    private EventRepository eventRepository;

    @RabbitListener(queues = {"${queue.events.name}"})
    public void receive(@Payload EventDTO dto){
        Event event = null;
        if(dto.getId() != null) {
            event = eventRepository.findById(dto.getId()).orElse(null);
        }else {
            event = new Event();
        }
        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setEnable(dto.getEnable());
        if(event != null){
            eventRepository.save(event);
        }
    }

}
